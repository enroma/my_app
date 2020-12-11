package ir.isiran.weatherapp

import android.R.id
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*


class SQLiteHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int):SQLiteOpenHelper(context, name, factory, version) {
    val Table_Name="City"

    override fun onCreate(db: SQLiteDatabase?) {
        val Create_Table=("CREATE TABLE "+Table_Name+" ("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"name TEXT)")
        db?.execSQL(Create_Table)
    }

    fun addItem(context : Context,cityname: String) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name", cityname)
        val query = "SELECT * FROM " + Table_Name +" WHERE name = '" + cityname +"'"
        val cursor = database.rawQuery(query, null)
        if(cursor.moveToFirst())
        {
            val dialog = AlertDialog.Builder(context)
                    .setTitle("توجه")
                    .setMessage("شهر موردنظر قبلاً وارد شده است")
                    .setNeutralButton("باشه!"){
                        dialog,which ->
                    }.create()
            dialog.show()
        }
        else
        {
            val _success = database.insert(Table_Name, null, contentValues)
            if (_success == (0).toLong()) {
                Toast.makeText(context, "اضافه کردن شهر با مشکل روبرو شد!", Toast.LENGTH_SHORT).show()

            }
            else {
                Toast.makeText(context, "شهر موردنظر اضافه شد.", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun ReadData():  List<ElementItems>{
        val citylist = ArrayList<ElementItems>()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + Table_Name
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val Cityid = cursor.getString(cursor.getColumnIndex("_id")).toInt()
                val Cityname = cursor.getString(cursor.getColumnIndex("name"))
                val items=ElementItems(Cityname)
                citylist+=items
            }
            while (cursor.moveToNext())
        }
        return citylist
    }

    fun ReadDataItem(ID : Int):  List<ElementItems>{
        val citylist = ArrayList<ElementItems>()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + Table_Name + "WHERE _id = " + ID
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            val Cityid = cursor.getString(cursor.getColumnIndex("_id")).toInt()
            val Cityname = cursor.getString(cursor.getColumnIndex("name"))
            val items=ElementItems(Cityname)
            citylist.add(items)
        }
        return citylist
    }

    fun updateItem(cityname: String , citypreview: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("name", cityname)
        val _success = db.update(Table_Name, values, "name =?", arrayOf(cityname)).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun DeleteTable(){
        val Delete_Table="DELETE FROM "+Table_Name //+" WHERE _id LIKE '%"+position+"%'"
        val db=this.writableDatabase
        db.execSQL(Delete_Table)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
