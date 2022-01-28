package com.havish.gce_tvl.ui.faculty

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.havish.gce_tvl.R

class FacultyFragment : Fragment() {

    private lateinit var csDep:RecyclerView
    private lateinit var mechDep:RecyclerView
    private lateinit var civilDep:RecyclerView
    private lateinit var eceDep: RecyclerView
    private lateinit var eeeDep:RecyclerView
    private lateinit var csNoData:LinearLayout
    private lateinit var mechNoData:LinearLayout
    private lateinit var civilNoData: LinearLayout
    private lateinit var eceNoData:LinearLayout
    private lateinit var eeeNoData:LinearLayout
    private lateinit var reference: DatabaseReference
    private lateinit var dbRef: DatabaseReference
    private lateinit var cseList:MutableList<StaffData>
    private lateinit var mechList:MutableList<StaffData>
    private lateinit var civilList:MutableList<StaffData>
    private lateinit var eceList:MutableList<StaffData>
    private lateinit var eeeList:MutableList<StaffData>
    private lateinit var staffAdapter: StaffAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_faculty, container, false)

        reference= FirebaseDatabase.getInstance().reference.child("staff")
        csDep=view.findViewById(R.id.csDep)
        mechDep=view.findViewById(R.id.mechDep)
        civilDep=view.findViewById(R.id.civilDep)
        eceDep=view.findViewById(R.id.eceDep)
        eeeDep=view.findViewById(R.id.eeeDep)

        csNoData=view.findViewById(R.id.csNoData)
        mechNoData=view.findViewById(R.id.mechNoData)
        civilNoData=view.findViewById(R.id.civilNoData)
        eceNoData=view.findViewById(R.id.eceNoData)
        eeeNoData=view.findViewById(R.id.eeeNoData)

        csDepartment()
        mechDepartment()
        civilDepartment()
        eceDepartment()
        eeeDepartment()


        return view
    }

    private fun csDepartment() {
        dbRef=reference.child("CSE")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                cseList= mutableListOf()
                if(!snapshot.exists()){
                    csNoData.visibility= View.VISIBLE
                    csDep.visibility=View.GONE
                }else{
                    csNoData.visibility= View.GONE
                    csDep.visibility=View.VISIBLE
                    for (snap:DataSnapshot in snapshot.children){
                        val data=snap.getValue(StaffData::class.java)
                        cseList.add(data!!)
                    }
                    csDep.setHasFixedSize(true)
                    csDep.layoutManager= LinearLayoutManager(context)
                    staffAdapter= StaffAdapter(cseList, context!!)
                    csDep.adapter=staffAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun mechDepartment() {
        dbRef=reference.child("MECH")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mechList= mutableListOf()
                if(!snapshot.exists()){
                    mechNoData.visibility= View.VISIBLE
                    mechDep.visibility=View.GONE
                }else{
                    mechNoData.visibility= View.GONE
                    mechDep.visibility=View.VISIBLE
                    for (snap:DataSnapshot in snapshot.children){
                        val data=snap.getValue(StaffData::class.java)
                        mechList.add(data!!)
                    }
                    mechDep.setHasFixedSize(true)
                    mechDep.layoutManager=LinearLayoutManager(context)
                    staffAdapter= StaffAdapter(mechList,context!!)
                    mechDep.adapter=staffAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun civilDepartment() {
        dbRef=reference.child("CIVIL")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                civilList= mutableListOf()
                if(!snapshot.exists()){
                    civilNoData.visibility= View.VISIBLE
                    civilDep.visibility=View.GONE
                }else{
                    civilNoData.visibility= View.GONE
                    civilDep.visibility=View.VISIBLE
                    for (snap:DataSnapshot in snapshot.children){
                        val data=snap.getValue(StaffData::class.java)
                        civilList.add(data!!)
                    }
                    civilDep.setHasFixedSize(true)
                    civilDep.layoutManager=LinearLayoutManager(context)
                    staffAdapter= StaffAdapter(civilList,context!!)
                    civilDep.adapter=staffAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun eceDepartment() {
        dbRef=reference.child("ECE")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                eceList= mutableListOf()
                if(!snapshot.exists()){
                    eceNoData.visibility= View.VISIBLE
                    eceDep.visibility=View.GONE
                }else{
                    eceNoData.visibility= View.GONE
                    eceDep.visibility=View.VISIBLE
                    for (snap:DataSnapshot in snapshot.children){
                        val data=snap.getValue(StaffData::class.java)
                        eceList.add(data!!)
                    }
                    eceDep.setHasFixedSize(true)
                    eceDep.layoutManager=LinearLayoutManager(context)
                    staffAdapter= StaffAdapter(eceList,context!!)
                    eceDep.adapter=staffAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun eeeDepartment() {
        dbRef=reference.child("EEE")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                eeeList= mutableListOf()
                if(!snapshot.exists()){
                    eeeNoData.visibility= View.VISIBLE
                    eeeDep.visibility=View.GONE
                }else{
                    eeeNoData.visibility= View.GONE
                    eeeDep.visibility=View.VISIBLE
                    for (snap:DataSnapshot in snapshot.children){
                        val data=snap.getValue(StaffData::class.java)
                        eeeList.add(data!!)
                    }
                    eeeDep.setHasFixedSize(true)
                    eeeDep.layoutManager=LinearLayoutManager(context)
                    staffAdapter= StaffAdapter(eeeList,context!!)
                    eeeDep.adapter=staffAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
}