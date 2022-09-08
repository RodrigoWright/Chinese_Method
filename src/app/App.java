package src.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.model.equacaoResto;

public class App {
    public static void main (String[] args){       
        List<equacaoResto> equacao = new ArrayList<equacaoResto>();
        int K = getIntInput("Quantas equações deseja inserir?");

        for (int i = 0; i < K; i++){
            equacaoResto tmp = new equacaoResto();
            tmp.setValues(
                getIntInput("Insira o valor de 'a' da equação " + (i+1)), 
                getIntInput("Insira o valor de 'b' da equação " + (i+1)), 
                getIntInput("Insira o valor de 'n' da equação " + (i+1))
                );
            equacao.add(tmp);   
        }

    }
    private static int getIntInput (String message){
        int x;
        String input = JOptionPane.showInputDialog(message);
        x = Integer.parseInt(input);

        return x;
    }
}