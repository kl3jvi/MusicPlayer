package com.kl3jvi.musicapp.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.musicapp.MainActivity
import com.kl3jvi.musicapp.R
import com.kl3jvi.musicapp.common.viewBinding
import com.kl3jvi.musicapp.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()


    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (activity as MainActivity?)?.showBottomNavBar()
        }
    }

}