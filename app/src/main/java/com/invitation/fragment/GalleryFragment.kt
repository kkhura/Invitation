package com.invitation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.invitation.R
import com.invitation.adapters.HorizontalPagerAdapter
import java.util.*
import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener





class GalleryFragment : androidx.fragment.app.Fragment() {

    private lateinit var storage: FirebaseStorage
    private lateinit var databaseReference: DatabaseReference
    private lateinit var hicvp: HorizontalInfiniteCycleViewPager
    private var list = ArrayList<UploadInfo>()
    private lateinit var valueEventListener: ValueEventListener
    private lateinit var progress_circular: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storage = FirebaseStorage.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.photo_fragment, container, false)
        hicvp = view.findViewById(R.id.hicvp)
        progress_circular = view.findViewById(R.id.progress_circular)
        /*hicvp.scrollDuration = 400
        // hicvp.setPageDuration(1000)hicvp
        hicvp.interpolator = AnimationUtils.loadInterpolator(context, android.R.anim.linear_interpolator)
        hicvp.isMediumScaled = false
        hicvp.maxPageScale = 0.8f
        hicvp.minPageScale = 0.5f
        hicvp.centerPageScaleOffset = 30.0f
        hicvp.minPageScaleOffset = 5.0f*/
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
                        val match = UploadInfo(
                            mapObj["fileName"] as String,
                            mapObj["fileUrl"] as String
                        )
                        list.add(match)
                    }
                }
                hicvp.adapter = HorizontalPagerAdapter(context, list)
                progress_circular.visibility = View.GONE;
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        }

        databaseReference.addValueEventListener(valueEventListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        databaseReference.removeEventListener(valueEventListener)
    }
}