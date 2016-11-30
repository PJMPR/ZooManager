/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwierzeta;

import java.util.List;
import wybieg.Wybieg;

/**
 *
 * @author TKK
 */
public class Zwierze {

    private Integer kod;
    private String nazwa;
    private static final int MAX_NAJEDZENIE = 100;
    private int tempoJedzenia;
    private Integer poziomNajedzenia;
    private List<RodzajJedzenia> rodzajJedzenia;
    private List<Wybieg.RodzajWybiegu> rodzajWybiegu;
    
    public Zwierze(Integer id, String nazwa){
        this.kod = id;
        this.nazwa = nazwa;
    }

    public Zwierze(Integer kod, String nazwa, int tempoJedzenia, List<RodzajJedzenia> rodzajJedzenia, int poziomNajedzenia) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.tempoJedzenia = tempoJedzenia;
        this.rodzajJedzenia = rodzajJedzenia;
        this.poziomNajedzenia = poziomNajedzenia;
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
    

}
