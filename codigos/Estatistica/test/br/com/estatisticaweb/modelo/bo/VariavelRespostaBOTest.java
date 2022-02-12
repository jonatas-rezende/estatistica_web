package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Usuario;
import br.com.estatisticaweb.modelo.dto.VariavelResposta;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de teste para VariavelRespostaBO.java
 * @author Lara Caroline
 */
public class VariavelRespostaBOTest {
    /**
     * Método de teste responsável por inserir a variável resposta no banco de dados
     * @author Lara Caroline
     */
    //@Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        
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
            
            VariavelResposta vr = new VariavelResposta();
            vr.setNome("altura");
            vr.setProjeto(projeto);
            
            vrBO.inserir(vr);
            
            
            
        } catch(Exception ex){
           fail("Falha ao inserir uma variável resposta: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por alterar a variavel resposta no banco de dados
     * @author Lara Caroline
     */
    //@Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail("mary@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 2");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("altura");
        vr.setProjeto(projeto);

        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            vrBO.inserir(vr);
        } catch(Exception ex){
           fail("Falha ao inserir uma variável resposta: " + ex.getMessage());
        } 
        
        vr.setNome("tamanho");
        vr.setProjeto(projeto);
        
        try{
            vrBO.alterar(vr);
        }catch(Exception ex){
            fail("Falha ao alterar os dados da variável resposta: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar a variável resposta no banco de dados
     * @author Lara Caroline
     */
    //@Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail("mary@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 3");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("x1");
        vr.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            vrBO.inserir(vr);
            
            int id = vr.getId();
            
            VariavelResposta vrSelecionada = vrBO.selecionar(id);
            assertNotNull("Variável resposta não encontrada ", vrSelecionada);
        } catch(Exception ex){
           fail("Falha ao selecionar uma variável resposta: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por listar as variáveis respostas no banco de dados
     * @author Lara Caroline
     */
    //@Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Flavia");
            usuario.setEmail("flavia@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);
            
            Projeto projeto = new Projeto();
            projeto.setNome("Projeto 4");
            projeto.setQuantidadeRepeticoes(10);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
            projetoBO.inserir(projeto);
            
            List existentes = vrBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                VariavelResposta vr = new VariavelResposta();
                vr.setNome("y1");
                vr.setProjeto(projeto);
                
                try {
                    vrBO.inserir(vr);
                }catch(Exception ex){
                    fail("Falha ao inserir as variáveis respostas: " + ex.getMessage());
                }
            }
            
            List existentesFinal = vrBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
           fail("Erro ao listar as variáveis respostas: " + ex.getMessage());
        } 
    }
    
    /**
     * Método de teste responsável por excluir a variável resposta no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail("mary@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 5");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("exclusão");
        vr.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            vrBO.inserir(vr);
            
            int id = vr.getId();
            VariavelResposta vrSelecionada = vrBO.selecionar(id);
            
            assertNotNull("Variável resposta não encontrada ", vrSelecionada);
            
            vrBO.excluir(id);
            VariavelResposta vrSelecionadaPosExclusao = vrBO.selecionar(id);
            
            assertNull("Variável resposta encontrada, mesmo após excluí-la ", vrSelecionadaPosExclusao);
        }catch(Exception ex){
            fail("Falha ao excluir uma variável resposta: " + ex.getMessage());
        }
    }
}
