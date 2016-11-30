/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownicy;

import zwierzeta.*;

/**
 *
 * @author TKK
 */
public class PracownikOpiekun extends APracownik {
    private final static TYP_PRACOWNIKA typPracownika = TYP_PRACOWNIKA.OPIEKUN;

    public PracownikOpiekun(int kod, String imie, String nazwisko) {
        super(kod, imie, nazwisko, typPracownika);
        
    }

    public PracownikOpiekun(int id, String imie, String nazwisko, double penjsa) {
        super(id, imie, nazwisko, penjsa, typPracownika);
    }

    private void nakarmZwierze(Zwierze zwierze) {
    }

}
