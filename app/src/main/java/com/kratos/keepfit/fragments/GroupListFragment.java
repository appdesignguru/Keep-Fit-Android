package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.GroupAdapter;
import com.kratos.keepfit.entities.Group;
import com.kratos.keepfit.databinding.FragmentGroupListBinding;
import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class GroupListFragment extends Fragment {

    private FragmentGroupListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGroupListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String uri1 = "@drawable/_km_run";
        String uri2 = "@drawable/core_fitness";
        String uri3 = "@drawable/swim_class";
        String uri4 = "@drawable/tennis_group";
        List<String> uris = new ArrayList<>();
        uris.add(uri1);
        uris.add(uri2);
        uris.add(uri3);
        uris.add(uri4);

        List<String> names = new ArrayList<>();
        names.add("5km run");
        names.add("Core Fitness");
        names.add("Swim Class");
        names.add("Tennis Group");

        List<Group> groups = new ArrayList<>();

        int i = 0;
        while (i < 4){
            int imageResource = getResources().getIdentifier(uris.get(i), null, requireActivity().getPackageName());
            groups.add(new Group(i, imageResource, names.get(i), "Awaiting Confirmation", "At 10:00AM"));
            ++i;
        }
        //updateUI(groups);
        updateUI(new ArrayList<>());
    }

    private void updateUI(List<Group> groups){
        if (groups.isEmpty()) {
            binding.recyclerView.setVisibility(View.GONE);
            binding.noGroupsTextView.setVisibility(View.VISIBLE);
        }
        else {
            binding.recyclerView.setVisibility(View.VISIBLE);
            binding.noGroupsTextView.setVisibility(View.GONE);
        }
        GroupAdapter groupAdapter = new GroupAdapter(groups);
        binding.recyclerView.setAdapter(groupAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}