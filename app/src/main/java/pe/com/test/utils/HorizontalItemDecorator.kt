package pe.com.test.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class HorizontalItemDecorator(
    private val horizontalSpaceHeight: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {

        when {
            parent.getChildAdapterPosition(view) == 0 -> {
                outRect.left = horizontalSpaceHeight
                outRect.right = horizontalSpaceHeight / 2
            }
            parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1 -> {
                outRect.left = horizontalSpaceHeight / 2
                outRect.right = horizontalSpaceHeight
            }
            else -> {
                outRect.left = horizontalSpaceHeight / 2
                outRect.right = horizontalSpaceHeight / 2
            }
        }
    }
}