package ir.isiran.my_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ImplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        val edtBrowser = findViewById<EditText>(R.id.edtBrowser)
        val btnEnter = findViewById<Button>(R.id.btnGo)
        val edtCallID = findViewById<EditText>(R.id.edtCall)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val edtCallSMS = findViewById<EditText>(R.id.edtCallSMS)
        val edtSMS = findViewById<EditText>(R.id.edtSMS)
        val btnCallSMS = findViewById<Button>(R.id.btnCallSMS)

        btnEnter.setOnClickListener {
            val text = edtBrowser.text.toString()
            val browser_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://" + text))
            startActivity(browser_intent)
        }

        btnCall.setOnClickListener {
            val callID = edtCallID.text.toString()
            val call_intent = Intent(Intent.ACTION_DIAL)
            call_intent.data = Uri.parse("tel:"+callID)
            startActivity(call_intent)
        }

        btnCallSMS.setOnClickListener {
            val SMSNum = edtCallSMS.text.toString()
            val SMS = edtSMS.text.toString()
            val sms_intent = Intent(Intent.ACTION_SENDTO)
            sms_intent.data = Uri.parse("smsto:"+SMSNum)
            sms_intent.putExtra("sms_body",SMS)
            startActivity(sms_intent)


        }
    }
}