package com.arjun1194.firebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arjun1194.firebase.R
import com.arjun1194.firebase.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var database: FirebaseDatabase

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //val root = inflater.inflate(R.layout.fragment_home, container, false)
        val binding = FragmentHomeBinding.inflate(inflater)
        val textView = binding.textHome
        database = FirebaseDatabase.getInstance()
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        binding.saveBtn.setOnClickListener {
            saveToFirebase()
        }

        return binding.root
    }

    private fun saveToFirebase(){
        // Write a message to the database
        val myRef = database.getReference("message")
        myRef.setValue("Mat Stonie") { error, ref ->
            if (error == null) {
                Toast.makeText(requireContext(), "Value Saved Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}