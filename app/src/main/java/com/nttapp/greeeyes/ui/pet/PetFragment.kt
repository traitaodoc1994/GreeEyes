package com.nttapp.greeeyes.ui.pet

import com.nttapp.greeeyes.ui.base.BaseImageFragment
import com.nttapp.greeeyes.utils.ImageResourceUtils

class PetFragment : BaseImageFragment() {

    override fun getImageResources(): List<Int> {
        return requireContext().let { context ->
            ImageResourceUtils.getImageResourcesByPrefix(context, "pet")
        }
    }
} 