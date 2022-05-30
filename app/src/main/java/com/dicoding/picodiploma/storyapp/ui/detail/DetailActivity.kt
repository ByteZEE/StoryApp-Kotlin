package com.dicoding.picodiploma.storyapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.storyapp.databinding.ActivityDetailBinding
import com.dicoding.picodiploma.storyapp.service.response.ListStoryItem

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDesc()
    }

    private fun showDesc() {
        val data = intent.getParcelableExtra<ListStoryItem>(EXTRA_DATA) as ListStoryItem
        binding.apply {
            tvNameDetail.text = data.name
            tvDesc.text = data.description
            Glide.with(this@DetailActivity)
                .load(data.photoUrl)
                .centerCrop()
                .dontTransform()
                .apply(RequestOptions().override(600, 600))
                .into(binding.ivImageDetail)
        }
    }
}