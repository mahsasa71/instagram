package com.example.instagram3.ui.profile

import android.content.Context
import android.content.SharedPreferences
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
import coil.load
import coil.transform.CircleCropTransformation
import com.example.instagram.util.Constance
import com.example.instagram3.R
import com.example.instagram3.databinding.FragmentProfileBinding
import com.example.instagram3.models.Story
import com.example.instagram3.ui.home.PostsFragment
import com.example.instagram3.ui.home.ReelsFragment
import com.example.instagram3.ui.home.StoryAdapter
import com.example.instagram3.ui.home.ViewPagerAdapter


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileViewModel
    lateinit var owner: LifecycleOwner
    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner=this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(ProfileViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgProfile.load("${Constance.BASE_URL}story/maryam.jpg"){
            transformations(CircleCropTransformation())
        }
        val list:  MutableList<Story>  = mutableListOf()
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))
        list.add(Story("abasi","${Constance.BASE_URL}story/maryam.jpg"))

        binding.recyclerHilight.adapter= StoryAdapter(requireContext(),list)
        binding.recyclerHilight.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(PostsFragment(), "Posts")
        adapter.addFragment(ReelsFragment(), "Videos")


        // Adding the Adapter to the ViewPager
        binding.viewPager.adapter = adapter

        // bind the viewPager with the TabLayout.
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        var pref: SharedPreferences =requireActivity().getSharedPreferences("setting",Context.MODE_PRIVATE)
        var userId=pref.getString("userId","")
        binding.progressBar.visibility=View.VISIBLE

        viewModel.profileUser(userId!!).observe(owner, Observer{user->
            binding.progressBar.visibility=View.GONE
            binding.constraintProfile.visibility=View.VISIBLE

            Log.e("","")
            binding.imgProfile.load("${Constance.BASE_URL}${user.image}"){
                transformations(CircleCropTransformation())
            }
            binding.txtPostsCount.text=user.posts_count.toString()
            binding.txtUsername.text=user.username.toString()
            binding.txtBio.text=user.bio.toString()



        })

    }


}