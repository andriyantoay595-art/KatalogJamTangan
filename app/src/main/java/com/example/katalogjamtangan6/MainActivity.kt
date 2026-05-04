package com.example.katalogjamtangan6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLihat = findViewById<Button>(R.id.btnLihat)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnLihat.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        btnTambah.setOnClickListener {
            val intent = Intent(this, TambahActivity::class.java)
            startActivity(intent)
        }
    }
}