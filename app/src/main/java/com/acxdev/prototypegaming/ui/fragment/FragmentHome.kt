package com.acxdev.prototypegaming.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.commonFunction.util.view.RecyclerViewX.Companion.adapter
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.adapter.RowFtp
import com.acxdev.prototypegaming.adapter.RowHeader
import com.acxdev.prototypegaming.adapter.RowPopular
import com.acxdev.prototypegaming.common.Constant
import com.acxdev.prototypegaming.databinding.FragmentHomeBinding
import com.acxdev.prototypegaming.model.Game

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.header.adapter(RowHeader(Constant.headerGame()), true)

        binding.popularGames.adapter(RowPopular(Constant.popularGames()))

        binding.freeToPlay.adapter(RowFtp(Constant.freeToPlayGame()),1)
    }
}