package com.pierreherbelin.drivy.app.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.pierreherbelin.drivy.R
import com.pierreherbelin.drivy.domain.data.Car
import kotlinx.android.synthetic.main.car_header_layout.view.*

class CarHeaderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.car_header_layout, this, true)
    }

    fun buildView(car: Car) {
        Glide.with(context)
            .load(car.pictureURL)
            .placeholder(R.drawable.car)
            .into(car_picture)

        car_name.text = context.getString(R.string.car_name_format, car.brand, car.model)
        price_per_day.text = context.getString(R.string.price_format, car.pricePerDay)
        rating_bar.rating = car.carRating.average
        vote_count.text =
            context.resources.getQuantityString(
                R.plurals.vote_count,
                car.carRating.count,
                car.carRating.count
            )
    }

}