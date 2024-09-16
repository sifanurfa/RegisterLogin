package com.example.registerlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registerlogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var registeredUsername: String? = null
    private var registeredPassword: String? = null
    private var registeredEmail: String? = null
    private var registeredPhone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registeredUsername = intent.getStringExtra("username")
        registeredPassword = intent.getStringExtra("password")
        registeredEmail = intent.getStringExtra("email")
        registeredPhone = intent.getStringExtra("phone")

        with(binding) {
            btnLogin.setOnClickListener {
                val inputUsername = editUsernameLogin.text.toString()
                val inputPassword = editPasswordLogin.text.toString()

                if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java).apply {
                        putExtra("username", registeredUsername)
                        putExtra("email", registeredEmail)
                        putExtra("phone", registeredPhone)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Username atau password salah!", Toast.LENGTH_SHORT).show()
                }
            }
            linkRegister.setOnClickListener {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
