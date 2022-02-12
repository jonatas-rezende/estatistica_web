package br.com.estatisticaweb.modelo.dao;

import br.com.estatisticaweb.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Macilon Arruda, Jonathan Silvestre Sousa, Ianka Talita, Jônatas de Souza Rezende
 */
public class UsuarioDAO extends DAOCRUDBase<Usuario> {

    /**
     * Método responsável pela inserção de um usuário no banco de dados
     * @author Macilon Arruda
     * @param dto Usuario a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir (Usuario dto) throws Exception {
       Connection conexao = getConexao();

        PreparedStatement
        pstmt = conexao.prepareStatement("insert into usuarios(nome, email, senha) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

	pstmt.setString(1, dto.getNome());
        pstmt.setString(2, dto.getEmail());
        pstmt.setString(3, dto.getSenha());

	/**
        * executa uma inserção
        */
	pstmt.executeUpdate();

        dto.setId(getId(pstmt));
    }

    /**
     * Método responsável por selecionar um usuário no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param id identificador do usuário selecionado
     * @return o usuário selecionado
     * @throws Exception - Possíveis exceções que podem acontecer
     */
    @Override
    public Usuario selecionar (int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from usuarios where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()) {
            Usuario u = new Usuario ();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));

            return u;
        }else{
            return null;
        }
    }

    /**
     * Método responsável pela alteração de dados de um usuário no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param u novos dados alterado do usuário, com o ID do usuário a ser alterado preenchido
     * @throws Exception - Possíveis exceções que podem acontecer
     */
    @Override
    public void alterar (Usuario u) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update usuarios set nome = ?, email= ?, senha = ? where id = ?");

        pstmt.setString(1, u.getNome());
        pstmt.setString(2, u.getEmail());
        pstmt.setString(3, u.getSenha());
        pstmt.setInt(4, u.getId());

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
        pstmt = conexao.prepareStatement("select * from usuarios order by nome asc");

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        while (rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));

            lista.add(u);
        }

        return lista;
    }

    @Override
    public void excluir (int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from usuarios where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

}

/**
     * Método para fazer a verificação do usuário no banco de dados
     * @author José Gilvan Jacinto Junior
     * @param email
     * @param senha
     * @return
     * @throws Exception - Possíveis exceções que podem acontecer
     */
    public Usuario logar(String email, String senha) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement  pstmt;
        pstmt = conexao.prepareStatement("select * from usuarios where email = ? and senha = ?");
        pstmt.setString(1, email);
        pstmt.setString(2, senha);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()){
            Usuario u = new Usuario();
            
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));

            return u;
        } else
           return null;
    }

    public Usuario selecionarEmail(String email) throws Exception{
	Connection conexao = getConexao();

	PreparedStatement pstmt;
	pstmt = conexao.prepareStatement("select * from usuarios where email = ?");
	pstmt.setString(1, email);

        ResultSet rs;
	rs = pstmt.executeQuery();

	if (rs.next()) {
	    Usuario u = new Usuario ();
            u.setId(rs.getInt("id"));
	    u.setNome(rs.getString("nome"));
	    u.setEmail(rs.getString("email"));
	    u.setSenha(rs.getString("senha"));

        return u;
        }

	else
            return null;
        }

    public void alterarSenha (Usuario  u) throws Exception {
       	Connection conexao = getConexao();

	PreparedStatement  pstmt;
	pstmt = conexao.prepareStatement("update usuarios set senha = ? where id = ?");
	pstmt.setString(1, u.getSenha());

        pstmt.setInt(2, u.getId());
	pstmt.executeUpdate();
    }
}
