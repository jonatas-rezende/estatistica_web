package br.com.estatisticaweb.modelo.dto;

/**
 * Classe para representação de um tratamento
 * @author Jeferson Rossini
 */

public class Tratamento {

    // atributo de identificação do tratamento
    private Integer id;
        
    // atributo de descrição do tratamento
    private String descricao;
        
    // atributo de identificação de projeto do tratamento
    private Projeto projeto;


    /**
     * Função que retorna o identificador do tratamento
     * @return identificador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Função que modifica o identificador do tratamento
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Função que retorna o descrição do projeto
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Função que modifica a descrição do projeto
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Função que retorna o projeto do tratamento
     * @return identificador
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * Função que modifica o identificador do tratamento
     * @param projeto
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }


}
