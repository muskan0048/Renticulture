package in.codecorp.renticulture.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.codecorp.renticulture.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyProductFragment extends Fragment {


    public BuyProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_buy_product, container, false);
        return v;
    }

}
