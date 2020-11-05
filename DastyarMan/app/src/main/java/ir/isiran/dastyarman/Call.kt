package ir.isiran.dastyarman

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class Call : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)


        val btnCall = findViewById<ImageView>(R.id.imgCall)
        val edtCallID = findViewById<EditText>(R.id.edtCallNum)

        btnCall.setOnClickListener {
            val callID = edtCallID.text.toString()
            val call_intent = Intent(Intent.ACTION_DIAL)
            call_intent.data = Uri.parse("tel:"+callID)
            startActivity(call_intent)
        }


    }


}