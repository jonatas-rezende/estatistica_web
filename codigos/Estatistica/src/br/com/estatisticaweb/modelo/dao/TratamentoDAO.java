package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.Tratamento; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos metodos de tratamento
 * @author Adallberto, Macilon Arruda
 */
public class TratamentoDAO extends DAOCRUDBase<Tratamento> {
    
    /**
     * Método responsável pela inserção de um tratamento no banco de dados
     * @author Macilon Arruda
     * @param dto Tratamento a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir (Tratamento dto) throws Exception {
       Connection conexao = getConexao();

        PreparedStatement 
        pstmt = conexao.prepareStatement("insert into tratamentos(descricao, projeto) values(?, ?)", Statement.RETURN_GENERATED_KEYS);

	pstmt.setString(1, dto.getDescricao());
        pstmt.setInt(2, dto.getProjeto().getId());

	/**
        * executa uma inserção
        */
	pstmt.executeUpdate();

        dto.setId(getId(pstmt));
    }
    
    /**
     * Método que lista todos os tratamentos em ordem alfabética
     * @author Adallberto Lucena Moura
     * @return lista de tratamentos ordenados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from tratamentos order by descricao asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        ProjetoDAO projetoDAO = new ProjetoDAO();                
        while (rs.next()){
            Tratamento t = new Tratamento();
            
            t.setId(rs.getInt("id"));
            t.setDescricao(rs.getString("descricao"));            
            t.setProjeto(projetoDAO.selecionar(rs.getInt("projeto"))); 
            
            lista.add(t);
        }
        
        return lista;
    }  
    
     /**
     * Método responsável pela alteração de um tratamento no banco de dados
     * @author Luciano de Carvalhho Borba
     * @param dto novos dados do tratamento, com o Id do tratamento a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */   
    @Override
    public void alterar(Tratamento dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt; 
        pstmt = conexao.prepareStatement("update tratamentos set descricao = ?, projeto = ? where id = ?");
        
        pstmt.setString(1, dto.getDescricao());
        pstmt.setInt(2, dto.getProjeto().getId());
        pstmt.setInt(3, dto.getId());
        //executa uma atualização/alteração
        pstmt.executeUpdate();
    }
    
      /**
     * Método responsável de selecionar  um tratamento no banco de dados
     * @author José Gilvan Jacinto Junior
     * @param id
     * @return id do tratamento selecionado 
     * @throws Exception possíveis exceções que podem acontecer
     */   
    @Override
    public Tratamento selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt = conexao.prepareStatement("select * from tratamentos where id = ?"); 
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        ProjetoDAO p = new ProjetoDAO();
        if (rs.next()) {
            
            Tratamento u = new Tratamento ();
            u.setId(rs.getInt("id"));
            u.setDescricao(rs.getString("descricao"));
            u.setProjeto(p.selecionar(rs.getInt("projeto")));
            
            return u;
        }else{
            return null;
        }   
    }
	
    
    /**
     * Método responsável pela exclusão de um tratamento no banco de dados
     * @author Jeferson Rossini
     * @param id identificador do objeto a ser excluido
     * @throws Exception - Possíveis exceções que podem acontecer
    */
    @Override
    public void excluir (int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from tratamentos where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }  
    
  
}

