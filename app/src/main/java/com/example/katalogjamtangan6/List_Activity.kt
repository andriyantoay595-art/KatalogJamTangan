package com.example.katalogjamtangan6

import android.os.Bundle
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

        listViewJam = findViewById(R.id.listViewJam)
        etSearch = findViewById(R.id.etSearch)
        btnAZ = findViewById(R.id.btnAZ)
        btnZA = findViewById(R.id.btnZA)

        tampilkanData(dataJam)

        etSearch.setOnEditorActionListener { _, _, _ ->

            val keyword = etSearch.text.toString()
            val hasilCari = arrayListOf<String>()

            for (jam in dataJam) {
                if (jam.lowercase().contains(keyword.lowercase())) {
                    hasilCari.add(jam)
                }
            }

            tampilkanData(hasilCari)
            true
        }

        btnAZ.setOnClickListener {

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
        }

        btnZA.setOnClickListener {

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
        }
    }

    private fun tampilkanData(data: ArrayList<String>) {

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
        }
    }
}