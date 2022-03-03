package com.kl3jvi.musicapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.musicapp.databinding.ItemFavoritesBinding
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.presentation.home.HomeFragmentDirections

class FavoritesAdapter : ListAdapter<Album, FavoritesAdapter.FavoritesViewHolder>
    (FavoritesDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding: ItemFavoritesBinding = ItemFavoritesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bindItem(item)
        }
    }

    inner class FavoritesViewHolder constructor(
        private val binding: ItemFavoritesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.albumInfo?.let { albumInfo ->
                    navigateToDetails(albumInfo, view)
                }
            }
        }

        private fun navigateToDetails(album: Album, view: View) {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(album)
            view.findNavController().navigate(direction)
        }

        fun bindItem(album: Album) {
            binding.apply {
                albumInfo = album
                executePendingBindings()
            }
        }
    }
}

private class FavoritesDiffCallBack : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.playCount == newItem.playCount
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}
