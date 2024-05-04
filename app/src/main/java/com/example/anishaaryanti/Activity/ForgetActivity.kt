package com.example.anishaaryanti.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.anishaaryanti.R
import com.example.anishaaryanti.databinding.ActivityForgetBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            val email : String = binding.fgEmail.text.toString().trim()

            if (email.isEmpty()){
                binding.fgEmail.error = "Input Email"
                binding.fgEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.fgEmail.error = "Invalid Email"
                binding.fgEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this,"Check email to reset password",Toast.LENGTH_SHORT).show()
                    Intent(this, LoginActivity::class.java).also {
                     it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                     startActivity(it)
                    }
            }
        else {
            Toast.makeText(this,"${it.exception?.message}", Toast .LENGTH_SHORT).show()
        }
    }
  }
    }
}