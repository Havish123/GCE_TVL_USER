package com.havish.gce_tvl.ebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.havish.gce_tvl.R
import com.havish.gce_tvl.ui.faculty.StaffData

class EbookActivity : AppCompatActivity() {
    private lateinit var recycler:RecyclerView
    private lateinit var databaseReference: DatabaseReference
    private lateinit var list: MutableList<EbookData>
    private lateinit var adapter: EbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook)

        recycler=findViewById(R.id.ebookRecyclar)
        databaseReference=FirebaseDatabase.getInstance().reference.child("pdf").child("ECE")

        getData()
    }

    private fun getData() {
        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list= mutableListOf()
                for (snap:DataSnapshot in snapshot.children){
                    val data=snap.getValue(EbookData::class.java)
                    list.add(data!!)

                }
                recycler.setHasFixedSize(true)
                recycler.layoutManager= LinearLayoutManager(this@EbookActivity)
                adapter= EbookAdapter(list,this@EbookActivity)
                recycler.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@EbookActivity,error.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}