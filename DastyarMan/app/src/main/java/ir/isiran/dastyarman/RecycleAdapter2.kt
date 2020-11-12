package ir.isiran.dastyarman

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter2(val mylist:List<ElementItems>):RecyclerView.Adapter<RecycleAdapter2.RecyclerViewHolder2>() {

    class RecyclerViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRecyclerTitr = itemView.findViewById<TextView>(R.id.txtRecycleTitr)
        val txtRecyclerDesc = itemView.findViewById<TextView>(R.id.txtRecycleDesc)
        val imgRecyclerImage = itemView.findViewById<ImageView>(R.id.imgRecycleLogo)
        val layout = itemView.findViewById<LinearLayout>(R.id.ItemLayout)
        init {
            layout.setOnClickListener() {
                val position = adapterPosition
                Toast.makeText(itemView.context, "Item number = " + position, Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(itemView.context, Detail::class.java)
                itemView.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleviewitems,parent,false)
        val holder = RecyclerViewHolder2(view)
        return holder
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder2, position: Int) {
        val currentItem = mylist[position]
        holder.txtRecyclerTitr.text = currentItem.title
        holder.txtRecyclerDesc.text = currentItem.desc
        holder.imgRecyclerImage.setImageResource(currentItem.img)
    }

}