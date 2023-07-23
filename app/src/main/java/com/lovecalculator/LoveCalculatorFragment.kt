package com.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.databinding.FragmentLoveCalculatorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorFragment : Fragment() {

    private var _binding: FragmentLoveCalculatorBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.getPercentage(
                    etFistName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val model: LoveModel? = response.body()
                        val bundle = bundleOf(LOVEMODEL_KEY to model)
                        findNavController().navigate(R.id.navigate_resultFragment,bundle)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireActivity(),t.toString(),Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        const val LOVEMODEL_KEY = "LoveModel.key"
    }

}