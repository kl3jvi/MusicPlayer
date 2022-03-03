package com.kl3jvi.musicapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kl3jvi.musicapp.MainActivity
import com.kl3jvi.musicapp.R
import com.kl3jvi.musicapp.common.hide
import com.kl3jvi.musicapp.common.show
import com.kl3jvi.musicapp.common.viewBinding
import com.kl3jvi.musicapp.databinding.HomeFragmentBinding
import com.kl3jvi.musicapp.presentation.adapter.FavoritesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()
    private val adapter = FavoritesAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getFavorites()
    }

    private fun initViews() {
        binding.apply {
            homeRv.adapter = adapter
            homeRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun getFavorites() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.favoritesList.collect { albumList ->
                    if (albumList.isEmpty()) {
                        binding.apply {
                            homeRv.hide()
                            noFavoriteText.show()
                        }
                    } else {
                        adapter.submitList(albumList)
                        binding.apply {
                            homeRv.show()
                            noFavoriteText.hide()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (activity as MainActivity?)?.showBottomNavBar()
        }
    }

}