package com.geeks.lovecalculator.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.databinding.FragmentResultBinding
import com.geeks.lovecalculator.remote.LoveModel
import com.geeks.lovecalculator.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        loveModel = arguments?.getSerializable(MainFragment.LOVE_MODEL_RESULT_KEY) as LoveModel?

        initTextView()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnTryAgain.setOnClickListener {
                findNavController().navigate(R.id.navigate_mainFragment)
            }
        }
    }

    private fun initTextView() {
        with(binding) {
            tvFistName.text = loveModel?.firstName.toString()
            tvSecondName.text = loveModel?.secondName.toString()
            tvPercentage.text = loveModel?.percentage.toString() + "%"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}