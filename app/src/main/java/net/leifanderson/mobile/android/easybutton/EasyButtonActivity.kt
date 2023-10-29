package net.leifanderson.mobile.android.easybutton

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat


class EasyButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.easy_button_layout)
        (findViewById<View>(R.id.easy_button_layout) as ImageButton).setOnClickListener {
            val leMediaPlayer = MediaPlayer.create(this@EasyButtonActivity.applicationContext, R.raw.easy)
            leMediaPlayer.start()
            leMediaPlayer.setOnCompletionListener {
                leMediaPlayer.release()
            }
        }

        if(ContextCompat.checkSelfPermission(this@EasyButtonActivity, Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) != PackageManager.PERMISSION_GRANTED) { // I have found that with the new API target, sometimes the app will be "optimized" and the service for the media playback won't start reliably without removing
            // background restriction
            AlertDialog.Builder(this@EasyButtonActivity).setMessage("For the widget to reliably work, you need to grant background permissions.").setTitle("Permission needed").setPositiveButton("Okee, I will enably") { dialog, which ->
                    val myIntent = Intent()
                    myIntent.action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                    myIntent.data = Uri.parse("package:" + this.packageName)
                    startActivity(myIntent)
                }.setNegativeButton("Nah, I don't care") { dialog, which ->
                    AlertDialog.Builder(this@EasyButtonActivity).setMessage("The widget may or may not work properly!").setTitle("You were warned!").setPositiveButton("I'll take my chances") { _, _ ->/*Do nothing*/ }.show()
                }.show()
        }
    }
}
