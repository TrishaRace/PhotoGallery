package com.trisharace.generalgallery.models.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserView(
    val username: String?
) :Parcelable {

    fun toUserView() = UserView(username)

}