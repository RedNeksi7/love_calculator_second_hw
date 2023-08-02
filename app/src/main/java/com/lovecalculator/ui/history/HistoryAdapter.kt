package com.lovecalculator.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.geeks.lovecalculator.databinding.ItemHistoryBinding
import com.lovecalculator.remote.LoveModel

class HistoryAdapter(
    var list: List<LoveModel>,
    private val onItemClick: (Bundle) -> Unit
) : Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            with(binding) {
                tvFistName.text = loveModel.firstName
                tvSecondName.text = loveModel.secondName
                tvResult.text = loveModel.result
                tvPercentage.text = loveModel.percentage
            }
            itemView.setOnClickListener {
                onItemClick(bundleOf(LOVE_MODEL_UPDATE_KEY to loveModel))
            }
        }
    }

    companion object {
        const val LOVE_MODEL_UPDATE_KEY = "LoveUpdateInfo"
    }
}