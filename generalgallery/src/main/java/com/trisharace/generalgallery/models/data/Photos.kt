package com.trisharace.generalgallery.models.data

import com.trisharace.generalgallery.models.entity.PhotosEntity
import com.trisharace.generalgallery.models.view.PhotosView

data class Photos(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: MutableList<Photo>?,
) {

    constructor(results: MutableList<Photo>?) : this(
        null,
        null,
        null,
        null,
        results
    )

    fun toPhotosEntity() =
        PhotosEntity(
            null,
            offset,
            limit,
            total,
            count,
            mutableListOf()
        )

    fun toPhotosView() =
        PhotosView(results?.map { it.toPhotoView() }?.toMutableList() ?: mutableListOf())
}
