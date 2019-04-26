package com.pierreherbelin.drivy.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class OwnerRating(
    @SerializedName("average")
    val average: Float,
    @SerializedName("count")
    val count: Int
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<OwnerRating> {
        override fun createFromParcel(parcel: Parcel): OwnerRating = OwnerRating(parcel)
        override fun newArray(size: Int): Array<OwnerRating?> = arrayOfNulls(size)
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