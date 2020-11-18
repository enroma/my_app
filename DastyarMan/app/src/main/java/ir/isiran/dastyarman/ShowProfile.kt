package ir.isiran.dastyarman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.EditText
import android.widget.TextView

class ShowProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_profile)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtNNumber = findViewById<TextView>(R.id.txtNnumber)
        val txtEducation = findViewById<TextView>(R.id.txtEducation)
        val txtWork = findViewById<TextView>(R.id.txtWork)
        val txtAge = findViewById<TextView>(R.id.txtAge)
        val txtMobile = findViewById<TextView>(R.id.txtMobile)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)

        txtName.text  = LoadData("Name","مهدی شیرازی")
        txtNNumber.text = LoadData("Number","کد ملی")
        txtEducation.text = LoadData("Education","تحصیلات")
        txtWork.text = LoadData("Work","شغل")
        txtAge.text = LoadData("Age","سن")
        txtMobile.text = LoadData("Mobile","موبایل")
        txtEmail.text = LoadData("Email","ایمیل")

    }



    fun LoadData( Key :String ,  Default : String) : String? {
        val result : String? = PreferenceManager.getDefaultSharedPreferences(this).getString(Key,Default)
        return result
    }
}