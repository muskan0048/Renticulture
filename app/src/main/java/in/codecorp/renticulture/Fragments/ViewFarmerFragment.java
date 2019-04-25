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
public class ViewFarmerFragment extends Fragment {


    public ViewFarmerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_farmer, container, false);
    }

}
