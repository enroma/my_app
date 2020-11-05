package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class DrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        val imgMenu = findViewById<ImageView>(R.id.imgMenu)
        val drawer = findViewById<DrawerLayout>(R.id.drawerLayout)

        imgMenu.setOnClickListener(){
            drawer.openDrawer(GravityCompat.START)
        }


    }
}