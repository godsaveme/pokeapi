package com.bcp.bank.proyectofinal.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcp.bank.proyectofinal.data.entities.AllCharacterResponse
import com.bcp.bank.proyectofinal.databinding.FragmentNotificationBinding
import com.bcp.bank.proyectofinal.ui.adapter.RMCharacterAdapter
import com.bcp.bank.proyectofinal.viewmodel.RMViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : Fragment() {


    private val viewModel: RMViewModel by viewModels()
    private lateinit var adapter: RMCharacterAdapter

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNotificationBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupViewModel()
        setup()


        viewModel.doListAllCharacter()


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setup() {

        adapter = RMCharacterAdapter()

        binding.rviRM.layoutManager = LinearLayoutManager(requireContext())
        binding.rviRM.adapter = adapter


    }

    private fun setupViewModel() {
        viewModel.listCharacter.observe(requireActivity(), allCharacterObserver)
    }


    //region observable

    private val allCharacterObserver = Observer<AllCharacterResponse> { response ->

        Toast.makeText(
            requireContext(),
            "Cantidad de Personajes: ${response.results.size}",
            Toast.LENGTH_SHORT
        ).show()


        adapter.arrayCharacter = response.results



    }
    //endregion


    //region interface
    fun pruebaTest() {

    }

    fun pruebaTest1() {

    }
    //endregion
}

