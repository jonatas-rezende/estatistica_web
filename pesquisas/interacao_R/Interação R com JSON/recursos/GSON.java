//Importacao da biblioteca
import com.google.gson.Gson;

//Criacao do objeto GSON
Gson gson = new Gson();

//Conversao de GSON para JSON para um arquivo .json
writeFile = new FileWriter("saida.json");
writeFile.write(gson.toJson(ent_valor.valores));