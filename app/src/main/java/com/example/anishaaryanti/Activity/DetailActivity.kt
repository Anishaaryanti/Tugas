package com.example.anishaaryanti.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.anishaaryanti.R
import com.example.anishaaryanti.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var back : ImageView
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        back = findViewById(R.id.iv_backD)

        val intent = intent
        val nama = intent.getStringExtra("nama")
        val asal = intent.getStringExtra("asal")
        val biografi = intent.getStringExtra("biografi")
        val gambar = intent.getStringExtra("gambar")

        binding.ivGambar.loadImage(gambar)
        binding.tvNama.text = nama
        binding.tvAsal.text = asal
        binding.tvBiografi.text = biografi

        back.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}