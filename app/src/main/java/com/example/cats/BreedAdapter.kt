package com.example.cats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BreedAdapter(private val contextFragment: Context) :
    RecyclerView.Adapter<BreedAdapter.BreedHolder>() {
    private val breeds = ArrayList<BreedModel>()


    class BreedHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val tvBreed: TextView = item.findViewById(R.id.tvBreed)
        val imCat: ImageView = item.findViewById(R.id.im_cat)

        fun initItem(breedModel: BreedModel) {
            tvBreed.text = breedModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_breed, parent, false)
        return BreedHolder(view)
    }

    override fun onBindViewHolder(holder: BreedHolder, position: Int) {
        bind(holder, position)
    }

    private fun bind(holder: BreedHolder, position: Int) {
        holder.initItem(breeds[position])
        Glide.with(contextFragment).load(breeds[position].image.url).into(holder.imCat)
    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    fun updateList(newBreedModels: ArrayList<BreedModel>) {
        breeds.clear()
        breeds.addAll(newBreedModels)
        notifyDataSetChanged()
    }
}
