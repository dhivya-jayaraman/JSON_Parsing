package com.example.dhivya.json_parsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {
    public String val = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = (TextView) findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        String city = bundle.getString("city");
        String url = generateURL(city);

        JSONParser parser = new JSONParser();
        JSONObject toParse = parser.doInBackground(url);
        try {
            JSONObject main = toParse.getJSONObject("main");
            val = main.getString("temp");
            Log.e("temp",val);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textView.setText(val);
    }



    private  String generateURL(String city){
        String first = "http://api.openweathermap.org/data/2.5/weather?q=";
        String second = "&appid=75267c738ff61efb01235a91ef64a154&units=metric";
        String url = first + city + second;
        return url;
    }

}
