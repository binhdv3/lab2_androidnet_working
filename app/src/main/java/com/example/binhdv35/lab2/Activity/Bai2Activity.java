package com.example.binhdv35.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binhdv35.lab2.API.APIService;
import com.example.binhdv35.lab2.AsyncTask_POST;
import com.example.binhdv35.lab2.R;

public class Bai2Activity extends AppCompatActivity {

    private EditText edDai, edRong;
    private Button btnSend;
    private TextView tvResult;

    private AsyncTask_POST asyncTask_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        initID();

        btnSend.setOnClickListener(v -> {
            asyncTask_post = new AsyncTask_POST(this,
                    APIService.rectangle_POST,
                    edDai.getText().toString().trim(),
                    edRong.getText().toString().trim(),
                    tvResult);
            asyncTask_post.execute();
        });

    }

    private void initID() {
        edDai = findViewById(R.id.ed_dai);
        edRong = findViewById(R.id.ed_rong);
        btnSend = findViewById(R.id.btn_send);
        tvResult = findViewById(R.id.tv_result_bai2);
    }
}