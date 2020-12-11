package ir.isiran.weatherapp

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.system.Os
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import kotlin.coroutines.coroutineContext
import kotlin.system.exitProcess

class CityListAdapter(val cityList : List<ElementItems>): RecyclerView.Adapter<CityListAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCityName = itemView.findViewById<TextView>(R.id.txtCityname)
        val imgCitypreview = itemView.findViewById<ImageView>(R.id.imgWeatherCity)

        val result : String? = PreferenceManager.getDefaultSharedPreferences(itemView.context).getString("City","Null")
        
        init {
            //imgCitypreview.setImageResource(R.drawable.refresh_icon)

            txtCityName.setOnClickListener() {
                val position = adapterPosition
                Toast.makeText(itemView.context, "شهر " + txtCityName.text.toString() + " انتخاب شد، صفحه را بروزرسانی کنید.", Toast.LENGTH_SHORT)
                        .show()
                val prefrences = PreferenceManager.getDefaultSharedPreferences(itemView.context).edit().putString("City", txtCityName.text.toString()).apply()

                CityName= txtCityName.text.toString()
            }

            imgCitypreview.setOnClickListener() {
                val position = adapterPosition
             //   Toast.makeText(itemView.context, "Item Deleted = " + position, Toast.LENGTH_SHORT)
             //           .show()
                //val intent = Intent(itemView.context, Detail::class.java)
                //itemView.context.startActivity(intent)

            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cityslidename,parent,false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = cityList[position]
        holder.txtCityName.text = currentItem.CityName
    }

    override fun getItemCount(): Int {
        return cityList.size
    }




}