package com.example.anishaaryanti.Adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.Activity.DetailActivity
import com.example.anishaaryanti.Activity.loadImage
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData

class MyAdapter (var mContext : Context, var listPahlawan: List<ItemData>):
    RecyclerView.Adapter<MyAdapter.ListViewHolder>()

{
        inner class  ListViewHolder(var v: View): RecyclerView.ViewHolder(v){
         val imgT = v.findViewById<ImageView>(R.id.iv_pahlawan)
         val nameT = v.findViewById<TextView>(R.id.tv_nama)
         val asalT = v.findViewById<TextView>(R.id.tv_asal)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       var infalter = LayoutInflater.from (parent.context)
        var v = infalter.inflate(R.layout.pahlawan, parent, false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int = listPahlawan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val newList = listPahlawan[position]
        holder.nameT.text = newList.nama
        holder.asalT.text = newList.asal
        holder.imgT.loadImage(newList.gambar)
        holder.v.setOnClickListener {

            val name = newList.nama
            val biografi = newList.biografi
            val gambar = newList.gambar

            val mIntent = Intent (mContext, DetailActivity::class.java)
            mIntent.putExtra("nama", name)
            mIntent.putExtra("biografi", biografi)
            mIntent.putExtra("gambar", gambar)
            mContext.startActivity(mIntent)

        }
    }



}