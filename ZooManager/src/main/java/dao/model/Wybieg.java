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
public class Wybieg implements IHaveId {

    private RodzajWybiegu rodzajWybiegu;
    private Integer id;

    public enum RodzajWybiegu {

        KLATKA, ZAMKNIETY, OTWARTY
    }

    @Override
    public int getId() {
        return id;
    }

    public RodzajWybiegu getRodzajWybiegu() {
        return rodzajWybiegu;
    }

    public void setRodzajWybiegu(RodzajWybiegu rodzajWybiegu) {
        this.rodzajWybiegu = rodzajWybiegu;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

}
