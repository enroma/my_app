package ir.isiran.my_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Home_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnAbout = findViewById<Button>(R.id.btnAboutus)
        val btnTas = findViewById<Button>(R.id.btnTas)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val edtUser = findViewById<EditText>(R.id.edtUesrname)
        val txtReport = findViewById<TextView>(R.id.txtReport)

        val tas_intent: Intent = Intent(this,TasActivity::class.java)
        val aboutus_intent: Intent = Intent(this,exercise2_digikala_about::class.java)
        val profile_intent: Intent = Intent(this,ProfileEdit::class.java)


        btnAbout.setOnClickListener {
            startActivity(aboutus_intent)
        }
        btnTas.setOnClickListener {
            val name : String = edtUser.text.toString()
            tas_intent.putExtra("Username",name)
            startActivity(tas_intent)
        }
        btnProfile.setOnClickListener {
            val Act1toAct2 : String = edtUser.text.toString()
            profile_intent.putExtra("Request",Act1toAct2)
            startActivityForResult(profile_intent,150)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 150){
            if(resultCode == Activity.RESULT_OK){
                val result : String? = data?.getStringExtra("Report") //safe call
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }

}