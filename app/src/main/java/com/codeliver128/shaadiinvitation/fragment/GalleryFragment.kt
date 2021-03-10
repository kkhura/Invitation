package com.codeliver128.shaadiinvitation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeliver128.shaadiinvitation.R
import com.codeliver128.shaadiinvitation.adapters.HorizontalPagerAdapter
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.item_image.view.*
import android.widget.Toast
import android.R.attr.author
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.DataSnapshot
import java.util.*


class GalleryFragment : androidx.fragment.app.Fragment() {

    private lateinit var storage: FirebaseStorage
    private lateinit var databaseReference: DatabaseReference
    private lateinit var hicvp: HorizontalInfiniteCycleViewPager
    private val mUploadInfoListener: ChildEventListener? = null
    private var list = ArrayList<UploadInfo>()
    private lateinit var valueEventListener: ValueEventListener
    private lateinit var progress_circular: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(context)
        storage = FirebaseStorage.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.photo_fragment, container, false)
        hicvp = view.findViewById<HorizontalInfiniteCycleViewPager>(R.id.hicvp)
        progress_circular = view.findViewById(R.id.progress_circular)
        var query: Query = databaseReference.orderByKey();

        /*  hicvp.setScrollDuration(400)
         // hicvp.setPageDuration(1000)hicvp
          hicvp.setInterpolator(
              AnimationUtils.loadInterpolator(context, android.R.anim.linear_interpolator)
          )
          hicvp.setMediumScaled(false)
          hicvp.setMaxPageScale(0.8f)
          hicvp.setMinPageScale(0.5f)
          hicvp.setCenterPageScaleOffset(30.0f)
          hicvp.setMinPageScaleOffset(5.0f)*/
        return view
    }


    override fun onStart() {
        super.onStart()
        valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val td = dataSnapshot.value as HashMap<String, Object>
                for (obj in td.values) {
                    if (obj is Map<*, *>) {
                        val mapObj = obj as Map<String, Object>
                        val match = UploadInfo(mapObj.get("FileName") as String, mapObj.get("FileUrl") as String)
                        list.add(match)
                    }
                }
                hicvp.adapter = HorizontalPagerAdapter(context, list)
                Log.e("Valueevent Info", "onChildAdded:" + list.toString())
                progress_circular.visibility = View.GONE;
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        databaseReference.addValueEventListener(valueEventListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        databaseReference.removeEventListener(valueEventListener)
    }
}