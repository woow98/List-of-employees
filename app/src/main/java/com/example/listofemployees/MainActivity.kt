package com.example.listofemployees

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.UTF_8
import kotlin.text.Charsets.UTF_8


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var empList: ArrayList<Employees>
    private lateinit var empAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)


        empAdapter = RecyclerAdapter(empList)
        recyclerView.adapter = empAdapter

        val employeesList: ArrayList<Employees> = ArrayList()

        try{
            val obj = JSONObject(getJSONFromAssets()!!)
            val empArray =obj.getJSONArray("employees")
            for(i in 0 until empArray.length()){
                val employees = empArray.getJSONObject(i)
                val fio = employees.getString("fio")
                val depart = employees.getString("depart")
                val phoneNum = employees.getString("phoneNum")
                val age = employees.getString("age")
                val empDetails =
                    Employees(fio,depart,phoneNum,age)
                employeesList.add(empDetails)
            }
        }
        catch(e: JSONException){
            e.printStackTrace()
        }


        empAdapter.onItemClick={
            val intent =Intent(this, detailInformation::class.java)
            intent.putExtra("employees", it)
            startActivity(intent)
        }
    }
    private fun getJSONFromAssets(): String? {
        var json: String? = null
        //ОШИБКА!!
        val charset: Charset = Charset.UTF_8
        try {
            val empJSONFile = assets.open("employees.json")
            val size = empJSONFile.available()
            val buffer = ByteArray(size)
            empJSONFile.read(buffer)
            empJSONFile.close()
            json = String(buffer, charset)
        }
        catch(ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }
}