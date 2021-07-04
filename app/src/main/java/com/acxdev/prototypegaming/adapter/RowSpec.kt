package com.acxdev.prototypegaming.adapter

import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.prototypegaming.databinding.RowSpecBinding
import com.acxdev.prototypegaming.model.Spec

class RowSpec(private val list: MutableList<Spec>) :
    BaseAdapter<RowSpecBinding>(RowSpecBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowSpecBinding>, position: Int) {
        val list = list[position]
        holder.binding.title.text = list.title
        holder.binding.subtitle.text = list.subtitle
        holder.binding.processor.text = list.processor
        holder.binding.ram.text = list.ram
        holder.binding.gpu.text = list.gpu
    }
}