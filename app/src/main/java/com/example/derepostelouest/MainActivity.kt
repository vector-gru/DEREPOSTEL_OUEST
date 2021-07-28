package com.example.derepostelouest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_services.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){

                R.id.nav_home -> Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                //R.id.nav_services -> Toast.makeText(applicationContext, "Services", Toast.LENGTH_SHORT).show()
                R.id.nav_services -> replaceFragment(ServicesFragment(), it.title.toString())
                //R.id.nav_settings -> Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> replaceFragment(SettingsFragment(), it.title.toString())
                //R.id.nav_operator_login -> Toast.makeText(applicationContext, "Operator Login", Toast.LENGTH_SHORT).show()
                R.id.nav_operator_login -> replaceFragment(OperatorLoginFragment(), it.title.toString())
                //R.id.nav_guide -> Toast.makeText(applicationContext, "Guide", Toast.LENGTH_SHORT).show()
                R.id.nav_guide -> replaceFragment(GuideFragment(), it.title.toString())
                //R.id.nav_about_developer -> Toast.makeText(applicationContext, "About Developer", Toast.LENGTH_SHORT).show()
                R.id.nav_about_developer -> replaceFragment(AboutDeveloperFragment(), it.title.toString())

            }

            true
        }

        setSupportActionBar(welcome_home_toolbar)

        welcome_home_toolbar.setNavigationOnClickListener {
            Toast.makeText(this,"Navigation Menu Clicked",Toast.LENGTH_SHORT).show()
        }

        layoutOperatorLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        layoutServices.setOnClickListener{
            startActivity(Intent(this, Services::class.java))
        }

    }

    private fun replaceFragment(fragment: Fragment, title : String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
       //if (toggle.onOptionsItemSelected(item)){

            //return true

        //}

        //return super.onOptionsItemSelected(item)
    //}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_services_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when(itemView){

            R.id.add -> Toast.makeText(applicationContext,"Add Clicked",Toast.LENGTH_SHORT).show()
            R.id.notify -> Toast.makeText(applicationContext,"Notification Clicked",Toast.LENGTH_SHORT).show()
        }

        return false
    }

}