package ir.isiran.my_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import java.awt.font.TextAttribute

//class RecyclerAdapter(val mylist: ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
class RecyclerAdapter(val mylist: List<ElementItems>):RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {


        class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRecyclerTitr = itemView.findViewById<TextView>(R.id.txtRecycleTitr)
        val txtRecyclerDesc = itemView.findViewById<TextView>(R.id.txtRecycleText)
        val imgRecyclerImage = itemView.findViewById<ImageView>(R.id.imgRecycleLogo)
        val layout = itemView.findViewById<LinearLayout>(R.id.ItemLayout)
        init{
            layout.setOnClickListener(){
                val position = adapterPosition
                Toast.makeText(itemView.context, "Item number = "+position, Toast.LENGTH_LONG).show()
                val intent = Intent(itemView.context,MoreActivity::class.java)
                itemView.context.startActivity(intent)

            }

        }
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




      //  holder.txtRecyclerTitr.text = mylist[position]


        val currentItem = mylist[position]
        holder.txtRecyclerTitr.text = currentItem.title
        holder.txtRecyclerDesc.text = currentItem.desc
        holder.imgRecyclerImage.setImageResource(currentItem.img)
        }

    override fun getItemCount(): Int {
        return mylist.size
    }
}
