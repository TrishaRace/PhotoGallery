package com.trisharace.generalgallery.models.view

import android.os.Parcelable
import com.trisharace.generalgallery.models.data.PhotoUrls
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoUrlsView(
    val regular: String?,
    val small: String?,
    val thumb: String?
) : Parcelable {

    fun toPhotoUrls() = PhotoUrls(regular, small, thumb)
}
