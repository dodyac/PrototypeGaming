package com.acxdev.prototypegaming.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.prototypegaming.databinding.FragmentBlankBinding

class FragmentBlank : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root
    }
}