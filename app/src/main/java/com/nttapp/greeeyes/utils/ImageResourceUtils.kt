package com.nttapp.greeeyes.utils

import android.content.Context
import com.nttapp.greeeyes.R

object ImageResourceUtils {
    
    /**
     * Load danh sách ảnh theo naming convention: [prefix][number].png
     * Ví dụ: map1.png, map2.png, tracking1.png, etc.
     */
    fun getImageResourcesByPrefix(context: Context, prefix: String): List<Int> {
        val resources = mutableListOf<Int>()
        var index = 1
        
        while (true) {
            val resourceName = "${prefix}${index}"
            val resourceId = context.resources.getIdentifier(
                resourceName, 
                "drawable", 
                context.packageName
            )
            
            if (resourceId != 0) {
                resources.add(resourceId)
                index++
            } else {
                break
            }
        }
        
        // Nếu không tìm thấy ảnh nào theo pattern, return ảnh mặc định
        return if (resources.isEmpty()) {
            listOf(getDefaultImageForPrefix(prefix))
        } else {
            resources
        }
    }
    
    /**
     * Lấy ảnh mặc định khi không tìm thấy ảnh theo pattern
     */
    private fun getDefaultImageForPrefix(prefix: String): Int {
        return when (prefix) {
            "map" -> R.drawable.map
            "tracking" -> R.drawable.tracking
            "pet" -> R.drawable.pet
            "rank" -> R.drawable.rank
            "notifications" -> R.drawable.notifications
            "personal" -> R.drawable.personal
            else -> R.drawable.map // fallback
        }
    }
} 