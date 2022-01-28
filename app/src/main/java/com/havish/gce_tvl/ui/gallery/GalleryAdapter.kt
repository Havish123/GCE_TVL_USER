package com.havish.gce_tvl.ui.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.havish.gce_tvl.R
import com.havish.gce_tvl.ui.faculty.StaffData

class GalleryAdapter() : RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter>(){

        private lateinit var context: Context
        private lateinit var imageList:List<String>

    constructor( imageList: List<String>, context: Context) : this(){
        this.context=context
        this.imageList=imageList
    }



    class GalleryViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView

        init {

            image = itemView.findViewById(R.id.imageg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewAdapter {
        var view:View=LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false)
        return GalleryViewAdapter(view)
    }

    override fun onBindViewHolder(holder: GalleryViewAdapter, position: Int) {
        Glide.with(context).load(imageList.get(position)).into(holder.image)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}