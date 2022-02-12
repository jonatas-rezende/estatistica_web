package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.DadoSimples; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos dados simples
 * @author Adallberto
 */
public class DadoSimplesDAO extends DAOCRUDBase<DadoSimples> {
    
    /**
     * Método que lista todos os dados simples armazanados no banco de dados
     * @author Adallberto Lucena Moura
     * @return lista dos dados simples
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from dados_simples order by id asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        ProjetoDAO projetoDAO = new ProjetoDAO();                
        while (rs.next()){
            DadoSimples d = new DadoSimples();
            
            d.setId(rs.getInt("id"));
            d.setValor(rs.getDouble("valor"));           
            d.setProjeto(projetoDAO.selecionar(rs.getInt("projeto"))); 
            
            lista.add(d);
        }
        
        return lista;
    }  
    
    /**
     * Método responsável pela inserção de dados simples no banco de dados
     * @author Luciano de Carvalho Borba
     * @param dto dados simples a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(DadoSimples dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement
        pstmt = conexao.prepareStatement("insert into dados_simples (valor, projeto) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setDouble(1, dto.getValor());
        pstmt.setInt(2, dto.getProjeto().getId());
        
        //Executa a inserção
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
    }

     /**
     * Método responsável pela alteração de dados simples no banco de dados
     * @author Jeferson Rossini Ferreira Lourenço
     * @param dto dados simples a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */   
    @Override
    public void alterar(DadoSimples dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt; 
        pstmt = conexao.prepareStatement("update dados_simples set valor = ?, projeto = ? where id = ?");
        
        pstmt.setDouble(1, dto.getValor());
        pstmt.setInt(2, dto.getProjeto().getId());
        pstmt.setInt(3, dto.getId());
        
        //executa uma atualização/alteração
        pstmt.executeUpdate();
    }
    
    /**
     * Método responsável por selecionar algum dados simples no banco de dados
     * @author Macilon Arruda
     * @param id identificador de dados simples selecionado
     * @return o dados simples selecionado
     * @throws Exception - Possíveis exceções que podem acontecer
     */
    @Override
    public DadoSimples selecionar(int id) throws Exception {

        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from dados_simples where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        if(rs.next()) {
            DadoSimples d = new DadoSimples();
            d.setId(rs.getInt("id"));
            d.setValor(rs.getDouble("valor"));
            d.setProjeto(projetoDAO.selecionar(rs.getInt("projeto")));
            
            return d;
        }else{
            return null;
        }
    }

    /**
     * Método que exclui um dado simples
     * @param id identificador de id de um dado simples
     * @throws Exception possíveis exceções que podem acontecer
     * @author Daniel Moreira Cardoso
     */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from dados_simples where id = ?");
        
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
}