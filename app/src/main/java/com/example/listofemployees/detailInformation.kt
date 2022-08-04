package com.example.listofemployees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class detailInformation : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_information)

        val emp = intent.getParcelableExtra<Employees>("employees")
        if(emp !=null){
            val tvfio: TextView = findViewById(R.id.fio)
            val tvage:TextView=findViewById(R.id.age)
            val tvphone:TextView=findViewById(R.id.phoneNumber)
            val tvdepart:TextView=findViewById(R.id.depart)

            tvfio.text=emp.fio
            tvphone.text=emp.phoneNum
            tvage.text= emp.age
            tvdepart.text=emp.depart

        }
    }
}