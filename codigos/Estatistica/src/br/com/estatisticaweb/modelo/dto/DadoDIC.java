package br.com.estatisticaweb.modelo.dto;

/**
 * DTO dos Dados de DIC
 * @author Thalia Santos de Santana
 * @since 22/10/2017
 */
public class DadoDIC {
    
    private VariavelResposta variavelResposta;
    
    private Tratamento tratamento;
    
    private Integer repeticao;
    
    private Double valor;
    
    private Integer x;
    
    private Integer y;  
    
    /**
    * Construtor vazio para a classe
    */
    public DadoDIC() {
    }
    
    /**
     * Construtor da classe DadoDIC com dois parâmetros
     * @param variavelResposta identificador da variável resposta do DIC
     * @param tratamento nome do(s) tratamento(s) do DIC
     */
    public DadoDIC(VariavelResposta variavelResposta, Tratamento tratamento) {
        this.variavelResposta = variavelResposta;
        this.tratamento = tratamento;
    }

    /**
     * Função que retorna o identificador de uma variável resposta
     * @return identificador
     */
    public VariavelResposta getVariavelResposta() {
        return variavelResposta;
    }
    
    /**
     * Função que modifica o nome da postagem
     * @param variavelResposta nova variável resposta do DIC
     */
    public void setVariavelResposta(VariavelResposta variavelResposta) {
        this.variavelResposta = variavelResposta;
    }
   
    /**
     * Função que retorna o identificador de um tratamento
     * @return identificador
     */
    public Tratamento getTratamento() {
        return tratamento;
    }
    
     /**
     * Função que modifica o nome da postagem
     * @param tratamento novo nome do tratamento do DIC
     */
    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
    
    /**
     * Função que retorna o identificador da repetição de um DIC
     * @return repeticao
     */
    public Integer getRepeticao() {
        return repeticao;
    }
    
    /**
     * Função que modifica a repetição de um DIC
     * @param repeticao
     */
    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }
    
    /**
     * Função que retorna o valor do DIC
     * @return valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Função que modifica o valor do DIC
     * @param valor
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    /**
     * Função que retorna uma posição X de um DIC
     * @return x
     */
    public Integer getX() {
        return x;
    }

    /**
     * Função que modifica a posição X de um DIC
     * @param x
     */
    public void setX(Integer x) {
        this.x = x;
    }
    
    /**
     * Função que retorna uma posição Y de um DIC
     * @return y
     */
    public Integer getY() {
        return y;
    }

    /**
     * Função que modifica a posição Y de um DIC
     * @param y
     */
    public void setY(Integer y) {
        this.y = y;
    }
}


