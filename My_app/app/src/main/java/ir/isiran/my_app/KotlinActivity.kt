package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        showToast()
        showToast1("Shirazi/Android")
        IncrementByOne(10)
    }

    fun showToast(){
        Toast.makeText(this,"Welcome to Login Page!",Toast.LENGTH_LONG).show()
    }

    fun showToast1(Fname: String){
        Toast.makeText(this,Fname,Toast.LENGTH_LONG).show()
    }

  /* fun IncrementByOne(num : Int) : Int{
        return num+1
    }

   */

    fun IncrementByOne(num : Int) = num+1


}