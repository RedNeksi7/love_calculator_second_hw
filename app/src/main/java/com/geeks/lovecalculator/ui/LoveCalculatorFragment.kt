package com.geeks.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.LoveViewModel
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.data.Pref
import com.geeks.lovecalculator.databinding.FragmentLoveCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    @Inject
    lateinit var pref: Pref

    private var _binding: FragmentLoveCalculatorBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

        if(!pref.isUserSeen()){ findNavController().navigate(R.id.navigate_onBoardingFragment)}
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveData(etFistName.text.toString(), etSecondName.text.toString())
                    .observe(this@LoveCalculatorFragment) { loveModel ->
                        findNavController().navigate(
                            R.id.navigate_resultFragment,
                            bundleOf(LOVEMODEL_KEY to loveModel)
                        )
                    }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val LOVEMODEL_KEY = "LoveModel.key"
    }
}