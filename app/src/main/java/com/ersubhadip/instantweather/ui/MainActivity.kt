package com.ersubhadip.instantweather.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.FragmentTransitionSupport
import com.ersubhadip.instantweather.R
import com.ersubhadip.instantweather.viewmodel.MainViewModel
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    //DONE:
    //setup accent color
    //colors.xml
    //setting up the navigation for bottom bar

    //TODO
    //font -> pending
    //current weather fragment -> ?
    //forced white theme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController

        //setting up navBar
        val bottomNavigation:MeowBottomNavigation = findViewById(R.id.bottomNavigationView)
        bottomNavigation.add(MeowBottomNavigation.Model(R.string.forecastFragment ,R.drawable.ic_forecast))
        bottomNavigation.add(MeowBottomNavigation.Model(R.string.homeFragment,R.drawable.ic_weather))
        bottomNavigation.add(MeowBottomNavigation.Model(R.string.graphFragment,R.drawable.ic_graph))

        bottomNavigation.show(R.string.homeFragment,true)


        val homeFragment = HomeFragment()
        val graphFragment = GraphFragment()
        val forecastFragment = ForecastFragment()

        setFragment(homeFragment, R.string.homeFragment)


        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                R.string.forecastFragment-> {
                    Toast.makeText(this@MainActivity, "Forecast", LENGTH_SHORT).show()
                    setFragment(forecastFragment, R.string.forecastFragment)

                }

                R.string.homeFragment-> {
                    Toast.makeText(this@MainActivity, "Home", LENGTH_SHORT).show()
                    setFragment(homeFragment , R.string.homeFragment)

                }

                R.string.graphFragment-> {
                    Toast.makeText(this@MainActivity, "Weather Analytics", LENGTH_SHORT).show()
                    setFragment(graphFragment ,R.string.graphFragment)
                }

                else -> Toast.makeText(this@MainActivity,"Hello",LENGTH_SHORT).show()
            }
        }

    }

    private fun setFragment(fragment : Fragment, label : Int ) {
        supportFragmentManager.beginTransaction().apply {
            replace(
                R.id.flFragmentContainer, fragment
            )
            commit()
            this@MainActivity.setTitle(label)

        }
    }


}