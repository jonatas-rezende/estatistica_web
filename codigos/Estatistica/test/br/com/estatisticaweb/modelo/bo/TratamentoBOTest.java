/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.bo;

import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Tratamento;
import br.com.estatisticaweb.modelo.dto.Usuario;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de teste para TratamentoBO.java
 * @author Lara
 */
public class TratamentoBOTest {
    /**
     * Método de teste responsável por inserir os tratamentos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        
        try{
            Usuario usuario = new Usuario();
            usuario.setNome("Mari");
            usuario.setEmail("marina@contato.com");
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
            
        } catch(Exception ex){
           fail("Falha ao inserir um tratamento: " + ex.getMessage());
        } 
    }
    
    /**
     * Método de teste responsável por alterar os tratamentos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar(){
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        
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
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 10");
        tratamento.setProjeto(projeto);

        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
        } catch(Exception ex){
           fail("Falha ao inserir um tratamento: " + ex.getMessage());
        } 
        
        tratamento.setDescricao("tipo 2");
        tratamento.setProjeto(projeto);
        
        try{
            tratamentoBO.alterar(tratamento);
        }catch(Exception ex){
            fail("Falha ao alterar os dados do tratamento: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar os tratamentos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
         
        Usuario usuario = new Usuario();
        usuario.setNome("Enzo");
        usuario.setEmail("enzo@contato.com");
        usuario.setSenha("1234");

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 3");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 3");
        tratamento.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
            
            int id = tratamento.getId();
            
            Tratamento tratamentoSelecionado = tratamentoBO.selecionar(id);
            assertNotNull("Tratamento não encontrado ", tratamentoSelecionado);
            
        } catch(Exception ex){
           fail("Falha ao selecionar um tratamento: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por listar os tratamentos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        
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
            
            List existentes = tratamentoBO.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 4;
            for (int i = 0; i < 4; i++){
                Tratamento tratamento = new Tratamento();
                tratamento.setDescricao("tipo 4");
                tratamento.setProjeto(projeto);
                
                try {
                    tratamentoBO.inserir(tratamento);
                }catch(Exception ex){
                    fail("Falha ao inserir os tratamentos: " + ex.getMessage());
                }
            }
            
            List existentesFinal = tratamentoBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        } catch(Exception ex){
           fail("Erro ao listar tratamentos: " + ex.getMessage());
        } 
    }
    /**
     * Método de teste responsável por excluir os tratamentos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        UsuarioBO usuarioBO = new UsuarioBO();
        ProjetoBO projetoBO = new ProjetoBO();
        TratamentoBO tratamentoBO = new TratamentoBO();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Sophia");
        usuario.setEmail("sophia@contato.com");
        usuario.setSenha("12345");
        
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto 5");
        projeto.setQuantidadeRepeticoes(3);
        projeto.setSignificancia(0.5);
        projeto.setTeste(1);
        projeto.setUsuario(usuario);
        
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao("tipo 5");
        tratamento.setProjeto(projeto);
        
        try{
            usuarioBO.inserir(usuario);
            projetoBO.inserir(projeto);
            tratamentoBO.inserir(tratamento);
            
            int id = tratamento.getId();
            Tratamento tratamentoSelecionado = tratamentoBO.selecionar(id);
            
            assertNotNull("Tratamento não encontrado ", tratamentoSelecionado);
            
            tratamentoBO.excluir(id);
            Tratamento tratamentoSelecionadoPosExclusao = tratamentoBO.selecionar(id);
            
            assertNull("Tratamento encontrado, mesmo após excluí-lo ", tratamentoSelecionadoPosExclusao);
        }catch(Exception ex){
            fail("Falha ao excluir um tratamento: " + ex.getMessage());
        }
    }
}
