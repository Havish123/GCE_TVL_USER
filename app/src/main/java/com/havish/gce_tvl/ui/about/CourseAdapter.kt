package com.havish.gce_tvl.ui.about

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.havish.gce_tvl.R

class CourseAdapter(val context:Context) : PagerAdapter() {

    private var list: MutableList<CourseModel> = mutableListOf()

    constructor(context: Context,list: MutableList<CourseModel>) : this(context) {
        this.list=list
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view:View=LayoutInflater.from(context).inflate(R.layout.coursei_tem_layout,container,false)

        var courseIcon:ImageView
        var courseTitle:TextView
        var courseDes:TextView

        courseIcon=view.findViewById(R.id.courseIcon)
        courseTitle=view.findViewById(R.id.courseTitle)
        courseDes=view.findViewById(R.id.courseDesc)

        Log.d("Mesg",list.get(position).description)

        courseIcon.setImageResource(list.get(position).img)
        courseTitle.setText(list.get(position).title)
        courseDes.setText(list.get(position).description)

        container.addView(view,0)

        return view;

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}