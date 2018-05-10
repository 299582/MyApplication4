package com.example.caixiao0504yk.Utils;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mac on 2018/5/4.
 */

public class MyTast extends AsyncTask<String,Void,String> {
    private IcallBack icallBack;

    public MyTast(IcallBack icallBack) {
        this.icallBack = icallBack;
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            if(urlConnection.getResponseCode() == 200){
                InputStream inputStream = urlConnection.getInputStream();
                String s = steamtoString(inputStream);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        icallBack.getjson(s);
    }

    public interface IcallBack{
        void getjson(String jsondata);
    }

    private String steamtoString(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len;
        byte[] b = new byte[1024];
        try {
            while((len = inputStream.read(b))!= -1){
                outputStream.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }
}
