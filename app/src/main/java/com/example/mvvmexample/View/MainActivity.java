package com.example.mvvmexample.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmexample.Model.ContractsPojo;
import com.example.mvvmexample.Model.PhonePojoResult;
import com.example.mvvmexample.R;

public class MainActivity extends AppCompatActivity implements CustomAdapter.Listener{

    private static final String TAG = "MainActivity";
    CustomViewModel customViewModel;
    CustomAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        customViewModel = ViewModelProviders.of(this)
                .get(CustomViewModel.class);

//        customViewModel.initRetrofit().observe(
//                this,
//                pojo -> {
//                    //adapter.setAdapter
//                }
//        );
        customViewModel.initRetrofit().observe(this,
                this::getResult);
    }

    private void getResult(PhonePojoResult phonePojoResult) {
        adapter.setDataSet(phonePojoResult);
    }

    @Override
    public void onClick(ContractsPojo contractsPojo) {
        showDialogFragment(contractsPojo);
    }

    private void showDialogFragment(ContractsPojo contractsPojo) {
        Log.d(TAG, "showDialogFragment: ");
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment dialogFragment = DialogFragment.newInstance(contractsPojo);
        dialogFragment.show(getSupportFragmentManager(), "dialog");

    }
}
