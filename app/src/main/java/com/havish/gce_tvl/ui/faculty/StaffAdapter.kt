package com.havish.gce_tvl.ui.faculty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.havish.gce_tvl.R

class StaffAdapter(private val staffList: List<StaffData>, private val context: Context) :
    RecyclerView.Adapter<StaffAdapter.StaffViewAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewAdapter {
        var view: View =
            LayoutInflater.from(context).inflate(R.layout.faculty_data_layout, parent, false)
        return StaffViewAdapter(view)
    }

    override fun onBindViewHolder(holder: StaffViewAdapter, position: Int) {
        var item: StaffData = staffList.get(position)
        holder.name.text = item.name
        holder.email.text = item.email
        holder.post.text = item.post
        try {
            Glide.with(context).load(item.image).placeholder(R.drawable.avatarprofile).into(holder.image)
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    override fun getItemCount(): Int {
        return staffList.size
    }

    class StaffViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var email: TextView
        var post: TextView
        var image: ImageView

        init {

            name = itemView.findViewById(R.id.staffName)
            email = itemView.findViewById(R.id.staffEmail)
            post = itemView.findViewById(R.id.staffPost)
            image = itemView.findViewById(R.id.staffImage)
        }
    }
}