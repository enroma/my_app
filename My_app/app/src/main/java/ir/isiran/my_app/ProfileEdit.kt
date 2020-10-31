package ir.isiran.my_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ProfileEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)

        val btnReport = findViewById<Button>(R.id.btnReport)
        val edtUser = findViewById<EditText>(R.id.edtUesrname)
        val txtReport = findViewById<TextView>(R.id.txtReport)

        val intent = getIntent()
        val rectext = intent.getStringExtra("Request")

        txtReport.text = rectext

        btnReport.setOnClickListener {
            val Report = edtUser.text.toString()
            intent.putExtra("Report" , Report)
            setResult(Activity.RESULT_OK,intent)
            finish() //important
        }

    }


}