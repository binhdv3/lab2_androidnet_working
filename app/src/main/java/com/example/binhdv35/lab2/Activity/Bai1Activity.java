package com.example.binhdv35.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binhdv35.lab2.API.APIService;
import com.example.binhdv35.lab2.AsyncTask.AsyncTask_GET;
import com.example.binhdv35.lab2.R;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGet;
    private EditText edId, edName;
    private TextView tvResult;

    AsyncTask_GET asyncTask_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        initID();
        btnGet.setOnClickListener(this);
    }

    private void initID() {
        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        btnGet = findViewById(R.id.btn_get);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_get){
            asyncTask_get = new AsyncTask_GET(this,
                    APIService.student_get,
                    edId.getText().toString().trim(),
                    edName.getText().toString().trim(),
                    tvResult);
            asyncTask_get.execute();
//            Toast.makeText(this, "get", Toast.LENGTH_SHORT).show();
        }
    }
}