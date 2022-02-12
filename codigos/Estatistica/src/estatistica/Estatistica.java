package estatistica;

import java.io.DataInputStream;

public class Estatistica {
    public static void main(String[] args) throws Exception {
        Process processo = Runtime.getRuntime().exec("ls -la");
        
        DataInputStream dos = new DataInputStream(processo.getInputStream());
        
        String resultado; 
        
        while ((resultado = dos.readLine()) != null){
            System.out.println(resultado);
        }
    }    
}
