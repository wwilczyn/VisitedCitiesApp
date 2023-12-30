package com.example.visitedcitiesapp

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.Icon
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.visitedcitiesapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }


//        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setTitle("I am the title")
            .setPositiveButton("Positive") { dialog, which ->
                // Do something.
            }
            .setNegativeButton("Negative") { dialog, which ->
                // Do something else.
            }
            .setMultiChoiceItems(
                arrayOf("Item One", "Item Two"), null) { dialog, which, isChecked ->
                // Do something.
            }

        val dialog: AlertDialog = builder.create()
//        dialog.show()


        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Adding a city in a country", Snackbar.LENGTH_LONG)
                .setAction("Action", View.OnClickListener { dialog.show() })
//                .setAction("COPY TO", View.OnClickListener() {
//                    onClick = onClick(View view) {
//                        showDialog("Hello")
//                    }
//                })
                .show()
        }
    }


    private fun showDialog(title: String) {
//        val dialog = Dialog(activity)
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.custom_layout)

//        val body = dialog.findViewById(R.id.body) as TextView
        val body = dialog.findViewById(R.id.fab) as TextView
        body.text = title

        val yesBtn = dialog.findViewById(R.id.button_first) as Button
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }

        val noBtn = dialog.findViewById(R.id.button_second) as Button
        noBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
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
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}