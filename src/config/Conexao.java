/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nicolau
 */
public class Conexao {

    public Conexao() {

    }

    public static Connection conectar() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "gestao_clientes";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?characterEncoding=utf8";
            String username = "root";
            String password = "Np@2015b";

            connection = DriverManager.getConnection(url, username, password);

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados." + e.getMessage());
            return null;
        }
    }

    public static boolean desconectar() {

        try {
            Conexao.conectar().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Connection ReiniciarConexao() {
        desconectar();

        return Conexao.conectar();
    }
}
