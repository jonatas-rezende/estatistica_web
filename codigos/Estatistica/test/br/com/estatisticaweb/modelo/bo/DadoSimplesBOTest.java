package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.DadoSimples;
import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Usuario;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de teste para DadoSimplesBO.java
 * @author Lara Caroline
 */
public class DadoSimplesBOTest {
    /**
     * Método de teste responsável por inserir os dados simples no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        DadoSimplesBO dadoSimplesBO = new DadoSimplesBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("José");
            usuario.setEmail("jose@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);

            Projeto projeto = new Projeto();
            projeto.setNome("Projeto Teste 1");
            projeto.setQuantidadeRepeticoes(10);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
            projetoBO.inserir(projeto);
            
            DadoSimples dadoSimples = new DadoSimples();
            dadoSimples.setValor(1.2);
            dadoSimples.setProjeto(projeto);
            
            dadoSimplesBO.inserir(dadoSimples);
        } catch(Exception ex){
           fail("Falha ao inserir um dado simples: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por alterar os dados simples no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        DadoSimplesBO dadoSimplesBO = new DadoSimplesBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("José");
        usuario.setEmail("jose@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste 1");
        projeto.setQuantidadeRepeticoes(10);
        projeto.setSignificancia(0.5);
        projeto.setTeste(2);
        projeto.setUsuario(usuario);
        
        DadoSimples dadoSimples = new DadoSimples();
        dadoSimples.setValor(1.2);
        dadoSimples.setProjeto(projeto);

        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            dadoSimplesBO.inserir(dadoSimples);
        } catch(Exception ex){
           fail("Falha ao inserir um dado simples: " + ex.getMessage());
        } 
        
        dadoSimples.setValor(1.0);
        dadoSimples.setProjeto(projeto);
        
        try{
            dadoSimplesBO.alterar(dadoSimples);
        }catch(Exception ex){
            fail("Falha ao alterar os dados da tabela dados simples: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar os dados simples no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        DadoSimplesBO dadoSimplesBO = new DadoSimplesBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail("mary@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste 3");
        projeto.setQuantidadeRepeticoes(4);
        projeto.setSignificancia(1.0);
        projeto.setTeste(3);
        projeto.setUsuario(usuario);
        
        DadoSimples dadoSimples = new DadoSimples();
        dadoSimples.setValor(1.7);
        dadoSimples.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            dadoSimplesBO.inserir(dadoSimples);
            
            int id = dadoSimples.getId();
            
            DadoSimples dadoSimplesSelecionado = dadoSimplesBO.selecionar(id);
            assertNotNull("Dado simples não encontrado ", dadoSimplesSelecionado);
            
        } catch(Exception ex){
           fail("Falha ao selecionar um dado simples " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por listar os dados simples no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        DadoSimplesBO dadoSimplesBO = new DadoSimplesBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Lucia");
            usuario.setEmail("lucia@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);
            
            Projeto projeto = new Projeto();
            projeto.setNome("Projeto Teste 4");
            projeto.setQuantidadeRepeticoes(6);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
            projetoBO.inserir(projeto);
            
            List existentes = dadoSimplesBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                DadoSimples dadoSimples = new DadoSimples();
                dadoSimples.setValor(2.0);
                dadoSimples.setProjeto(projeto);
                
                try {
                    dadoSimplesBO.inserir(dadoSimples);
                }catch(Exception ex){
                    fail("Falha ao inserir os dados simples: " + ex.getMessage());
                }
            }
            
            List existentesFinal = dadoSimplesBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
           fail("Erro ao listar os dados simples: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por excluir os dados simples no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        DadoSimplesBO dadoSimplesBO = new DadoSimplesBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Juliana");
        usuario.setEmail("jujuba@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste 5");
        projeto.setQuantidadeRepeticoes(5);
        projeto.setSignificancia(1.8);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        DadoSimples dadoSimples = new DadoSimples();
        dadoSimples.setValor(1.2);
        dadoSimples.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            dadoSimplesBO.inserir(dadoSimples);
            
            int id = dadoSimples.getId();
            DadoSimples dadoSimplesSelecionado = dadoSimplesBO.selecionar(id);
            
            assertNotNull("Dado simples não encontrado ", dadoSimplesSelecionado);
            
            dadoSimplesBO.excluir(id);
            DadoSimples dadoSimplesSelecionadoPosExclusao = dadoSimplesBO.selecionar(id);
            
            assertNull("Dado simples encontrado, mesmo após excluí-lo ", dadoSimplesSelecionadoPosExclusao);
        }catch(Exception ex){
            fail("Falha ao excluir um dado simples: " + ex.getMessage());
        }
    }
}
