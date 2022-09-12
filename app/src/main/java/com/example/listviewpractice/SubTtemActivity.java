package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubTtemActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_ttem);
        textView = findViewById(R.id.textView);
        // nhận intent

        Intent intent = getIntent();

        // lấy giữ liệu
        String nameItem = intent.getStringExtra("name");
        textView.setText(nameItem);
    }
}