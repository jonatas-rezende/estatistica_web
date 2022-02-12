package Aplicativo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Windows {
    
    //criacao do método executar a ser usado na classe principal
    public static void executar() throws Exception {
        
        try{
            // onde sera armazenado o retorno 
            String resultado; 
            
            // nome do arquivo que armazenara o resultado
            String n_arquivo = "resultado.txt";
            
            // o comando que sera utilizado
            // deve obser o caminho do script em relação ao computador que tiver sendo usado
            // o Rscript deverá estar habilitado no Path do windows, caso nao esteja basta informar o caminho completo do executavel
            String comando = "CMD /C Rscript C:\\Users\\qualq\\Documents\\GitHub\\estatisticaweb\\codigos\\EstatisticaWeb\\web\\Script\\calculo_mediana_usando_json.R";
            
            // executa o processo e armazena a referencia em 'exec'
            Process exec = Runtime.getRuntime().exec(comando);
        
            // pega o retorno do processo e armazena em buffer
            BufferedReader retorno = new BufferedReader(new InputStreamReader(exec.getInputStream()));
          
            // salva e imprime o retorno
            while ((resultado = retorno.readLine()) != null){
                FileWriter arquivo;
		try {
                    // cria o arquivo para gravar os dados do retorno
                    arquivo = new FileWriter(new File(n_arquivo));
                    arquivo.write("\nResultado da operação: ");
                    arquivo.write(resultado);
                    arquivo.close();
                    // realiza a leitura do arquivo onde estao gravados os dados
                    FileReader reader = new FileReader(n_arquivo);
                    BufferedReader leitor = new BufferedReader(reader);
                    // imprime o dado encontrado na tela
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
            // pega o diretorio de trabalho atual
            String dir = System.getProperty("user.dir");
            // armazena o caminho completo do arquivo onde foi salvo os dados
            dir = dir + "\\" + n_arquivo;
            // imprime o caminho completo do arquivo
            System.out.println("\nResultado gravado em " + dir + "\n");
            
            retorno.close();
            exec.destroy();
        }
        
        catch(IOException exc){
            System.err.println("Erro: " + exc.toString());
        }
    }
}