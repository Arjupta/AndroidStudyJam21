package com.gdsciitbhu.android.phonebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.phonebook.databinding.ContactItemBinding

class ContactsAdapter : RecyclerView.Adapter<ContactViewHolder>() {

    private var contacts = emptyList<Contact>()

    fun submitList(list: List<Contact>) {
        contacts = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ContactItemBinding.inflate(layoutInflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.contactName.text = contacts[position].name
        holder.binding.contactNumber.text = contacts[position].phoneNumber
    }

    override fun getItemCount() = contacts.size

}

class ContactViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root)