package com.pierreherbelin.drivy.app.extension

import android.support.v7.widget.RecyclerView
import com.pierreherbelin.drivy.app.listener.RecyclerItemClickListener


fun RecyclerView.onItemClick(listener: RecyclerItemClickListener.OnClickListener) {
    this.addOnChildAttachStateChangeListener(RecyclerItemClickListener(this, listener))
}
