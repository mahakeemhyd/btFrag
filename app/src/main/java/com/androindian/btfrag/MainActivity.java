package com.androindian.btfrag;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button f1;
    String url = "http://businesstech.in/api/Statusonly.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = findViewById(R.id.bt1);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                TypeFrag frag=new TypeFrag();
                fragmentTransaction.addToBackStack("frag");
                fragmentTransaction.replace(R.id.frame,frag);
                fragmentTransaction.commit();
            }
        });


    }

}
