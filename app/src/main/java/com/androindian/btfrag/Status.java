package com.androindian.btfrag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Status  extends Fragment {
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.status,container,false);


        button=view.findViewById(R.id.bt2);

        button.setOnClickListener(new View.OnClickListener() {
            class Secondfrag extends Fragment {
            }

            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                Secondfrag secondfrag=new Secondfrag();
                fragmentTransaction.addToBackStack("secondfrag");
                fragmentTransaction.replace(R.id.frame,secondfrag);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}
