/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Conexao;
import java.sql.SQLException;
import java.sql.Statement;
import model.Pessoa;

/**
 *
 * @author nicolau
 */
public class PessoaController extends Controller{
    
    public Conexao conn;
    
    public String store(Pessoa pessoa){
        
        this.sql = "insert into pessoas(id_municipio, nome, genero, data_nascimento, telefone, foto, estado) "
                + "values(?, ?, ?, ?, ?, ?, ?)";
        try {

            this.cmd = conn.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.cmd.setInt(1, pessoa.getId_municipio());
            this.cmd.setString(2, pessoa.getNome());
            this.cmd.setString(3, pessoa.getGenero());
            this.cmd.setString(4, pessoa.getData_nascimento());
            this.cmd.setInt(5, pessoa.getTelefone());
            this.cmd.setString(6, pessoa.getFoto());
            this.cmd.setString(7, pessoa.getEstado());
            this.cmd.executeUpdate();
            this.rs = this.cmd.getGeneratedKeys();
            if(this.rs.next()){
                pessoa.setIdPessoa(this.rs.getInt(1));
                this.response = "yes";
            }

        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return this.response;
    }
}
