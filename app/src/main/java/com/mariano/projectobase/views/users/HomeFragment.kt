package com.mariano.projectobase.views.users

import com.mariano.projectobase.databinding.FragmentHomeBinding
import com.mariano.projectobase.views.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setUpViews() {

    }

    override fun observeData() {

    }

    override val viewBinding: FragmentHomeBinding
        get() = FragmentHomeBinding.inflate(layoutInflater)
}