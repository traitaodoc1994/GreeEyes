package com.nttapp.greeeyes.ui.map

import com.nttapp.greeeyes.ui.base.BaseImageFragment
import com.nttapp.greeeyes.utils.ImageResourceUtils

class MapFragment : BaseImageFragment() {

    override fun getImageResources(): List<Int> {
        return requireContext().let { context ->
            ImageResourceUtils.getImageResourcesByPrefix(context, "map")
        }
    }
} 