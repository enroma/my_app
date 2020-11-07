package ir.isiran.my_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import java.awt.font.TextAttribute

class RecyclerAdapter(val mylist: ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRecyclerView = itemView.findViewById<TextView>(R.id.txtRecycleTitr)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_items,parent,false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        /*holder.txtRecyclerView.text = when(position){
            0   ->  "test1"
            1   ->  "test2"
            2   ->  "test3"
            3   ->  "test4"
            4   ->  "test5"
            5   ->  "test6"
            6   ->  "test7"
            7   ->  "test8"
            8   ->  "test9"
            9   ->  "test10"
            else   ->  "test else"

         */



        holder.txtRecyclerView.text = mylist[position]

        }

    override fun getItemCount(): Int {
        return mylist.size
    }
}
