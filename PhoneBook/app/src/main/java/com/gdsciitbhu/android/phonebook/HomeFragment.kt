package com.gdsciitbhu.android.phonebook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.phonebook.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel by activityViewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentHomeBinding.bind(view)

        val adapter = ContactsAdapter()
        binding.contactsList.adapter = adapter

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addContactFragment)
        }

        viewModel.contactList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}