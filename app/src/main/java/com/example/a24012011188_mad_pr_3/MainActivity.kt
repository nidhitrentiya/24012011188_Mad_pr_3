package com.example.a24012011188_mad_pr_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        implicitIntent()
    }
    fun implicitIntent (){
        findViewById<Button>(R.id.btn_browse).setOnClickListener {
            Intent(Intent.ACTION_VIEW,Uri.parse(findViewById<EditText>(R.id.editTextText).text.toString())).also {startActivity(it) }

        }
        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val number=findViewById<EditText>(R.id.editTextPhone).text.toString()
            val intent= Intent(Intent.ACTION_DIAL)
            intent.setData("tel:$number".toUri())
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_calllog).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.TYPE).apply { startActivity(this)}

        }
        findViewById<Button>(R.id.btn_camera).setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }
        findViewById<Button>(R.id.btn_gallery).setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/star").apply { startActivity(this) }
        }
        findViewById<Button>(R.id.btn_alarm).setOnClickListener{
            Intent(AlarmClock.ACTION_SET_ALARM).also { startActivity(it) }
        }
        fun explicitIntent(){
            findViewById<Button>(R.id.btn_login).setOnClickListener {  }
        }
    }
        }
