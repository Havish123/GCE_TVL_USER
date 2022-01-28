package com.havish.gce_tvl.ui.gallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.havish.gce_tvl.R


class GalleryFragment : Fragment() {

    lateinit var IndrecyclerView:RecyclerView
    lateinit var GradrecyclerView:RecyclerView
    lateinit var otherRecycler:RecyclerView
    lateinit var adapter: GalleryAdapter
    lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_gallery, container, false)

        IndrecyclerView=view.findViewById(R.id.independanceRecyclar)
        GradrecyclerView=view.findViewById(R.id.graduationRecyclar)
        otherRecycler=view.findViewById(R.id.otherRecyclar)
        reference=FirebaseDatabase.getInstance().reference.child("gallery")

        getIndependance()
        getGraduation()
        getOtherEvents()
        return view
    }

    private fun getOtherEvents() {
        reference.child("Other Events").addValueEventListener(object :ValueEventListener{
            var otherList:MutableList<String> = mutableListOf()
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                     var data:String=snap.value.toString()
                    otherList.add(data)
                }
                adapter= GalleryAdapter(otherList,context!!)
                otherRecycler.layoutManager=GridLayoutManager(context,3)
                otherRecycler.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
            }

        })

    }

    private fun getGraduation() {
        reference.child("Graduation Day").addValueEventListener(object :ValueEventListener{
            var gradList:MutableList<String> = mutableListOf()
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                    var data:String=snap.value.toString()
                    gradList.add(data)
                }
                adapter= GalleryAdapter(gradList,context!!)
                GradrecyclerView.layoutManager=GridLayoutManager(context,3)
                GradrecyclerView.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun getIndependance() {
        reference.child("Independance Day").addValueEventListener(object :ValueEventListener{
            var indList:MutableList<String> = mutableListOf()
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                    var data:String=snap.value.toString()
                    indList.add(data)
                }
                adapter= GalleryAdapter(indList,context!!)
                IndrecyclerView.layoutManager=GridLayoutManager(context,3)
                IndrecyclerView.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
            }

        })
    }

}