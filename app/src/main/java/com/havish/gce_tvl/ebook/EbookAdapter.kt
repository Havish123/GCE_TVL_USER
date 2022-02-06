package com.havish.gce_tvl.ebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.havish.gce_tvl.R
import com.havish.gce_tvl.ui.faculty.StaffData

class EbookAdapter(private val ebookList: List<EbookData>, private val context: Context): RecyclerView.Adapter<EbookAdapter.EbookViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewHolder {

        var view:View=LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false)

        return EbookViewHolder(view);
    }

    override fun onBindViewHolder(holder: EbookViewHolder, position: Int) {

        holder.pdfTitle.setText(ebookList.get(position).pdfTitle)

        holder.itemView.setOnClickListener{
            Toast.makeText(context,ebookList.get(position).pdfTitle,Toast.LENGTH_LONG).show()
        }

        holder.pdfDownload.setOnClickListener{
            Toast.makeText(context,"Download",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return ebookList.size
    }

    public class EbookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pdfTitle:TextView
        var pdfDownload:ImageView

        init {
            pdfTitle=itemView.findViewById(R.id.pdfName)
            pdfDownload=itemView.findViewById(R.id.downloadPdfBtn)
        }
    }

}