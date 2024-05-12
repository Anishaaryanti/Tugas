package com.example.anishaaryanti.data

import com.google.firebase.database.Exclude

data class ItemData(
    val gambar : String? = null,
    val nama : String? = null,
    val asal : String? = null,
    val biografi : String? = null,
    @get:Exclude
    @set:Exclude
    var key: String? = null
)
