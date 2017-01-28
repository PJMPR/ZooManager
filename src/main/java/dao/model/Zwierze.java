/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.model;

import dao.RepositoryCatalogue;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TKK
 */
public class Zwierze implements IHaveId {

    private Integer id;
    private String nazwa;
    private static final int MAX_NAJEDZENIE = 100;
    private Integer tempoJedzenia;
    private Integer poziomNajedzenia;

    public Zwierze(Integer id, String nazwa, Integer tempoJedzenia, Integer poziomNajedzenia) {
        this.id = id;
        this.nazwa = nazwa;
        this.tempoJedzenia = tempoJedzenia;
        this.poziomNajedzenia = poziomNajedzenia;
    }

    public Zwierze() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setTempoJedzenia(int tempoJedzenia) {
        this.tempoJedzenia = tempoJedzenia;
    }

    public void setPoziomNajedzenia(Integer poziomNajedzenia) {
        this.poziomNajedzenia = poziomNajedzenia;
    }


    public String getNazwa() {
        return nazwa;
    }

    public static int getMAX_NAJEDZENIE() {
        return MAX_NAJEDZENIE;
    }

    public int getTempoJedzenia() {
        return tempoJedzenia;
    }




    @Override
    public int getId() {

        return id;
    }


    public Integer getPoziomNajedzenia() {
        return poziomNajedzenia;
    }
    
    public boolean czyGlodny (){
        return poziomNajedzenia < MAX_NAJEDZENIE;
    }
    
    
}
