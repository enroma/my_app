package ir.isiran.dastyarman

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnOk = findViewById<ImageButton>(R.id.btnOK)
        val btnNotOk = findViewById<ImageButton>(R.id.btnNotOK)

        val home_intent = intent

        btnOk.setOnClickListener {
            SendDetail()
            home_intent.putExtra("Report" , "اطلاعات وارد شده اصلاح شد.")
            setResult(Activity.RESULT_OK,intent)
            finish() //important
        }

        btnNotOk.setOnClickListener {
            home_intent.putExtra("Report" , "اصلاحی انجام نشد.")
            setResult(Activity.RESULT_CANCELED,intent)
            finish() //important
        }
    }

    fun SendDetail(){
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtNNumber = findViewById<EditText>(R.id.edtNnumber)
        val edtEducation = findViewById<EditText>(R.id.edtEducation)
        val edtWork = findViewById<EditText>(R.id.edtWork)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val edtMobile = findViewById<EditText>(R.id.edtMobile)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        val home_intent = intent
        val name : String = edtName.text.toString()
        val nnumber : String = edtNNumber.text.toString()
        val education : String = edtEducation.text.toString()
        val work : String = edtWork.text.toString()
        val age : String = edtAge.text.toString()
        val mobile : String = edtMobile.text.toString()
        val email : String = edtEmail.text.toString()

        home_intent.putExtra("Name",name)
        home_intent.putExtra("Number",nnumber)
        home_intent.putExtra("Education",education)
        home_intent.putExtra("Work",work)
        home_intent.putExtra("Age",age)
        home_intent.putExtra("Mobile",mobile)
        home_intent.putExtra("Email",email)

    }

}
