package com.example.dhivya.json_parsing;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                if (editText.getText().toString() != null) {
                    city  = editText.getText().toString();
                }
                secondAct(city);
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void secondAct(String city){

        Intent intent = new Intent(this,SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("city", city);
        intent.putExtras(bundle);
        startActivity(intent);
//        intent.putExtra("city", city);
    }

}


