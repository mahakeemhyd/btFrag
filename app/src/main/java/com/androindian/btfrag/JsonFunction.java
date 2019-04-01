package com.androindian.btfrag;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonFunction {

    public  static JSONObject GettingData(String baseurl,
                                          String param){

        JSONObject jsonObject=null;
        try {
            URL jsonurl=new URL(baseurl);
            HttpURLConnection connection=
                    (HttpURLConnection) jsonurl.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(20000);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            OutputStream outputStream=
                    new BufferedOutputStream(connection.getOutputStream());
            outputStream.write(param.getBytes());
            outputStream.flush();

            InputStream inputStream=new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader=
                    new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer=new StringBuffer();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            inputStream.close();

            try {
                jsonObject =new JSONObject(stringBuffer.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonObject;

    }
}
