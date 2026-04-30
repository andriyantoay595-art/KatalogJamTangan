package com.example.katalogjamtangan6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listViewJam = findViewById<ListView>(R.id.listViewJam)

        // Map the list of Jam objects to a list of Strings for the simple ArrayAdapter
        val displayList = JamData.listJam.map { "${it.nama} - ${it.brand} (Rp ${it.harga})" }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayList)
        listViewJam.adapter = adapter
    }
}