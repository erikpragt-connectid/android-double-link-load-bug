package com.example.echoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data

        Thread {
            // do background stuff here
            val content = if(appLinkData != null) {
                URL(appLinkData.toString()).readText()
            } else {
                "Please load the application from a URL"
            }

            runOnUiThread {
                val textView = findViewById<TextView>(R.id.responseTextView)

                textView.text = content
            }
        }.start()

        setContentView(R.layout.activity_main)
    }
}

