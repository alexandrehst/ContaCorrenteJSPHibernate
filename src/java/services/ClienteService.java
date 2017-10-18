/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configuracao.HibernateUtil;
import java.util.List;
import models.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alexandretorres
 */
public class ClienteService {
    
    public static List<Cliente> obtemClientes(){
        SessionFactory sf = null;
        Session session = null;
        List<Cliente> clientes = null;
        
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            
            String hql = "from "+ Cliente.class.getName();
            Query query = session.createQuery(hql);

           clientes = query.list();
            
        } catch (Exception e){
            e.printStackTrace();        
        } finally {
          if (session != null) session.close();
        } 
        
        return clientes;
                
    }
    
    public static boolean incluir( Cliente cliente){
        SessionFactory sf = null;
        Session session = null;
        boolean sucesso = false;
        
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
            
            sucesso = true;
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();        
        } finally {
          if (session != null) session.close();
        } 
        
        return sucesso;
                
    }
}
