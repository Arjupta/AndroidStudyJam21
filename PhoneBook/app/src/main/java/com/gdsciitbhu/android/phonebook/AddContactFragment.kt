package com.gdsciitbhu.android.phonebook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.phonebook.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment(R.layout.fragment_add_contact) {

    private val viewModel by activityViewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAddContactBinding.bind(view)

        binding.btnSave.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()
            if (name.isNotBlank() && number.length == 10) {
                viewModel.saveContact(Contact(name, number))
                findNavController().navigateUp()
            }
        }
    }
}