package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Usuario;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de teste para ProjetoBO.java
 * @author Lara Caroline
 */
public class ProjetoBOTest {
    /**
     * Método de teste responsável por inserir os projetos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Flavia");
            usuario.setEmail("flavia@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);

            Projeto projeto = new Projeto();
            projeto.setNome("Projeto 1");
            projeto.setQuantidadeRepeticoes(10);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
        
            projetoBO.inserir(projeto);
            
        } catch(Exception ex){
           fail("Falha ao inserir um Projeto: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por alterar os projetos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("UsuarioTeste");
        usuario.setEmail("teste@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 22");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
        } catch(Exception ex){
           fail("Falha ao inserir um Projeto: " + ex.getMessage());
        } 
        
        projeto.setNome("Projeto 2");
        projeto.setQuantidadeRepeticoes(5);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        try{
            projetoBO.alterar(projeto);
        }catch(Exception ex){
            fail("Falha ao alterar os dados do projeto: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar os projetos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("UsuarioTeste");
        usuario.setEmail("teste@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 22");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            
            int id = projeto.getId();
            
            Projeto projetoSelecionado = projetoBO.selecionar(id);
            assertNotNull("Projeto não encontrado ", projetoSelecionado);
        } catch(Exception ex){
           fail("Falha ao selecionar um Projeto: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por listar os projetos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Flavia");
            usuario.setEmail("flavia@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);
            
            List existentes = projetoBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                Projeto projeto = new Projeto();
                projeto.setNome("Projeto 1");
                projeto.setQuantidadeRepeticoes(10);
                projeto.setSignificancia(0.5);
                projeto.setTeste(2);
                projeto.setUsuario(usuario);
                
                try {
                    projetoBO.inserir(projeto);
                }catch(Exception ex){
                    fail("Falha ao inserir os projetos: " + ex.getMessage());
                }
            }
            
            List existentesFinal = projetoBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
           fail("Erro ao listar projetos: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por excluir os projetos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("UsuarioTeste");
        usuario.setEmail("teste@contato.com");
        usuario.setSenha("12345");
        
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 2");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            
            int id = projeto.getId();
            Projeto projetoSelecionado = projetoBO.selecionar(id);
            
            assertNotNull("Projeto não encontrado ", projetoSelecionado);
            
            projetoBO.excluir(id);
            Projeto projetoSelecionadoPosExclusao = projetoBO.selecionar(id);
            
            assertNull("Projeto encontrado, mesmo após excluí-lo ", projetoSelecionadoPosExclusao);
        }catch(Exception ex){
            fail("Falha ao excluir um projeto: " + ex.getMessage());
        }
    }
}
