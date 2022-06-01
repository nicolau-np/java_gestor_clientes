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
import model.User;

public class UserController extends Controller {

    public Conexao conn;

    public int strore(User user) {

        return 1;
    }

    public String login(User user) {

        return "hello";
    }

    public List<User> list() {
        List<User> utilizadores = new ArrayList<>();

        return utilizadores;
    }

    public String update(User user) {
        return "hello";
    }

}
