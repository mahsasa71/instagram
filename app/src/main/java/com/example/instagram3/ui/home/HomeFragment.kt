package com.example.instagram3.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.util.Constance

import com.example.instagram3.databinding.FragmentHomeBinding
import com.example.instagram3.models.Story

import com.example.instagram3.viewModel.PostsViewModel


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel:PostsViewModel
    lateinit var owner :LifecycleOwner
    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner=this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(PostsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list:  MutableList<Story>  = mutableListOf()
       list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))


        binding.recyclerStory.adapter=StoryAdapter(requireContext(),list)
        binding.recyclerStory.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        viewModel.getPosts().observe(owner, Observer {
            Log.e("","")
            binding.recyclerPosts.adapter=PostsAdapter (it.post)
            binding.recyclerPosts.layoutManager=LinearLayoutManager(
                requireContext(),LinearLayoutManager.VERTICAL,false)
        })
    }


}