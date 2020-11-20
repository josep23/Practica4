package com.example.Practica4;


public class Ppt {

    interface callback {
        void resultado(String resultado);
        void Error(int player);
    }

    void resultado(String player1, String player2, callback callback){

        if (!player1.equals("Piedra") && !player1.equals("Papel") && !player1.equals("Tijeras")){
            callback.Error(1);
        }
        if (!player2.equals("Piedra") && !player2.equals("Papel") && !player2.equals("Tijeras")){
            callback.Error(2);
        }
        String resultado = "";

        if (player2.equals("Papel")) {
            if (player1.equals("Papel")) {
                resultado = "Draw";
            } else if (player1.equals("Tijeras")) {
                resultado = "player 1 win";
            } else if (player1.equals("Piedra")) {
                resultado = "player 2 win";
            }
        }
        if (player2.equals("Tijeras")) {
            if (player1.equals("Papel")) {
                resultado = "player 2 win";
            }
            if (player1.equals("Tijeras")) {
                resultado = "Draw";
            }
            if (player1.equals("Piedra")) {
                resultado = "player 1 win";
            }
        }
        if (player2.equals("Piedra")) {
            if (player1.equals("Papel")) {
                resultado = "player 1 win";
            }
            if (player1.equals("Tijeras")) {
                resultado = "player 2 win";
            }
            if (player1.equals("Piedra")) {
                resultado = "draw";
            }
        }

        callback.resultado(resultado);
    }
}
