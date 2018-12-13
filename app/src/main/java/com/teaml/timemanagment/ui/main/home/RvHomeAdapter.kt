package com.teaml.timemanagment.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.databinding.RvEmptyItemBinding
import com.teaml.timemanagment.databinding.RvTaskItemBinding
import com.teaml.timemanagment.ui.base.BaseViewHolder
import timber.log.Timber
import javax.inject.Inject

class RvHomeAdapter @Inject constructor(private val list: MutableList<Task>) : RecyclerView.Adapter<BaseViewHolder>() {

    companion object {
        private const val EMPTY_ITEM = 1
        private const val TASK_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        Timber.i("onCreateViewHolder typeId %d", viewType)

        return if (viewType == TASK_ITEM) {
            val binding = RvTaskItemBinding.inflate(inflater, parent,
                false)
            TaskViewHolder(binding)
        } else {
            val binding = RvEmptyItemBinding.inflate(inflater, parent,
                false)
             EmptyViewHolder(binding)
        }

    }

    override fun getItemCount(): Int = if (list.isEmpty()) 1 else list.count()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.onBind(position)

    override fun getItemViewType(position: Int): Int =
        if (list.isEmpty()) EMPTY_ITEM else TASK_ITEM

    fun addTasks(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(private val rvItemTaskBinding: RvTaskItemBinding) :
        BaseViewHolder(rvItemTaskBinding.root) {

        override fun onBind(position: Int) {
            rvItemTaskBinding.task = list[position]
            rvItemTaskBinding.executePendingBindings()
        }
    }

    inner class EmptyViewHolder(rvEmptyItemBinding: RvEmptyItemBinding) :
            BaseViewHolder(rvEmptyItemBinding.root) {

        override fun onBind(position: Int) {

        }
    }


}