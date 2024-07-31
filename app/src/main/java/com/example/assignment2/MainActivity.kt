package com.example.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : ComponentActivity() {

    private lateinit var fragmentBtn1: Button
    private lateinit var fragmentBtn2: Button
    private lateinit var rootLayout: ConstraintLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.expanded_menu)

        fragmentBtn1 = findViewById(R.id.fragmentBtn1)
        fragmentBtn2 = findViewById(R.id.fragmentBtn2)

        fragmentBtn1.setOnClickListener {
            loadFragment(Fragment1())
        }

        fragmentBtn2.setOnClickListener {
            loadFragment(Fragment2())
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_option1 -> {
                changeBackgroundColor(Color.RED)
                true
            }

            R.id.action_option2 -> {
                changeBackgroundColor(Color.BLUE)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val manager = fragment.requireActivity().supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container_view_tag, fragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
        }

    private fun changeBackgroundColor(color: Int) {
        rootLayout.setBackgroundColor(color)
        window.decorView.setBackgroundColor(color)

    }

}





