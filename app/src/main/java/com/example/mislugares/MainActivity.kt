package com.example.mislugares

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.edit_place.*
import kotlinx.android.synthetic.main.edit_place.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        button3?.setOnClickListener{
            launchAbout()
        }
        button7?.setOnClickListener{
            launchAbout()
        }
        button4?.setOnClickListener{
            finish()
        }
        button8?.setOnClickListener{
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.about -> {
                launchAbout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun launchAbout(view: View? = null) {
        val i = Intent(this, AboutActivity::class.java)
        i.putExtra("usuario", "Denry Techera")
        i.putExtra("edad", 34)
        startActivityForResult(i, 1234)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1234 && resultCode == Activity.RESULT_OK) {
            val res = data?.extras?.getString("resultado")?:"sin resultado"

            val snack = Snackbar.make(coordinator_layout, res, Snackbar.LENGTH_LONG).show()
        }
    }
}
