package com.bcp.bank.proyectofinal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.data.entities.RMCharacter
import com.bcp.bank.proyectofinal.databinding.ItemRmBinding
import com.squareup.picasso.Picasso

class RMCharacterAdapter : RecyclerView.Adapter<RMCharacterAdapter.RMHolder>() {


    var arrayCharacter: List<RMCharacter> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RMHolder {
        val view = ItemRmBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RMHolder(view)
    }

    override fun onBindViewHolder(holder: RMHolder, position: Int) {
        val character = arrayCharacter[position]

        holder.bind(character = character)
    }

    override fun getItemCount(): Int {
        return arrayCharacter.size
    }


    class RMHolder(private val itemBinding: ItemRmBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var binding: ItemRmBinding

        fun bind(character: RMCharacter) {
            binding = itemBinding
            binding.tviTitle.text = character.name
            binding.tviDescription.text = character.status


            Picasso.get()
                .load(character.image)
                .placeholder(R.drawable.img_welcome_person)
                .error(R.drawable.img_welcome_person)
                .into(binding.iviCharacter)

        }

    }


}