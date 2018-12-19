package com.teaml.mytask.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teaml.mytask.utils.extension.toPx

class SpaceItemDecoration(
    var paddingLeft: Int = 8,
    var paddingRight: Int = 8,
    var paddingTop: Int = 8,
    var paddingBottom: Int = 0,
    var lastItemPadding: Int = 72
) : RecyclerView.ItemDecoration() {


    init {
        paddingLeft = paddingLeft.toPx()
        paddingRight = paddingRight.toPx()
        paddingTop = paddingTop.toPx()
        paddingBottom = paddingBottom.toPx()
        lastItemPadding = lastItemPadding.toPx()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemPosition = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount


        with(outRect) {
            bottom = paddingBottom
            top = paddingTop
            right = paddingRight
            left = paddingLeft
        }

        if (itemCount > 0 && itemPosition == itemCount - 1) {
            outRect.bottom = lastItemPadding
        }
    }
}