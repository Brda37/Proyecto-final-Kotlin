package com.example.forokotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forokotlin.R
import com.example.forokotlin.dto.Group

class GroupAdapter(context: Context, private var groups: MutableList<Group?>?) :
    RecyclerView.Adapter<GroupAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return groups?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        @SuppressLint("InflateParams") val view = inflater.inflate(R.layout.group_element, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        groups?.let { holder.bindData(it[position]) }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Group>) {
        groups = items.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        private var description: TextView
        private var status: TextView

        init {
            name = itemView.findViewById(R.id.groupNameTextView)
            description = itemView.findViewById(R.id.groupDescriptionTextView)
            status = itemView.findViewById(R.id.groupStatusTextView)
        }

        fun bindData(item: Group?) {
            item?.let {
                name.text = it.getName()
                description.text = it.getDescription()
                status.text = it.getStatus()
            }
        }
    }
}
