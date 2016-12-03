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

    public Wybieg(Integer id, Integer idRodzajWybiegu, String stanWybiegu) {
        this.id = id;
        this.idRodzajWybiegu = idRodzajWybiegu;
        this.stanWybiegu = stanWybiegu;
    }

    public Integer getIdRodzajWybiegu() {
        return idRodzajWybiegu;
    }

    public String getStanWybiegu() {
        return stanWybiegu;
    }
    
    

}
