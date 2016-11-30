/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.model;

/**
 *
 * @author TKK
 */
public class Magazynier implements IHaveId {

    String imie;
    String nazwisko;
    Integer id;

    public Magazynier(String imie, String nazwisko, Integer id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public int getId() {
        return id;
    }

}
