package ir.isiran.my_app

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList
import kotlin.random.Random

class TasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tas)

        val btnTas = findViewById<Button>(R.id.btnTas)
        val imgTas = findViewById<ImageView>(R.id.imgTas)
        val txtTas = findViewById<TextView>(R.id.txtRandom)

        btnTas.setOnClickListener {
            val rand = ShowNewClassTest(this).Randomize_fun()
            txtTas.text = "Your Random Number is ${rand.toString()}"

            when(rand){
                1   -> imgTas.setImageResource(R.drawable.one_pic)
                2   -> imgTas.setImageResource(R.drawable.two_pic)
                3   -> imgTas.setImageResource(R.drawable.three_pic)
                4   -> imgTas.setImageResource(R.drawable.four_pic)
                5   -> imgTas.setImageResource(R.drawable.five_pic)
                6   -> imgTas.setImageResource(R.drawable.six_pic)
                else-> imgTas.setImageResource(R.drawable.face_pic)
            }
        }
    }
}