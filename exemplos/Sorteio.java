
package sorteio;

import java.util.Scanner;


public class Sorteio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        
        int sorteado; // irá receber o numero sorteado
        int maximo; // numero máximo a ser sorteado 
        int quantidade; // quantidade de vezes que irá repetir

        System.out.print("Digite o numero máximo a ser sorteado: ");
        maximo = teclado.nextInt();
        
        System.out.print("\nDigite a quantidade de numeros que deseja repetir: ");
        quantidade = teclado.nextInt();
        
        System.out.println("\nOs números sorteados são: ");
        
        for (int i = 0; i < quantidade; i++) {
            sorteado = (int) (Math.random() * (maximo + 1) );
            //variavel sorteado recebe o valor que a biblioteca sorteou
            // sorteia numeros iguais 

            System.out.println(sorteado);//Imprime o numero sorteado
        }
    }
    
}

