package ir.isiran.profile_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtNNumber = findViewById<TextView>(R.id.txtNnumber)
        val txtEducation = findViewById<TextView>(R.id.txtEducation)
        val txtWork = findViewById<TextView>(R.id.txtWork)
        val txtAge = findViewById<TextView>(R.id.txtAge)
        val txtMobile = findViewById<TextView>(R.id.txtMobile)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val btnOK = findViewById<ImageButton>(R.id.btnOK)
        val btnNotOK = findViewById<ImageButton>(R.id.btnNotOK)

        val intent = intent
        val nameRecieved = intent.getStringExtra("Name")
        val numberRecieved = intent.getStringExtra("Number")
        val educationRecieved = intent.getStringExtra("Education")
        val workRecieved = intent.getStringExtra("Work")
        val ageRecieved = intent.getStringExtra("Age")
        val mobileRecieved = intent.getStringExtra("Mobile")
        val emailRecieved = intent.getStringExtra("Email")

        txtName.text = nameRecieved
        txtNNumber.text = numberRecieved
        txtEducation.text = educationRecieved
        txtWork.text = workRecieved
        txtAge.text = ageRecieved
        txtMobile.text = mobileRecieved
        txtEmail.text = emailRecieved


        btnOK.setOnClickListener {
            intent.putExtra("Report" , "اطلاعات وارد شده صحیح می باشد.")
            setResult(Activity.RESULT_OK,intent)
            finish() //important
        }

        btnNotOK.setOnClickListener {
            intent.putExtra("Report" , "اطلاعات وارد شده صحیح نمی باشد. دوباره تلاش کنید.")
            setResult(Activity.RESULT_OK,intent)
            finish() //important
        }

    }
}