/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zoomanager_projekt_pjwstk;

import dao.PracownikRepository;
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        UnitOfWork zwierzetaUnitWork = new UnitOfWork(connection);
        TypJedzeniaRepository typRepo = new TypJedzeniaRepository(connection, new TypJedzeniaMapper(), new UnitOfWork(connection));
        TypWybieguRepository jedzRepo = new TypWybieguRepository(connection, new TypWybieguMapper(), new UnitOfWork(connection));
            WybiegRepository wybiegRepo = new WybiegRepository(connection, new WybiegMapper(), new UnitOfWork(connection));
        ZwierzeDoTypJedzeniaRepository zwDoJedz = new ZwierzeDoTypJedzeniaRepository(connection, new ZwierzeDoTypJedzMapper(), new UnitOfWork(connection));
        ZwierzeDoTypWybieguRepository zwDoWyb = new ZwierzeDoTypWybieguRepository(connection, new ZwierzeDoTypWybMapper(), new UnitOfWork(connection));
        ZwierzetaRepository zwierzeRepo = new ZwierzetaRepository(connection, new ZwierzeMapper(), new UnitOfWork(connection));
        PracownikRepository pracownikRepo = new PracownikRepository(connection, new PracownikMapper(), new UnitOfWork(connection));
            
        
        Wybieg wybieg1 = new Wybieg(1, 3, "1");
        Zwierze zwierze1 = new Zwierze(1, "Miau", 6, 100, null, null, 354);
        
        wybiegRepo.add(wybieg1);
        wybiegRepo.getUnitWork().saveChanges();
        zwierzeRepo.add(zwierze1);
        zwierzeRepo.getUnitWork().saveChanges();
        
        
        Zwierze newZw1 = zwierzeRepo.get(3);
        Zwierze newZw2 = newZw1;
        

        //Zwierze zweirzeObiekt = new Zwierze();
        
       
        //zwierzeRepo.add(zweirzeObiekt);
        //zwierzeRepo.delete(zweirzeObiekt);

        zwierzeRepo.getUnitWork().saveChanges();
        
         try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // TODO code application logic here
    }

}
