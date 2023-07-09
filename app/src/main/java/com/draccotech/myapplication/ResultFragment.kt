package com.draccotech.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.draccotech.myapplication.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var engine: JokenpoEngine
    private lateinit var resultText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        resultText = binding.resultLabel
        engine = JokenpoEngine(resources.getStringArray(R.array.available_plays_array))

        val currentPlay = arguments?.getString("currentPLay")

        currentPlay?.let {
            Log.d("onCreateView", currentPlay)
            resultText.text = updateResultText(currentPlay)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun  updateResultText(currentPlay: String): String{
        Log.d("updateResultText", currentPlay)
        return when(engine.calculateResult(currentPlay)){
            Result.WIN -> "Você ganhou"
            Result.LOSS -> "Você perdeu"
            else -> "Empatou"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }
}