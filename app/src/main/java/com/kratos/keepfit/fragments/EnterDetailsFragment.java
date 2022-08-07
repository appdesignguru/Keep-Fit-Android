package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentEnterDetailsBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class EnterDetailsFragment extends Fragment {

    private FragmentEnterDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEnterDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.confirmDetailsButton.setOnClickListener(buttonView ->
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_activity_fragment_container_view,
                                HomeFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)  // name can be null
                        .commit()
        );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
