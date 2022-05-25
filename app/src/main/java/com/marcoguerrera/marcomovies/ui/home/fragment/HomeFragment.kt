package com.marcoguerrera.marcomovies.ui.home.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.marcoguerrera.marcomovies.databinding.FragmentHomeBinding
import com.marcoguerrera.marcomovies.data.source.remote.model.PopularResultsItem
import com.marcoguerrera.marcomovies.ui.home.viewmodel.HomeViewModel

class HomeFragment: Fragment() {
    private val TAG = "HomeFragment"
    private lateinit var homeViewModel: HomeViewModel

    private var popMovies: List<PopularResultsItem>? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //homeViewModel.getMoviesCategory()

        //1.//val observePopularItems = Observer<List<PopularResultsItem>>(){}
        //2.//homeViewModel.listPopular.observe(viewLifecycleOwner,observePopularItems)
        //3.//homeViewModel.listPopular.observe(viewLifecycleOwner, Observer {  })
        /*4*/homeViewModel.listPopular.observe(viewLifecycleOwner, { Log.d(TAG,"$it") })
    }
}