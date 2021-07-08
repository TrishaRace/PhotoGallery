package com.trisharace.generalgallery.models.view

import android.os.Parcelable
import com.trisharace.generalgallery.models.data.PhotoThumbnail
import com.trisharace.generalgallery.models.data.Photo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoView(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String?,
    val resourceURI: String,
    val image: String
) : Parcelable {


    fun toPhoto() =
        Photo(id, name, description, modified, resourceURI, PhotoThumbnail.thumbail(image))
}
