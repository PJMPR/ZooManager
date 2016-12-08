/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.model;

import dao.model.IHaveId;

/**
 *
 * @author TKK
 */
public class APracownik implements IHaveId {

    private static double PENJSA_PODSTAWOWA = 1200;

    protected final int id;
    protected String imie;
    protected String nazwisko;
    protected double pensja;
    protected Typ_Pracownika typPracownika;

    public APracownik(int id, String imie, String nazwisko, double penjsa, Typ_Pracownika typPracownika) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = penjsa;
        this.typPracownika = typPracownika;
        
    }

    public APracownik(int id, String imie, String nazwisko, Typ_Pracownika typPracownika) {
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

    public Typ_Pracownika getTypPracownika() {
        return typPracownika;
    }
    
    

}
