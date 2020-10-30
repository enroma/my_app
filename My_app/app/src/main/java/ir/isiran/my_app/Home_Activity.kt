package ir.isiran.my_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Home_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnAbout = findViewById<Button>(R.id.btnAboutus)
        val btnTas = findViewById<Button>(R.id.btnTas)
        val edtUser = findViewById<EditText>(R.id.edtUesrname)

        val tas_intent: Intent = Intent(this,TasActivity::class.java)
        val aboutus_intent: Intent = Intent(this,exercise2_digikala_about::class.java)


        btnAbout.setOnClickListener {
            startActivity(aboutus_intent)
        }
        btnTas.setOnClickListener {
            val name : String = edtUser.text.toString()
            tas_intent.putExtra("Username",name)
            startActivity(tas_intent)
        }
    }

}