package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de teste para UsuarioBO.java
 * @author Lara Caroline
 */
public class UsuarioBOTest {
    /**
     * Método de teste responsável por inserir os usuarios no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Flavia");
        usuario.setEmail("flavia@contato.com");
        usuario.setSenha("12345");
        
        try {
            usuarioBO.inserir(usuario);
        } catch (Exception ex) {
            fail("Falha ao inserir um Usuario: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por alterar os usuarios no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Roni");
        usuario.setEmail("ronne@contato.com");
        usuario.setSenha("135245");
        
        try {
            usuarioBO.inserir(usuario);
        } catch (Exception ex) {
            fail("Falha ao inserir o usuario: " + ex.getMessage());
        }
        
        //Mudança de dados
        usuario.setNome("Ronne");
        usuario.setEmail("ronne@contato2.com");
        usuario.setSenha("135245");
        
        try {
            usuarioBO.alterar(usuario);
        } catch (Exception ex) {
            fail("Falha ao alterar os dados do usuario: " + ex.getMessage());
        }  
    }
    /**
     * Método de teste responsável por selecionar os usuarios no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Hannah");
        usuario.setEmail("Backer@contato.com");
        usuario.setSenha("54678");
        
        try {
            usuarioBO.inserir(usuario);

            int id = usuario.getId();

            Usuario usuarioSelecionado = usuarioBO.selecionar(id);

            assertNotNull("Usuário não encontrado ", usuarioSelecionado);
        } catch (Exception ex) {
            fail("Falha ao selecionar o usuario: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por listar os usuarios no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        
        try{
            List existentes = usuarioBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                Usuario usuario = new Usuario();
                usuario.setNome("ana");
                usuario.setEmail("ana@");
                usuario.setSenha("123");
                
                try {
                    usuarioBO.inserir(usuario);
                } catch (Exception ex) {
                    fail("Falha ao inserir os usuários " + ex.getMessage());
                }
            }
            
            List existentesFinal = usuarioBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por excluir os usuarios no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Roni");
        usuario.setEmail("ronne@contato.com");
        usuario.setSenha("135245");
        
        try {
            usuarioBO.inserir(usuario);

            int id = usuario.getId();
            Usuario usuarioSelecionado = usuarioBO.selecionar(id);
            
            assertNotNull("Usuário não encontrado", usuarioSelecionado);
            
            usuarioBO.excluir(id);
            Usuario usuarioSelecionadoPosExclusao = usuarioBO.selecionar(id);
            
            assertNull("Usuário encontrado, mesmo após excluí-lo", usuarioSelecionadoPosExclusao);
            
        } catch (Exception ex){
            fail("Falha ao excluir um usuário: " + ex.getMessage());
        }
    }
}
