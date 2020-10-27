package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList as ArrayList1

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        showToast()
        //showToast1("Shirazi/Android")
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

    fun Var_Val(){
        //var (like reg)
        //val (like constant)
        var person : String = "test"
        person = "Shirazi"
        val list: ArrayList1<String> = ArrayList()
        list.add("Salehi")
        list.add("Shirazi")
        list.add("Mahdi")
        val list1=ArrayList<String>()
        val list2:ArrayList<String> = arrayListOf<String>("Salehi","Shirazi","Mahdi")


    }

    fun If_fun(number : Int): String{
        if (number == 10){
            return "Yes"
        }
        else
        {
            return "No"
        }

        val pop : String = when(number){
            1   -> "one"
            2   -> "two"
            in 3..7 -> "Medium"
            in 7..10 -> "high"
            else    -> "No"
        }

        for (i:Int in 0..30 step 2){}
        for (j:Int in 20 downTo 0){}
        for (k:Int in 10 until 0){}

    }
}

