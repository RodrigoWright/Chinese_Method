package src.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.error.MDCnot1NException;
import src.error.MDCnot1anException;
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
        validateMDCan(equacao);

        equacao = setX(equacao);

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
                int verificationN = verification.getn();
                int validateN = validate.getn();

                if (validateN == verificationN || validateN == 1 || verificationN == 1){
                    break;
                }
                if (verificationN % validateN == 0 || validateN % verificationN == 0){
                    System.out.println("falhou no teste entre eles: " + verificationN + "; " + validateN);
                    throw new MDCnot1NException(verificationN, validateN);
                }
                for (int i = 0; i < primos.length; i++){
                    if (verificationN % primos[i] == 0 && validateN % primos[i] == 0){
                        System.out.println("falhou no teste dos primos: " + primos[i]);
                        throw new MDCnot1NException(primos[i], primos[i]);
                    }
                    //só precisa verificar até a raiz do menor número;
                    if (verificationN <= validateN){
                        if (primos[i] > Math.sqrt(verificationN)){
                            break;
                        }
                    } else if (primos[i] > Math.sqrt(validateN/2)){
                        break;
                    }
                }
            }
        }
    }
    public static void validateMDCan (List<equacaoResto> objectList){
        int primos[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        
        for (equacaoResto verification : objectList){
            int a = verification.getA();
            int n = verification.getn();

            if (a == 1 || n == 1){
                break;
            }
            if (a % n == 0 || n % a == 0){
                System.out.println("Falhou porque são divisíveis entre si");
                throw new MDCnot1anException(a, n, a);
            }

            for (int i = 0; i < primos.length; i++){
                if (n % primos[i] == 0 && a % primos[i] == 0){
                    System.out.println("falhou no teste dos primos2: " + primos[i]);
                    throw new MDCnot1anException(a, n, primos[i]);
                }
                //só precisa verificar até a raiz do menor número
                if (a <= n){
                    if (primos[i] > Math.sqrt(n)){
                        break;
                    }
                } else if(primos[i] > Math.sqrt(a)){
                    break;
                }
            }
        }
    }
    public static List<equacaoResto> setX(List<equacaoResto> objectList) {
        int i = 0;
        for (equacaoResto tmp : objectList){
            tmp.setX();
            objectList.set(i, tmp);
            System.out.println(tmp.getX());
            i++;
        }
        return objectList;
    }
    
}