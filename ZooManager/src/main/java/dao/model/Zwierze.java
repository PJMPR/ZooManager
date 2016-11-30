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
public class Zwierze implements IHaveId{

    String nazwa;
    Integer id;

    public Zwierze(String nazwa, Integer id) {
        this.nazwa = nazwa;
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }
    
    @Override
    public int getId() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
