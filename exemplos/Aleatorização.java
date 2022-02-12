package aleatorização;
import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class Aleatorização {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random gerador = new Random();
        
        String tratamentos[] = {"P", "K"};
        int r = 10;
        int t = 2; // int t = sizeof(tratamentos) / sizeof(char)
        int n = r * t;
        
        int v[n] = new int[n];
        int qtde[t];
        
        for (int i = 0; i < n; i++){
                v[i] = 0;
        }
        for (int i = 0; i < t; i++);{
            qtde[i] = 0;
        }
        
        for (int i = 0; i < n; i++){
            boolean permitido = false;
            do {
                //Sorteia um número inteiro k entre 0 e t
                float kReal = (rand()) / rand_max;
                int k = round(kReal * (t - 1));
                
                //Atribui v[i] o valor k
                if (qtde[k] < r){
                    v[i] = k;
                    qtde[k]++;
                    permitido = true;
                }
            } while (!permitido);
        }
        
        int linhas, colunas;
        boolean encontrou = false;
        int menorDiferenca = 100000;
        for (int i = 3; i < n; i++){
            for (int j = 3; j < n; j++){
                int produto = i * j;
                
                if (produto == n){
                    encontrou = true;
                    int diferenca = abs(i - j);
                    
                    if (diferenca < menorDiferenca){
                        linhas = i;
                        colunas = j;
                        menorDiferenca = diferenca;
                    }
                }
            }
        }
        
        if(!encontrou){
           linhas = (int) sqrt(n);
           colunas = round((float) (n) / linhas);           
        }
        
        int menor = fmin(linhas, colunas);
        int maior = fmax(linhas, colunas);
        
        colunas = menor;
        linhas = maior;
        
        //Essa é a única parte que deve ir para o JSP
        int i = 0;
        for(int linha = 0; linha < linhas; linha++){
            for (int coluna = 0; coluna < colunas; coluna++){
                int k = v[i];
                
                System.out.print(tratamentos[k]);
                i++;
                
                if (i > n - 1) break;
            }
            System.out.println("");
            if (i > n - 1) break;
        }
        System.out.println("");
        
        return 0;
        
    }
    
}
