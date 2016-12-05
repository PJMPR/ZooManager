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

    private Integer id;
    private Integer idRodzajWybiegu;
    private String stanWybiegu;

    public void setIdRodzajWybiegu(Integer idRodzajWybiegu) {
        this.idRodzajWybiegu = idRodzajWybiegu;
    }

    public void setStanWybiegu(String stanWybiegu) {
        this.stanWybiegu = stanWybiegu;
    }

    public Wybieg() {
    }

    

    @Override
    public int getId() {
        return id;
    }

    public Integer getRodzajWybiegu() {
        return idRodzajWybiegu;
    }

    public void setRodzajWybiegu(Integer rodzajWybiegu) {
        this.idRodzajWybiegu = rodzajWybiegu;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIdRodzajWybiegu() {
        return idRodzajWybiegu;
    }

    public String getStanWybiegu() {
        return stanWybiegu;
    }
    
    

}
