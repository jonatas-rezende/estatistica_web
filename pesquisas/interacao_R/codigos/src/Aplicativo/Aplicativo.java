package Aplicativo;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicativo {
    
    //arraylist criada para armazenar os valores recebidos para depois converter em JSON
    ArrayList<Valor> valores = new ArrayList() ;
    
    public static void main(String[] args) throws Exception{
        
        //objeto criado para receber os valores que comporão a arraylist
        Aplicativo ent_valor = new Aplicativo();
        String valor;
        
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("\nSeja bem vindo(a) ao sistema de cálculo da mediana!!!");
        System.out.println("\nInforme os valores desejado, para iniciar a execução aperte ENTER no espaço vazio\n");
        while(continuar){
            valor = entrada.nextLine();
            //condicional necessária para verificar se o valor e vazio
            if(valor.isEmpty())
                break;
            
            ent_valor.valores.add(new Valor(valor));
        }
        //imprime os valores informados
        /*for(int i = 0; i < ent_valor.valores.size(); i++){
            System.out.println(ent_valor.valores.get(i).valor);
        }*/
        
        //criacao do objeto para converter para JSON
        Gson teste = new Gson();
        //exibe os dados no formato JSON
        //System.out.println(teste.toJson(ent_valor.valores));

        //cria o objeto para criacao do arquivo JSON
        FileWriter writeFile = null;
        
        try{
            //informa o nome do arquivo a ser usado para gravar os dados no formato JSON
            writeFile = new FileWriter("saida.json");
            //informa que dados deverão ser gravados no arquivo
            writeFile.write(teste.toJson(ent_valor.valores));
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //identifica qual o nome do sistema operacional executado na máquina
        String resposta = System.getProperty("os.name");
        
        //condicional para executar os comandos de acordo com o sistema operacional
        if(resposta.contains("Windows"))
            //executa os comandos contidos no metodo executar na classe Windows
            Windows.executar();
        else //como so temos windows e linux na faculdade, n fiz mais if, nao sendo windows, sera linux...
            //executa os comandos contidos no metodo executar na classe Linux
            Linux.executar();
    }        
}