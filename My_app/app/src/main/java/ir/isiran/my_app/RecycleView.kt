package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
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


        val recycleview = findViewById<RecyclerView>(R.id.RecycleViewLayout)
        val adapter = RecyclerAdapter(list)
        recycleview.adapter = adapter
        recycleview.layoutManager= LinearLayoutManager(this,RecyclerView.HORIZONTAL,true)

        val recycleview2 = findViewById<RecyclerView>(R.id.RecycleViewLayout2)
        val adapter2 = RecyclerAdapter(list)
        recycleview2.adapter = adapter2
        recycleview2.layoutManager= LinearLayoutManager(this,RecyclerView.HORIZONTAL,true)






    }
}