package nl.mohinder.bottomnavigationviewkotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import nl.mohinder.bottomnavigationviewkotlin.fragment.HomeFragment
import nl.mohinder.bottomnavigationviewkotlin.fragment.RateFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initNavigation()
    }

    private fun initNavigation() {
        val navController: NavController = findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(navView, navController)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNavigationBar(true)
                R.id.rateFragment -> showBottomNavigationBar(true)
                R.id.ratedFragment -> showBottomNavigationBar(false)
            }
        }
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun showBottomNavigationBar(visible: Boolean) {
        when (visible) {
            true -> navView.visibility = View.VISIBLE
            false -> navView.visibility = View.GONE
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.homeFragment -> {
                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, fragment, fragment.javaClass.simpleName).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.rateFragment -> {
                val fragment = RateFragment()
                supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, fragment, fragment.javaClass.simpleName).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
