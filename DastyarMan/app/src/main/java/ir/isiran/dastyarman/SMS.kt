package ir.isiran.dastyarman

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import java.net.IDN

class SMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        val edtSMSID = findViewById<EditText>(R.id.edtSMSNum)
        val edtSMSBody = findViewById<EditText>(R.id.edtSMSBody)
        val btnSMSSend = findViewById<ImageView>(R.id.imgSMSSend)

        btnSMSSend.setOnClickListener {
            val SMSID = edtSMSID.text.toString()
            val SMSBody = edtSMSBody.text.toString()
            val sms_intent = Intent(Intent.ACTION_SENDTO)
            sms_intent.data = Uri.parse("smsto:"+SMSID)
            sms_intent.putExtra("sms_body",SMSBody)
            startActivity(sms_intent)
        }

        }


}