package com.example.weekaheadapplication

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weekaheadapplication.tips.TipActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.tv_hello)

        var button: Button = findViewById(R.id.buttonChange)
        val intent = Intent(this, TipActivity::class.java)

        button.setOnClickListener(View.OnClickListener {
            //textView.text = "its changed"
            startActivity(intent)
            //Toast.makeText(this, "your toast text", Toast.LENGTH_LONG).show()
        })

    }
}
