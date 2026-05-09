package com.example.katalogjamtangan6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahActivity : AppCompatActivity() {

    private lateinit var etNamaJam: EditText
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        etNamaJam = findViewById(R.id.etNamaJam)
        btnSimpan = findViewById(R.id.btnSimpan)

        btnSimpan.setOnClickListener {

            val namaJam = etNamaJam.text.toString()

            if (namaJam.isEmpty()) {

                Toast.makeText(
                    this,
                    "Nama jam harus diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val intent = Intent(this, ListActivity::class.java)

                intent.putExtra("nama_jam", namaJam)

                startActivity(intent)
            }
        }
    }
}