/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umb.mavenproject1.model;

/**
 *
 * @author user
 */
public class Database {
    private String url;
    private String user;
    private String pass;
    private String driver;
    

    public Database() {
        this.url = "jdbc:mysql://192.168.10.4:3306/umb";
        this.user = "remoto";
        this.pass = "pass";
        this.driver = "com.mysql.jdbc.Driver";
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
    public String getDriver() {
        return driver;
    }
    
 
    
}
