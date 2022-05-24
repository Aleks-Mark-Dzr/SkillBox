package com.example.viewandlayout

import android.os.Parcel
import android.os.Parcelable

data class FormState(
    val valid: Boolean,
    var email: String,
    var password: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (valid) 1 else 0)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FormState> {
        override fun createFromParcel(parcel: Parcel): FormState {
            return FormState(parcel)
        }

        override fun newArray(size: Int): Array<FormState?> {
            return arrayOfNulls(size)
        }
    }

}