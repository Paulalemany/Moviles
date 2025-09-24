package com.example.cuacapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "MiCuacApp"; // Etiqueta para Logcat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart llamado");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart llamado");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume llamado");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause llamado");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop llamado");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy llamado");
    }

}