/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author nicolau
 */
public class Cliente extends Pessoa{
    private int idCliente;
    private int id_pessoa;
    private String estado;
    private String created_at;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DateTimeFormatter getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTimeFormatter created_at) {
        this.created_at = created_at;
    }
    
    
}
