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
public class Fragment_Arms_ex2 extends Fragment {


    public Fragment_Arms_ex2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_arms_ex2, container, false);
        return  view;
    }

}
