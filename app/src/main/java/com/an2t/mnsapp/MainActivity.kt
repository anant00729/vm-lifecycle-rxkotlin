package com.an2t.mnsapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.an2t.mnsapp.home.HomeFragment
import com.an2t.mnsapp.maps.MapsFragment
import com.an2t.mnsapp.menu.MenuFragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(){


//    private lateinit var mMap: GoogleMap

//    override fun onMapReady(googleMap: GoogleMap?) {
//        mMap = googleMap!!
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//
//    }




    lateinit var mapFragment: SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment


        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.map, fragment, fragment.javaClass.getSimpleName())
            .commit()



        //textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {


//                val mapFragment = supportFragmentManager
//                    .findFragmentById(R.id.map) as SupportMapFragment

                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.map, fragment, fragment.javaClass.getSimpleName())
                    .commit()

                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {


                val fragment = MapsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.map, fragment, fragment.javaClass.getSimpleName())
                    .commit()

//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.map, mapFragment, mapFragment.javaClass.getSimpleName())
//                    .commit()
//
//                mapFragment.getMapAsync(this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //textMessage.setText(R.string.title_notifications)

                val fragment = MenuFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.map, fragment, fragment.javaClass.getSimpleName())
                    .commit()

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
