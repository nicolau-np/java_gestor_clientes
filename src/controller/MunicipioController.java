/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Municipio;

/**
 *
 * @author nicolau
 */
public class MunicipioController extends Controller{
    public Conexao conn;
  
    public List<Municipio> list(int id_province){
       List<Municipio> municipios = new ArrayList<>();
        this.sql = "select *from municipios where id_provincia=?";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.cmd.setInt(1, id_province);
            this.rs = this.cmd.executeQuery();

            while (this.rs.next()) {
                Municipio municipio = new Municipio();
                municipio.setIdMunicipio(this.rs.getInt("idMunicipio"));
                municipio.setMunicipio(this.rs.getString("municipio"));
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        }finally{
            conn.desconectar();
        }
        return municipios; 
    }
    
    public int getIdMunicipio(String municipio){
        int idMunicipio = 0;

        this.sql = "select *from municipios where municipio=?";
        try {
            this.cmd = conn.conectar().prepareStatement(this.sql);
            this.cmd.setString(1, municipio);
            this.rs = this.cmd.executeQuery();

            if (this.rs.next()) {
                idMunicipio = this.rs.getInt("idMunicipio");
            } 
        } catch (SQLException ex) {
            this.response = ex.getMessage();
        }finally{
            conn.desconectar();
        }
        
     return idMunicipio;
    }
    
}
