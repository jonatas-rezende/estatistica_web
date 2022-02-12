package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.DadoDIC;
import br.com.estatisticaweb.modelo.dto.Tratamento;
import br.com.estatisticaweb.modelo.dto.VariavelResposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos Dados Dic
 * @author Lara Caroline
 */
public class DadoDICDAO extends DAOBase {
    /**
     * Método responsável pela inserção dos dados do DIC no banco de dados
     * @author Lara Caroline
     * @param dto Dados do DIC que serão inseridos
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void inserir(DadoDIC dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into dados_dic (variavel_resposta, tratamento, repeticao, valor, x, y) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setInt(1, dto.getVariavelResposta().getId());
        pstmt.setInt(2, dto.getTratamento().getId());
        pstmt.setInt(3, dto.getRepeticao());
        pstmt.setDouble(4, dto.getValor());
        pstmt.setInt(5, dto.getX());
        pstmt.setInt(6, dto.getY());
        
        pstmt.execute();
    }
    /**
     * Método responsável pela alteração dos dados do DIC no banco de dados
     * @author Lara Caroline
     * @param dto Dados do DIC que serão alterados
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void alterar(DadoDIC dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update dados_dic set repeticao = ?, valor = ?, x = ?, y = ? where variavel_resposta = ? and tratamento = ?");
        
        pstmt.setInt(1, dto.getRepeticao());
        pstmt.setDouble(2, dto.getValor());
        pstmt.setInt(3, dto.getX());
        pstmt.setInt(4, dto.getY());
        pstmt.setInt(5, dto.getVariavelResposta().getId());
        pstmt.setInt(6, dto.getTratamento().getId());
        
        pstmt.executeUpdate();
    }
    /**
     * Método responsável pela seleção dos dados do DIC no banco de dados
     * @author Lara Caroline
     * @param variavelResposta que será selecionada
     * @param tratamento que será selecionado
     * @param repeticao que será selecionada
     * @throws Exception possíveis exceções que podem acontecer
     */
    public DadoDIC selecionar(VariavelResposta variavelResposta, Tratamento tratamento, int repeticao) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from dados_dic where variavel_resposta = ? and tratamento = ? and repeticao = ?;");
        pstmt.setInt(1, variavelResposta.getId());
        pstmt.setInt(2, tratamento.getId());
        pstmt.setInt(3, repeticao);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        VariavelRespostaDAO vrDAO = new VariavelRespostaDAO();
        TratamentoDAO tratamentoDAO = new TratamentoDAO();
        
        if(rs.next()){
            DadoDIC dd = new DadoDIC();
            
            dd.setVariavelResposta(vrDAO.selecionar(rs.getInt("variavel_resposta")));
            dd.setTratamento(tratamentoDAO.selecionar(rs.getInt("tratamento")));
            dd.setRepeticao(rs.getInt("repeticao"));
            dd.setValor(rs.getDouble("valor"));
            dd.setX(rs.getInt("x"));
            dd.setY(rs.getInt("y"));
            
            return dd;
        }else{
            return null;
        } 
    }
    /**
     * Método responsável pela listagem dos dados do DIC no banco de dados
     * @author Lara Caroline
     * @return retorna a lista de dados do DIC
     * @throws Exception possíveis exceções que podem acontecer
     */
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from dados_dic order by x, y");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        VariavelRespostaDAO vrDAO = new VariavelRespostaDAO();
        TratamentoDAO tratamentoDAO = new TratamentoDAO();
        
        while(rs.next()){
            DadoDIC dd = new DadoDIC();
            
            dd.setVariavelResposta(vrDAO.selecionar(rs.getInt("variavel_resposta")));
            dd.setTratamento(tratamentoDAO.selecionar(rs.getInt("tratamento")));
            dd.setRepeticao(rs.getInt("repeticao"));
            dd.setValor(rs.getDouble("valor"));
            dd.setX(rs.getInt("x"));
            dd.setY(rs.getInt("y"));
            
            lista.add(dd);
        } 
        return lista;
    }
    /**
     * Método responsável pela exclusão dos dados do DIC no banco de dados
     * @author Lara Caroline
     * @param variavelResposta que será excluído
     * @param tratamento que será excluído
     * @param repeticao que será excluído
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void excluir(VariavelResposta variavelResposta, Tratamento tratamento, int repeticao) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from dados_dic where variavel_resposta = ? and tratamento = ? and repeticao = ?;");
        
        pstmt.setInt(1, variavelResposta.getId());
        pstmt.setInt(2, tratamento.getId());
        pstmt.setInt(3, repeticao);
        
        pstmt.executeUpdate();
    }
    
}
