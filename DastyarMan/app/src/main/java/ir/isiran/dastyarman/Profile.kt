package ir.isiran.dastyarman

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val btnOk = findViewById<ImageButton>(R.id.btnOK)
        val btnNotOk = findViewById<ImageButton>(R.id.btnNotOK)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtNNumber = findViewById<EditText>(R.id.edtNnumber)
        val edtEducation = findViewById<EditText>(R.id.edtEducation)
        val edtWork = findViewById<EditText>(R.id.edtWork)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val edtMobile = findViewById<EditText>(R.id.edtMobile)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        edtName.setText(LoadData("Name","مهدی شیرازی"))
        edtNNumber.setText(LoadData("Number","کد ملی"))
        edtEducation.setText(LoadData("Education","تحصیلات"))
        edtWork.setText(LoadData("Work","شغل"))
        edtAge.setText(LoadData("Age","سن"))
        edtMobile.setText(LoadData("Mobile","موبایل"))
        edtEmail.setText(LoadData("Email","ایمیل"))



        val home_intent = intent

        btnOk.setOnClickListener {
            val name : String = edtName.text.toString()
            val nnumber : String = edtNNumber.text.toString()
            val education : String = edtEducation.text.toString()
            val work : String = edtWork.text.toString()
            val age : String = edtAge.text.toString()
            val mobile : String = edtMobile.text.toString()
            val email : String = edtEmail.text.toString()

            SendDetail(home_intent,"Name",name)
            SendDetail(home_intent,"Number",nnumber)
            SendDetail(home_intent,"Education",education)
            SendDetail(home_intent,"Work",work)
            SendDetail(home_intent,"Age",age)
            SendDetail(home_intent,"Mobile",mobile)
            SendDetail(home_intent,"Email",email)
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

    fun SendDetail(intent : Intent, Key: String,  Value : String){
        intent.putExtra(Key,Value)
        SaveData(Key,Value)
    }

    fun SaveData( Key: String,  Value : String){
        //save setting
        val prefrences = PreferenceManager.getDefaultSharedPreferences(this).edit().putString(Key, Value).apply()
    }

    fun LoadData( Key :String ,  Default : String) : String? {
        val result : String? = PreferenceManager.getDefaultSharedPreferences(this).getString(Key,Default)
        return result
    }

}
