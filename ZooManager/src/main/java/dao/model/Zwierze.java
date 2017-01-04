/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.model;

import java.util.List;

/**
 *
 * @author TKK
 */
public class Zwierze implements IHaveId {

    private Integer id;
    private String nazwa;
    private static final int MAX_NAJEDZENIE = 100;
    private int tempoJedzenia;
    private Integer poziomNajedzenia;
    private List<ZwierzeDoTypJedzenia> rodzajJedzenia;
    private List<ZwierzeDoTypWybiegu> rodzajWybiegu;
    private Integer idWybiegu;

   

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

    public void setRodzajJedzenia(List<ZwierzeDoTypJedzenia> rodzajJedzenia) {
        this.rodzajJedzenia = rodzajJedzenia;
    }

    public void setRodzajWybiegu(List<ZwierzeDoTypWybiegu> rodzajWybiegu) {
        this.rodzajWybiegu = rodzajWybiegu;
    }

    public void setIdWybiegu(Integer idWybiegu) {
        this.idWybiegu = idWybiegu;
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

    public List<ZwierzeDoTypJedzenia> getRodzajJedzenia() {
        return rodzajJedzenia;
    }

    public List<ZwierzeDoTypWybiegu> getRodzajWybiegu() {
        return rodzajWybiegu;
    }

    public Integer getIdWybiegu() {
        return idWybiegu;
    }

    private void pobierzListeTypJedzenia() {

    }

    private void pobierzListeTypWybiegu() {
    }

    public boolean jedz(Integer ilosc, RodzajJedzenia jedzenie) {
        // sprawdzam poziom najedzenia i rodzaj jedzenia
        if (poziomNajedzenia < MAX_NAJEDZENIE) {
            if (rodzajJedzenia.contains(jedzenie)) {
//                poziomNajedzenia = (poziomNajedzenia + ilosc)/(MAX_NAJEDZENIE+1);
                if (poziomNajedzenia + ilosc > MAX_NAJEDZENIE) {
                    poziomNajedzenia = MAX_NAJEDZENIE;
                } else {
                    poziomNajedzenia = poziomNajedzenia + ilosc;
                }
                return true;
            }

        }
        return false;

    }

    public double getPoziomNajedzenia() {
        return poziomNajedzenia / MAX_NAJEDZENIE;
    }

    @Override
    public int getId() {

        return id;
    }

    public Zwierze(Integer id, String nazwa, int tempoJedzenia, Integer poziomNajedzenia, List<ZwierzeDoTypJedzenia> rodzajJedzenia, List<ZwierzeDoTypWybiegu> rodzajWybiegu, Integer idWybiegu) {
        this.id = id;
        this.nazwa = nazwa;
        this.tempoJedzenia = tempoJedzenia;
        this.poziomNajedzenia = poziomNajedzenia;
        this.rodzajJedzenia = rodzajJedzenia;
        this.rodzajWybiegu = rodzajWybiegu;
        this.idWybiegu = idWybiegu;
    }

    public Zwierze() {
    }
    

}
