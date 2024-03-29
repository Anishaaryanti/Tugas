package com.example.anishaaryanti.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData

class MyAdapter (private val namaList : ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
 class MyViewHolder (ItemData: View) : RecyclerView.ViewHolder (ItemData) {
     val gambar :ImageView = ItemData.findViewById(R.id.iv_pahlawan)
     val nama : TextView = ItemData.findViewById(R.id.tv_nama)
     val asal : TextView = ItemData.findViewById(R.id.tv_asal)
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       val ItemData = LayoutInflater.from (parent.context).inflate(R.layout.pahlawan,parent, false)
        return MyViewHolder(ItemData)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.asal.text = currentItem.asal
    }

    override fun getItemCount(): Int = namaList.size


}