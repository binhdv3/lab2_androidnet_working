package com.example.binhdv35.lab2.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTask_GET extends AsyncTask<String, Void, String> {

    private Context context;
    private String link, id, name;
    private TextView tvReult;
    private String result = "";
    private ProgressDialog progressDialog;

    public AsyncTask_GET(Context context, String link, String id, String name, TextView tvReult) {
        this.context = context;
        this.link = link;
        this.id = id;
        this.name = name;
        this.tvReult = tvReult;
    }

    @Override
    protected String doInBackground(String... strings) {
        link += "?id="+id+"&name="+name;
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
