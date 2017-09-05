/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandretorres
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;

    public static List getClientes(){
        
        List<Cliente> clientes = new ArrayList<>();
        clientes.add( new Cliente( 1, "Frodo Baggins", "2345678909"));
        clientes.add( new Cliente( 2, "Bilbo Baggins", "48732682912"));
        clientes.add( new Cliente( 3, "Sauron Corintians", "38576139571"));
        clientes.add( new Cliente( 4, "Galadriel Diva", "57084290572"));
        clientes.add( new Cliente( 5, "Nazgul Flamenguista", "2849750284"));
        
        return clientes;
        
    }
    
    public Cliente(int id, String nome, String cpf){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
