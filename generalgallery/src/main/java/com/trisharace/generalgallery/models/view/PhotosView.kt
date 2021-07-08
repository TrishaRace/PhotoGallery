package com.trisharace.generalgallery.models.view

import com.trisharace.generalgallery.models.data.Photos

data class PhotosView(
    val results: MutableList<PhotoView>
) {

    fun toPhotos() =
        Photos(results.map { it.toPhoto() }.toMutableList())
}
