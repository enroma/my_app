package ir.isiran.my_app

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context? , name : String? , factory : SQLiteDatabase.CursorFactory? , version : Int) : SQLiteOpenHelper(context,name,factory,version) {
    val Table_Name = "Students"
    override fun onCreate(db: SQLiteDatabase?) {
        val Create_Table = ("CREATE TABLE " + Table_Name + " ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT."
                + "name TEXT,"
                + "family TEXT"
                + "code INTEGER")
        db?.execSQL(Create_Table)
    }

    fun InsertData(name: String, family : String, code : Int){
        val Insert_Table = "INSERT INTO "+Table_Name+" (name,family,code) VALUES ('" + name + "','" + family + "'," + code + ")"
        val db = this.writableDatabase
        db.execSQL(Insert_Table)
        db.close()
    }

    fun ReadTable():String{
        val Read_Table = "SELECT name FROM" + Table_Name
        var result = ""
        val db= this.readableDatabase
        val data:Cursor=db.rawQuery(Read_Table,null)
        while (data.moveToNext()){
            result+=result+data.getString(0)+"\n"
        }
        return result
    }

    fun DeleteTable(name : String){
        val Delete_Table="DELETE FROM "+Table_Name+" WHERE name LIKE '%"+name+"%'"
        val db=this.writableDatabase
        db.execSQL(Delete_Table)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}

