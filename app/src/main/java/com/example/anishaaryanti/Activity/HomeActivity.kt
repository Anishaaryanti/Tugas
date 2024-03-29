package com.example.anishaaryanti.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.Adapter.MyAdapter
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData
import com.example.anishaaryanti.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var pahlawanAdapter: MyAdapter
    private lateinit var listPahlawan : ArrayList<ItemData>

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        listPahlawan = ArrayList()

        listPahlawan.add(ItemData(R.drawable.andii,"Andi Depu","Sulawesi Barat"))
        listPahlawan.add(ItemData(R.drawable.agengserang,"Nyi Ageng Serang","Jawa Tengah"))
        listPahlawan.add(ItemData(R.drawable.cutnyakdhien,"Cut Nyak Dhien","Aceh"))
        listPahlawan.add(ItemData(R.drawable.cutnyakmeutia,"Cut Nyak Meutia","Kesultanan Aceh"))
        listPahlawan.add(ItemData(R.drawable.radendewisartika,"Dewi Sartika","Jawa Barat"))
        listPahlawan.add(ItemData(R.drawable.rakartini,"RA Kartini","Jepara"))
        listPahlawan.add(ItemData(R.drawable.martha,"Martha Christina Tiahahu","Maluku"))
        listPahlawan.add(ItemData(R.drawable.rasunasaid,"Rasuna Said","Sumatra Barat"))
        listPahlawan.add(ItemData(R.drawable.mariawalanda,"Maria Walanda Maramis","Minahasa"))

        binding.rvPahlawan.layoutManager = LinearLayoutManager(this)
        binding.rvPahlawan.setHasFixedSize(true)
        pahlawanAdapter = MyAdapter(listPahlawan)
        binding.rvPahlawan.adapter = pahlawanAdapter

//        binding.send.setOnClickListener {
//            shareContent()
//        }
//
//        binding.open.setOnClickListener {
//            openWeb()
//        }

//        binding.ivBackH.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }

    }

//    private fun shareContent() {
//        // Membuat Intent untuk berbagi teks
//        val intent = Intent()
//        intent.setAction(Intent.ACTION_SEND)
//        intent.putExtra(Intent.EXTRA_TEXT, "Teks yang ingin Anda bagikan")
//        intent.setType("text/plain")
//
//        // Memulai Activity untuk berbagi
//        startActivity(Intent.createChooser(intent, "Bagikan melalui"))
//    }
//
//    private fun openWeb() {
//
//        val url = "https://www.wikipedia.com"
//
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(url)
//        startActivity(intent)
//    }



}