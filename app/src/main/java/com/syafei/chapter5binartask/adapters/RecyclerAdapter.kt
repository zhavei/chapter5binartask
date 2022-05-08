package com.syafei.chapter5binartask.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syafei.chapter5binartask.DetailsActivity
import com.syafei.chapter5binartask.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    companion object {
        const val NUMBER = "number"
        const val CODE = "code"
        const val CATEGORY = "category"
        const val CONTENT = "content"
    }

    private val kode = arrayOf(
        "d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b", "afasfaa", "adasdad"
    )

    private val kategori = arrayOf(
        "Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana",
        "fiqih", "tauhid"
    )

    private val isi = arrayOf(
        "pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21", "pertanyaan 56", "pertanyaan 69"
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemKode: TextView = itemView.findViewById(R.id.kodePertanyaan)
        var itemKategori: TextView = itemView.findViewById(R.id.kategori)
        var itemIsi: TextView = itemView.findViewById(R.id.isiPertanyaan)

        init {

            itemView.setOnClickListener {
                var position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra(NUMBER, position)
                    putExtra(CODE, itemKode.text)
                    putExtra(CATEGORY, itemKategori.text)
                    putExtra(CONTENT, itemIsi.text)
                }
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemKode.text = kode[position]
        holder.itemKategori.text = kategori[position]
        holder.itemIsi.text = isi[position]
    }

    override fun getItemCount(): Int {
        return kode.size
    }
}