/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dao.VariavelRespostaDAO;
import br.com.estatisticaweb.modelo.dto.VariavelResposta;

/**
 *
 * @author Andrey
 */
public class VariavelRespostaBO extends BOCRUDBase <VariavelResposta, VariavelRespostaDAO>{

    @Override
    protected VariavelRespostaDAO instanciarDAO() {
        return new VariavelRespostaDAO();
    }

    @Override
    protected void validarChavePrimaria(VariavelResposta dto) throws Exception {
        if(dto.getId() == null)
           throw new Exception("Preencha o id.");
    }

    @Override
    protected void validar(VariavelResposta dto) throws Exception {
        if (dto.getNome().trim().equals(""))
           throw new Exception("Preencha o nome");
        if (dto.getProjeto() == null)
            throw new Exception("Preencha o projeto.");
    }
    
}
