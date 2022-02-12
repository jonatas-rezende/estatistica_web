package br.com.estatisticaweb.modelo.dto;

/**
 * Classe dto para DadosSimples
 * @since 23/10/2017
 */
public class DadoSimples {
    // atributo de identificação de id de Dado simples
    private Integer id;
    // atributo de identificação de valor de Dado simples
    private Double valor;
    // atributo de identificação de projeto de Dado Simples
    private Projeto projeto;

    /**
     * Construtor vazio para a classe
     */
    public DadoSimples() {
    }

    /**
     * Construtor para a classe
     * @param id identificador de DadosSimples
     * @param valor identificador de valor de um dado simples
     * @param projeto identificador de projeto de um dado simples
     */
    public DadoSimples(Integer id, Double valor, Projeto projeto) {
        this.id = id;
        this.valor = valor;
        this.projeto = projeto;
    }

    /**
     * Método que retorna o id de um dado simples
     * @return id de um dado simples
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que modifica o id de um dado simples
     * @param id identificador de id de um dado simples
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que retorna o valor de um dado simples
     * @return o valor de um dado simples
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Método que modifica o valor de um dado simples
     * @param valor identificador de valor de um dado simples
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Método que retorna o projeto de um dado simples
     * @return projeto de um dado simples
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * Método que modifica o projeto de um dados simples
     * @param projeto identificaodr de projeto de um dado simples
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
}
