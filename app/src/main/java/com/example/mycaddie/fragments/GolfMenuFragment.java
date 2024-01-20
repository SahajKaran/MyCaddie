package com.example.mycaddie.fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mycaddie.R;
import com.example.mycaddie.databinding.FragmentGolfMenuBinding; // Update this import

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class GolfMenuFragment extends Fragment {

    private GolfMenuViewModel mViewModel;
    FragmentGolfMenuBinding binding;
    NavController navController;

    public static GolfMenuFragment newInstance() {
        return new GolfMenuFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GolfMenuViewModel.class);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentGolfMenuBinding.inflate(inflater,container,false);
        navController = NavHostFragment.findNavController(this);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpToolbar();
        setUpButtons();
    }

    private void setUpButtons() {
        binding.startImg.setOnClickListener(view -> {moveToStartRound();});
        binding.startTxt.setOnClickListener(view -> {moveToStartRound();});
    }

    private void moveToStartRound() {
        navController.navigate(R.id.action_golfMenuFragment_to_StartRoundFragment);
    }

    private void setUpToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(binding.toolbar);

            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }

            // Set Toolbar navigation click listener
            binding.toolbar.setNavigationOnClickListener(v -> navController.navigateUp());
        }
    }

}