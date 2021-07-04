package com.acxdev.prototypegaming.adapter

import android.content.Intent
import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.common.Constant
import com.acxdev.prototypegaming.databinding.RowHeaderBinding
import com.acxdev.prototypegaming.model.Game
import com.acxdev.prototypegaming.ui.activity.ActivityDetail
import com.google.gson.Gson

class RowHeader(private val list: MutableList<Game>) :
    BaseAdapter<RowHeaderBinding>(RowHeaderBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowHeaderBinding>, position: Int) {
        val list = list[position]
        holder.binding.genre.text = context.getString(list.genre)
        holder.binding.desc.text = context.getString(list.desc)
        holder.binding.logo.setImageResource(list.logo!!)
        holder.binding.image.setImageResource(list.image)
        holder.binding.play.text = if(list.price != null) context.getString(R.string.addToCart) else context.getString(R.string.playNow)
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, ActivityDetail::class.java).putExtra(Constant.DATA, Gson().toJson(list))) }
    }
}