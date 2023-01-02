package com.example.notio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.notio.databinding.ActivityMainBinding;
import com.example.notio.ui.messange.MessageFragment;
import com.example.notio.ui.prof.ProfFragment;
import com.example.notio.ui.main.ReelsFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FragmentTransaction transaction;
    BottomNavigationView navigationView;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //may get problems
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navigationView = binding.nav;
        toolbar = binding.toolbar;

        //обработчик нажатий работает, осталось понять почему не переключаются фрагменты и горит первая иконка!

        navigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.reels:
                    startFrag(0);
                    break;
                case R.id.mess:
                    startFrag(1);
                    break;
                case R.id.prof:
                    startFrag(2);
                    break;
            }
            return false;
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    private void startFrag(int NUM_FRAGMENT) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, getFragment(NUM_FRAGMENT));
        toolbar.setTitle(getTitle(NUM_FRAGMENT));
    }

    private int getTitle(int num_fragment) {
        return R.string.app_name;
    }

    private Fragment getFragment(int num_fragment){
        switch (num_fragment){
            case 0:
                return new ReelsFragment();
            case 1:
                return new MessageFragment();
            case 2:
                return new ProfFragment();
            default:
                return new Fragment();
        }
    }

}