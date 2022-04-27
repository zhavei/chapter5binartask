package com.syafei.chapter5binartask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syafei.chapter5binartask.databinding.ActivityMainBinding
import com.syafei.chapter5binartask.fragment.FragmentTwo

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var binding: ActivityMainBinding

    companion object{
        val KEY_FRAGSECOND = "fragment_second"
        val KEY_IMAGE = "imagea-key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setupWithNavController
        val bottomNavView = findViewById<BottomNavigationView>(R.id.BottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)

        //appBarConfig
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.tridhFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavView.setupWithNavController(navController)
    }

    /*override fun editextData(editextData: String) {
        *//*val bundle = Bundle()
        bundle.putString(KEY_FRAGSECOND, editextData)*//*

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentTwo()

        //fragmentTwo.arguments = bundle

        fragmentTwo.arguments = bundleOf(
            KEY_FRAGSECOND to editextData,
            KEY_IMAGE to R.drawable.gunung
        )

        // to pass data to fragment B and open it
        transaction.replace(R.id.fragmentSecond, fragmentTwo).commit()
    }*/


    override fun editextData(editextData: String, imageView: Int) {
        /*val bundle = Bundle()
        bundle.putString(KEY_FRAGSECOND, editextData)*/

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentTwo()

        //fragmentTwo.arguments = bundle

        fragmentTwo.arguments = bundleOf(
            KEY_FRAGSECOND to editextData,
            KEY_IMAGE to R.drawable.gunung
        )

        // to pass data to fragment B and open it a.k.a replace view fragment
        transaction.replace(R.id.fragmentSecond, fragmentTwo).commit()
    }


}