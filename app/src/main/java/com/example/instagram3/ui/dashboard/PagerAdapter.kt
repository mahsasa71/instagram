package com.example.radiojavannahaei.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity, var fragments:List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    var fragmentlist=fragments
    override fun getItemCount(): Int {
       return fragmentlist.size

    }

    override fun createFragment(position: Int): Fragment {
      return  fragmentlist.get(position)

    }

}