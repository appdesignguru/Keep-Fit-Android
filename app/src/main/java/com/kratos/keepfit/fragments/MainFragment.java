package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.kratos.keepfit.databinding.FragmentMainBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.allButton.setOnClickListener(buttonView -> {
            binding.keepFitMatchesButton.setEnabled(false);
        });
        binding.keepFitMatchesButton.setOnClickListener(buttonView -> {
            binding.allButton.setEnabled(false);
        });
        binding.signupButton.setOnClickListener(buttonView -> {
            NavDirections action = MainFragmentDirections
                    .actionMainFragmentToRegisterFragment();
            Navigation.findNavController(buttonView).navigate(action);
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}