package com.example.weekaheadapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)
        var rvTrial = findViewById<RecyclerView>(R.id.rvTrial)

        val trialContacts = trailContactsFun()
        rvTrial.adapter = TrialContactAdapter(this, trialContacts)
        rvTrial.layoutManager = LinearLayoutManager(this)

    }

    private fun trailContactsFun(): List<TrialContact> {
        val trialContacts = mutableListOf<TrialContact>()
        for (i in 1..200) trialContacts.add(TrialContact("Person #$i", i))
        return  trialContacts
    }
}