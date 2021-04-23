package com.bcp.bank.proyectofinal.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcp.bank.proyectofinal.databinding.FragmentMainBinding
import com.bcp.bank.proyectofinal.ui.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

class MainFragment : Fragment() {


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var  adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMainBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = MainAdapter()


        binding.rviMain.layoutManager = LinearLayoutManager(this.context)
        binding.rviMain.adapter = adapter


        adapter.arrayMain = listOf("uno", "dos", "tres", "cuatro", "cinco", "seis")



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

