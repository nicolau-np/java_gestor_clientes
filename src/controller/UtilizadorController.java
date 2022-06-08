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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Utilizador;

public class UtilizadorController extends Controller {

    public Conexao conn;

    public String store(Utilizador utilizador) {

        this.sql = "insert into utilizadores(id_pessoa, utilizador, palavra_passe, acesso, estado) "
                + "values(?, ?, ?, ?, ?)";
        try {

            this.cmd = conn.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.cmd.setInt(1, utilizador.getId_pessoa());
            this.cmd.setString(2, utilizador.getUtilizador());
            this.cmd.setString(3, utilizador.getPalavra_passe());
            this.cmd.setString(4, utilizador.getAcesso());
            this.cmd.setString(5, utilizador.getEstado());
            this.cmd.executeUpdate();
            this.rs = this.cmd.getGeneratedKeys();
            if (this.rs.next()) {
                utilizador.setIdUtilizador(this.rs.getInt(1));
                this.response = "yes";
            }

        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return this.response;
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
        this.sql = "select *from ulilizador_view";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.rs = this.cmd.executeQuery();

            while (this.rs.next()) {
                Utilizador utilizador = new Utilizador();
                utilizador.setIdUtilizador(this.rs.getInt("idUtilzador"));
                utilizador.setNome(this.rs.getString("nome"));
                utilizador.setTelefone(this.rs.getInt("telefone"));
                utilizador.setGenero(this.rs.getString("genero"));
                utilizador.setData_nascimento(this.rs.getString("data_nascimento"));
                utilizador.setProvincia(this.rs.getString("provincia"));
                utilizador.setMunicipio(this.rs.getString("municipio"));
                utilizador.setUtilizador(this.rs.getString("utilizador"));
                utilizador.setAcesso(this.rs.getString("acesso"));
                
                utilizadores.add(utilizador);
                
                System.out.println(utilizadores);
            }
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return utilizadores;
    }

    public String update(Utilizador user) {
        return "hello";
    }

}
