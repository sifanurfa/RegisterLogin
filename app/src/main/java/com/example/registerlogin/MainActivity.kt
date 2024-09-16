package com.example.registerlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registerlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener {
                val username = editUsernameRegister.text.toString()
                val email = editEmailRegister.text.toString()
                val phone = editPhoneRegister.text.toString()
                val password = editPasswordRegister.text.toString()

                when {
                    username.isEmpty() -> {
                        editUsernameRegister.error = "Masukkan username"
                    }
                    email.isEmpty() -> {
                        editEmailRegister.error = "Masukkan email"
                    }
                    phone.isEmpty() -> {
                        editPhoneRegister.error = "Masukkan phone number"
                    }
                    password.isEmpty() -> {
                        editPasswordRegister.error = "Masukkan password"
                    }
                    else -> {
                        val intent = Intent(this@MainActivity, LoginActivity::class.java).apply {
                            putExtra("username", username)
                            putExtra("password", password)
                            putExtra("email", email)
                            putExtra("phone", phone)
                        }
                        startActivity(intent)
                    }
                }

            }
            login.setOnClickListener {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}