package com.example.yumrush

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yumrush.databinding.ActivitySignBinding
import com.example.yumrush.databinding.ActivityStartBinding

class SignActivity : AppCompatActivity() {
    private val binding:ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.haveaccountbutton.setOnClickListener{
            val intent= Intent(this,LoginActivity2::class.java)
            startActivity(intent)
        }
    }
}