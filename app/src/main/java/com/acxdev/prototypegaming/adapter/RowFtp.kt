package com.acxdev.prototypegaming.adapter

import android.content.Intent
import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.common.Constant
import com.acxdev.prototypegaming.databinding.RowFtpBinding
import com.acxdev.prototypegaming.databinding.RowHeaderBinding
import com.acxdev.prototypegaming.model.Game
import com.acxdev.prototypegaming.ui.activity.ActivityDetail
import com.google.gson.Gson

class RowFtp(private val list: MutableList<Game>) :
    BaseAdapter<RowFtpBinding>(RowFtpBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowFtpBinding>, position: Int) {
        val list = list[position]
        holder.binding.genre.text = context.getString(list.genre)
        holder.binding.desc.text = context.getString(list.desc)
        holder.binding.name.text = context.getString(list.name)
        holder.binding.image.setImageResource(list.image)
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, ActivityDetail::class.java).putExtra(Constant.DATA, Gson().toJson(list))) }
    }
}