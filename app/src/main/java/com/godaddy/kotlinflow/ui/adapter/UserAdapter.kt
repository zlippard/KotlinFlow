package com.godaddy.kotlinflow.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.godaddy.kotlinflow.R
import com.godaddy.kotlinflow.model.Universe.ALTERNATE
import com.godaddy.kotlinflow.model.Universe.PRIMARY
import com.godaddy.kotlinflow.model.User
import kotlinx.android.synthetic.main.cell_user.view.*

class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell_user, parent, false)
        return object : RecyclerView.ViewHolder(view) { }
    }

    override fun getItemCount() = users.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        holder.itemView.setBackgroundColor(
            holder.itemView.resources.getColor(
                when (user.universe) {
                    PRIMARY -> R.color.primaryUniverse
                    ALTERNATE -> R.color.alternateUniverse
                },
                null
            )
        )
        holder.itemView.name.text = "${user.firstName} ${user.lastName}"
    }

    fun update(newUsers: List<User>) {
        notifyItemRangeRemoved(0, users.size)
        users = newUsers
        notifyItemRangeInserted(0, users.size)
    }

}
