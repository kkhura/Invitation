package com.invitation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.invitation.R
import com.invitation.WishesModel
import com.invitation.adapters.WishesAdapter
import java.util.*


class WishesFragment : Fragment() {

    private lateinit var rv_wishes: RecyclerView
    private lateinit var wishesAdapter: WishesAdapter
    private var wishesList = ArrayList<WishesModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.wishes_fragment, container, false)
        rv_wishes = view.findViewById<RecyclerView>(R.id.rv_wishes)
        val layoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(context);
        rv_wishes.layoutManager = layoutManager

        wishesList.clear();
        wishesAdapter = WishesAdapter(activity as Context, wishesList)

        rv_wishes.adapter = wishesAdapter

        val database = FirebaseFirestore.getInstance();
        val docRef = database.collection("wishes").document("wish")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val hashMap = document.data as kotlin.collections.HashMap<*, *>
                    for (obj in hashMap.values) {
                        if (obj is Map<*, *>) {
                            val mapObj = obj as Map<String, Object>
                            val match = WishesModel(
                                mapObj["name"] as String,
                                mapObj["text"] as String,
                                mapObj["image"] as String
                            )
                            wishesList.add(match)
                        }
                    }
                    wishesAdapter.notifyDataSetChanged()
                } else {
                    Log.d("TAG", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }

        return view
    }


}

