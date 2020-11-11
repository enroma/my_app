package ir.isiran.dastyarman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter2(val mylist:ArrayList<String>):RecyclerView.Adapter<RecycleAdapter2.RecyclerViewHolder2>() {

    class RecyclerViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRecyclerView = itemView.findViewById<TextView>(R.id.txtRecycleTitr)

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
        holder.txtRecyclerView.text = mylist[position]
    }

}