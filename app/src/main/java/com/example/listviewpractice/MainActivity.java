package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    ArrayList<String> arrayList;
    Button btnThem, btnCapNhat ;
    EditText editText;
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        arrayList = new ArrayList<>();
        arrayList.add("mon_1");
        arrayList.add("mon_2");
        arrayList.add("mon_3");
        arrayList.add("mon_4");
        arrayList.add("mon_5");
        arrayList.add("mon_6");
        arrayList.add("mon_7");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dish = editText.getText().toString();

                arrayList.add(dish);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(arrayList.get(i));
                index = i;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(index,editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,SubTtemActivity.class);
                intent.putExtra("name",arrayList.get(i));
                startActivity(intent);
                return false;

            }
        });
    }
    public void Anhxa(){
        btnCapNhat = findViewById(R.id.BtnUpdate);
        btnThem = findViewById(R.id.BtnAddDish);
        editText = findViewById(R.id.editText);
        listView  = findViewById(R.id.listView);
    }


}