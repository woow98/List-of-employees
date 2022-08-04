package com.example.listofemployees

import android.os.Parcel
import android.os.Parcelable

data class Employees(val fio: String, val depart: String, val phoneNum: String, val age: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fio)
        parcel.writeString(depart)
        parcel.writeString(phoneNum)
        parcel.writeString(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employees> {
        override fun createFromParcel(parcel: Parcel): Employees {
            return Employees(parcel)
        }

        override fun newArray(size: Int): Array<Employees?> {
            return arrayOfNulls(size)
        }
    }
}

