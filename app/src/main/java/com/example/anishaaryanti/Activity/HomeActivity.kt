package com.example.anishaaryanti.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anishaaryanti.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.send.setOnClickListener {
            shareContent()
        }

        binding.open.setOnClickListener {
            openWeb()
        }

        binding.ivBackH.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun shareContent() {
        // Membuat Intent untuk berbagi teks
        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "Teks yang ingin Anda bagikan")
        intent.setType("text/plain")

        // Memulai Activity untuk berbagi
        startActivity(Intent.createChooser(intent, "Bagikan melalui"))
    }

    private fun openWeb() {

        val url = "https://www.wikipedia.com"

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

}