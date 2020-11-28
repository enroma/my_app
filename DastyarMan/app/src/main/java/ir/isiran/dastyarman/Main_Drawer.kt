package ir.isiran.dastyarman

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
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
        val txtName = findViewById<TextView>(R.id.txtName)

        txtName.setText("سلام " + (PreferenceManager.getDefaultSharedPreferences(this).getString("Name","مهدی شیرازی")) + " عزیز!")

        imgMenu.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.END)
        })


        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val txtProfile = findViewById<TextView>(R.id.txtProfile)
        val txtCall = findViewById<TextView>(R.id.txtCall)
        val txtSMS = findViewById<TextView>(R.id.txtSMS)
        val txtCamera = findViewById<TextView>(R.id.txtCamera)
        val txtPraytime = findViewById<TextView>(R.id.txtPrayTime)
        val txtVideoplayer = findViewById<TextView>(R.id.txtVideoPlayer)
        val txtWebExplorer = findViewById<TextView>(R.id.txtWebEXplorer)
        val txtMap = findViewById<TextView>(R.id.txtMap)


        imgProfile.setOnClickListener(){
            val show_profile_intent: Intent = Intent(this,ShowProfile::class.java)
            startActivity(show_profile_intent)
        }


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

        txtPraytime.setOnClickListener() {
            val pray_intent = Intent(this,http_url_connection::class.java)
            startActivity(pray_intent)
        }

        txtVideoplayer.setOnClickListener() {
            val video_intent = Intent(this,VideoPlayer::class.java)
            startActivity(video_intent)
        }

        txtWebExplorer.setOnClickListener() {
            val web_intent = Intent(this,WebExplorer::class.java)
            startActivity(web_intent)
        }

        txtMap.setOnClickListener() {
            val map_intent = Intent(this,MapsActivity::class.java)
            startActivity(map_intent)
        }
        // --------Recycle View -------


        val recycleview = findViewById<RecyclerView>(R.id.RVL_1)
        val list = generateList(100)
        val adapter = RecycleAdapter1(list)
        recycleview.adapter = adapter
        recycleview.layoutManager= LinearLayoutManager(this,RecyclerView.HORIZONTAL,true)
        recycleview.setHasFixedSize(true)


        val recycleview2 = findViewById<RecyclerView>(R.id.RVL_2)
        val adapter2 = RecycleAdapter2(list)
        recycleview2.adapter = adapter2
        recycleview2.layoutManager= LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)

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

    fun generateList(size : Int): List<ElementItems>{
        val mylist=ArrayList<ElementItems>()
        for(i in 0 until size){
            val img = when(i % 4){
                0   ->  R.drawable.one_pic
                1   ->  R.drawable.two_pic
                2   ->  R.drawable.three_pic
                3   ->  R.drawable.four_pic
                else->  R.drawable.loop_icon
            }

            val title = "Item $i"
            val desc = when(i % 3){
                0   ->  "des1"
                1   ->  "des2"
                2   ->  "des3"
                3   ->  "des4"
                else->  "else"
            }

            val items=ElementItems(img,title,desc)
            mylist+=items
        }

        return mylist
    }
}