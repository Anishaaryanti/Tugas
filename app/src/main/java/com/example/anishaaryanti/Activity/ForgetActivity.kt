package com.example.anishaaryanti.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anishaaryanti.R
import com.example.anishaaryanti.databinding.ActivityForgetBinding

class ForgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackF.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}