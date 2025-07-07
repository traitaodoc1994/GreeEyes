package com.nttapp.greeeyes.ui.tracking

import com.nttapp.greeeyes.ui.base.BaseImageFragment
import com.nttapp.greeeyes.utils.ImageResourceUtils

class TrackingFragment : BaseImageFragment() {

    override fun getImageResources(): List<Int> {
        return requireContext().let { context ->
            ImageResourceUtils.getImageResourcesByPrefix(context, "tracking")
        }
    }
} 