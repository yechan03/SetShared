package com.example.hashmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    Set<String> set = new HashSet<String>();
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.BT);
        textView = findViewById(R.id.text);

        set.add("사나이");
        set.add("이예찬");

        SharedPreferences pref = getSharedPreferences("사나이 이예찬",MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        editor.putStringSet("애송이 윤원우",set);
        editor.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref1 = getSharedPreferences("사나이 이예찬", MODE_PRIVATE);
                Set<String> fetch = pref1.getStringSet("애송이 윤원우",null);
                List<String> list = new ArrayList<String>(fetch);

                for(int i = 0 ; i < list.size() ; i++){
                    text += list.get(i);
                }
                textView.setText(text);
            }
        });





    }
}