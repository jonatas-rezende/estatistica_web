/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.controle;

import br.com.estatisticaweb.modelo.bo.DadoDICBO;
import br.com.estatisticaweb.modelo.bo.DadoSimplesBO;
import br.com.estatisticaweb.modelo.bo.ProjetoBO;
import br.com.estatisticaweb.modelo.bo.TratamentoBO;
import br.com.estatisticaweb.modelo.bo.VariavelRespostaBO;
import br.com.estatisticaweb.modelo.dto.DadoDIC;
import br.com.estatisticaweb.modelo.dto.DadoSimples;
import br.com.estatisticaweb.modelo.dto.EstatisticaDescritiva;
import br.com.estatisticaweb.modelo.dto.Projeto;
import br.com.estatisticaweb.modelo.dto.Tratamento;
import br.com.estatisticaweb.modelo.dto.Usuario;
import br.com.estatisticaweb.modelo.dto.VariavelResposta;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ProjetoControle", urlPatterns = {"/ProjetoControle"})
public class ProjetoControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operacao = request.getParameter("operacao");

        try {
            switch (operacao){
                case "Calcular":
                    this.calcular(request, response);
                    break;
                case "ExibirDIC":
                    this.exibirDIC(request, response);
                    break;
                case "ExibirProjetosPagina":
                    this.exibirProjetosPagina(request, response);
                    break;
                case "ExibirProjetos":
                    this.exibirProjetosPerfil(request, response);
                    break;
                case "ExibirDrops":
                    this.exibirDrops(request, response);
                    break;
                case "ExibirAprendizagem":
                    this.exibirAprendizagem(request, response);
                    break;
                case "ExibirAleatorizacao":
                    this.exibirAleatorizacao(request, response);
                    break;
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void calcular(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dados = request.getParameter("dados");

        ProjetoBO bo = new ProjetoBO();
        Double[] numeros = bo.separarDados(dados);

        EstatisticaDescritiva ed = bo.calcularEstatisticaDescritiva(numeros);

        request.setAttribute("dados", dados);
        request.setAttribute("ed", ed);
        request.setAttribute("pagina", "tela_aprendizagem.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }
    
    private void exibirDIC(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        request.setAttribute("pagina", "tela_dic.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }
    
    private void exibirProjetosPagina(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        if (usuario != null){
            ProjetoBO projetoBO = new ProjetoBO();
            List projetos = projetoBO.listarPorUsuario(usuario);
            
            request.setAttribute("projetos", projetos);
            
            request.setAttribute("pagina", "tela_projetos.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
    
    private void exibirProjetosPerfil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("pagina", "tela_projetos.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }
    
    private void exibirDrops(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("pagina", "tela_drops.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }
    
    private void exibirAprendizagem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("pagina", "tela_aprendizagem.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }
    
    private void exibirAleatorizacao(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        Projeto projeto = new Projeto();
        
        projeto.setNome(request.getParameter("projeto"));
        projeto.setUsuario(usuario);
        
        if(projeto.getId() == null){
            this.inserirProjeto(projeto, request, response);
        }
        
        VariavelResposta variavelResposta = new VariavelResposta();
        
        variavelResposta.setNome(request.getParameter("variavelResposta"));
        variavelResposta.setProjeto(projeto);
        this.inserirVariavelResposta(variavelResposta, request, response);
        
        Tratamento tratamento = new Tratamento();
        
        tratamento.setDescricao(request.getParameter("tratamento"));
        tratamento.setProjeto(projeto);
        this.inserirTratamento(tratamento, request, response);
        
        DadoDIC dadoDIC = new DadoDIC();
        
        dadoDIC.setVariavelResposta(variavelResposta);
        dadoDIC.setTratamento(tratamento);
        dadoDIC.setRepeticao(Integer.parseInt(request.getParameter("repeticao")));
        this.inserirDadoDIC(dadoDIC, request, response);*/
        
        request.setAttribute("pagina", "tela_aleatorizacao.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
        rd.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Projeto projeto = new Projeto();
        
        projeto.setNome(request.getParameter("nomeProjeto"));
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        projeto.setUsuario(usuario);
        
        if(projeto.getId() == null){
            this.inserirProjeto(projeto, request, response);
        }
        
        ProjetoBO projetoBO = new ProjetoBO();
        
        int tamanho;
        tamanho = request.getParameter("dadosCopia").length();
        
        Double[] dadosSeparados = new Double[tamanho];
        
        dadosSeparados = projetoBO.separarDados(request.getParameter("dadosCopia"));
        
        for(int i = 0; i < dadosSeparados.length; i++){
            DadoSimples dadosSimples = new DadoSimples();
            
            dadosSimples.setValor(dadosSeparados[i]);
            dadosSimples.setProjeto(projeto);
            this.inserirDadosSimples(dadosSimples, request, response);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("./ProjetoControle?operacao=ExibirProjetosPagina");
        rd.forward(request, response);
    }

    private void inserirProjeto(Projeto projeto, HttpServletRequest request, HttpServletResponse response) {
        try {
            ProjetoBO bo = new ProjetoBO();
            
            bo.inserir(projeto);
            
            request.setAttribute("mensagem", "Projeto inserido com sucesso!!");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }

    private void inserirDadosSimples(DadoSimples dados, HttpServletRequest request, HttpServletResponse response) {
        try {
            DadoSimplesBO bo = new DadoSimplesBO();
            
            bo.inserir(dados);
            request.setAttribute("mensagem", "Dados simples inserido com sucesso.");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }
    
    private void inserirVariavelResposta(VariavelResposta variavelResposta, HttpServletRequest request, HttpServletResponse response) {
        try {
            VariavelRespostaBO bo = new VariavelRespostaBO();
            
            bo.inserir(variavelResposta);
            request.setAttribute("mensagem", "Variável resposta inserida com sucesso.");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }

    private void inserirTratamento(Tratamento tratamento, HttpServletRequest request, HttpServletResponse response) {
        try {
            TratamentoBO bo = new TratamentoBO();
            
            bo.inserir(tratamento);
            request.setAttribute("mensagem", "Tratamento inserido com sucesso.");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }
    
    private void inserirDadoDIC(DadoDIC dadoDIC, HttpServletRequest request, HttpServletResponse response) {
        try {
            DadoDICBO bo = new DadoDICBO();
            
            bo.inserir(dadoDIC);
            request.setAttribute("mensagem", "Dado DIC inserido com sucesso.");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }
    
    private void alterarDadosSimples(DadoSimples dados, HttpServletRequest request, HttpServletResponse response) {
        try {
            DadoSimplesBO bo = new DadoSimplesBO();
            
            bo.alterar(dados);
            request.setAttribute("mensagem", "Dados simples alterados com sucesso.");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
    }

}
