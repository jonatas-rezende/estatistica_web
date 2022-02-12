package br.com.estatisticaweb.modelo.bo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Regras de negócio do R
 * @author Ronneesley Moura Teles  /home/andrey/Documentos/projetos/estatisticaweb/scripts/
 * @since 10/11/2017
 */
public class RBO {
    public static String DIRETORIO = "/home/aluno/git/estatisticaweb/scripts/";

    public void gravarDados(Double[] numeros) {
        //Criação do objeto para converter para JSON
        Gson teste = new Gson();
        FileWriter writeFile = null;

        try{
            //informa o nome do arquivo a ser usado para gravar os dados no formato JSON
            writeFile = new FileWriter(DIRETORIO + "entrada.json");
            //informa que dados deverão ser gravados no arquivo
            writeFile.write(teste.toJson(numeros));
            writeFile.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Criação do método executar os processos são os mesmos
     * da classe windows, com exceção do caminho do script
     * @param script
     * @return
     * @throws java.lang.Exception
     */
    public String executar(String script) throws Exception {
        try{
            String comando = "Rscript " + DIRETORIO + script;

            Process exec = Runtime.getRuntime().exec(comando);

            BufferedReader retorno = new BufferedReader(new InputStreamReader(exec.getInputStream()));

            String linha, resultado = "";
            while ((linha = retorno.readLine()) != null){
                resultado += linha;
            }

            retorno.close();
            exec.destroy();

            return resultado;
        } catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Este método executa um script R, e converte o único resultado
     * esperado para um número de ponto flutuante
     * @param script script
     * @return valor do resultado
     * @throws Exception
     */
    public Double calcular(String script) throws Exception {
        String resultado = executar(script);

        return Double.parseDouble(resultado);
    }
    
    public Double[] calcularResultados(String script) throws Exception {
        String resultado = executar(script);
        return converterMultiplasLinhas(resultado);
    }
    
    public Double[] converterMultiplasLinhas(String resultado){
        String[] linhas = resultado.split("\n");

        int n = linhas.length;
        Double resultados[] = new Double[n];
        for (int i = 0; i < n; i++){
            String linha = linhas[i];
            
            resultados[i] = Double.parseDouble(linha);
        }
        
        return resultados;
    }
    
}
