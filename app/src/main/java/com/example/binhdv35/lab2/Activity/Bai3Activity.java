package com.example.binhdv35.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binhdv35.lab2.API.APIService;
import com.example.binhdv35.lab2.AsyncTask.AsyncTask_POST_Bai3;
import com.example.binhdv35.lab2.R;

public class Bai3Activity extends AppCompatActivity {

    private EditText edCanh;
    private Button btnSend;
    private TextView tvResult;

    private AsyncTask_POST_Bai3 asyncTaskPostBai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        edCanh = findViewById(R.id.ed_canh);
        btnSend = findViewById(R.id.btn_send_bai3);
        tvResult = findViewById(R.id.tv_result_bai3);

        btnSend.setOnClickListener(v -> {
            asyncTaskPostBai3 = new AsyncTask_POST_Bai3(
                    this,
                    APIService.rectangler_volume_POST,
                    edCanh.getText().toString().trim(),
                    tvResult
            );

            asyncTaskPostBai3.execute();
        });
    }
}