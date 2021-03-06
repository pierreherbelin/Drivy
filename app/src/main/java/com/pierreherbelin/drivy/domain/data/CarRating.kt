package com.pierreherbelin.drivy.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CarRating(
    @SerializedName("average")
    val average: Float,
    @SerializedName("count")
    val count: Int
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<CarRating> {
        override fun createFromParcel(parcel: Parcel): CarRating = CarRating(parcel)
        override fun newArray(size: Int): Array<CarRating?> = arrayOfNulls(size)
    }

    constructor(source: Parcel) : this(
        source.readFloat(),
        source.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(average)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int = 0
}