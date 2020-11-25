package ir.isiran.dastyarman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

public var FajrResult = "--:--"
public var SunriseResult = "--:--"
public var DhuhrResult = "--:--"
public var MaghribResult = "--:--"
public var SunsetResult = "--:--"
public var MidnightResult = "--:--"


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
            val city  =  edtCityname.text.toString()
            LoadPrayTimeAsync(city)
            txtFajr.text     = FajrResult + "    :    اذان صبح"
            txtSunrise.text  = SunriseResult + "   :    طلوع آفتاب"
            txtDhuhr.text    = DhuhrResult + "   :    اذان ظهر"
            txtMaghrib.text  = MaghribResult + "   :    اذان مغرب"
            txtSunset.text   = SunsetResult + "   :    غروب آفتاب"
            txtMidnight.text = MidnightResult + "   :    نیمه شب"
        }
    }
/*
    fun LoadPrayTime(city : String,PrayTime : String) : String{
        var final_result :String =  "--:--"
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

 */


    fun LoadPrayTimeAsync(city : String){

        val client=AsyncHttpClient()
        val url="http://api.aladhan.com/v1/timingsByCity?city=" + city + "&country=Iran&method=8"
        client.get(url,object :JsonHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                super.onSuccess(statusCode, headers, response)
                val gson=Gson()
                val pray=gson.fromJson(response.toString(),PrayJson::class.java)
                
                FajrResult      = pray.data.timings.Fajr
                SunriseResult   = pray.data.timings.Sunrise
                DhuhrResult     = pray.data.timings.Dhuhr
                MaghribResult   = pray.data.timings.Maghrib
                SunsetResult    = pray.data.timings.Sunset
                MidnightResult  = pray.data.timings.Midnight
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                println(throwable?.message)
            }
        })
    }
}