package com.example.sharedprefapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name_textView:TextView
    lateinit var  editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         editText=findViewById(R.id.name)
        name_textView=findViewById(R.id.textView)
        val btn:Button=findViewById(R.id.save)

        btn.setOnClickListener(){
            val enteredString:String=editText.text.toString()

            SaveNameInSharedPref(enteredString)
            DisplaySavedName()

        }

    }

    private fun SaveNameInSharedPref(enteredString: String) {

        //saving the text into shared pref
        val mySharedPreferences:SharedPreferences=getSharedPreferences("UserName", MODE_PRIVATE)

        //writing a data into shared pref

        val editor:SharedPreferences.Editor=
            mySharedPreferences.edit()

        editor.putString("name",enteredString)
        editor.commit()
        Toast.makeText(this, "Name saved successfully!", Toast.LENGTH_SHORT).show()
        editText.text.clear()
    }

    //reading data from sharedPref

    fun DisplaySavedName(){
        val sharedPreferences:SharedPreferences=getSharedPreferences("UserName", MODE_PRIVATE)

        val s1:String?=sharedPreferences.getString("name","")

        name_textView.setText(s1)
    }
}



