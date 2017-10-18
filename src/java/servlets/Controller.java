 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import configuracao.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cliente;
import models.User;
import services.ClienteService;
import services.LoginService;

/**
 *
 * @author alexandretorres
 */
public class Controller extends HttpServlet {
    private static final String LOGIN = "login.jsp";
    private static final String CLIENTES = "Clientes.jsp";
    private static final String INCLUI_CLIENTE = "Cliente.jsp";
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
        
        switch (action){
            case "login":
                forward = LOGIN;
                break;
            case "incluir":
                forward = INCLUI_CLIENTE;
                break;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");// == null?"login":request.getParameter("action");
        String forward = "";
                
        System.out.println("No Post");
        System.out.println("Action: " + action);
        
        switch(action){
            case "login": 
                forward = login(request);
                break;
            case "incluir":
                forward = incluirCliente(request);
        }
       
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
            
    }
    
    private String login(HttpServletRequest request){
        String usuario = request.getParameter("userId");
        String senha = request.getParameter("password");
        String forward = "";
 
        LoginService ls = new LoginService();
        
        if  (ls.authenticate(usuario, senha)){ 
            forward = carregarClientes(request);
        } else {
            forward = LOGIN;
            request.setAttribute("erro", "erros encontrados");
        }
            
        return forward;
    }
    
    private String incluirCliente(HttpServletRequest request){
        
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setNome(request.getParameter("nome"));
        
        ClienteService.incluir( cliente );
        
        return carregarClientes(request);
    }

    private String carregarClientes(HttpServletRequest request){
        
        List<Cliente> clientes = ClienteService.obtemClientes();
        request.setAttribute("clientes", clientes);
        return CLIENTES;
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

}
