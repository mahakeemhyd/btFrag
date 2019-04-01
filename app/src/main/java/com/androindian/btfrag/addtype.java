package com.androindian.btfrag;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class addtype extends AppCompatActivity {

    Button Registertype;
    EditText type;
String ur1="http://businesstech.in/api/typeonly.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtype);


        type=findViewById(R.id.type);
        Registertype=findViewById(R.id.btnType);
        Registertype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("type",type.getText().toString().trim());
                    jsonObject.put("baction","register_user");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //2
                RegsiterUser regsiterUser=new RegsiterUser();
                regsiterUser.execute(jsonObject.toString());

            }
        });


    }

    private class RegsiterUser extends AsyncTask<String,String,String> {
        //5

        ProgressDialog progressDialog=new ProgressDialog(addtype.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //8

            progressDialog.setMessage("Please wait");
            progressDialog.setTitle("Content Loading");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        //4
        @Override
        protected String doInBackground(String... param) {
            JSONObject object=JsonFunction.GettingData(ur1,param[0]);
            Log.i("Result",object.toString());
            return object.toString();
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //9
            progressDialog.dismiss();

            try {
                JSONObject j1=new JSONObject(s.toString());

                String res1=j1.getString("response");

                if(res1.equalsIgnoreCase("success")){
                    String res2=j1.getString("user");
                    Toast.makeText(addtype.this, ""+res2, Toast.LENGTH_SHORT).show();

                }else if(res1.equalsIgnoreCase("failed")){
                    String res2=j1.getString("user");
                    Toast.makeText(addtype.this, ""+res2, Toast.LENGTH_SHORT).show();

                }else {
                    String res2=j1.getString("user");
                    Toast.makeText(addtype.this, ""+res2, Toast.LENGTH_SHORT).show();

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}

