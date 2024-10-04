package com.example.yumrush

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.yumrush.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)  // Updated here to use binding

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent)
        }
    }
}
