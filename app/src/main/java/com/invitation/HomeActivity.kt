package com.invitation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseApp
import com.invitation.databinding.ActivityHomeBinding
import com.invitation.fragment.*
import com.invitation.services.SoundService
import com.invitation.utils.Utils
import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter
import github.chenupt.multiplemodel.viewpager.PagerModelManager


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val manager = PagerModelManager()
//        manager.addFragment(HomeFragment() as Fragment,baseContext.getString(R.string.wedding))
        manager.addFragment(WeddingFragment(), getString(R.string.reception))
        manager.addFragment(ProgrammeFragment(), getString(R.string.venue))
        manager.addFragment(WishesFragment(), getString(R.string.wishes))
        manager.addFragment(GalleryFragment(), getString(R.string.photos))

        val adapter = ModelPagerAdapter(supportFragmentManager, manager)
        binding.viewPager.adapter = adapter
        binding.viewPager.fixScrollSpeed()

        // just set viewPager
        binding.indicator.setViewPager(binding.viewPager)
    }

    override fun onStart() {
        super.onStart()
        if (!Utils.isMyServiceRunning(SoundService::class.java, this)) {
//            startService(Intent(this, SoundService::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
//        if (Utils.isMyServiceRunning(SoundService::class.java, this)) {
//            stopService(Intent(this, SoundService::class.java))
//        }
    }

}
