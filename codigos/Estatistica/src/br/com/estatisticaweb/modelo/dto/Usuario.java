package br.com.estatisticaweb.modelo.dto;

/**
 * DTO para representação da entidade usuário
 * @author Willian Wallace de Matteus Silva
 * @since 13/10/2017
 */
public class Usuario {
    
    private Integer id;
    
    private String nome;

    private String email;
    
    private String senha;
    
    /**
    * Construtor vazio para a classe
    */
    public Usuario() {
    }

    /**
     * Construtor da classe Usuario com dois parâmetros
     * @param email identificador do usuário
     * @param senha senha do usuário
     */
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    /**
     * Função que retorna o identificador do usuário
     * @return identificador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Função que modifica o identificador do usuário
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Função que retorna o nome do usuário
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função que modifica o nome do usuário
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Função que retorna o email do usuário
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Função que modifica o email do usuário
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    /**
     * Função que modifica a senha do usuário
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }    

}
