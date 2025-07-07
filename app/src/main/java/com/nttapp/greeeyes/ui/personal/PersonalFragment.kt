package com.nttapp.greeeyes.ui.personal

import com.nttapp.greeeyes.ui.base.BaseImageFragment
import com.nttapp.greeeyes.utils.ImageResourceUtils

class PersonalFragment : BaseImageFragment() {

    override fun getImageResources(): List<Int> {
        return requireContext().let { context ->
            ImageResourceUtils.getImageResourcesByPrefix(context, "personal")
        }
    }
} 