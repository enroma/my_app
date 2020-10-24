package ir.isiran.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        EditText username=findViewById(R.id.edtUser);
        EditText password=findViewById(R.id.edtPass);
        Button enter=findViewById(R.id.btnLogin);
        Button close=findViewById(R.id.btnClose);

        Toast.makeText(Login_activity.this,"Welcome to Android Class", Toast.LENGTH_LONG).show();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Login_activity.this,"Wrong Password!", Toast.LENGTH_LONG).show();

            }
        });



    }
}