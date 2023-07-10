package com.example.binhdv35.lab2.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncTask_POST_Bai3 extends AsyncTask<String, Void, String> {

    private Context context;
    private String link, canh;
    private TextView tvReult;
    private String result = "";
    private ProgressDialog progressDialog;

    public AsyncTask_POST_Bai3(Context context, String link, String canh, TextView tvReult) {
        this.context = context;
        this.link = link;
        this.canh = canh;
        this.tvReult = tvReult;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(link);
            String param = "canh=" + URLEncoder.encode(canh, "utf-8");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setFixedLengthStreamingMode(param.getBytes().length);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printW = new PrintWriter(connection.getOutputStream());
            printW.print(param);
            printW.close();

            BufferedReader bfr = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line=bfr.readLine())!= null)
            {
                sb.append(line);
            }
            result = sb.toString();
            connection.disconnect(); //done

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPreExecute() { //doing
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) { //done
        super.onPostExecute(s);
        if (progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
        tvReult.setText(result);
    }
}
