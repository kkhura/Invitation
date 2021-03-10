package com.codeliver128.shaadiinvitation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codeliver128.shaadiinvitation.R
import com.codeliver128.shaadiinvitation.WishesModel
import com.codeliver128.shaadiinvitation.adapters.WishesAdapter.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView

class WishesAdapter(private val context: Context, private val list: List<WishesModel>?) :
    RecyclerView.Adapter<WishesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.wishes_list_item, parent, false) as View
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val wishesModel = list!![position]
        holder.txt_message.text = wishesModel.message
        holder.txt_name.text = "--" + wishesModel.name

        holder.profile_image.setImageResource(wishesModel.photo_id)

        if(position==0){
            holder.temp_margin_top.visibility=View.VISIBLE
        }else{
            holder.temp_margin_top.visibility=View.GONE
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


    // you provide access to all the views for a data item in a view holder
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var txt_message: TextView
        var txt_name: TextView
        var temp_margin_top:FrameLayout

         val profile_image: CircleImageView

        init {
            profile_image = v.findViewById(R.id.profile_image)
            txt_message = v.findViewById(R.id.txt_message)
            txt_name = v.findViewById(R.id.txt_name)
            temp_margin_top=v.findViewById(R.id.temp_margin_top)
        }
    }

}