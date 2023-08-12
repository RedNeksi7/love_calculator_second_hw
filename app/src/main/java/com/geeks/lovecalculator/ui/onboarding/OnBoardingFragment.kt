package com.geeks.lovecalculator.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.data.Pref
import com.geeks.lovecalculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var pref: Pref

    private val adapter = OnBoardingAdapter(this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClick() {
        pref.saveSeen()
        findNavController().navigate(R.id.navigate_mainFragment)
    }
}