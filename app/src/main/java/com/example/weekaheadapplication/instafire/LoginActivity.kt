package com.example.weekaheadapplication.instafire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weekaheadapplication.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener{
            val email = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Email/password cannot be empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            //firebase connection check
        }
    }
}