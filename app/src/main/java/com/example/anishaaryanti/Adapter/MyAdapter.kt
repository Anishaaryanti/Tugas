package com.example.anishaaryanti.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData

class MyAdapter (private val namaList : ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class MyViewHolder(ItemData: View, listener:onItemClickListener): RecyclerView.ViewHolder(ItemData) {
        val gambar: ImageView = ItemData.findViewById(R.id.iv_pahlawan)
        val nama: TextView = ItemData.findViewById(R.id.tv_nama)
        val asal: TextView = ItemData.findViewById(R.id.tv_asal)
//     val biografi : TextView = ItemData.findViewById(R.id.tv_biografi)


    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       val ItemData = LayoutInflater.from (parent.context).inflate(R.layout.pahlawan,parent, false)
        return MyViewHolder(ItemData, mListener)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.asal.text = currentItem.asal
//        holder.biografi.text = currentItem.biografi
    }



}