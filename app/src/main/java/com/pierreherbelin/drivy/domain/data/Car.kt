package com.pierreherbelin.drivy.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("brand")
    val brand: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("picture_url")
    val pictureURL: String,
    @SerializedName("price_per_day")
    val pricePerDay: Int,
    @SerializedName("rating")
    val carRating: CarRating,
    @SerializedName("owner")
    val owner: CarOwner
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun newArray(size: Int): Array<Car?> = arrayOfNulls<Car>(size)
        override fun createFromParcel(source: Parcel): Car = Car(source)
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readParcelable<CarRating>(CarRating::class.java.classLoader),
        source.readParcelable<CarOwner>(CarOwner::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(model)
        parcel.writeString(pictureURL)
        parcel.writeInt(pricePerDay)
        parcel.writeParcelable(carRating, 0)
        parcel.writeParcelable(owner, 0)
    }

    override fun describeContents(): Int = 0
}