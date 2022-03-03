package com.kl3jvi.musicapp.presentation.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.musicapp.MainActivity
import com.kl3jvi.musicapp.R
import com.kl3jvi.musicapp.common.viewBinding
import com.kl3jvi.musicapp.databinding.SearchFragmentBinding
import com.kl3jvi.musicapp.presentation.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: SearchViewModel by viewModels()
    private val binding: SearchFragmentBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (activity as MainActivity?)?.hideBottomNavBar()
        }
    }

}