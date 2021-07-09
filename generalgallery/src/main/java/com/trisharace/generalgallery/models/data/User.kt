package com.trisharace.generalgallery.models.data

import android.os.Parcelable
import com.trisharace.generalgallery.models.entity.UserEntity
import com.trisharace.generalgallery.models.view.UserView
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String?
):Parcelable {

    fun toUserEntity() = UserEntity(username)
    fun toUserView() = UserView(username)
}