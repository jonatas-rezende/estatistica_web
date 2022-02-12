package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.VariavelResposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Macilon Arruda
 */
 public class VariavelRespostaDAO extends DAOCRUDBase<VariavelResposta> {
    
    @Override
    public void inserir (VariavelResposta dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement
        pstmt = conexao.prepareStatement("insert into variaveis_respostas (nome, projeto) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getProjeto().getId());
        
        //Executa a inserção
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
    }
    
    
    
    @Override
    public void alterar (VariavelResposta dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt; 
        pstmt = conexao.prepareStatement("update variaveis_respostas set nome = ?, projeto = ? where id = ?");
        
        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getProjeto().getId());
        pstmt.setInt(3, dto.getId());
        
        //executa uma atualização/alteração
        pstmt.executeUpdate();
    }

    @Override
    public VariavelResposta selecionar(int id) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from variaveis_respostas where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        if(rs.next()) {
            VariavelResposta v = new VariavelResposta();
            v.setId(rs.getInt("id"));
            v.setNome(rs.getString("nome"));
            v.setProjeto(projetoDAO.selecionar(rs.getInt("projeto")));
            
            return v;
        }else{
            return null;
        }
    }


    @Override
    public void excluir(int id) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from variaveis_respostas where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public List listar() throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from variaveis_respostas order by nome asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        ProjetoDAO projetoDAO = new ProjetoDAO();                
        while (rs.next()){
            VariavelResposta vr = new VariavelResposta();
            
            vr.setId(rs.getInt("id"));
            vr.setNome(rs.getString("nome"));            
            vr.setProjeto(projetoDAO.selecionar(rs.getInt("projeto"))); 
            
            lista.add(vr);
        }
    
        return lista;
    }
}