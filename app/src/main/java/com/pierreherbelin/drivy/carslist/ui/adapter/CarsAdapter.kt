package com.pierreherbelin.drivy.carslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pierreherbelin.drivy.R
import com.pierreherbelin.drivy.domain.data.Car
import java.util.*


class CarsAdapter(private val mCarList: ArrayList<Car>) : RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): CarViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cars_list_cell, viewGroup, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CarViewHolder, position: Int) {
        viewHolder.bind(mCarList[position])
    }

    override fun getItemCount(): Int {
        return mCarList.size
    }
}