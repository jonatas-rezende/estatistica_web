package br.com.estatisticaweb.controle;

import br.com.estatisticaweb.modelo.bo.ProjetoBO;
import br.com.estatisticaweb.modelo.bo.UsuarioBO;
import br.com.estatisticaweb.modelo.dto.Usuario;
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
 * @author Lara Caroline
 */
@WebServlet(name = "UsuarioControle", urlPatterns = {"/UsuarioControle"})
public class UsuarioControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operacao = request.getParameter("operacao");

        try {
            switch (operacao){
                case "Logar":
                    this.logar(request, response);
                    break;                    
                case "Perfil":
                    this.mostrarPerfil(request, response);
                    break;
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
                case "Sair":
                    this.sair(request, response);
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Usuario usuario = new Usuario();  
        
        if (!"".equals(request.getParameter("id").trim()))
            usuario.setId(Integer.parseInt(request.getParameter("id")));
        
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        
        request.setAttribute("usuario", usuario);
        
        try {
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            request.getSession().setAttribute("usuario", usuario);
            
            request.setAttribute("pagina", "tela_aprendizagem.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
            rd.forward(request, response);
            
            /*request.setAttribute("mensagem", "Cadastro realizado com sucesso! Faça seu Login!");
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);*/
        } catch (Exception ex){
            request.setAttribute("erro", "Erro: " + ex.getMessage());
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
        return "Servlet de usuários";
    }// </editor-fold>


    private void logar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioBO bo = new UsuarioBO();
        Usuario usuario = bo.logar(email, senha);

        if (usuario != null){
            request.setAttribute("usuario", usuario);

            request.getSession().setAttribute("usuario", usuario);
            
            request.setAttribute("pagina", "tela_aprendizagem.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("erro", "Usuário ou senha inválidos");

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    private void mostrarPerfil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        if (usuario != null){
            ProjetoBO projetoBO = new ProjetoBO();
            List projetos = projetoBO.listarUltimos(usuario);
            
            request.setAttribute("projetos", projetos);
            
            request.setAttribute("pagina", "perfil.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("./paginas/layout.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        request.getSession().invalidate();
        
        request.setAttribute("erro", "Você foi desconectado!");

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
}
