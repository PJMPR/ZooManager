/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownicy;

import dao.model.IHaveId;

/**
 *
 * @author TKK
 */
public class APracownik implements IHaveId {

    private static double PENJSA_PODSTAWOWA = 1200;

    protected final int id;
    protected final String imie;
    protected final String nazwisko;
    protected double pensja;
    protected final TYP_PRACOWNIKA typPracownika;

    public APracownik(int id, String imie, String nazwisko, double penjsa, TYP_PRACOWNIKA typPracownika) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = penjsa;
        this.typPracownika = typPracownika;
        
    }

    public APracownik(int id, String imie, String nazwisko, TYP_PRACOWNIKA typPracownika) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = PENJSA_PODSTAWOWA;
        this.typPracownika = typPracownika;
    }

    public static void setPodstawowaPensja(double podstawowaPensja) {
        PENJSA_PODSTAWOWA = podstawowaPensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;

    }

    @Override
    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getPensja() {
        return this.pensja;
    }

    public TYP_PRACOWNIKA getTypPracownika() {
        return typPracownika;
    }
    
    

}
