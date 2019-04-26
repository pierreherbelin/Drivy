package com.pierreherbelin.drivy.carslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.pierreherbelin.drivy.R
import com.pierreherbelin.drivy.domain.data.Car
import kotlinx.android.synthetic.main.cars_list_cell.view.*


class CarViewHolder(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {
    fun bind(car: Car) {
        Glide.with(mItemView.context)
            .load(car.pictureURL)
            .placeholder(R.drawable.car)
            .into(mItemView.car_picture)

        mItemView.car_name.text = mItemView.context.getString(R.string.car_name_format, car.brand, car.model)
        mItemView.price_per_day.text = mItemView.context.getString(R.string.price_format, car.pricePerDay)
        mItemView.rating_bar.rating = car.rating.average
        mItemView.vote_count.text =
            mItemView.context.resources.getQuantityString(R.plurals.vote_count, car.rating.count, car.rating.count)
    }
}