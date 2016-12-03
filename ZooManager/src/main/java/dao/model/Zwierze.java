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
    private List<RodzajJedzenia> rodzajJedzenia;
    private List<TypWybiegu.RodzajWybiegu> rodzajWybiegu;

//    public Zwierze(Integer id, String nazwa) {
//        this.id = id;
//        this.nazwa = nazwa;
//    }
//
//    public Zwierze(Integer kod, String nazwa, int tempoJedzenia, List<RodzajJedzenia> rodzajJedzenia, int poziomNajedzenia) {
//        this.id = kod;
//        this.nazwa = nazwa;
//        this.tempoJedzenia = tempoJedzenia;
//        this.rodzajJedzenia = rodzajJedzenia;
//        this.poziomNajedzenia = poziomNajedzenia;
//        pobierzListeTypJedzenia();
//        pobierzListeTypWybiegu();
//    }

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

}
