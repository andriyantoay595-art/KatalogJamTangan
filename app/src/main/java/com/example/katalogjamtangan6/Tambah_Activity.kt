package com.example.katalogjamtangan6

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etBrand = findViewById<EditText>(R.id.etBrand)
        val etHarga = findViewById<EditText>(R.id.etHarga)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val brand = etBrand.text.toString()
            val hargaStr = etHarga.text.toString()

            if (nama.isNotEmpty() && brand.isNotEmpty() && hargaStr.isNotEmpty()) {
                val harga = hargaStr.toInt()
                val jamBaru = Jam(nama, brand, harga)
                JamData.listJam.add(jamBaru)
                
                Toast.makeText(this, "Jam berhasil ditambahkan!", Toast.LENGTH_SHORT).show()
                finish() // Close activity and go back
            } else {
                Toast.makeText(this, "Mohon isi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}