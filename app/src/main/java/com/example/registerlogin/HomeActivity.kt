package com.example.registerlogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.registerlogin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        with(binding) {
            textUsername.text = "Welcome $username"
            textEmail.text = "Your $email has been activated"
            textPhone.text = "Your $phone has been registered"
        }
    }
}
