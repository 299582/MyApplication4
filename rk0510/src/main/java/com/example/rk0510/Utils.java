package com.example.rk0510;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Utils extends AsyncTask<String,Void,String> {

    private IcallBack icallBack;

    public Utils(IcallBack icallBack) {
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
        icallBack.getJson(s);

    }

    public interface IcallBack{
        void getJson(String jsondata);
    }

    private String steamtoString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len;
        byte[] b = new byte[1024];
        while((len = inputStream.read(b))!= -1){
            outputStream.write(b,0,len);
        }
        return outputStream.toString();
    }

}
