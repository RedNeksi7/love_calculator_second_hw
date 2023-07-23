package com.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.databinding.FragmentLoveCalculatorBinding
import com.geeks.lovecalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private var loveModel: LoveModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loveModel = arguments?.getSerializable(LoveCalculatorFragment.LOVEMODEL_KEY) as LoveModel

        initTextView()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun initTextView() {
        with(binding) {
            tvFistName.text = loveModel?.first_name.toString()
            tvSecondName.text = loveModel?.second_name.toString()
            tvPercentage.text = loveModel?.percentage.toString() + "%"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}