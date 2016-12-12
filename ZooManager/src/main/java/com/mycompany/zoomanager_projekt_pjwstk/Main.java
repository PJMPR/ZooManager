/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zoomanager_projekt_pjwstk;

import dao.PracownikRepository;
import dao.RepositoryCatalogue;
import dao.TypJedzeniaRepository;
import dao.TypWybieguRepository;
import dao.WybiegRepository;
import dao.ZwierzeDoTypJedzeniaRepository;
import dao.ZwierzeDoTypWybieguRepository;
import dao.ZwierzetaRepository;
import dao.mappers.PracownikMapper;
import dao.mappers.TypJedzeniaMapper;
import dao.mappers.TypWybieguMapper;
import dao.mappers.WybiegMapper;
import dao.mappers.ZwierzeDoTypJedzMapper;
import dao.mappers.ZwierzeDoTypWybMapper;
import dao.mappers.ZwierzeMapper;
import dao.model.TypJedzenia;
import dao.model.Wybieg;
import dao.model.Zwierze;
import dao.uow.UnitOfWork;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RepositoryCatalogue repos;
        try{
         repos = new RepositoryCatalogue();
        }catch(SQLException e){
            e.printStackTrace();
            return;
        }
        
        repos.wybiegRepository();
        
        
        repos.save();
        repos.close();
        
        
    }

}
