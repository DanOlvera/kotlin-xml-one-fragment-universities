package com.example.kotlinxmlonefragmentpractice.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinxmlonefragmentpractice.databinding.ListItemBinding
import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse
import kotlin.math.log

class UniversitiesListAdapter(
    private var list: List<UniversitiesResponse>,
    private val listener: UniversityClickListener)
    : RecyclerView.Adapter<UniversitiesListAdapter.UniversitiesViewHolder>() {

    inner class UniversitiesViewHolder(private val itemBinding: ListItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

            private lateinit var response: UniversitiesResponse

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(response: UniversitiesResponse) {
                this.response = response
                itemBinding.univName.text = response.name
            }

        override fun onClick(p0: View?) {
            listener.getUniversity(response)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversitiesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return UniversitiesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UniversitiesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface UniversityClickListener {
        fun getUniversity(response: UniversitiesResponse)
    }

    internal fun updateUniversity(response: List<UniversitiesResponse>) {
        this.list = response
        notifyDataSetChanged()
    }
}