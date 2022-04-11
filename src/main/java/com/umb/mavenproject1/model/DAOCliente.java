/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umb.mavenproject1.model;

import com.umb.mavenproject1.controller.Operations;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DAOCliente implements Operations {

    Database db = new Database();

    Cliente cliente = new Cliente();

    @Override
    public boolean add(Object obj) {
        cliente = (Cliente) obj;
        String sql = "INSERT INTO cliente(id,tipoId,nombre,apellido,usuario,contra,celular,email) VALUES (?,?,?,?,?,?,?,?)";
        Connection con;
        PreparedStatement pst;
        try {
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            pst = con.prepareCall(sql);
            pst.setInt(1, cliente.getId());
            pst.setString(2, cliente.getTipoId());
            pst.setString(3, cliente.getNombre());
            pst.setString(4, cliente.getApellido());
            pst.setString(5, cliente.getUsuario());
            pst.setString(6, cliente.getContra());
            pst.setString(7, cliente.getCelular());
            pst.setString(8, cliente.getEmail());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error :" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        cliente = (Cliente) obj;
        String sql = "UPDATE cliente SET tipoId = ?,nombre = ?,apellido = ?,"
                + "usuario = ?,contra = ?,celular = ?,email = ? "
                + "WHERE id = ?";
        Connection con;
        PreparedStatement pst;
        try {
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            pst = con.prepareCall(sql);
            pst.setString(1, cliente.getTipoId());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getUsuario());
            pst.setString(5, cliente.getContra());
            pst.setString(6, cliente.getCelular());
            pst.setString(7, cliente.getEmail());
            pst.setInt(8, cliente.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error :" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Object obj) {
        cliente = (Cliente) obj;
        String sql = "DELETE FROM cliente WHERE id = ?";
        Connection con;
        PreparedStatement pst;
        try {
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            pst = con.prepareCall(sql);
            pst.setInt(1, cliente.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error :" + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> list() {
        String sql = "SELECT * FROM Cliente";
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData meta;
        ArrayList<Object[]> datos = new ArrayList<>();
        try {
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            meta = rs.getMetaData();
            while (rs.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                datos.add(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error :" + e.getMessage());
        }
        return datos;
    }

}
