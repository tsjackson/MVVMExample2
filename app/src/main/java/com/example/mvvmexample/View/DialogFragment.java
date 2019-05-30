package com.example.mvvmexample.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmexample.Model.ContractsPojo;
import com.example.mvvmexample.R;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_EMAIL = "email";
    private static final String ARG_ID = "id";
    private static final String ARG_ADDRESS = "address";
    private static final String ARG_GENDER = "gender";
    private static final String ARG_MOBILE = "mobile";
    private static final String ARG_HOME = "home";
    private static final String ARG_OFFICE = "office";

    // TODO: Rename and change types of parameters
    private TextView id;
    private TextView name;
    private TextView email;
    private TextView address;
    private TextView gender;
    private TextView mobile;
    private TextView home;
    private TextView office;

    public DialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name  Parameter 1.
     * @param email Parameter 2.
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogFragment newInstance(ContractsPojo contractsPojo) {
        DialogFragment fragment = new DialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, contractsPojo.name);
        args.putString(ARG_EMAIL, contractsPojo.email);
        args.putString(ARG_ID, contractsPojo.id);
        args.putString(ARG_ADDRESS, contractsPojo.address);
        args.putString(ARG_GENDER, contractsPojo.gender);
        args.putString(ARG_MOBILE, contractsPojo.phone.mobile);
        args.putString(ARG_HOME, contractsPojo.phone.home);
        args.putString(ARG_OFFICE, contractsPojo.phone.office);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //todo get all text views and populate
        if (getArguments() != null) {

            name = view.findViewById(R.id.tv_fragmentName);
            id = view.findViewById(R.id.tv_id);
            email = view.findViewById(R.id.tv_fragmentEmail);
            address = view.findViewById(R.id.tv_address);
            gender = view.findViewById(R.id.gender);
            mobile = view.findViewById(R.id.mobile);
            home = view.findViewById(R.id.fragmentHome);
            office = view.findViewById(R.id.tv_office);

            name.setText(getArguments().getString(ARG_NAME));
            email.setText(getArguments().getString(ARG_EMAIL));
            id.setText(getArguments().getString(ARG_ID));
            address.setText(getArguments().getString(ARG_ADDRESS));
            gender.setText(getArguments().getString(ARG_GENDER));
            mobile.setText(getArguments().getString(ARG_MOBILE));
            home.setText(getArguments().getString(ARG_HOME));
            office.setText(getArguments().getString(ARG_OFFICE));
        }
    }
}
