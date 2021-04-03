package com.example.weekaheadapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contact.view.*

class TrialContactAdapter(private val context: Context, private val trialContacts: List<TrialContact>)
    : RecyclerView.Adapter<TrialContactAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(trialContacts: TrialContact) {
            itemView.tvName.text = trialContacts.name
            itemView.tvAge.text = "Age: ${trialContacts.age}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trialContact = trialContacts[position]
        holder.bind(trialContact)
    }

    override fun getItemCount() = trialContacts.size
}