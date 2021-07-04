package com.acxdev.prototypegaming.adapter

import android.content.Intent
import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.common.Constant
import com.acxdev.prototypegaming.databinding.RowPopularBinding
import com.acxdev.prototypegaming.model.Game
import com.acxdev.prototypegaming.ui.activity.ActivityDetail
import com.acxdev.prototypegaming.util.Func.Companion.toIDR
import com.google.gson.Gson

class RowPopular(private val list: MutableList<Game>) :
    BaseAdapter<RowPopularBinding>(RowPopularBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowPopularBinding>, position: Int) {
        val list = list[position]
        holder.binding.name.text = context.getString(list.name)
        holder.binding.genre.text = context.getString(list.genre)
        holder.binding.desc.text = context.getString(list.desc)
        holder.binding.image.setImageResource(list.image)
        holder.binding.price.text = if(list.price != null) list.price.toIDR() else context.getString(R.string.freeToPlay)
        holder.binding.play.text = if(list.price != null) context.getString(R.string.addToCart) else context.getString(R.string.playNow)
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, ActivityDetail::class.java).putExtra(Constant.DATA, Gson().toJson(list))) }
    }
}