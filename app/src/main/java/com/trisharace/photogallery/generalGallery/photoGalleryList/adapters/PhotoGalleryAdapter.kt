package com.trisharace.photogallery.generalGallery.photoGalleryList.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.trisharace.generalgallery.databinding.ItemViewPhotoBinding
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.photogallery.R

import kotlin.properties.Delegates

class PhotoGalleryAdapter : RecyclerView.Adapter<PhotoGalleryAdapter.CharacterListViewHolder>() {

    internal var collection: List<PhotoView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }
    internal var characterListener: (PhotoView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_photo, parent, false)
        )


    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(collection[position], characterListener)
    }

    inner class CharacterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemViewPhotoBinding.bind(itemView)

        fun bind(item: PhotoView, characterListener: (PhotoView) -> Unit) {
            binding.name.text = item.name
            with(binding.image) {
                Glide.with(context.applicationContext)
                    .load(item.image)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(this)
            }
            binding.cardViewItem.setOnClickListener { characterListener(item) }

        }
    }
}
