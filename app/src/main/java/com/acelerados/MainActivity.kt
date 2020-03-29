package com.acelerados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadHome()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> loadHome()
                R.id.suppliers -> loadSuppliers()
                R.id.cart -> loadCart()
                R.id.profile -> loadProfile()
            }
            true
        }

    }

    fun loadHome(){
        addFragment(HomeFragment(), R.id.container)
    }

    fun loadCart(){
        addFragment(CartFragment(), R.id.container)
    }

    fun loadSuppliers(){
        addFragment(SuppliersFragment(), R.id.container)
    }

    fun loadProfile(){
        addFragment(ProfileFragment(), R.id.container)
    }

    private fun addFragment(fragment: Fragment, container: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
