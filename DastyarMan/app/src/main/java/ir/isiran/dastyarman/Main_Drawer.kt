package ir.isiran.dastyarman

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main_Drawer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_drawer)

        val imgMenu=findViewById<ImageView>(R.id.imgMenu)
        val drawer=findViewById<DrawerLayout>(R.id.drawer)
        imgMenu.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.END)
        })


        val txtProfile = findViewById<TextView>(R.id.txtProfile)
        val txtCall = findViewById<TextView>(R.id.txtCall)
        val txtSMS = findViewById<TextView>(R.id.txtSMS)
        val txtCamera = findViewById<TextView>(R.id.txtCamera)


        txtProfile.setOnClickListener(){
            val profile_intent: Intent = Intent(this,Profile::class.java)
            startActivityForResult(profile_intent,150)
        }

        txtCall.setOnClickListener(){
            val call_intent: Intent = Intent(this,Call::class.java)
            startActivity(call_intent)
        }

        txtSMS.setOnClickListener(){
            val sms_intent: Intent = Intent(this,SMS::class.java)
            startActivity(sms_intent)
        }



        txtCamera.setOnClickListener() {
            val camera_intent = Intent(this,Camera::class.java)
            startActivity(camera_intent)
        }

        // --------Recycle View -------


        val list = ArrayList<String>()
        list.add("list1")
        list.add("list2")
        list.add("list3")
        list.add("list4")
        list.add("list5")
        list.add("list6")
        list.add("list7")
        list.add("list8")
        list.add("list9")
        list.add("list8")
        list.add("list7")

        val list2 = ArrayList<String>()
        list2.add("test1")
        list2.add("test2")
        list2.add("test3")
        list2.add("test4")
        list2.add("test5")
        list2.add("test6")
        list2.add("test7")
        list2.add("test8")
        list2.add("test9")
        list2.add("test8")
        list2.add("test7")


        val recycleview = findViewById<RecyclerView>(R.id.RVL_1)
        val adapter = RecycleAdapter1(list)
        recycleview.adapter = adapter
        recycleview.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,true)

        val recycleview2 = findViewById<RecyclerView>(R.id.RVL_2)
        val adapter2 = RecycleAdapter2(list2)
        recycleview2.adapter = adapter2
        recycleview2.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 150){
            if(resultCode == Activity.RESULT_OK) {
                val result: String? = data?.getStringExtra("Report") //safe call
                val name: String? = data?.getStringExtra("Name") //safe call
                val txtName = findViewById<TextView>(R.id.txtName)
                txtName.text = "سلام "+name+" عزیز!"
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
            else if (resultCode == Activity.RESULT_CANCELED){
                val result: String? = data?.getStringExtra("Report") //safe call
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }
}