package com.trisharace.generalgallery.domain.repository

import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.core.utilities.State
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getPhotos(): Flow<State<List<PhotoView>>>
    fun getPhotoDetail(id: String): Flow<State<PhotoView>>

}