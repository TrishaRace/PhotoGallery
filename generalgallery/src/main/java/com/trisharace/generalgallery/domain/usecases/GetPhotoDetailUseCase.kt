package com.trisharace.generalgallery.domain.usecases

import com.trisharace.generalgallery.domain.repository.PhotosRepository
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.core.utilities.State
import com.trisharace.core.utilities.usecase.FlowUseCase

class GetPhotoDetailUseCase(private val repository: PhotosRepository) :
    FlowUseCase<State<PhotoView>, GetPhotoDetailUseCase.Input>() {

    override fun run(params: Input?) = repository.getPhotoDetail(params?.id?:"0")

    data class Input(val id: String)
}
