package com.codeliver128.shaadiinvitation

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codeliver128.shaadiinvitation.fragment.*
import com.codeliver128.shaadiinvitation.services.SoundService
import com.codeliver128.shaadiinvitation.utils.Utils
import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter
import github.chenupt.multiplemodel.viewpager.PagerModelManager
import github.chenupt.springindicator.SpringIndicator
import github.chenupt.springindicator.viewpager.ScrollerViewPager


class HomeActivity : AppCompatActivity() {

    var viewPager: ScrollerViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById<View>(R.id.view_pager) as ScrollerViewPager
        val springIndicator = findViewById<View>(R.id.indicator) as SpringIndicator

        val manager = PagerModelManager()
      //  manager.addCommonFragment(ProgrammeFragment::class.java, getBgRes(), getTitles())
      //  manager.addFragment(HomeFragment() as Fragment,baseContext.getString(R.string.wedding))
        manager.addFragment(WeddingFragment() as Fragment,baseContext.getString(R.string.reception))
        manager.addFragment(ProgrammeFragment() as Fragment,baseContext.getString(R.string.venue))
        manager.addFragment(WishesFragment() as Fragment, baseContext.getString(R.string.wishes))
        manager.addFragment(GalleryFragment() as Fragment,baseContext.getString(R.string.photos))
        val adapter = ModelPagerAdapter(supportFragmentManager, manager)
        viewPager!!.setAdapter(adapter)
        viewPager!!.fixScrollSpeed()

        // just set viewPager
        springIndicator.setViewPager(viewPager)

    }

    override fun onStart() {
        super.onStart()
        if(!Utils.isMyServiceRunning(SoundService::class.java,this)){
            startService(Intent(this, SoundService::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
        if(Utils.isMyServiceRunning(SoundService::class.java,this)){
            stopService(Intent(this, SoundService::class.java))
        }
    }

}
