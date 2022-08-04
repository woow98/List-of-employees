package com.example.listofemployees

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        empList = ArrayList()

        empList.add(Employees("Никифоров Прохор Станиславович","Отдел кадров","+79870956784", "03.12.1999"))
        empList.add(Employees("Титова Наоми Адольфовна","Финансовый отдел","+79053458746", "14.09.2000"))
        empList.add(Employees("Гусев Максим Святославович","Бухгалтерия","+78763462233", "31.07.1995"))
        empList.add(Employees("Крылова Нила Святославовна","Канцелярия","+79074458070", "22.03.1986"))
        empList.add(Employees("Зиновьев Орест Максович","Архив","+79010080501", "01.05.1997"))
        empList.add(Employees("Меркушева Аделина Созоновна","Отдел продаж","+79058761122", "10.10.1999"))
        empList.add(Employees("Рябов Май Артёмович","Отдел рекламы и PR","+79873327845", "11.09.1980"))
        empList.add(Employees("Дмитриева Веселина Святославовна","Отдел охраны труда","+79871129402", "29.04.1995"))
        empList.add(Employees("Григорьев Святослав Геласьевич","Экономический отдел","+79042126734", "03.01.2000"))
        empList.add(Employees("Евсеева Фелиция Парфеньевна","Отдел закупок","+79053782687", "19.07.1992"))

        empAdapter = RecyclerAdapter(empList)
        recyclerView.adapter = empAdapter


        empAdapter.onItemClick={
            val intent =Intent(this, detailInformation::class.java)
            intent.putExtra("employees", it)
            startActivity(intent)
        }
    }
}