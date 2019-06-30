package com.maciejkozlowski.imagebrowser.app.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.maciejkozlowski.imagebrowser.R
import com.maciejkozlowski.imagebrowser.api.model.Image
import com.squareup.picasso.Picasso

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class ImageListAdapter(
    private val list: List<Image>,
    private val listener: ImageClickListener
) : RecyclerView.Adapter<ImageListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
        Picasso.get().load(item.url).into(holder.imageView)
        holder.itemView.setOnClickListener { listener.onImageClicked(item.id) }
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView = view as ImageView
    }
}