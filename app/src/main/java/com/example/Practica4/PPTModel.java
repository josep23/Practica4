package com.example.Practica4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PPTModel extends AndroidViewModel {

    Executor executor;

    Ppt ppt;

    static MutableLiveData<String> resultadoLiveData = new MutableLiveData<>();
    static MutableLiveData<Boolean> player1LiveData = new MutableLiveData<>();
    static MutableLiveData<Boolean> player2LiveData = new MutableLiveData<>();

    public PPTModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        ppt = new Ppt();
    }

    public void resultado(final String player1, final String player2) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                ppt.resultado(player1, player2, new Ppt.callback() {


                    @Override
                    public void resultado(String resultado) {
                        resultadoLiveData.postValue(resultado);
                    }

                    @Override
                    public void Error(int player) {
                        if(player == 1){
                            player1LiveData.postValue(true);
                        }
                        else if (player == 2){
                            player2LiveData.postValue(true);
                        }
                    }
                });
            }
        });
    }
}
