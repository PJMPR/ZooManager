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
    private List<TypJedzenia.RodzajJedzenia> rodzajJedzenia;
    private List<TypWybiegu.RodzajWybiegu> rodzajWybiegu;
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

    public void setRodzajJedzenia(List<TypJedzenia.RodzajJedzenia> rodzajJedzenia) {
        this.rodzajJedzenia = rodzajJedzenia;
    }

    public void setRodzajWybiegu(List<TypWybiegu.RodzajWybiegu> rodzajWybiegu) {
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

    public List<TypJedzenia.RodzajJedzenia> getRodzajJedzenia() {
        return rodzajJedzenia;
    }

    public List<TypWybiegu.RodzajWybiegu> getRodzajWybiegu() {
        return rodzajWybiegu;
    }

    public Integer getIdWybiegu() {
        return idWybiegu;
    }

    private void pobierzListeTypJedzenia() {

    }

    private void pobierzListeTypWybiegu() {
    }

    public boolean jedz(Integer ilosc, TypJedzenia.RodzajJedzenia jedzenie) {
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

}
