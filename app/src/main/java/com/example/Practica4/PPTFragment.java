package com.example.Practica4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.Practica4.databinding.FragmentPptBinding;

public class PPTFragment extends Fragment {
    private FragmentPptBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPptBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PPTModel pptModel = new ViewModelProvider(this).get(PPTModel.class);

        binding.resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    pptModel.resultado(binding.player1.getText().toString(), binding.player2.getText().toString());
            }
        });

        PPTModel.resultadoLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.resultado.setText(s);
            }
        });

        PPTModel.player1LiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean resultado) {
                binding.player1.setError("LAS PALABRAS SON  Piedra, Papel o Tijeras");
            }

        });

        PPTModel.player2LiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean s) {
                binding.player2.setError("LAS PALABRAS SON Piedra, Papel o Tijeras");
            }
        });

    }


}

