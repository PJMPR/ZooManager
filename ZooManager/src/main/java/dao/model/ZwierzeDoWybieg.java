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
public class ZwierzeDoWybieg implements IHaveId {

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
    
    

}
