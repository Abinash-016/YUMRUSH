package com.example.yumrush.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumrush.R
import com.example.yumrush.adapter.MenuAdapter
import com.example.yumrush.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName= listOf("Burger", "sandwich", "Fried momo", "Chicken Pizza", "Sandwich", "Momo", "sandwich", "Fried momo", "Chicken Pizza", "Sandwich", "Momo")
    private val originalMenuItemPrice = listOf("150", "80", "85", "170", "75", "50", "80", "85", "170", "75", "50")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName= mutableListOf<String>()
    private val filteredMenuFoodPrice= mutableListOf<String>()
    private val filteredMenuFoodImage= mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentSearchBinding.inflate(inflater,container,false)
        adapter=MenuAdapter(filteredMenuFoodName,filteredMenuFoodPrice,filteredMenuFoodImage,requireContext()
        )
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter

        //setup search view
        setupSearchView()

        //show mneu items
        showAlMenu()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showAlMenu() {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuFoodPrice.addAll(originalMenuItemPrice)
        filteredMenuFoodImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener( /* listener = */ object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
                }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }



        })

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuFoodPrice.add(originalMenuItemPrice[index])
                filteredMenuFoodImage.add(originalMenuImage[index])
        }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}