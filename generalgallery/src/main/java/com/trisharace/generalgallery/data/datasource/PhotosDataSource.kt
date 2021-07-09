package com.trisharace.generalgallery.data.datasource

import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.core.utilities.State
import kotlinx.coroutines.flow.Flow

interface PhotosDataSource {
    fun getPhotos(): Flow<State<List<PhotoView>>>
    fun getPhotoDetail(id: String): Flow<State<PhotoView>>

}