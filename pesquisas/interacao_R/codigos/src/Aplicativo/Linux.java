package Aplicativo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Linux {
    
    // criação do método executar
    // os processos são os mesmos da classe windows, com exceção do caminho do script
    public static void executar() throws Exception {
        
        try{
            String resultado; 
            String n_arquivo = "resultado.txt";
            /*observar o caminho de onde estão os scripts no linux
            o Rscript tem que estar instalado no shell do linux, caso contrário é necessário
            colocar o caminho completo do executável*/
            String comando = "Rscript /home/aluno/git1/estatisticaweb/codigos/EstatisticaWeb/web/Script/calculo_mediana_usando_json.R";

            Process exec = Runtime.getRuntime().exec(comando);

            BufferedReader retorno = new BufferedReader(new InputStreamReader(exec.getInputStream()));

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
            
            String dir = System.getProperty("user.dir");
            dir = dir + "\\" + n_arquivo;
            System.out.println("\nResultado gravado em " + dir + "\n");

            retorno.close();
            exec.destroy();
        }
        
        catch(IOException exc){
            System.err.println("Erro: " + exc.toString());
        }
    }
}