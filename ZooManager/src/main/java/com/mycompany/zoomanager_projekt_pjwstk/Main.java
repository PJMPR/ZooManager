/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zoomanager_projekt_pjwstk;

import dao.ZwierzetaRepository;
import dao.mappers.ZwierzeMapper;
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
            connection = DriverManager.getConnection(" url do bazy danych");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        UnitOfWork zwierzetaUnitWork = new UnitOfWork(connection);
        ZwierzetaRepository zwierzeRepo = new ZwierzetaRepository(connection, new ZwierzeMapper(), zwierzetaUnitWork);

        Zwierze zweirzeObiekt = new Zwierze();
        zwierzeRepo.add(zweirzeObiekt);
        zwierzeRepo.delete(zweirzeObiekt);

        zwierzeRepo.getUnitWork().saveChanges();
        
         try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // TODO code application logic here
    }

}
