package com.acxdev.prototypegaming.adapter

import com.acxdev.commonFunction.adapter.BaseSlider
import com.acxdev.prototypegaming.databinding.RowSliderBinding

class RowSlider(private val list: MutableList<Int>) :
    BaseSlider<RowSliderBinding>(RowSliderBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowSliderBinding>, position: Int) {
        val list = list[position]
        holder.binding.image.setImageResource(list)
    }
}