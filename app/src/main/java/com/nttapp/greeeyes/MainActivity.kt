package com.nttapp.greeeyes

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.nttapp.greeeyes.ui.map.MapFragment
import com.nttapp.greeeyes.ui.tracking.TrackingFragment
import com.nttapp.greeeyes.ui.pet.PetFragment
import com.nttapp.greeeyes.ui.rank.RankFragment
import com.nttapp.greeeyes.ui.notifications.NotificationsFragment
import com.nttapp.greeeyes.ui.personal.PersonalFragment
import com.nttapp.greeeyes.ui.base.BaseImageFragment

class MainActivity : AppCompatActivity() {
    
    // Danh sách các tab ImageView
    private lateinit var tabMap: ImageView
    private lateinit var tabTracking: ImageView
    private lateinit var tabPet: ImageView
    private lateinit var tabRank: ImageView
    private lateinit var tabNotifications: ImageView
    private lateinit var tabPersonal: ImageView
    
    // Danh sách tất cả tabs để dễ quản lý
    private val allTabs = mutableListOf<ImageView>()
    
    // Fragment hiện tại
    private var currentFragment: Fragment? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        setupTabs()
        
        // Hiển thị fragment đầu tiên (Map) và set tab selected
        showFragment(MapFragment(), 0)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    
    private fun setupTabs() {
        // Khởi tạo các tab
        tabMap = findViewById(R.id.tab_map)
        tabTracking = findViewById(R.id.tab_tracking)
        tabPet = findViewById(R.id.tab_pet)
        tabRank = findViewById(R.id.tab_rank)
        tabNotifications = findViewById(R.id.tab_notifications)
        tabPersonal = findViewById(R.id.tab_personal)
        
        // Thêm vào danh sách
        allTabs.addAll(listOf(tabMap, tabTracking, tabPet, tabRank, tabNotifications, tabPersonal))
        
        // Set click listeners
        tabMap.setOnClickListener { 
            showFragment(MapFragment(), 0)
        }
        
        tabTracking.setOnClickListener { 
            showFragment(TrackingFragment(), 1)
        }
        
        tabPet.setOnClickListener { 
            showFragment(PetFragment(), 2)
        }
        
        tabRank.setOnClickListener { 
            showFragment(RankFragment(), 3)
        }
        
        tabNotifications.setOnClickListener { 
            showFragment(NotificationsFragment(), 4)
        }
        
        tabPersonal.setOnClickListener { 
            showFragment(PersonalFragment(), 5)
        }
    }
    
    private fun showFragment(fragment: Fragment, selectedIndex: Int) {
        // Chuyển fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        
        currentFragment = fragment
        
        // Reset ViewPager về item đầu tiên nếu fragment có ViewPager
        if (fragment is BaseImageFragment) {
            // Delay một chút để đảm bảo fragment đã được load
            fragment.view?.post {
                fragment.resetToFirstItem()
            }
        }
        
        // Cập nhật trạng thái selected/unselected
        updateTabsState(selectedIndex)
    }
    
    private fun updateTabsState(selectedIndex: Int) {
        // Reset tất cả tabs về trạng thái unselected
        allTabs.forEachIndexed { index, tab ->
            if (index == selectedIndex) {
                // Tab được chọn - set selected = true để trigger background xanh
                tab.isSelected = true
                tab.alpha = 1.0f
            } else {
                // Tab không được chọn - set selected = false, background transparent
                tab.isSelected = false
                tab.alpha = 0.8f
            }
        }
    }
}