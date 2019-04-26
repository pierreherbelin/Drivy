package com.pierreherbelin.drivy.domain.data

import com.google.gson.annotations.SerializedName

data class Car(
    private val mBrand: String,
    private val mModel: String,
    private val mPictureURL: String,
    private val mPricePerDay: Int,
    private val mCarRating: CarRating
) {
    @SerializedName("brand")
    var brand: String = mBrand
    @SerializedName("model")
    var model: String = mModel
    @SerializedName("picture_url")
    var pictureURL: String = mPictureURL
    @SerializedName("price_per_day")
    var pricePerDay: Int = mPricePerDay
    @SerializedName("rating")
    var rating: CarRating = mCarRating
}