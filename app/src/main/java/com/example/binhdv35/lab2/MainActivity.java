package com.example.binhdv35.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binhdv35.lab2.Activity.Bai1Activity;
import com.example.binhdv35.lab2.Activity.Bai2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBai1, btnBai2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        initID();
        btnBai1.setOnClickListener(this);
        btnBai2.setOnClickListener(this);
    }

    private void initID() {
        btnBai1 = findViewById(R.id.btn_bai1);
        btnBai2 = findViewById(R.id.btn_bai2);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_bai1){
            intent = new Intent(this, Bai1Activity.class);
            startActivity(intent);
        }else if (id == R.id.btn_bai2) {
            intent = new Intent(MainActivity.this, Bai2Activity.class);
            startActivity(intent);
        }
    }
}