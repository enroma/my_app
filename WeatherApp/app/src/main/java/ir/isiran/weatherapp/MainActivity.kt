package ir.isiran.weatherapp

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

public val API_ID = "c0dde6aa9a4d42ef9b24fdd525cf2452"
public var CityName = "تهران"
public var WeatherDesc = ""
public var WeatherIcon = ""
public var WeatherTemp = ""
public var MaghribResult = "--:--"
public var SunsetResult = "--:--"
public var MidnightResult = "--:--"

class MainActivity : AppCompatActivity() {
    public val database=SQLiteHelper(this,"CityDB",null,1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgMenu = findViewById<ImageView>(R.id.imgMenu)
        val btnCity = findViewById<Button>(R.id.btnCityOK)
        val btnClearList = findViewById<Button>(R.id.btnClearList)
        val imgRefresh = findViewById<ImageView>(R.id.imgRefresh)

        val drawer=findViewById<DrawerLayout>(R.id.drawer)

        RefreshList()

        // -------------------  Refresh City Name ----------------------
        imgRefresh.setOnClickListener(){
            RefreshList()
        }

        // -------------------  Drawer Open ----------------------
        imgMenu.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.END)
            RefreshList()
        })

        // -------------------  Clear List ----------------------
        btnClearList.setOnClickListener(){
            database.DeleteTable()
            RefreshList()
        }

        // -------------------  Add City ------------------------
        btnCity.setOnClickListener(){
            val edtCityname = findViewById<EditText>(R.id.edtCityname)
            val citypreview = "0"
            val cityname = edtCityname.text.toString()

            val ID = database.addItem(this,cityname)
            Toast.makeText(this, ID.toString(), Toast.LENGTH_SHORT).show()
            RefreshList()
            ClearText()
        }
    }



    fun RefreshList(){

        val recycleview = findViewById<RecyclerView>(R.id.RecycleViewCity)
        val adapter = CityListAdapter(database.ReadData())
        recycleview.adapter = adapter
        recycleview.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        recycleview.setHasFixedSize(true)

        val CityNamet = LoadData("City","Tehran")
        LoadCityWeatherAsync(CityNamet)

        val txtDay1 = findViewById<TextView>(R.id.txtDay1)
        txtDay1.text = LoadCityForecastWeatherAsync(CityNamet,0)


    }

    fun ClearText(){
        val edtCityname=findViewById<EditText>(R.id.edtCityname)
        edtCityname.setText("")
    }

    fun ChangeText(text : String){

    }

    fun LoadCityWeatherAsync(city : String){
        val client= AsyncHttpClient()
        val url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=c0dde6aa9a4d42ef9b24fdd525cf2452&lang=fa"
        client.get(url,object : JsonHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                super.onSuccess(statusCode, headers, response)
                val gson= Gson()
                val weather=gson.fromJson(response.toString(),WeatherJSON::class.java)

                WeatherDesc = weather.weather[0].description
                WeatherIcon = weather.weather[0].icon
                WeatherTemp = weather.main.temp.toString()

                val imgWeatherpic = findViewById<ImageView>(R.id.imgWeatherPic)
                val txtWeatherDesc = findViewById<TextView>(R.id.txtWeatherDesc)
                val txtWeatherTemp = findViewById<TextView>(R.id.txtWeatherTemp)
                val txtCityTitrName = findViewById<TextView>(R.id.txtCityTitrName)

                val img  = when(WeatherIcon){
                    "01d"   ->  R.drawable.pic01d
                    "01n"   ->  R.drawable.pic01n
                    "02d"   ->  R.drawable.pic02d
                    "02n"   ->  R.drawable.pic02n
                    "03d"   ->  R.drawable.pic03d
                    "03n"   ->  R.drawable.pic03n
                    "04d"   ->  R.drawable.pic04d
                    "04n"   ->  R.drawable.pic04n
                    "09d"   ->  R.drawable.pic09d
                    "09n"   ->  R.drawable.pic09n
                    "10d"   ->  R.drawable.pic10d
                    "10n"   ->  R.drawable.pic10n
                    "11d"   ->  R.drawable.pic11d
                    "11n"   ->  R.drawable.pic11n
                    "13d"   ->  R.drawable.pic13d
                    "13n"   ->  R.drawable.pic13n
                    "50d"   ->  R.drawable.pic50d
                    "50n"   ->  R.drawable.pic50n
                    else  ->  R.drawable.refresh_icon
                }

                imgWeatherpic.setImageResource(img)
                txtWeatherDesc.text = WeatherDesc
                txtWeatherTemp.text = ((WeatherTemp.toDouble() / 10).toShort()).toString() + " ^C"
                txtCityTitrName.text = CityName

            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                println(throwable?.message)
            }
        })
    }

    fun LoadCityForecastWeatherAsync(city : String,Index : Int) : String{
        var final_result :String =  "Null"
        Thread(Runnable {
            try{
                val url= URL("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=c0dde6aa9a4d42ef9b24fdd525cf2452&lang=fa")
                var con=url.openConnection() as HttpURLConnection
                con.requestMethod="GET"
                con.setRequestProperty("User-Agent","Mozilla/5.0")
                val requestCode=con.responseCode
                if(requestCode == HttpURLConnection.HTTP_OK){
                    val reader= BufferedReader(InputStreamReader(con.inputStream))
                    var line :String?
                    val responce=StringBuffer()
                    while (reader.readLine().also { line=it } != null){
                        responce.append(line)
                    }
                    val objec1=JSONObject(responce.toString())
                    val result1=objec1.getString("list")
                    val object2=JSONObject(result1.toString())
                    val result2=object2.getString("0")
                    val object3=JSONObject(result2.toString())
                    val result3=object3.getString("weather")
                    val object4=JSONObject(result3.toString())
                    val result4=object4.getString("0")
                    val object5=JSONObject(result4.toString())
                    val result5=object2.getString("description")
                    final_result = result5
                }

            }
            catch (e : Exception){
                e.printStackTrace()
            }

        }).start()

        return final_result
    }



    fun LoadData( Key :String ,  Default : String) : String {
        val result : String? = PreferenceManager.getDefaultSharedPreferences(this).getString(Key,Default)
        return result.toString()
    }


}
