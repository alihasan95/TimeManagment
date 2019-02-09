package com.teaml.mytasks.ui.main.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teaml.mytasks.data.model.db.Task
import com.teaml.mytasks.databinding.RvEmptyItemBinding
import com.teaml.mytasks.databinding.RvTaskItemBinding
import com.teaml.mytasks.ui.base.BaseViewHolder
import timber.log.Timber
import javax.inject.Inject

class RvHomeAdapter @Inject constructor(private val context: Context, private val list: MutableList<Task>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    companion object {
        private const val EMPTY_ITEM = 1
        private const val TASK_ITEM = 2
    }

    private var onItemClickListener: ((Int) -> Unit)? = null
    private var onItemSwipeListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        Timber.i("onCreateViewHolder typeId %d", viewType)

        return if (viewType == TASK_ITEM) {
            val binding = RvTaskItemBinding.inflate(
                inflater, parent,
                false
            )
            TaskViewHolder(binding)
        } else {
            val binding = RvEmptyItemBinding.inflate(
                inflater, parent,
                false
            )
            EmptyViewHolder(binding)
        }

    }

    override fun getItemCount(): Int = if (list.isEmpty()) 1 else list.count()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.onBind(position)

    override fun getItemViewType(position: Int): Int =
        if (list.isEmpty()) EMPTY_ITEM else TASK_ITEM

    fun getContext(): Context = context

    fun addTasks(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    fun removeTask(position: Int) {
        onItemSwipeListener?.invoke(list[position].taskId)
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setOnItemClickListener(onItemClickListener: (taskId: Int) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemSwipeListener(onItemSwipeListener: (taskId: Int) -> Unit) {
        this.onItemSwipeListener = onItemSwipeListener
    }

    inner class TaskViewHolder(private val rvItemTaskBinding: RvTaskItemBinding) :
        BaseViewHolder(rvItemTaskBinding.root) {

        init {
            rvItemTaskBinding.root.setOnClickListener {
                val taskId = list[adapterPosition].taskId
                this@RvHomeAdapter.onItemClickListener?.invoke(taskId)
            }
        }

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