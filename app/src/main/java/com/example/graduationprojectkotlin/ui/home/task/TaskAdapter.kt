package com.example.graduationprojectkotlin.ui.home.task

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationprojectkotlin.R
import com.example.graduationprojectkotlin.StudyActivity
import com.example.graduationprojectkotlin.logic.model.Task

class TaskAdapter(val fragment: Fragment, private val taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskName: TextView = view.findViewById(R.id.tv_task_name)
        val taskTime: TextView = view.findViewById(R.id.tv_time)
        val taskDetail: TextView = view.findViewById(R.id.tv_task_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        val viewHolder = ViewHolder(view)
//        viewHolder.itemView.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val task = taskList[position]
//            Toast.makeText(parent.context, "you clicked view ${task.name}", Toast.LENGTH_SHORT)
//                .show()
//        }
//        viewHolder.taskImage.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val task = taskList[position]
//            Toast.makeText(parent.context, "you clicked image ${task.name}", Toast.LENGTH_SHORT)
//                .show()
//        }
//        viewHolder.taskName.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val task = taskList[position]
//            Toast.makeText(parent.context, "you clicked name ${task.name}", Toast.LENGTH_SHORT)
//                .show()
//        }
        //TODO 传给StudyActivity一个值（用来判断加载什么类型的Fragment）
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val intent = Intent(parent.context, StudyActivity::class.java)
                .apply { putExtra("extra_data",position%2) }
            fragment.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskDetail.text=task.task_detail
        holder.taskName.text = task.task_name
        holder.taskTime.text = task.task_time
    }
}