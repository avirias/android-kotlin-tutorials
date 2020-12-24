package com.arjun1194.firebase.ui.user

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.arjun1194.firebase.R
import com.arjun1194.firebase.data.FirebaseWrapper
import com.arjun1194.firebase.data.FirebaseWrapper.*
import com.arjun1194.firebase.data.models.User
import com.arjun1194.firebase.databinding.UserFragmentBinding

class UserFragment : Fragment() {

    val viewModel: UserViewModel by viewModels()
    lateinit var binding: UserFragmentBinding
    val firebaseWrapper = FirebaseWrapper()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = UserFragmentBinding.inflate(inflater)
        binding.submitBtn.setOnClickListener {
            firebaseWrapper.createUser(User(name = binding.nameEdit.text.toString()),object: TaskListener{
                override fun onSuccess(key: String) {
                    // save key to Shared preferences

                    // navigate to main activity
                }


                override fun onFailed(e: Exception) {
                    TODO("Not yet implemented")
                }

            })
        }


        return binding.root;
    }







}