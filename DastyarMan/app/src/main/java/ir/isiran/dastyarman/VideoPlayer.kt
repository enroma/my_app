package ir.isiran.dastyarman

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class VideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val edtAddress = findViewById<EditText>(R.id.edtAddress)
        val btnAddress = findViewById<Button>(R.id.btnAddress)
        val btnVideotest = findViewById<Button>(R.id.btnVideoTest)
        val videoView =  findViewById<VideoView>(R.id.videoView)

        btnAddress.setOnClickListener(){
            val address = edtAddress.text.toString()
            if (address == "") {
                val dialog = AlertDialog.Builder(this)
                        .setTitle("توجه")
                        .setMessage("آدرس را وارد و سپس برای جستجو اقدام کنید")
                        .setNeutralButton("باشه!"){
                            dialog,which -> Toast.makeText(this,"آدرس فراموش نشود!",Toast.LENGTH_SHORT).show()
                        }.create()
                dialog.show()
            } else {
                videoView.setMediaController(MediaController(this))
                videoView.setVideoURI(Uri.parse(address))
                videoView.start()
            }
        }

        btnVideotest.setOnClickListener(){
            videoView.setMediaController(MediaController(this))
            videoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.test_video))
            videoView.start()
        }
    }
}