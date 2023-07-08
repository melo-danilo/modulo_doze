package com.draccotech.myapplication

import android.os.Bundle
import android.util.Log
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

        Log.d("LifeCycle", "onCreateView")

        savedInstanceState?.getString("editTextNameValue")?.let {
            binding.editTextText2.setText(it)
        }

        lifecycle.addObserver(CustomObserver())
        onClick()
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextNameValue", binding.editTextText2.text.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("LifeCycle", "onDetach")
    }

    private fun onClick() {
        binding.button.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }
    }


}