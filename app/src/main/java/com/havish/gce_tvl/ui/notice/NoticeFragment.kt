package com.havish.gce_tvl.ui.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.havish.gce_tvl.R


class NoticeFragment : Fragment() {


    private lateinit var deleteRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var noticeList: MutableList<NoticeData>

    private lateinit var reference: DatabaseReference

    private lateinit var adapter: NoticeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_notice, container, false)



        reference = FirebaseDatabase.getInstance().reference.child("Notice")

        deleteRecyclerView = view.findViewById(R.id.notice_recyclar_view)
        progressBar = view.findViewById(R.id.progressBar)

        deleteRecyclerView.layoutManager = LinearLayoutManager(context)
        deleteRecyclerView.setHasFixedSize(true)

        getNotice()

        return view
    }

    private fun getNotice() {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                noticeList = mutableListOf()
                if (!snapshot.exists()) {

                } else {
                    for (snap: DataSnapshot in snapshot.children) {
                        val data = snap.getValue(NoticeData::class.java)
                        noticeList.add(data!!)
                    }
                    adapter = NoticeAdapter(context!!, noticeList)
                    adapter.notifyDataSetChanged()
                    progressBar.visibility = View.GONE
                    deleteRecyclerView.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                progressBar.visibility = View.GONE
                Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}