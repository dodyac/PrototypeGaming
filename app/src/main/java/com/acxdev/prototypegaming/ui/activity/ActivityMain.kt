package com.acxdev.prototypegaming.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.ViewPager
import com.acxdev.commonFunction.adapter.PageAdapter
import com.acxdev.commonFunction.common.Toast
import com.acxdev.commonFunction.util.Toast.Companion.toasty
import com.acxdev.prototypegaming.ui.fragment.FragmentBlank
import com.acxdev.prototypegaming.ui.fragment.FragmentHome
import com.acxdev.prototypegaming.R
import com.acxdev.prototypegaming.databinding.ActivityMainBinding
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior

class ActivityMain : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pager = PageAdapter(supportFragmentManager)
        pager.adds(FragmentHome(), FragmentBlank(), FragmentBlank(), FragmentBlank())
        binding.viewPager.adapter = pager
        binding.viewPager.offscreenPageLimit = 4
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                binding.bottomNav.menu.getItem(position).isChecked = true
                slideUp()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> binding.viewPager.currentItem = 0
                R.id.navigation_chat -> binding.viewPager.currentItem = 1
                R.id.navigation_list -> binding.viewPager.currentItem = 2
                R.id.navigation_person -> binding.viewPager.currentItem = 3
            }
            slideUp()
            true
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        toasty(Toast.INFO, R.string.tapAgain)
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun slideUp(){
        val layoutParams = binding.bottomNav.layoutParams as CoordinatorLayout.LayoutParams
        val bottomViewNavigationBehavior = layoutParams.behavior as HideBottomViewOnScrollBehavior
        bottomViewNavigationBehavior.slideUp(binding.bottomNav)
    }
}