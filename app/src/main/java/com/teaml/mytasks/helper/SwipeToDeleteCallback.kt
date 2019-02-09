package com.teaml.mytasks.helper

import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.teaml.mytasks.R
import com.teaml.mytasks.ui.main.home.RvHomeAdapter

class SwipeToDeleteCallback(private val adapter: RvHomeAdapter)
    : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){

    var icon: Drawable = ContextCompat.getDrawable(adapter.getContext(), R.drawable.ic_done_black_24dp)!!
    var background: ColorDrawable = ColorDrawable(ContextCompat.getColor(adapter.getContext(), android.R.color.white))

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.removeTask(viewHolder.adapterPosition)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val item = viewHolder.itemView
        val backgroundCornerOffset = 20

        // Margin based on the height of the item and height of icon
        val iconMargin = (item.height - icon.intrinsicHeight) / 2

        val iconTop = item.top + (item.height - icon.intrinsicHeight) / 2
        val iconBottom = iconTop + icon.intrinsicHeight

        when {
            dX > 0 -> { // Swiping to the right

                val iconRight = item.left + 24 + icon.intrinsicWidth
                val iconLeft = item.left + 24
                icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)

                background.setBounds(item.left, item.top, item.left + dX.toInt() + backgroundCornerOffset, item.bottom)
            }
            dX < 0 -> { // Swiping to the left

                val iconLeft = item.right - 24 - icon.intrinsicWidth
                val iconRight = item.right - 24
                icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)

                background.setBounds(item.right + dX.toInt() - backgroundCornerOffset, item.top, item.right, item.bottom)
            }
            else -> // view is unSwiped
                background.setBounds(0, 0, 0, 0)
        }

        background.draw(c)
        icon.draw(c)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }
}