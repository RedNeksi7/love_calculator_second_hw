package com.geeks.lovecalculator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geeks.lovecalculator.databinding.ItemOnBoardingBinding
import com.geeks.lovecalculator.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = listOf(

        OnBoard(
            "Have a good time",
            "You should take the time \nto help those who need you",
            "https://i.postimg.cc/cHhP682g/Group-3.png"
        ),
        OnBoard(
            "Cherishing love",
            "It is now no longer possible for\n" +
                    "you to cherish love",
            "https://i.postimg.cc/054RR7sr/image-5.png"
        ),
        OnBoard(
            "Have a breakup?",
            "We have made the correction for you\n dont worry\nMaybe someone is waiting for you!",
            "https://i.postimg.cc/hP7GHSHW/image-6.png"
        ),
        OnBoard(
            "It's Funs and Many more",
            "",
            "https://i.postimg.cc/3xr7BYCH/image-7.png"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoard) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDescription.text = onBoarding.description
                imageOnBoarding.load(onBoarding.image)
                btnStart.isVisible = adapterPosition == list.lastIndex
                btnStart.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}