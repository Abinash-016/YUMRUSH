package com.example.yumrush

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yumrush.databinding.ActivityLogin2Binding


class LoginActivity2 : AppCompatActivity() {

    private val binding: ActivityLogin2Binding by lazy {
        ActivityLogin2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)
        setContentView(binding.root)  // Updated here to use binding

        binding.loginbutton.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }
        binding.donthavebutton.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }
    }
}