package ir.isiran.dastyarman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter1(val mylist:ArrayList<String>):RecyclerView.Adapter<RecycleAdapter1.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRecyclerView = itemView.findViewById<TextView>(R.id.txtRecycleTitr)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleviewitems,parent,false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.txtRecyclerView.text = mylist[position]
    }

}