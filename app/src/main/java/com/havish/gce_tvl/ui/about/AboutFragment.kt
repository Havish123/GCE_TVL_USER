package com.havish.gce_tvl.ui.about

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.havish.gce_tvl.R

class AboutFragment : Fragment() {

    private lateinit var viewPager:ViewPager
    private lateinit var adapter: CourseAdapter
    private lateinit var list:MutableList<CourseModel>
    var url:String="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2FGCE.jpg?alt=media&token=d10873fc-647a-49ea-bdf8-dd400aaff168"

    var eceDes:String="The salient aspects of the department such as facilities available, achievements , students forum etc are brought out in the succeeding sections. Electronics & Communication Engineering deals with the electronic devices,integrated circuits (IC)."
    var eeeDes:String="Department of Electrical and Electronics Engineering was established in 1999 with the objective to produce professionally competent students for a career in Electrical and Electronics Engineering by providing value-based quality education."
    var civilDes:String="Civil engineers create, improve and protect the environment in which we live. They plan, design and oversee construction and maintenance of building structures and infrastructure, such as roads, railways and sewerage systems."
    var mechDes:String="Mechanical engineering is an engineering branch that combines engineering physics and mathematics principles with materials science, to design, analyze, manufacture, and maintain mechanical systems. "
    var compDes:String= "The discipline of computer science includes the study of algorithms and data structures, computer and network design, modeling data and information processes, and artificial intelligence."
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_about, container, false)
        // Inflate the layout for this fragment
        list= mutableListOf()
        list.add(CourseModel(R.drawable.ic_computer,"CSE",compDes ))
        list.add(CourseModel(R.drawable.ic_ece,"ECE", eceDes ))
        list.add(CourseModel(R.drawable.ic_eee,"EEE", eeeDes ))
        list.add(CourseModel(R.drawable.ic_mech,"MECH",  mechDes))
        list.add(CourseModel(R.drawable.ic_civil,"CIVIL ", civilDes ))

        adapter= CourseAdapter(requireContext(),list)

        viewPager=view.findViewById(R.id.viewPager)

        viewPager.adapter=adapter

        var imageView:ImageView=view.findViewById(R.id.college_image)

        Glide.with(requireContext()).load(url).into(imageView)


        return view
    }

}