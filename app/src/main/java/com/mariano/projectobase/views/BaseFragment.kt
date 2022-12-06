package com.mariano.projectobase.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.mariano.projectobase.App
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

abstract class BaseFragment<BindingClass : ViewBinding> : Fragment(){

    protected lateinit var binding: BindingClass
    protected lateinit var navController: NavController
    private lateinit var app: App

    @Inject
    @ApplicationContext protected lateinit var ctx: Context

    protected abstract val viewBinding: BindingClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewBinding
        app = App.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setUpOnce()
    }

    protected infix fun NavController.navigateTo (action: NavDirections) {
        navigate(action)
    }

    protected open fun setUpOnce() {}
    protected abstract fun setUpViews()
    protected abstract fun observeData()

    override fun onResume() {
        super.onResume()
        observeData()
        setUpViews()
    }
}