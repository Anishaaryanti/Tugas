package com.example.anishaaryanti.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anishaaryanti.Adapter.MyAdapter
import com.example.anishaaryanti.R
import com.example.anishaaryanti.data.ItemData
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {

    private lateinit var pahlawanRecyclerView: RecyclerView

    //    private lateinit var pahlawanAdapter : MyAdapter
    private lateinit var back: ImageView
    private lateinit var nama: Array<String>
    private lateinit var asal: Array<String>
    private lateinit var gambar: Array<Int>
    private lateinit var biografi: Array<String>
    private lateinit var listPahlawan: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        back = findViewById(R.id.iv_backH)



        back.setOnClickListener {
           FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        gambar = arrayOf(
            R.drawable.andii,
            R.drawable.agengserang,
            R.drawable.cutnyakdhien,
            R.drawable.cutnyakmeutia,
            R.drawable.radendewisartika,
            R.drawable.rakartini,
            R.drawable.martha,
            R.drawable.rasunasaid,
            R.drawable.mariawalanda,
        )

        nama = arrayOf(
            "Andi Depu", "Nyi Ageng Serang", "Cut Nyak Dhien", "Cut Nyak Meutia",
            "Dewi Sartika", "RA Kartini", "Martha Christina Tiahahu",
            "Rasuna Said", "Maria Walanda Maramis"
        )

        asal = arrayOf(
            "Sulawesi Barat", "Jawa Tengah", "Aceh", "Kesultanan Aceh",
            "Jawa Barat", "Jawa Tengah", "Maluku", "Sumatra Barat", "Minahasa"
        )

        biografi = arrayOf(
            getString(R.string.andii),
            getString(R.string.agengserang),
            getString(R.string.cutnyakdhien),
            getString(R.string.cutnyakmeutia),
            getString(R.string.radendewisartika),
            getString(R.string.rakartini),
            getString(R.string.martha),
            getString(R.string.rasunasaid),
            getString(R.string.mariawalanda)
        )

        pahlawanRecyclerView = findViewById(R.id.rv_pahlawan)
        pahlawanRecyclerView.layoutManager = LinearLayoutManager(this)
        pahlawanRecyclerView.setHasFixedSize(true)

        listPahlawan = arrayListOf<ItemData>()
        getDataUser()
    }

    private fun getDataUser() {
        for (i in gambar.indices) {
            val dataPahlawan = ItemData(gambar[i], nama[i], asal[i], biografi[i])
            listPahlawan.add(dataPahlawan)
        }

        var adapter = MyAdapter(listPahlawan)
        pahlawanRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                intent = Intent(this@HomeActivity, DetailActivity::class.java)
                intent.putExtra("idgambar", listPahlawan[position].gambar)
                intent.putExtra("idnama", listPahlawan[position].nama)
                intent.putExtra("idasal", listPahlawan[position].asal)
                intent.putExtra("idbiografi", biografi[position])

                startActivity(intent)
            }
        })
    }
}

//        listPahlawan = ArrayList()
//        listPahlawan.add(ItemData(R.drawable.andii,"Andi Depu","Sulawesi Barat"))
//        listPahlawan.add(ItemData(R.drawable.agengserang,"Nyi Ageng Serang","Jawa Tengah"))
//        listPahlawan.add(ItemData(R.drawable.cutnyakdhien,"Cut Nyak Dhien","Aceh"))
//        listPahlawan.add(ItemData(R.drawable.cutnyakmeutia,"Cut Nyak Meutia","Kesultanan Aceh"))
//        listPahlawan.add(ItemData(R.drawable.radendewisartika,"Dewi Sartika","Jawa Barat"))
//        listPahlawan.add(ItemData(R.drawable.rakartini,"RA Kartini","Jepara"))
//        listPahlawan.add(ItemData(R.drawable.martha,"Martha Christina Tiahahu","Maluku"))
//        listPahlawan.add(ItemData(R.drawable.rasunasaid,"Rasuna Said","Sumatra Barat"))
//        listPahlawan.add(ItemData(R.drawable.mariawalanda,"Maria Walanda Maramis","Minahasa"))

//        binding.rvPahlawan.layoutManager = LinearLayoutManager(this)
//        binding.rvPahlawan.setHasFixedSize(true)
//        pahlawanAdapter = MyAdapter(listPahlawan)
//        binding.rvPahlawan.adapter = pahlawanAdapter

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



