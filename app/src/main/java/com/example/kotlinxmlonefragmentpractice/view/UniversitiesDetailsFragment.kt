package com.example.kotlinxmlonefragmentpractice.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinxmlonefragmentpractice.databinding.FragmentUniversitiesDetailsBinding
import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class UniversitiesDetailsFragment : Fragment() {

    private lateinit var detailBinding: FragmentUniversitiesDetailsBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentUniversitiesDetailsBinding.inflate(inflater, container, false)

        detailBinding.stateProvince.text = param1 ?: "Default State Province"

        return detailBinding.root
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: UniversitiesResponse) =
            UniversitiesDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1.state_province)
                }
            }
    }
}