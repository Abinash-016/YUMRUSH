package com.example.yumrush.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumrush.CongratsBottomSheet
import com.example.yumrush.PayOutActivity
import com.example.yumrush.R
import com.example.yumrush.adapter.CartAdapter
import com.example.yumrush.databinding.CartItemBinding
import com.example.yumrush.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val cartFoodName = listOf("Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val cartItemPtice = listOf("$5", "$6", "$8", "$9", "$10", "$10")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )

        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPtice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        binding.proceedButton.setOnClickListener {
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {
    }
}