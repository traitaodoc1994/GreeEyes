package com.nttapp.greeeyes.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.nttapp.greeeyes.R
import com.nttapp.greeeyes.adapter.ImagePagerAdapter

abstract class BaseImageFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var imageAdapter: ImagePagerAdapter

    // Abstract method để subclass provide danh sách ảnh
    abstract fun getImageResources(): List<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewPager = view.findViewById(R.id.view_pager)
        setupViewPager()
    }

    private fun setupViewPager() {
        val imageResources = getImageResources()
        imageAdapter = ImagePagerAdapter(imageResources)
        viewPager.adapter = imageAdapter
    }

    // Method để reset ViewPager về item đầu tiên
    fun resetToFirstItem() {
        if (::viewPager.isInitialized) {
            viewPager.setCurrentItem(0, false)
        }
    }

    // Method để get ViewPager instance nếu cần
    fun getViewPager(): ViewPager2? {
        return if (::viewPager.isInitialized) viewPager else null
    }
} 