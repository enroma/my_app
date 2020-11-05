package ir.isiran.dastyarman

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val imgCall = findViewById<ImageView>(R.id.imgCall)
        val imgSMS = findViewById<ImageView>(R.id.imgSMS)
        val imgCamera = findViewById<ImageView>(R.id.imgCamera)


        imgProfile.setOnClickListener(){
            val profile_intent: Intent = Intent(this,Profile::class.java)
            startActivityForResult(profile_intent,150)
        }

        imgCall.setOnClickListener(){
            val call_intent: Intent = Intent(this,Call::class.java)
            startActivity(call_intent)
        }

        imgSMS.setOnClickListener(){
            val sms_intent: Intent = Intent(this,SMS::class.java)
            startActivity(sms_intent)
        }



        imgCamera.setOnClickListener() {
            val camera_intent = Intent(this,Camera::class.java)
            startActivity(camera_intent)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 150){
            if(resultCode == Activity.RESULT_OK) {
                val result: String? = data?.getStringExtra("Report") //safe call
                val name: String? = data?.getStringExtra("Name") //safe call
                val txtName = findViewById<TextView>(R.id.txtName)
                txtName.text = "سلام "+name+" عزیز!"
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
            else if (resultCode == Activity.RESULT_CANCELED){
                val result: String? = data?.getStringExtra("Report") //safe call
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }
}