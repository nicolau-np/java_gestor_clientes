/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Conexao;
import model.Provincia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolau
 */
public class ProvinciaController extends Controller {

    public Conexao conn;

    public int getIdProvincia(String provincia) {
        int idProvincia = 0;

        this.sql = "select *from provincias where provincia=?";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.cmd.setString(1, provincia);
            this.rs = this.cmd.executeQuery();

            if (this.rs.next()) {
                idProvincia = this.rs.getInt("idProvincia");
            } 
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        }finally{
            conn.desconectar();
        }
        
     return idProvincia;   
    }

    public List<Provincia> list() {
        List<Provincia> provincias = new ArrayList<>();
        this.sql = "select *from provincias";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.rs = this.cmd.executeQuery();

            while (this.rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setIdProvincia(this.rs.getInt("idProvincia"));
                provincia.setProvincia(this.rs.getString("provincia"));
                provincias.add(provincia);
            }
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        } finally {
            conn.desconectar();
        }
        return provincias;
    }

}
