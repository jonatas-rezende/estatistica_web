package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.DadoDIC;
import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Tratamento;
import br.com.estatisticaweb.modelo.dto.Usuario;
import br.com.estatisticaweb.modelo.dto.VariavelResposta;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de teste para DadoDICBO.java
 * @author Lara Caroline
 */
public class DadoDICBOTest {
    /**
     * Método de teste responsável por inserir o DIC no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        DadoDICBO dadoDICBO = new DadoDICBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Lara");
            usuario.setEmail("lara@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);

            Projeto projeto = new Projeto();
            projeto.setNome("Projeto 1");
            projeto.setQuantidadeRepeticoes(10);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
            projetoBO.inserir(projeto);
            
            Tratamento tratamento = new Tratamento();
            tratamento.setDescricao("tipo 1");
            tratamento.setProjeto(projeto);
            tratamentoBO.inserir(tratamento);
            
            VariavelResposta vr = new VariavelResposta();
            vr.setNome("altura");
            vr.setProjeto(projeto);
            vrBO.inserir(vr);
            
            DadoDIC dadoDIC = new DadoDIC();
            dadoDIC.setVariavelResposta(vr);
            dadoDIC.setTratamento(tratamento);
            dadoDIC.setRepeticao(1);
            dadoDIC.setValor(1.1);
            dadoDIC.setX(2);
            dadoDIC.setY(2);
            
            dadoDICBO.inserir(dadoDIC);
        } catch(Exception ex){
           fail("Falha ao inserir um Dado DIC: " + ex.getMessage());
        } 
    }
    
    /**
     * Método de teste responsável por alterar o DIC no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        DadoDICBO dadoDICBO = new DadoDICBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Lara");
        usuario.setEmail("lara@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 1");
        projeto.setQuantidadeRepeticoes(10);
        projeto.setSignificancia(0.5);
        projeto.setTeste(2);
        projeto.setUsuario(usuario);
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 10");
        tratamento.setProjeto(projeto);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("altura");
        vr.setProjeto(projeto);
        
        DadoDIC dadoDIC = new DadoDIC();
        dadoDIC.setVariavelResposta(vr);
        dadoDIC.setTratamento(tratamento);
        dadoDIC.setRepeticao(1);
        dadoDIC.setValor(1.1);
        dadoDIC.setX(2);
        dadoDIC.setY(2);

        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
            vrBO.inserir(vr);
            dadoDICBO.inserir(dadoDIC);
        } catch(Exception ex){
           fail("Falha ao inserir um DIC: " + ex.getMessage());
        } 
        
        dadoDIC.setVariavelResposta(vr);
        dadoDIC.setTratamento(tratamento);
        dadoDIC.setRepeticao(2);
        dadoDIC.setValor(1.2);
        dadoDIC.setX(4);
        dadoDIC.setY(4);
        
        try{
            dadoDICBO.alterar(dadoDIC);
        }catch(Exception ex){
            fail("Falha ao alterar o DIC: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar os DICs no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        DadoDICBO dadoDICBO = new DadoDICBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Lara");
        usuario.setEmail("lara@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 1");
        projeto.setQuantidadeRepeticoes(10);
        projeto.setSignificancia(0.5);
        projeto.setTeste(2);
        projeto.setUsuario(usuario);
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 10");
        tratamento.setProjeto(projeto);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("altura");
        vr.setProjeto(projeto);
        
        DadoDIC dadoDIC = new DadoDIC();
        dadoDIC.setVariavelResposta(vr);
        dadoDIC.setTratamento(tratamento);
        dadoDIC.setRepeticao(1);
        dadoDIC.setValor(1.3);
        dadoDIC.setX(3);
        dadoDIC.setY(3);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
            vrBO.inserir(vr);
            dadoDICBO.inserir(dadoDIC);
            
            VariavelResposta vr2 = dadoDIC.getVariavelResposta();
            Tratamento tratamento2 = dadoDIC.getTratamento();
            int repeticao = dadoDIC.getRepeticao();
            
            DadoDIC dadoDICSelecionado = dadoDICBO.selecionar(vr2, tratamento2, repeticao);
            assertNotNull("DIC não encontrado ", dadoDICSelecionado);
            
        } catch(Exception ex){
           fail("Falha ao selecionar um DIC: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por listar os DICs no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        DadoDICBO dadoDICBO = new DadoDICBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Lara");
            usuario.setEmail("lara@contato.com");
            usuario.setSenha("1234");
            usuarioBO.inserir(usuario);

            Projeto projeto = new Projeto();
            projeto.setNome("Projeto 1");
            projeto.setQuantidadeRepeticoes(10);
            projeto.setSignificancia(0.5);
            projeto.setTeste(2);
            projeto.setUsuario(usuario);
            projetoBO.inserir(projeto);
            
            Tratamento tratamento = new Tratamento();
            tratamento.setDescricao("tipo 1");
            tratamento.setProjeto(projeto);
            tratamentoBO.inserir(tratamento);
            
            VariavelResposta vr = new VariavelResposta();
            vr.setNome("altura");
            vr.setProjeto(projeto);
            vrBO.inserir(vr);
            
            List existentes = dadoDICBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                DadoDIC dadoDIC = new DadoDIC();
                dadoDIC.setVariavelResposta(vr);
                dadoDIC.setTratamento(tratamento);
                dadoDIC.setRepeticao(i);
                dadoDIC.setValor(1.4);
                dadoDIC.setX(5);
                dadoDIC.setY(5);
                try {
                    dadoDICBO.inserir(dadoDIC);
                }catch(Exception ex){
                    fail("Falha ao inserir os DICs: " + ex.getMessage());
                }
            }
            
            List existentesFinal = dadoDICBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
           fail("Erro ao listar os DICs: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por excluir os DICs no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        VariavelRespostaBO vrBO = new VariavelRespostaBO();
        DadoDICBO dadoDICBO = new DadoDICBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Lara");
        usuario.setEmail("lara@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 1");
        projeto.setQuantidadeRepeticoes(10);
        projeto.setSignificancia(0.5);
        projeto.setTeste(2);
        projeto.setUsuario(usuario);
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 10");
        tratamento.setProjeto(projeto);
        
        VariavelResposta vr = new VariavelResposta();
        vr.setNome("altura");
        vr.setProjeto(projeto);
        
        DadoDIC dadoDIC = new DadoDIC();
        dadoDIC.setVariavelResposta(vr);
        dadoDIC.setTratamento(tratamento);
        dadoDIC.setRepeticao(45);
        dadoDIC.setValor(1.3);
        dadoDIC.setX(3456);
        dadoDIC.setY(34321);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
            vrBO.inserir(vr);
            dadoDICBO.inserir(dadoDIC);
            
            VariavelResposta vr2 = dadoDIC.getVariavelResposta();
            Tratamento tratamento2 = dadoDIC.getTratamento();
            int repeticao = dadoDIC.getRepeticao();
            
            DadoDIC dadoDICSelecionado = dadoDICBO.selecionar(vr2, tratamento2, repeticao);
            assertNotNull("DIC não encontrado ", dadoDICSelecionado);
            
            dadoDICBO.excluir(vr2, tratamento2, repeticao);
            DadoDIC dadoDICSelecionadoPosExclusao = dadoDICBO.selecionar(vr2, tratamento2, repeticao);
            
            assertNull("DIC encontrado, mesmo após excluí-lo ", dadoDICSelecionadoPosExclusao);
        }catch(Exception ex){
            fail("Falha ao excluir um DIC: " + ex.getMessage());
        }
    }
}