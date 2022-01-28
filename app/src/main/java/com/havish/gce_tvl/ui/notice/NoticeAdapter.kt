package com.havish.gce_tvl.ui.notice
import android.annotation.SuppressLint
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.havish.gce_tvl.R
import com.squareup.picasso.Picasso

class NoticeAdapter() : RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>() {
    private lateinit var context:Context
    private lateinit var noticeList: List<NoticeData>

    constructor(context: Context,list:List<NoticeData>) : this() {
        this.context=context
        this.noticeList=list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoticeAdapter.NoticeViewAdapter {
        var view:View=
            LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout,parent,false)
        return NoticeViewAdapter(view)
    }

    override fun onBindViewHolder(holder: NoticeViewAdapter, @SuppressLint("RecyclerView") position: Int) {
        var item:NoticeData=noticeList.get(position)
        holder.notice_title.text=item.title
        holder.date.text=item.date
        holder.time.text=item.time
        var display:DisplayMetrics=context.resources.displayMetrics
        var width:Int=display.widthPixels

        try {
            if(item.image!=null)
                Glide.with(context).load(item.image).override(width,width).optionalCenterCrop().into(holder.notice_image)
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

    class NoticeViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var deleteNoticeBtn:Button
        var notice_title:TextView
        var notice_image:ImageView
        var date:TextView
        var time:TextView
        init {
//            deleteNoticeBtn=itemView.findViewById(R.id.deleteNoticeBtn)
            notice_title=itemView.findViewById(R.id.notice_title)
            notice_image=itemView.findViewById(R.id.notice_image)
            date=itemView.findViewById(R.id.date)
            time=itemView.findViewById(R.id.time)
        }
    }
}