package com.example.anishaaryanti.Activity

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.anishaaryanti.R


fun ImageView.loadImage(url : String?) {
    val options = RequestOptions().placeholder(
        R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}