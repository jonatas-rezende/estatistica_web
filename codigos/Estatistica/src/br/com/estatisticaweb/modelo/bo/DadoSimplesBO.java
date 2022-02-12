/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dao.DadoSimplesDAO;
import br.com.estatisticaweb.modelo.dto.DadoSimples;

/**
 *
 * @author Andrey Ribeiro
 */
public class DadoSimplesBO extends BOCRUDBase <DadoSimples, DadoSimplesDAO>{

    @Override
    protected DadoSimplesDAO instanciarDAO() {
        return new DadoSimplesDAO();
    }

    @Override
    protected void validarChavePrimaria(DadoSimples dto) throws Exception {
        if(dto.getId() == null)
           throw new Exception("Preencha o id.");
    }

    @Override
    protected void validar(DadoSimples dto) throws Exception {
        
        if (dto.getValor() == null)
            throw new Exception("Preencha o valor.");
        if (dto.getProjeto() == null)
            throw new Exception("Preencha o projeto.");
        }
    }
