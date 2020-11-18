package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.prefs.PreferenceChangeEvent

class SharePreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preference)

        val edtShare = findViewById<EditText>(R.id.edtText)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnShow = findViewById<Button>(R.id.btnShow)

        btnSave.setOnClickListener() {
            val preferences = PreferenceManager.getDefaultSharedPreferences(this).edit().putString("shareData", edtShare.text.toString()).apply()
            Toast.makeText(this,"Save Done!",Toast.LENGTH_SHORT).show()
        }

        btnShow.setOnClickListener(){
            val result = PreferenceManager.getDefaultSharedPreferences(this).getString("shareData","Null")
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
        }
    }




}