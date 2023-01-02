package com.example.notio.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notio.databinding.FragmentLoginBinding;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    TextInputEditText login;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        login = binding.login;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
