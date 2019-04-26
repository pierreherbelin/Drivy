package com.pierreherbelin.drivy.domain.data

import com.google.gson.annotations.SerializedName

data class CarRating(
    private val mAverage: Float,
    private val mCount: Int
) {
    @SerializedName("average")
    var average: Float = mAverage
    @SerializedName("count")
    var count: Int = mCount
}