 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
                forward = incluir(request);
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
            request.setAttribute("clientes", Cliente.getClientes());
            forward = CLIENTES;
        } else {
            forward = LOGIN;
            request.setAttribute("erro", "erros encontrados");
        }
        return forward;
    }
    
    private String incluir(HttpServletRequest request){
        
        List<Cliente> clientes = Cliente.getClientes();
        Cliente c = clientes.get( clientes.size() - 1);
        
        Cliente cliente = new Cliente( c.getId() + 1,
                request.getParameter("nome"), 
                request.getParameter("cpf"));
        
        clientes.add( cliente);
        request.setAttribute("sucesso", "sucesso");
  
        return INCLUI_CLIENTE;
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
