package com.bcp.bank.proyectofinal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcp.bank.proyectofinal.databinding.ItemMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {


    var arrayMain: List<String> = ArrayList()
        set(value) {
            field = value

            //Refrescamos listado
            notifyDataSetChanged()
        }


    //Asociar diseño al adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {

        //val view = LayoutInflater.from(parent.context)
        //.inflate(R.layout.item_main, parent, false)

        val view = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(view)


    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {

        val stringValue = arrayMain[position]

        holder.bind(stringValue)

    }

    override fun getItemCount(): Int {
        return arrayMain.size
    }


    class MainHolder(private val itemBinding: ItemMainBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        lateinit var binding: ItemMainBinding

        fun bind(value: String) {
            binding = itemBinding
            binding.tviTitle.text = value
        }

    }


}