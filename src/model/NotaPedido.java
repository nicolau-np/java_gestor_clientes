/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nicolau
 */
public class NotaPedido {
    private int idNotaPedido;
    private int id_fornecedor;
    private int id_utilizador;
    private String tipo_nota;
    private String estado;

    public int getIdNotaPedido() {
        return idNotaPedido;
    }

    public void setIdNotaPedido(int idNotaPedido) {
        this.idNotaPedido = idNotaPedido;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public String getTipo_nota() {
        return tipo_nota;
    }

    public void setTipo_nota(String tipo_nota) {
        this.tipo_nota = tipo_nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
