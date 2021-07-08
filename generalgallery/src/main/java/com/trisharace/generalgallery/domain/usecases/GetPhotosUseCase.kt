package com.trisharace.generalgallery.domain.usecases

import com.trisharace.generalgallery.domain.repository.PhotosRepository
import com.trisharace.generalgallery.models.view.PhotosView
import com.trisharace.core.utilities.State
import com.trisharace.core.utilities.usecase.FlowUseCase

class GetPhotosUseCase(private val repository: PhotosRepository) :
    FlowUseCase<State<PhotosView>, Unit>() {

    override fun run(params: Unit?) = repository.getPhotos()

}
