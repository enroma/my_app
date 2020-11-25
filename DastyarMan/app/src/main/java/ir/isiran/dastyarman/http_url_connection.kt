package ir.isiran.dastyarman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class http_url_connection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_url_connection)
        val txtFajr = findViewById<TextView>(R.id.txtFajr)
        val txtSunrise = findViewById<TextView>(R.id.txtSunrise)
        val txtDhuhr = findViewById<TextView>(R.id.txtDhuhr)
        val txtMaghrib = findViewById<TextView>(R.id.txtMaghrib)
        val txtSunset = findViewById<TextView>(R.id.txtSunset)
        val txtMidnight = findViewById<TextView>(R.id.txtMidnight)

        val edtCityname = findViewById<EditText>(R.id.edtCityname)

        val btnSearch = findViewById<ImageButton>(R.id.btnSearch)


        btnSearch.setOnClickListener(){
            val city =  edtCityname.text.toString()
            txtFajr.text = "    :    اذان صبح" + LoadPrayTime(city,"Fajr")
            txtSunrise.text = "   :    طلوع آفتاب" + LoadPrayTime(city,"Sunrise")
            txtDhuhr.text = "   :    اذان ظهر" + LoadPrayTime(city,"Dhuhr")
            txtMaghrib.text = "   :    اذان مغرب" + LoadPrayTime(city,"Maghrib")
            txtSunset.text = "   :    غروب آفتاب" + LoadPrayTime(city,"Sunset")
            txtMidnight.text = "   :    نیمه شب" + LoadPrayTime(city,"Midnight")
        }
    }

    fun LoadPrayTime(city : String,PrayTime : String) : String{

        var final_result = "Null"

        Thread(Runnable {
            try{
                val url=URL("https://api.aladhan.com/v1/timingsByCity?city="+ city +"&country=Iran&method=8")
                var con=url.openConnection() as HttpURLConnection
                con.requestMethod="GET"
                con.setRequestProperty("User-Agent","Mozilla/5.0")
                val requestCode=con.responseCode
                if(requestCode == HttpURLConnection.HTTP_OK){
                    val reader=BufferedReader(InputStreamReader(con.inputStream))
                    var line :String?
                    val responce=StringBuffer()
                    while (reader.readLine().also { line=it } != null){
                        responce.append(line)
                    }
                    val objec1=JSONObject(responce.toString())
                    val result1=objec1.getString("data")
                    val object2=JSONObject(result1.toString())
                    val result2=object2.getString("timings")
                    val object3=JSONObject(result2.toString())
                    val result3=object3.getString(PrayTime)
                    final_result = result3
                }

            }
            catch (e : Exception){
                e.printStackTrace()
            }

        }).start()

        return final_result


    }
}