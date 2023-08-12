package com.geeks.lovecalculator.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.databinding.ItemOnBoardingBinding
import com.geeks.lovecalculator.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = listOf(

        OnBoarding(
            "Have a good time",
            "You should take the time \nto help those who need you",
            R.raw.animation_hello
        ),
        OnBoarding(
            "Cherishing love",
            "It is now no longer possible for\n" +
                    "you to cherish love",
            R.raw.animation_love2
        ),
        OnBoarding(
            "Have a breakup?",
            "We have made the correction for you\n dont worry\nMaybe someone is waiting for you!",
            R.raw.animation_love
        ),
        OnBoarding(
            "It's Funs and Many more",
            "",
            R.raw.animation_couple
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
        fun bind(onBoarding: OnBoarding) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDescription.text = onBoarding.description
                lottieAnimationView.setAnimation(onBoarding.anim!!)
                btnStart.isVisible = adapterPosition == list.lastIndex
                btnStart.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}