package ir.isiran.my_app

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class ShowNewClassTest(var context: Context):AppCompatActivity() {


    fun Randomize_fun(): Int {
        val rand = (Random.nextInt(1,7))
        return rand
    }

}