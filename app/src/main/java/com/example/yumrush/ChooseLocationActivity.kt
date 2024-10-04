package com.example.yumrush

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yumrush.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding:ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val locationList= arrayOf("Banki, Cuttack,754008","Harirajpur,Jatni,752050","Centurion University ,Bhubaneswar,752050")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView=binding.listofLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}