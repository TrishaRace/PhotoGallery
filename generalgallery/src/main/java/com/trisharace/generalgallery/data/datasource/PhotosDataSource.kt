package com.trisharace.generalgallery.data.datasource

import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.generalgallery.models.view.PhotosView
import com.trisharace.core.utilities.State
import kotlinx.coroutines.flow.Flow

interface PhotosDataSource {
    fun getPhotos(): Flow<State<PhotosView>>
    fun getPhotoDetail(id: String): Flow<State<PhotoView>>

}