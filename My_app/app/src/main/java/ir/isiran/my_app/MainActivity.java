package ir.isiran.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mytag", "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mytag", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("mytag", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mytag", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mytag", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mytag", "onStop");
    }
}

