package com.kl3jvi.musicapp.presentation.home

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kl3jvi.musicapp.R
import com.kl3jvi.musicapp.common.viewBinding
import com.kl3jvi.musicapp.databinding.HomeFragmentBinding
import com.kl3jvi.musicapp.presentation.adapter.MusicAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()




}