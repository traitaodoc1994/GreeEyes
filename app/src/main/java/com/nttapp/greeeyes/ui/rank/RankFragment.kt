package com.nttapp.greeeyes.ui.rank

import com.nttapp.greeeyes.ui.base.BaseImageFragment
import com.nttapp.greeeyes.utils.ImageResourceUtils

class RankFragment : BaseImageFragment() {

    override fun getImageResources(): List<Int> {
        return requireContext().let { context ->
            ImageResourceUtils.getImageResourcesByPrefix(context, "rank")
        }
    }
} 