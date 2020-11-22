package ir.isiran.my_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SQLite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtFamily = findViewById<EditText>(R.id.edtFamily)
        val edtCode = findViewById<EditText>(R.id.edtCode)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnRead = findViewById<Button>(R.id.btnRead)

        val database = SQLiteHelper(this,"IsiranDB", null,1)

        btnSave.setOnClickListener(){
            database.InsertData(edtName.text.toString(),edtFamily.text.toString(),edtCode.text.toString().toInt())
            Toast.makeText(this,"Saved data in Database",Toast.LENGTH_LONG).show()
        }

        btnRead.setOnClickListener {
            val result=database.ReadTable()
            Toast.makeText(this,result,Toast.LENGTH_LONG).show()
        }

        btnDelete.setOnClickListener {
            database.DeleteTable(edtName.text.toString())
            Toast.makeText(this,"Delete data from Database",Toast.LENGTH_LONG).show()
        }


    }
}