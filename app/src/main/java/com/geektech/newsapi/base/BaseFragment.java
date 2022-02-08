package com.geektech.newsapi.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.geektech.newsapi.R;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    //region values
    protected VB viewBinding;
    protected abstract VB bind();
    protected NavController controller;
    //endregion

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.nav_host);
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initValues();
        setupViews();
        callRequests();
        setupListeners();
        setupObservers();
    }

    protected abstract void initValues();

    protected abstract void setupObservers();

    protected abstract void setupListeners();

    protected abstract void setupViews();

    protected abstract void callRequests();
}
