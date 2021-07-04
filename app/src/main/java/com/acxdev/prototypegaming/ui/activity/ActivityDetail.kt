package com.acxdev.prototypegaming.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acxdev.commonFunction.util.view.RecyclerViewX.Companion.adapter
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.adapter.RowSlider
import com.acxdev.prototypegaming.adapter.RowSpec
import com.acxdev.prototypegaming.common.Constant
import com.acxdev.prototypegaming.databinding.ActivityDetailBinding
import com.acxdev.prototypegaming.model.Game
import com.acxdev.prototypegaming.model.Spec
import com.acxdev.prototypegaming.util.Func.Companion.toIDR
import com.google.gson.Gson

class ActivityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener { onBackPressed() }

        val data = Gson().fromJson(intent.getStringExtra(Constant.DATA), Game::class.java)

        binding.imageSlider.adapter(RowSlider(data.imageList))

        binding.genre.text = getString(data.genre)
        binding.name.text = getString(data.name)
        binding.desc.text = getString(data.desc)

        binding.price.text = if(data.price != null) data.price.toIDR() else getString(R.string.freeToPlay)
        binding.play.text = if(data.price != null) getString(R.string.addToCart) else getString(R.string.playNow)

        binding.requirement.adapter(RowSpec(Constant.spec()), hasFixed = true)
    }
}