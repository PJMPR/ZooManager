/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mappers;

import dao.model.Zwierze;
import dao.model.RodzajJedzenia;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class ZwierzeMapper implements IMapResultSetIntoEntity<Zwierze> {

    @Override
    public Zwierze map(ResultSet rs) throws SQLException {
       // return new Zwierze(rs.getInt("id"), rs.getString("nazwa"));
       return null;
    }

}
