package com.pierreherbelin.drivy.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CarOwner(
    @SerializedName("name")
    val name: String,
    @SerializedName("picture_url")
    val pictureURL: String,
    @SerializedName("rating")
    val ownerRating: OwnerRating
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<CarOwner> {
        override fun createFromParcel(parcel: Parcel): CarOwner = CarOwner(parcel)
        override fun newArray(size: Int): Array<CarOwner?> = arrayOfNulls(size)
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readParcelable<OwnerRating>(OwnerRating::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(pictureURL)
        parcel.writeParcelable(ownerRating, 0)
    }

    override fun describeContents(): Int = 0
}