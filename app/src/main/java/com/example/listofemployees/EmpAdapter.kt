package com.example.listofemployees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val empList:ArrayList<Employees>)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var onItemClick:((Employees)->Unit)?=null
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemFio: TextView =itemView.findViewById(R.id.fio_title)
        var itemDepart: TextView =itemView.findViewById(R.id.depart_title)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.employees_list,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val emp = empList[position]
        holder.itemFio.text = emp.fio
        holder.itemDepart.text = emp.depart
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(emp)

        }
    }

    override fun getItemCount(): Int {
        return empList.size
    }


}