package com.example.layoutpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.layoutpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.activity = this@MainActivity
        binding.alert = this@MainActivity


        //setContentView(R.layout.activity_main)
    }

    fun toastBtnClick(view: View){
        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
    }

    fun showSettingPopup(view: View) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert, null)
        val textView: TextView = view.findViewById(R.id.alertView)
        textView.text = "alert message"

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("AlertDialog test")
            .setPositiveButton("Ok", null)
            .create()

        alertDialog.setView(view)
        alertDialog.show()
    }
}