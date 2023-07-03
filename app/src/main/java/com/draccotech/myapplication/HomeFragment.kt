package com.draccotech.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.draccotech.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.button.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }
    }


}