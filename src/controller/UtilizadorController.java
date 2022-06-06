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

    public int store(Utilizador utilizador) {
        int idUser = 0;
        this.sql = "insert into utilizadores(id_pessoa, utilizador, palavra_passe, acesso, estado) "
                + "values(?, ?, ?, ?, ?)";
        try {

            this.cmd = conn.conectar().prepareStatement(sql);
            this.cmd.setInt(1, utilizador.getId_pessoa());
            this.cmd.setString(2, utilizador.getUtilizador());
            this.cmd.setString(3, utilizador.getPalavra_passe());
            this.cmd.setString(4, utilizador.getAcesso());
            this.cmd.setString(5, utilizador.getEstado());
            idUser = this.cmd.executeUpdate();

        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return idUser;
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
        } finally {
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
