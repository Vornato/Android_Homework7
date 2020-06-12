package com.example.levanhomework7.adapters

import com.example.levanhomework7.api.ApiModel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.levanhomework7.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.api_item.view.*


class MockAdapter(private var data: List<ApiModel> )
    : RecyclerView.Adapter<MockAdapter.MockViewHolder>() {

    class MockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(info: ApiModel) {

            itemView.titleENView.text = "Title: \n${info.titleEN}"
            itemView.descENView.text = "Description: \n${info.descriptionEN}"

            Picasso.get()
                .load(info.cover).into(itemView.apiCoverView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MockViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.api_item, parent, false)
        return MockViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MockViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateRecycler(data: List<ApiModel>) {
        this.data = data
        notifyDataSetChanged()
    }
}

