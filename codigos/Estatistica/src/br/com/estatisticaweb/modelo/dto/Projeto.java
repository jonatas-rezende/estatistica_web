package br.com.estatisticaweb.modelo.dto;

/**
 * Classe para representação de um artigo
 * @author Aluno
 */
public class Projeto {

    private Integer id;
        
    private String nome;
        
    private Integer quantidadeRepeticoes;
        
    private Double significancia;
       
    private Integer teste;
    
    private Usuario usuario;

   //Função que retorna um identificador de um artigo
    public Integer getId() {
        return id;
    }

    //Função que modifica o identficador de um artigo
    public void setId(Integer id) {
        this.id = id;
    }

   //Função que retorna um nome de um projeto
    public String getNome() {
        return nome;
    }

    //Função que modifica um nome de um projeto
    public void setNome(String nome) {
        this.nome = nome;
    }

   //Função que retorna um repeticao de um projeto
    public Integer getQuantidadeRepeticoes() {
        return quantidadeRepeticoes;
    }

    //Função que modifica o repeticao de um projeto
    public void setQuantidadeRepeticoes(Integer quantidadeRepeticoes) {
        this.quantidadeRepeticoes = quantidadeRepeticoes;
    }

   //Função que retorna um significancia de um projeto
    public Double getSignificancia() {
        return significancia;
    }

    //Função que modifica o significancia de um projeto
    public void setSignificancia(Double significancia) {
        this.significancia = significancia;
    }

    //Função que retorna um teste de um projeto
    public Integer getTeste() {
        return teste;
    }

    //Função que modifica um teste de um projeto
    public void setTeste(Integer teste) {
        this.teste = teste;
    }

    //Função que retorna um usuario de um projeto
    public Usuario getUsuario() {
        return usuario;
    }

    //Função que modifica o usuario de um projeto
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
