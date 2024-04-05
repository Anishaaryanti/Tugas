package com.example.anishaaryanti.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.anishaaryanti.R

class DetailActivity : AppCompatActivity() {

    private lateinit var back : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        back = findViewById(R.id.iv_backD)

        val gambar : ImageView = findViewById(R.id.iv_gambar)
        val nama : TextView = findViewById(R.id.tv_nama)
        val asal : TextView = findViewById(R.id.tv_asal)
        val biografi : TextView = findViewById(R.id.tv_biografi)

        val bundle: Bundle?= intent.extras
        val bNama = bundle !!.getString("idnama")
        val bGambar = bundle .getInt("idgambar")
        val bAsal = bundle .getString("idAsal")
        val bBiografi = bundle .getString("idbiografi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        asal.text = bAsal
        biografi.text = bBiografi

        back.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}