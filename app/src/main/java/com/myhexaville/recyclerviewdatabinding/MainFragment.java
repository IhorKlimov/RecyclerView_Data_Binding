package com.myhexaville.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myhexaville.recyclerviewdatabinding.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private static final String LOG_TAG = "MainFragment";

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_main, container, false);

        binding.recycler.setAdapter(new Adapter(getContext()));
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.setFragment(this);

        return binding.getRoot();
    }

    public void sayHello() {
        Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
    }

}
