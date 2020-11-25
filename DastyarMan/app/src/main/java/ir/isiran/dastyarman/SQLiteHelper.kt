package ir.isiran.dastyarman

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context : Context? , name : String? , factory : SQLiteDatabase.CursorFactory?, version : Int):SQLiteOpenHelper(context,name,factory,version) {
    val Table_Name="Profile"

    override fun onCreate(db: SQLiteDatabase?) {
        val Create_Table=("CREATE TABLE "+Table_Name+" ("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"name TEXT,"
                +"number TEXT,"
                +"education TEXT,"
                +"work TEXT,"
                +"age TEXT,"
                +"mobile TEXT,"
                +"email TEXT)")
        db?.execSQL(Create_Table)
    }

    fun InsertData(name : String,number: String,education : String,work : String,age : String,mobile : String, email : String){
        val Insert_Table=("INSERT INTO "+Table_Name+" (name,number,education,work,age,mobile,email) VALUES ('"
                                +name+"','"
                                +number+"','"
                                +education+"','"
                                +work+"','"
                                +age+"','"
                                +mobile+"','"
                                +email+"')")
        val db=this.writableDatabase
        db.execSQL(Insert_Table)
        db.close()
    }

    fun ReadTable(key : String) : String{
        val Read_Table="SELECT DISTINCT "+ key + " FROM " + Table_Name
        var result=""
        val db=this.readableDatabase
        val data:Cursor=db.rawQuery(Read_Table,null)

        while (data.moveToNext()){
            result+=result+data.getString(0)+"\n"
        }
        return result

    }

    fun DeleteTable(key : String,value :String){
        val Delete_Table="DELETE FROM "+Table_Name+" WHERE " + key + " LIKE '%"+value+"%'"
        val db=this.writableDatabase
        db.execSQL(Delete_Table)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}
