package com.example.instagram3.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram3.R
import com.example.instagram3.databinding.FragmentDashboardBinding
import com.example.instagram3.ui.addPost.AddPostFragment
import com.example.instagram3.ui.explore.ExploreFragment
import com.example.instagram3.ui.home.HomeFragment
import com.example.instagram3.ui.profile.ProfileFragment
import com.example.radiojavannahaei.adapter.PagerAdapter

class DashboardFragment : Fragment() {
 lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list= mutableListOf<Fragment>()
        list.add(HomeFragment())
        list.add(ExploreFragment())
        list.add(AddPostFragment())
        list.add(ProfileFragment())
        binding.pager.adapter= PagerAdapter(requireActivity(),list)
        binding.pager.isUserInputEnabled = false
        binding.bottomMenu.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.item_home->{
                    binding.pager.currentItem=0
                    true
                }
                R.id.item_explore->{
                    binding.pager.currentItem=1
                    true
                }
                R.id.item_addpost->{
                    binding.pager.currentItem=2
                    true
                }
                R.id.item_profile->{
                    binding.pager.currentItem=3
                    true
                }
            }
            true

        }

        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0->binding.bottomMenu.menu.findItem(R.id.item_home).setChecked(true)
                    1->binding.bottomMenu.menu.findItem(R.id.item_explore).setChecked(true)
                    2->binding.bottomMenu.menu.findItem(R.id.item_addpost).setChecked(true)
                    3->binding.bottomMenu.menu.findItem(R.id.item_profile).setChecked(true)
                }

            }
        })
    }


}