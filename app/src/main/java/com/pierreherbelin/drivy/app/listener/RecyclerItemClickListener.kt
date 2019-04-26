package com.pierreherbelin.drivy.app.listener

import android.support.v7.widget.RecyclerView
import android.view.View


class RecyclerItemClickListener(
    private val mRecycler: RecyclerView,
    private val mClickListener: OnClickListener? = null
) :
    RecyclerView.OnChildAttachStateChangeListener {

    override fun onChildViewDetachedFromWindow(view: View) {
        view.setOnClickListener(null)
    }

    override fun onChildViewAttachedToWindow(view: View) {
        view.setOnClickListener { v ->
            setOnChildAttachedToWindow(v)
        }
    }

    private fun setOnChildAttachedToWindow(view: View?) {
        view?.let {
            val position = mRecycler.getChildLayoutPosition(it)
            if (position >= 0) {
                mClickListener?.onItemClick(position, it)
            }
        }
    }

    interface OnClickListener {
        fun onItemClick(position: Int, view: View)
    }
}