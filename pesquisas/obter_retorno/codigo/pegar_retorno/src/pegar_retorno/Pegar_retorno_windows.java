package pegar_retorno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jônatas, Andrey e Lucas
 */
public class Pegar_retorno_windows {

    public static void main(String[] args) throws Exception {
        
        try{
            // onde será armazenado o resultado
            String resultado; 
            
            // nome do arquivo que armazenará o resultado
            String n_arquivo = "resultado.txt";
            
            // o comando que será utilizado
            String comando = "CMD /C Rscript d:\\desvio_padrao.R";
            
            // executa o processo e armazena a referência em 'exec'
            Process exec = Runtime.getRuntime().exec(comando);
        
            // pega o retorno do processo
            BufferedReader retorno = new BufferedReader(new InputStreamReader(exec.getInputStream()));
          
            // salva e imprime o retorno
            while ((resultado = retorno.readLine()) != null){
                FileWriter arquivo;
		try {
                    arquivo = new FileWriter(new File(n_arquivo));
                    arquivo.write("Resultado da operação: ");
                    arquivo.write(resultado);
                    arquivo.close();
                    FileReader reader = new FileReader(n_arquivo);
                    BufferedReader leitor = new BufferedReader(reader);
                    while(leitor.ready()) {
                            System.out.println(leitor.readLine());
                    }
                    reader.close();
                    leitor.close();
                    
                } catch (IOException e) {
                    System.err.println("Erro: " + e.toString());
		} catch (Exception e) {
                    System.err.println("Erro: " + e.toString());
		}
            }
            
            System.out.println("\nResultado gravado em resultado.txt\n");
            retorno.close();
            exec.destroy();
        }
        
        catch(IOException exc){
            System.err.println("Erro: " + exc.toString());
        }
    }        
}
