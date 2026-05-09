package com.example.katalogjamtangan6

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    private lateinit var listViewJam: ListView
    private lateinit var etSearch: EditText
    private lateinit var btnAZ: Button
    private lateinit var btnZA: Button

    private var dataJam = arrayListOf(
        "Rolex Submariner",
        "Casio G-Shock",
        "Seiko 5",
        "Fossil Gen 6",
        "Omega Speedmaster"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Log.d("42430002", "Halaman ListActivity dibuka")

        val jamBaru = intent.getStringExtra("nama_jam")

        if (jamBaru != null) {
            dataJam.add(jamBaru)
        }

        listViewJam = findViewById(R.id.listViewJam)
        etSearch = findViewById(R.id.etSearch)
        btnAZ = findViewById(R.id.btnAZ)
        btnZA = findViewById(R.id.btnZA)

        tampilkanData(dataJam)

        // SEARCH
        etSearch.setOnEditorActionListener { _, _, _ ->

            try {

                val keyword = etSearch.text.toString()
                val hasilCari = arrayListOf<String>()

                for (jam in dataJam) {

                    if (jam.lowercase().contains(keyword.lowercase())) {
                        hasilCari.add(jam)
                    }
                }

                tampilkanData(hasilCari)

                Log.d("42430002", "Search berhasil")

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Terjadi kesalahan saat mencari data",
                    Toast.LENGTH_SHORT
                ).show()

                Log.e("42430002", "Error Search: ${e.message}")
            }

            true
        }

        // SORT A-Z BUBBLE SORT
        btnAZ.setOnClickListener {

            try {

                for (i in 0 until dataJam.size - 1) {

                    for (j in 0 until dataJam.size - i - 1) {

                        if (dataJam[j] > dataJam[j + 1]) {

                            val temp = dataJam[j]
                            dataJam[j] = dataJam[j + 1]
                            dataJam[j + 1] = temp
                        }
                    }
                }

                tampilkanData(dataJam)

                Log.d("42430002", "Sorting A-Z berhasil")

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Terjadi kesalahan sorting",
                    Toast.LENGTH_SHORT
                ).show()

                Log.e("42430002", "Error Sorting A-Z: ${e.message}")
            }
        }

        // SORT Z-A BUBBLE SORT
        btnZA.setOnClickListener {

            try {

                for (i in 0 until dataJam.size - 1) {

                    for (j in 0 until dataJam.size - i - 1) {

                        if (dataJam[j] < dataJam[j + 1]) {

                            val temp = dataJam[j]
                            dataJam[j] = dataJam[j + 1]
                            dataJam[j + 1] = temp
                        }
                    }
                }

                tampilkanData(dataJam)

                Log.d("42430002", "Sorting Z-A berhasil")

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Terjadi kesalahan sorting",
                    Toast.LENGTH_SHORT
                ).show()

                Log.e("42430002", "Error Sorting Z-A: ${e.message}")
            }
        }
    }

    private fun tampilkanData(data: ArrayList<String>) {

        try {

            val adapter = object : ArrayAdapter<String>(
                this,
                R.layout.item_jam,
                data
            ) {

                override fun getView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {

                    val view = layoutInflater.inflate(R.layout.item_jam, null)

                    val tvNamaJam = view.findViewById<TextView>(R.id.tvNamaJam)

                    tvNamaJam.text = data[position]

                    return view
                }
            }

            listViewJam.adapter = adapter

            listViewJam.setOnItemClickListener { _, _, position, _ ->

                Toast.makeText(
                    this,
                    "Kamu memilih: ${data[position]}",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("42430002", "Item dipilih: ${data[position]}")
            }

        } catch (e: Exception) {

            Toast.makeText(
                this,
                "Terjadi kesalahan menampilkan data",
                Toast.LENGTH_SHORT
            ).show()

            Log.e("42430002", "Error tampil data: ${e.message}")
        }
    }
}