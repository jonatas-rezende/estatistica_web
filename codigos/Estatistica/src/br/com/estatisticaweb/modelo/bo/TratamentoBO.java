/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dao.TratamentoDAO;
import br.com.estatisticaweb.modelo.dto.Tratamento;

/**
 *
 * @author Andrey Ribeiro
 */
public class TratamentoBO extends BOCRUDBase <Tratamento, TratamentoDAO>{

    @Override
    protected TratamentoDAO instanciarDAO() {
        return new TratamentoDAO();
    }

    @Override
    protected void validarChavePrimaria(Tratamento dto) throws Exception {
        if(dto.getId() == null)
           throw new Exception("Preencha o id.");
    }

    @Override
    protected void validar(Tratamento dto) throws Exception {
        if (dto.getDescricao().trim().equals(""))
           throw new Exception("Preencha a descrição");
        if (dto.getProjeto() == null)
            throw new Exception("Preencha o projeto.");
    }
    
}
