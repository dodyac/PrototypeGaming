package com.acxdev.prototypegaming.ui.fragment

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.commonFunction.util.view.OtherViewX.Companion.html
import com.acxdev.prototypegaming.databinding.FragmentOnBoardingBinding

class FragmentOnBoarding : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = "<font color=#FFFFFF>Get a</font> <font color=#2FD32B>Fantastic Gaming</font><font color=#FFFFFF> Experience</font> "
        binding.title.html(string)
    }
}