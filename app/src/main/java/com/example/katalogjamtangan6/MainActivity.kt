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

        btnLihat.setOnClickListener { _ ->
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }

        btnTambah.setOnClickListener { _ ->
            val intent = Intent(this@MainActivity, TambahActivity::class.java)
            startActivity(intent)
        }
    }
}