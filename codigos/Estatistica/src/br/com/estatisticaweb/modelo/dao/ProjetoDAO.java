package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.Projeto; 
import br.com.estatisticaweb.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos projetos dos usuários
 * @author Ianka Talita Bastos de Assis, Jônatas de Souza Rezende, Macilon Arruda
 * @since 15/10/2017
 */
public class ProjetoDAO extends DAOCRUDBase<Projeto> {
    
    /**
     * Método responsável pela inserção de um projeto no banco de dados
     * @author Macilon Arruda
     * @param dto Projeto a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir (Projeto dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into projetos (nome, quantidade_repeticoes, significancia, teste, usuario) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        if(dto.getQuantidadeRepeticoes() != null){            
            pstmt.setInt(2, dto.getQuantidadeRepeticoes());
        }else{
            pstmt.setNull(2, Types.INTEGER);
        }
        if(dto.getSignificancia() != null){
            pstmt.setDouble(3, dto.getSignificancia());
        }else{
            pstmt.setNull(3, Types.DOUBLE);
        }
        if(dto.getTeste() != null){
            pstmt.setInt(4, dto.getTeste());
        }else{
            pstmt.setNull(4, Types.INTEGER);
        }
        pstmt.setInt(5, dto.getUsuario().getId());
        
        pstmt.executeUpdate(); //Executa a inserção
        
        dto.setId(getId(pstmt));
    }
    
    @Override
    public Projeto selecionar (int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from projetos where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(rs.next()){
            Projeto p = new Projeto();
            
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setQuantidadeRepeticoes(rs.getInt("quantidade_repeticoes"));
            p.setSignificancia(rs.getDouble("significancia"));
            p.setTeste(rs.getInt("teste"));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario"))); 
            return p;
        }else{
            return null;
        }
    }
    
    /**
     * Método responsável pela alteração de dados de um projeto no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param u novos dados alterado do projeto, com o ID do projeto a ser alterado preenchido
     * @throws Exception - Possíveis exceções que podem acontecer
     */
    @Override
    public void alterar (Projeto u) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update projetos set nome = ?, quantidade_repeticoes = ?, significancia = ?, teste = ?, usuario = ? where id = ?");
        
        pstmt.setString(1, u.getNome());
        pstmt.setInt(2, u.getQuantidadeRepeticoes());
        pstmt.setDouble(3, u.getSignificancia());
        pstmt.setInt(4, u.getTeste());
        pstmt.setInt(5, u.getUsuario().getId());
        pstmt.setInt(6, u.getId());
        
        //executa uma atualização/alteração
        pstmt.executeUpdate();        
    }
    
    /**
     * Método que lista todos os usuários em ordem alfabética cadastrados no banco de dados
     * @author Jônatas de Souza Rezende
     * @return lista de usuários ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from projetos order by nome asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();                
        while (rs.next()){
            Projeto p = new Projeto();
            
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setQuantidadeRepeticoes(rs.getInt("quantidade_repeticoes"));
            p.setSignificancia(rs.getDouble("significancia"));
            p.setTeste(rs.getInt("teste"));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario"))); 
            
            lista.add(p);
        }
        
        return lista;
    }   
    
    /**
     * Método responsável pela exclusão de um projeto no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param id identificador do objeto a ser excluido
     * @throws Exception - Possíveis exceções que podem acontecer
    */
    @Override
    public void excluir (int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from projetos where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }    

    public List listar(Usuario usuario, int quantidade) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from projetos where usuario = ? order by id desc limit ?");
        pstmt.setInt(1, usuario.getId());
        pstmt.setInt(2, quantidade);
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();                
        while (rs.next()){
            Projeto p = new Projeto();
            
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setQuantidadeRepeticoes(rs.getInt("quantidade_repeticoes"));
            p.setSignificancia(rs.getDouble("significancia"));
            p.setTeste(rs.getInt("teste"));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario"))); 
            
            lista.add(p);
        }
        
        return lista;
    }
    
     public List listar(Usuario usuario) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from projetos where usuario = ? order by id desc");
        pstmt.setInt(1, usuario.getId());
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();                
        while (rs.next()){
            Projeto p = new Projeto();
            
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setQuantidadeRepeticoes(rs.getInt("quantidade_repeticoes"));
            p.setSignificancia(rs.getDouble("significancia"));
            p.setTeste(rs.getInt("teste"));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario"))); 
            
            lista.add(p);
        }
        
        return lista;
    }
    
}