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
public class ZwierzeDoTypWybiegu implements IHaveId {

    private Integer id;
    private Integer idZwierze;
    private Integer idWybieg;

    @Override
    public int getId() {
        return id;
    }

    public Integer getIdZwierze() {
        return idZwierze;
    }

    public Integer getIdWybieg() {
        return idWybieg;
    }

    public ZwierzeDoTypWybiegu(Integer id, Integer idZwierze, Integer idWybieg) {
        this.id = id;
        this.idZwierze = idZwierze;
        this.idWybieg = idWybieg;
    }
    
    

}
