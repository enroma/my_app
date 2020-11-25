package ir.isiran.my_app

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AlertDialog
import java.net.URL

class AlarmDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_dialog)

        val btnAlert = findViewById<Button>(R.id.btnAlert)

        btnAlert.setOnClickListener(){
            val dialog = AlertDialog.Builder(this)
                    .setTitle("توجه")
                    .setMessage("خطرناکه می فهمی؟")
                    .setPositiveButton("بله"){
                        dialog,which -> Toast.makeText(this,"واقعاً گفتی بله؟",Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("نه"){
                        dialog,which -> Toast.makeText(this,"می دونستم میگی نه",Toast.LENGTH_SHORT).show()
                    }
                    .setNeutralButton("برو بابا"){
                        dialog,which -> Toast.makeText(this,"بی ادب",Toast.LENGTH_SHORT).show()
                    }.create()
            dialog.show()

        }


        val videoView =  findViewById<VideoView>(R.id.videoView)
        videoView.setMediaController(MediaController(this))
        videoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video))
        videoView.start()
    }


}