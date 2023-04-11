package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentMainBinding.inflate(inflater,container,false)
        loadFragment(HomeFragment())
        binding.navBottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.info->{
                    loadFragment(InfoFragment())
                    true
                }
                R.id.message->{
                    loadFragment(MessageFragment())
                    true
                }
                R.id.settings->{
                    loadFragment(SettingFragment())
                    true
                }

                else ->{
                    false
                }
            }
        }
        return binding.root
    }
    private fun loadFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.linearlayout,fragment)
            .commit()
    }

}