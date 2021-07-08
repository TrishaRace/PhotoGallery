package com.trisharace.photogallery.generalGallery.photoGalleryList

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trisharace.generalgallery.models.view.PhotoView
import com.example.extensions.viewBinding
import com.trisharace.photogallery.generalGallery.photoGalleryList.adapters.PhotoGalleryAdapter
import com.example.platform.BaseFragment
import com.trisharace.generalgallery.databinding.FragmentPhotoGalleryBinding
import com.trisharace.photogallery.R
import kotlinx.android.synthetic.main.navigation_activity.*
import org.koin.android.viewmodel.ext.android.viewModel



class PhotoGalleryFragment : BaseFragment(R.layout.fragment_photo_gallery) {

    private val binding by viewBinding<FragmentPhotoGalleryBinding>()
    private val photoViewModel by viewModel<PhotoGalleryViewModel>()
    private val photosAdapter by lazy { PhotoGalleryAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().toolbar.title = "Bienvenido"
        with(photoViewModel) {
            photos.observe(viewLifecycleOwner, ::handlePhotos)
            showSpinner.observe(viewLifecycleOwner, ::showLoading)
            failure.observe(viewLifecycleOwner, ::showError)
        }
        initView()
        initListeners()
        getData()

    }

    private fun initView() {
        binding.characterList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = photosAdapter
        }
    }

    private fun initListeners() {
        photosAdapter.characterListener = { photoView ->
            findNavController().navigate(
                PhotoGalleryFragmentDirections.actionPhotoGalleryFragmentToPhotoDetailFragment(
                    photoView
                )
            )
        }
    }

    private fun getData() {
        photoViewModel.getPhotos()
    }

    private fun handlePhotos(photosView: List<PhotoView>) {
        photosView.let {
            val list = photosAdapter.collection.toMutableList()
            list.addAll(it.toMutableList())
            photosAdapter.collection = list
        }
    }

}