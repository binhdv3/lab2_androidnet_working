package com.example.binhdv35.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binhdv35.lab2.API.APIService;
import com.example.binhdv35.lab2.AsyncTask.AsyncTask_POST_Bai4;
import com.example.binhdv35.lab2.R;

public class Bai4Activity extends AppCompatActivity {

    private EditText a,b,c;
    private Button btnSend;
    private TextView tvResult;

    private AsyncTask_POST_Bai4 asyncTaskPostBai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        a = findViewById(R.id.ed_a);
        b = findViewById(R.id.ed_b);
        c = findViewById(R.id.ed_c);
        btnSend = findViewById(R.id.btn_send_bai4);
        tvResult = findViewById(R.id.tv_result_bai4);

        btnSend.setOnClickListener(v -> {
            asyncTaskPostBai4 = new AsyncTask_POST_Bai4(
                    this,
                    APIService.ptb2_POST,
                    a.getText().toString().trim(),b.getText().toString().trim(),c.getText().toString().trim(),
                    tvResult
            );
            asyncTaskPostBai4.execute();
        });
    }
}