/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author nicolau
 */
import config.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Utilizador;

public class UtilizadorController extends Controller {

    public Conexao conn;

    public int strore(Utilizador user) {

        return 1;
    }

    public String login(Utilizador user) {

        this.sql = "select *from utilizadores where utilizador=? and palavra_passe=?";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.cmd.setString(1, user.getUtilizador());
            this.cmd.setString(2, user.getPalavra_passe());
            this.rs = this.cmd.executeQuery();

            if (this.rs.next()) {
                user.setUtilizador(this.rs.getString("utilizador"));
                user.setPalavra_passe(this.rs.getString("palavra_passe"));
                user.setEstado(this.rs.getString("estado"));
                user.setAcesso(this.rs.getString("acesso"));
                this.response = "yes";
            } else {
                this.response = "no";
            }
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        }finally{
            conn.desconectar();
        }
        return this.response;
    }

    public List<Utilizador> list() {
        List<Utilizador> utilizadores = new ArrayList<>();

        return utilizadores;
    }

    public String update(Utilizador user) {
        return "hello";
    }

}
