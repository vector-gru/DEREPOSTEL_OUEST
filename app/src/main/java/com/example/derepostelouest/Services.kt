package com.example.derepostelouest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_services.*

class Services : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        setSupportActionBar(services_toolbar)

        services_toolbar.setNavigationOnClickListener {
            Toast.makeText(this,"Navigation Menu Clicked",Toast.LENGTH_SHORT).show()
        }

    }

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