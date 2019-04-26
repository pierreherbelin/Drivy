package com.pierreherbelin.drivy.app.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pierreherbelin.drivy.R
import com.pierreherbelin.drivy.domain.data.CarOwner
import kotlinx.android.synthetic.main.owner_header_layout.view.*

class OwnerHeaderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.owner_header_layout, this, true)
    }

    fun buildView(owner: CarOwner) {
        Glide.with(context)
            .load(owner.pictureURL)
            .placeholder(R.drawable.man)
            .apply(RequestOptions.circleCropTransform())
            .into(owner_picture)

        owner_name.text = owner.name
        rating_bar.rating = owner.ownerRating.average
    }

}