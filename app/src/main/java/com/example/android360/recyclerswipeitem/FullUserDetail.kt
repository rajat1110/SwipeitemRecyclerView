package com.example.android360.recyclerswipeitem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_full_user_detail.*

class FullUserDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_user_detail)


        val names = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")
        val image =intent.getIntExtra("image",0)
        fullTextName.text = names
        fullTextId.text= id.toString()

        imageView.setImageResource(image)


    }
}
