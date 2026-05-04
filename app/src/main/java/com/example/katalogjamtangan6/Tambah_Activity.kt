package com.example.katalogjamtangan6

import android.os.Bundle
import android.widget.*
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
            val harga = etHarga.text.toString()

            // VALIDASI IF ELSE
            if (nama.isEmpty() || brand.isEmpty() || harga.isEmpty()) {
                Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()

                // BONUS: kosongin input
                etNama.text.clear()
                etBrand.text.clear()
                etHarga.text.clear()
            }
        }
    }
}