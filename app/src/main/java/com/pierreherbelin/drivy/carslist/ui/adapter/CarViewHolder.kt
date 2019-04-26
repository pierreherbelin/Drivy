package com.pierreherbelin.drivy.carslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.pierreherbelin.drivy.domain.data.Car
import kotlinx.android.synthetic.main.cars_list_cell.view.*


class CarViewHolder(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {
    fun bind(car: Car) {
        mItemView.car_header_view.buildView(car)
    }
}