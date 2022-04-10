/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umb.mavenproject1.controller;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface Operations {

    public boolean add(Object obj);

    public boolean update(Object obj);

    public boolean delete(Object obj);

    public ArrayList<Object[]> list();
    

}
