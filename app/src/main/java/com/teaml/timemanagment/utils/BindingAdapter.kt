package com.teaml.timemanagment.utils

import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.teaml.timemanagment.R
import com.teaml.timemanagment.data.local.db.converters.Priority

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("setPriorityColor")
    fun setPriorityColor(cardView: CardView, priority: Priority) {
        val priorityColorRes = when (priority) {
            Priority.VERY_HIGH -> R.color.colorPriorityVeryHigh
            Priority.HIGH -> R.color.colorPriorityHigh
            Priority.NORMAL -> R.color.colorPriorityNormal
            else -> R.color.colorPriorityLow
        }

        val color = ContextCompat.getColor(cardView.context, priorityColorRes)
        cardView.setCardBackgroundColor(color)
    }
}