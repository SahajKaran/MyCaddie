package com.example.mycaddie.ui;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycaddie.R;
import com.example.mycaddie.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    public Context context;
    private MainViewModel mViewModel;
    NavController navController;
    FragmentMainBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater,container,false);
        navController = NavHostFragment.findNavController(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpButtons();

    }

    private void setUpButtons() {
        binding.golfImg.setOnClickListener(v -> {
            moveToGolfMenu();
        });
        binding.golfTxt.setOnClickListener(v -> {
            moveToGolfMenu();
        });
    }

    private void moveToGolfMenu() {
        navController.navigate(R.id.action_mainFragment_to_golfMenuFragment);
    }

}