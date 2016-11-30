/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownicy;

import java.util.List;

/**
 *
 * @author TKK
 */
public class Magazynier extends APracownik{
    private final static TYP_PRACOWNIKA typPracownika = TYP_PRACOWNIKA.MAGAZYNIER;
private List <PozycjaMagazyn> magazyn;

    public Magazynier(int kod, String imie, String nazwisko) {
        super(kod, imie, nazwisko,typPracownika);
    }

    public Magazynier(int kod, String imie, String nazwisko,double pensja) {
        super(kod, imie, nazwisko,pensja,typPracownika);
    }
    public List<PozycjaMagazyn> getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(List<PozycjaMagazyn> magazyn) {
        this.magazyn = magazyn;
    }
    
    private void zmienStanMagazyn (PozycjaMagazyn pozycja){
    }
    }
