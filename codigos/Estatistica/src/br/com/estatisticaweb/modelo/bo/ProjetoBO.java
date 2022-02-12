package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dao.ProjetoDAO;
import br.com.estatisticaweb.modelo.dto.DIC;
import br.com.estatisticaweb.modelo.dto.EstatisticaDescritiva;
import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Usuario;
import java.util.List;

/**
 *
 * @author Lara
 */
public class ProjetoBO extends BOCRUDBase <Projeto, ProjetoDAO>{

    @Override
    protected ProjetoDAO instanciarDAO() {
        return new ProjetoDAO();
    }

    @Override
    protected void validarChavePrimaria(Projeto dto) throws Exception {
        if(dto.getId() == null)
           throw new Exception("Preencha o id.");
    }

    @Override
    protected void validar(Projeto dto) throws Exception {
        if (dto.getNome().trim().equals(""))
           throw new Exception("Preencha o nome");
        if (dto.getUsuario() == null)
            throw new Exception("Preencha o usuário.");
    }

    public List listarUltimos(Usuario usuario) throws Exception {
        ProjetoDAO dao = new ProjetoDAO();
        return dao.listar(usuario, 5);
    }
    
    public List listarPorUsuario(Usuario usuario) throws Exception {
        ProjetoDAO dao = new ProjetoDAO();
        return dao.listar(usuario);
    }
    
    public EstatisticaDescritiva calcularEstatisticaDescritiva(Double[] numeros){
        EstatisticaDescritiva ed = new EstatisticaDescritiva();
        
        ed.setMedia(calcularMedia(numeros));
        ed.setModa(calcularModa(numeros));
        ed.setMediana(calcularMediana(numeros));
        ed.setDesvioPadrao(calcularDesvioPadrao(numeros));
        ed.setVariancia(calcularVariancia(numeros));
        ed.setCurtose(calcularCurtose(numeros));
        ed.setAmplitude(calcularAmplitude(numeros));
        ed.setMaior(calcularMaior(numeros));
        ed.setMenor(calcularMenor(numeros));
        
        return ed;
    }
    
    public Double calcular(String script, Double[] numeros){
        RBO R = new RBO();
        
        try {
            R.gravarDados(numeros);
            Double media = R.calcular(script);
            return media;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public Double calcularMedia(Double[] numeros){
        return calcular("calcular_media.R", numeros);
    }    
    
    public Double calcularModa(Double[] numeros){
        return calcular("calcular_moda.R", numeros);
    }
    
    public Double calcularMediana(Double[] numeros){
        return calcular("calcular_mediana.R", numeros);
    }
    
    public Double calcularDesvioPadrao(Double[] numeros){
        return calcular("calcular_desvio_padrao.R", numeros);
    }
    
    public Double calcularVariancia(Double[] numeros){
        return calcular("calcular_variancia.R", numeros);
    }
    
    public Double calcularCurtose(Double[] numeros){
        return calcular("calcular_curtose.R", numeros);
    }
    
    public Double calcularAmplitude(Double[] numeros){
        return calcular("calcular_amplitude.R", numeros);
    }
    
    public Double calcularMaior(Double[] numeros){
        return calcular("calcular_maior.R", numeros);
    }
    
    public Double calcularMenor(Double[] numeros){
        return calcular("calcular_menor.R", numeros);
    }
    
    public DIC calcularDIC(Double[] numeros) {
        try {
            RBO rbo = new RBO();
            Double[] resultados = rbo.calcularResultados("dic.R");
            
            DIC dic = new DIC();
            dic.setGlTratamento(resultados[0].intValue());
            dic.setGlResiduo(resultados[1].intValue());
            
            return dic;
        } catch (Exception ex){
            return null;
        }
    }

    public Double[] separarDados(String dados) {
        String vetor[] = dados.split(";");        
        Double[] numeros = new Double[vetor.length];
        
        for (int i = 0; i < vetor.length; i++){
            String item = vetor[i].trim();
            item = item.replace(',', '.');
            
            Double numero = Double.parseDouble(item);
            numeros[i] = numero;
        }
        
        return numeros;
    }
}
