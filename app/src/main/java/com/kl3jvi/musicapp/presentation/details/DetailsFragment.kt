package com.kl3jvi.musicapp.presentation.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.insertFooterItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.musicapp.MainActivity
import com.kl3jvi.musicapp.R
import com.kl3jvi.musicapp.common.viewBinding
import com.kl3jvi.musicapp.databinding.DetailsFragmentBinding
import com.kl3jvi.musicapp.presentation.adapter.MoreAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: DetailsViewModel by viewModels()
    private val binding: DetailsFragmentBinding by viewBinding()
    private val args: DetailsFragmentArgs by navArgs()
    private val albumDetails get() = args.albumDetails
    private val adapter = MoreAdapter()
    private var searchJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        search(albumDetails.artist.name)
    }


    private fun initViews() {
        albumDetails.let { albumInfo ->
            binding.albumInfo = albumInfo
            binding.similarRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            binding.similarRecyclerView.adapter = adapter
        }
    }


    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (activity as MainActivity?)?.hideBottomNavBar()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_menu, menu)
        val item = menu.getItem(0)
        item.isChecked = albumDetails.isFavorite
        item.setIcon(
            if (albumDetails.isFavorite) R.drawable.ic_favorite_complete
            else R.drawable.ic_favorite_uncompleted
        )
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            item.isChecked = !item.isChecked
            item.setIcon(
                if (item.isChecked) R.drawable.ic_favorite_complete
                else R.drawable.ic_favorite_uncompleted
            )
            if (!albumDetails.isFavorite) {
                viewModel.markAsFavorite(albumDetails)
            } else {
                viewModel.deleteFromFavorite(albumDetails)
            }
            return true
        }
        return false
    }

    private fun search(query: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.searchPictures(query).collectLatest {
                adapter.submitData(it)
            }
        }
    }
}