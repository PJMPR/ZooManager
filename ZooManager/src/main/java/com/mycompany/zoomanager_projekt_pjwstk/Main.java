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
import dao.model.RodzajJedzenia;
import dao.model.TypJedzenia;
import dao.model.Wybieg;
import dao.model.Zwierze;
import dao.model.ZwierzeDoTypJedzenia;
import dao.model.ZwierzeDoTypWybiegu;
import dao.uow.UnitOfWork;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author TKK
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dodajWybiegi();
        dodajZwierzaki();
        pobierzZwierzaka();

    }

    public static void dodajWybiegi() {
        RepositoryCatalogue repos;
        try {
            repos = new RepositoryCatalogue();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        WybiegRepository wr = repos.wybiegRepository();

        for (int i = 1; i < 11; i++) {
            //String wybieg = "wybieg"+i;
            int j = (i % 3) + 1;
            wr.add(new Wybieg(i, j, "wolny"));
        }
        repos.save();
        repos.close();

    }

    public static void dodajZwierzaki() {
        RepositoryCatalogue repos;
        try {
            repos = new RepositoryCatalogue();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        ZwierzetaRepository zr = repos.zwierzetaRepository();

        for (int i = 1; i < 11; i++) {
            //String wybieg = "wybieg"+i;
            zr.add(new Zwierze(i, "Zwierze" + i, 6, 100, null, null, i));
        }

        repos.save();
        repos.close();

    }

    public static void pobierzZwierzaka() {
        RepositoryCatalogue repos;
        try {
            repos = new RepositoryCatalogue();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        ZwierzetaRepository zr = repos.zwierzetaRepository();

        repos.zwierzeDoTypJedzeniaRepository().add(new ZwierzeDoTypJedzenia(0, 4, 3));
        repos.zwierzeDoTypWybieguRepository().add(new ZwierzeDoTypWybiegu (0, 4, 1));
        repos.zwierzeDoTypWybieguRepository().add(new ZwierzeDoTypWybiegu (0, 4, 2));
        repos.save();
        Zwierze zwierze = zr.get(4);
        System.out.println(zwierze.getNazwa());
        for(ZwierzeDoTypJedzenia zw:zwierze.getRodzajJedzenia()){
             System.out.println(RodzajJedzenia.getById(zw.getIdTypJedzenia()).toString());
        }
        repos.close();
    }

}
