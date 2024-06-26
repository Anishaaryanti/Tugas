package com.example.anishaaryanti.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.Adapter.MyAdapter
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData
import com.example.anishaaryanti.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class HomeActivity : AppCompatActivity() {

    private lateinit var pahlawanRecyclerView: RecyclerView
    private lateinit var back: ImageView
    private lateinit var auth: FirebaseAuth

    private lateinit var listPahlawan: MutableList<ItemData>
    private lateinit var pahlawanAdapter: MyAdapter
    private lateinit var binding: ActivityHomeBinding
    private var mStorage: FirebaseStorage? = null
    private var mDatabaseref: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pahlawanRecyclerView = findViewById(R.id.rv_pahlawan)
        pahlawanRecyclerView.layoutManager = LinearLayoutManager(this)
        pahlawanRecyclerView.setHasFixedSize(true)
        binding.myDataLoaderProgressBar.visibility = View.VISIBLE
        listPahlawan = ArrayList()
        pahlawanAdapter = MyAdapter(this@HomeActivity, listPahlawan)
        pahlawanRecyclerView.adapter = pahlawanAdapter

        auth = FirebaseAuth.getInstance()
        mStorage = FirebaseStorage.getInstance()
        mDatabaseref = FirebaseDatabase.getInstance().getReference("Pahlawan")

        mDBListener = mDatabaseref!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@HomeActivity, error.message, Toast.LENGTH_SHORT).show()
                binding.myDataLoaderProgressBar.visibility = View.INVISIBLE
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                listPahlawan.clear()
                for (teacherSnapshot in snapshot.children) {
                    val upload = teacherSnapshot.getValue(ItemData::class.java)
                    upload!!.key = teacherSnapshot.key
                    listPahlawan.add(upload)
                }
                pahlawanAdapter.notifyDataSetChanged()
                binding.myDataLoaderProgressBar.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                Toast.makeText(this, "Setting click", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.profile -> {
                Toast.makeText(this, "Profile click", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.logout -> {
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}






