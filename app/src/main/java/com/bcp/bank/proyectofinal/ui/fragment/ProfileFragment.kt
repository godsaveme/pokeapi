package com.bcp.bank.proyectofinal.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bcp.bank.proyectofinal.data.entities.AllCharacterResponse
import com.bcp.bank.proyectofinal.data.entities.PokemonCharacter
import com.bcp.bank.proyectofinal.data.entities.RMCharacter
import com.bcp.bank.proyectofinal.databinding.FragmentNotificationBinding
import com.bcp.bank.proyectofinal.databinding.FragmentProfileBinding
import com.bcp.bank.proyectofinal.viewmodel.RMViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewModel: RMViewModel by viewModels()

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        viewModel.doGetCharacter(id = "1")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupViewModel() {
        viewModel.character.observe(requireActivity(), characterObserver)
    }


    //region observable

    private val characterObserver = Observer<RMCharacter> { response ->

        Toast.makeText(
            requireContext(),
            "Nombre de Personaje: ${response.name}",
            Toast.LENGTH_SHORT
        ).show()


    }
    //endregion
}

