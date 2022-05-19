package com.syafei.chapter5binartask.models

import android.os.Parcel
import android.os.Parcelable

data class Cars(
    val merk: String?,
    val tipe: String?,
    val display: Int
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(merk)
        parcel.writeString(tipe)
        parcel.writeInt(display)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cars> {
        override fun createFromParcel(parcel: Parcel): Cars {
            return Cars(parcel)
        }

        override fun newArray(size: Int): Array<Cars?> {
            return arrayOfNulls(size)
        }
    }

}
