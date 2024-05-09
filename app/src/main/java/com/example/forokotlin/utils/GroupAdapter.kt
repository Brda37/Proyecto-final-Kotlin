package com.example.forokotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forokotlin.R
import com.example.forokotlin.dto.Group
import com.example.forokotlin.interfaces.GroupJoinListener

class GroupAdapter(
    context: Context,
    private var groups: MutableList<Group?>?,
    private val isButtonEnabled: Boolean,
    private val listener: GroupJoinListener? = null
) : RecyclerView.Adapter<GroupAdapter.ViewHolder>() {
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

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView
        private var description: TextView
        private var status: TextView
        private var joinButton: Button

        init {
            name = itemView.findViewById(R.id.groupNameTextView)
            description = itemView.findViewById(R.id.groupDescriptionTextView)
            status = itemView.findViewById(R.id.groupStatusTextView)
            joinButton = itemView.findViewById(R.id.btnJoinGroup)
        }

        fun bindData(item: Group?) {
            item?.let { group ->
                name.text = group.getName()
                description.text = group.getDescription()
                status.text = group.getStatus()
                joinButton.visibility = if (isButtonEnabled) View.VISIBLE else View.GONE
                joinButton.setOnClickListener {
                    listener?.onJoinGroupClicked(group)
                }
            }
        }
    }
}
