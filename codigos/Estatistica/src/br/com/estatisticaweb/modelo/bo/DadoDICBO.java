package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dao.DadoDICDAO;
import br.com.estatisticaweb.modelo.dto.DadoDIC;

/**
 *
 * @author Lara
 */
public class DadoDICBO extends DadoDICDAO{

    protected DadoDICDAO instanciarDAO() {
        return new DadoDICDAO();    
    }

    protected void validarChavePrimaria(DadoDIC dto) throws Exception {
        if(dto.getRepeticao() == null) throw new Exception("Preencha o id."); 
    }

    protected void validar(DadoDIC dto) throws Exception {
        if (dto.getVariavelResposta() == null)
           throw new Exception("Preencha a Variavel resposta.");
        if (dto.getTratamento() == null)
           throw new Exception("Preencha o tratamento.");
        if (dto.getRepeticao() == null)
           throw new Exception("Preencha a repetição.");
        if (dto.getValor() == null)
            throw new Exception("Preencha o valor.");
        if (dto.getX() == null)
            throw new Exception("Preencha o X.");
        if (dto.getY() == null)
            throw new Exception("Preencha o Y.");
    }
    
}
