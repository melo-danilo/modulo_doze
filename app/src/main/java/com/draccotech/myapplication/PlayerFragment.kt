package com.draccotech.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.draccotech.myapplication.databinding.FragmentPlayerBinding


class PlayerFragment : Fragment() {

    private lateinit var binding: FragmentPlayerBinding
    private lateinit var onItemSelectedListener: OnItemSelectedListener


    override fun onAttach(context: Context) {
        super.onAttach(context)

        onItemSelectedListener = context as OnItemSelectedListener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        initializeSpinner()
        return binding.root
    }

    private fun initializeSpinner(){
        //Criando um array de valores
        val valores = arrayOf("Pedra", "Papel", "Tesoura")

        //Criando um ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.available_plays_array,
            android.R.layout.simple_spinner_item
        )

        //Definindo o layout do Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Conectando o ArrayAdapter ao Spinner
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = onItemSelectedListener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }

}