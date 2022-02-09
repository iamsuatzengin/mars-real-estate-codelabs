package com.suatzengin.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.suatzengin.marsrealestate.R
import com.suatzengin.marsrealestate.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        binding = FragmentDetailBinding.inflate(inflater, container, false)

//        val marsProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val marsProperty = args.selectedProperty

        val viewModelFactory = DetailViewModelFactory(marsProperty, application)

        binding.viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        return binding.root
    }

}