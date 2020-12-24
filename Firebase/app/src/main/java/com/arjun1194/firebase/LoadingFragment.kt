package com.arjun1194.firebase

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.arjun1194.firebase.databinding.FragmentLoadingBinding
import com.arjun1194.firebase.globals.SharedPrefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingFragment : Fragment() {

    lateinit var binding: FragmentLoadingBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentLoadingBinding.inflate(inflater)
        binding.circularProgress.indeterminate(3000)
        navController = findNavController();
        lifecycleScope.launch(Dispatchers.Main){
            delay(3000)
            navigate()
        }


        return binding.root
    }

    private fun navigate() {
        if (checkUser()) {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        } else {
            val action = LoadingFragmentDirections.actionLoadingFragmentToUserFragment()
            navController.navigate(action)
        }
    }


    private fun checkUser(): Boolean {
        val sharedPreferences = requireContext().
        getSharedPreferences(SharedPrefs.sharedPrefName,Context.MODE_PRIVATE);
        return sharedPreferences.contains(SharedPrefs.userId)
    }

    fun CircularProgressIndicator.indeterminate(durationAnimation: Long = 3000L) {
        ValueAnimator.ofInt(0, 360).apply {
            addUpdateListener {
                val value = it.animatedValue as Int
                startAngle = value
            }
            duration = durationAnimation / 2
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }.start()

        setProgress(0.0, 100.0)
        ValueAnimator.ofFloat(0f, 85f).apply {
            addUpdateListener {
                val value = it.animatedValue as Float
                setCurrentProgress(value.toDouble())
            }
            duration = durationAnimation
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }.start()
    }


}