package src.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.error.MDCnot1NException;
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
        validateMDCN(equacao);

    }
    private static int getIntInput (String message){
        int x;
        String input = JOptionPane.showInputDialog(message);
        x = Integer.parseInt(input);

        return x;
    }
    public static void validateMDCN(List<equacaoResto> objectList){
        //Via método dos primos
        int primos[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        for (equacaoResto verification : objectList){
            for (equacaoResto validate: objectList){
                if (verification == validate){
                    break;
                }
                if (verification.getn() % validate.getn() == 0 || validate.getn() % verification.getn() == 0){
                    System.out.println("falhou no teste entre eles: " + verification.getn() + "; " + validate.getn());
                    throw new MDCnot1NException();
                }
                for (int i = 0; i < primos.length; i++){
                    if (verification.getn() % primos[i] == 0 && validate.getn() % primos[i] == 0){
                        System.out.println("falhou no teste dos primos: " + primos[i]);
                        throw new MDCnot1NException();
                    }
                    if (verification.getn() < verification.getn()){
                        if (primos[i] > Math.sqrt(verification.getn())){
                            break;
                        }
                    } else if(primos[i] > Math.sqrt(verification.getn()/2)){
                        break;
                    }
                }
            }
        }
    }
}