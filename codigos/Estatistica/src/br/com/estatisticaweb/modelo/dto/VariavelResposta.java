/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.dto;

/**
 *
 * @author 
 */
public class VariavelResposta {
    
    private Integer id;
    
    private String nome;
    
    private Projeto projeto;
    
    //Função que retorna um identificador de uma variavel resposta
    public Integer getId() {
        return id;
    }

    //Função que modifica o identficador de uma variavel resposta
    public void setId(Integer id) {
        this.id = id;
    }

   //Função que retorna um nome de uma variavel resposta
    public String getNome() {
        return nome;
    }

    //Função que modifica um nome de uma variavel resposta
    public void setNome(String nome) {
        this.nome = nome;
    }
  
// Função que retorna um projeto  
   public Projeto getProjeto() {
        return projeto;
    }

//Função que modifica um projeto
     public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
