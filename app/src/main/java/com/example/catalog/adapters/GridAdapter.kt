package com.example.catalog.adapters


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catalog.R
import com.example.catalog.fragments.DetailFragment

class GridAdapter (private val array: ArrayList<com.example.catalog.models.ModelClass>, private val context: FragmentActivity):
    RecyclerView.Adapter<GridAdapter.ViewHolder>(){
    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val image: ImageView
        val name: TextView
        val description: TextView

        init {
            image = itemView.findViewById(R.id.imageView_second)
            name = itemView.findViewById(R.id.name_second)
            description = itemView.findViewById(R.id.description_second)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_second, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        Glide.with(holder.itemView).load(item.image).into(holder.image)
        holder.name.text = item.name
        holder.description.text = item.description

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("KEY", item)

            context.supportFragmentManager.beginTransaction()
                .replace(R.id.fragments_container, DetailFragment::class.java, bundle)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    }


