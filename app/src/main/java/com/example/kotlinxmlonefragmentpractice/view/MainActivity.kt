package com.example.kotlinxmlonefragmentpractice.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinxmlonefragmentpractice.R
import com.example.kotlinxmlonefragmentpractice.databinding.ActivityMainBinding
import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse
import com.example.kotlinxmlonefragmentpractice.viewmodel.UniversitiesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), UniversitiesListAdapter.UniversityClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UniversitiesViewModel
    private lateinit var adapter: UniversitiesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UniversitiesViewModel::class.java]

        adapter = UniversitiesListAdapter(emptyList(), this)
        binding.univList.layoutManager = LinearLayoutManager(this)
        binding.univList.adapter = adapter

        lifecycleScope.launch {
            viewModel.uniList.collectLatest { response ->
                adapter.updateUniversity(response)
            }
        }

    }

    override fun getUniversity(response: UniversitiesResponse) {
        val detailsFragment = UniversitiesDetailsFragment.newInstance(response)
        binding.univList.visibility = View.GONE
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, detailsFragment)
            addToBackStack(null)
            commit()
        }
    }
}