/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Conexao;
import java.sql.SQLException;
import model.Pessoa;

/**
 *
 * @author nicolau
 */
public class PessoaController extends Controller{
    
    public Conexao conn;
    
    public int store(Pessoa pessoa){
        int idPessoa = 0;
        this.sql = "insert into pessoas(id_municipio, nome, genero, data_nascimento, telefone, foto, estado) "
                + "values(?, ?, ?, ?, ?, ?, ?)";
        try {

            this.cmd = conn.conectar().prepareStatement(sql);
            this.cmd.setInt(1, pessoa.getIdPessoa());
            this.cmd.setString(2, pessoa.getNome());
            this.cmd.setString(3, pessoa.getGenero());
            this.cmd.setString(4, pessoa.getData_nascimento());
            this.cmd.setInt(5, pessoa.getTelefone());
            this.cmd.setString(6, pessoa.getFoto());
            this.cmd.setString(7, pessoa.getEstado());
            idPessoa = this.cmd.executeUpdate();

        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return idPessoa;
    }
}
