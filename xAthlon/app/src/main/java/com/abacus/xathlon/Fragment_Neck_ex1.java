package com.abacus.xathlon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abacus.xathlon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Neck_ex1 extends Fragment {


    public Fragment_Neck_ex1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_neck_ex1, container, false);
        return view;
    }

}
