/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mappers;

import Pracownicy.APracownik;
import Pracownicy.Magazynier;
import Pracownicy.PracownikOpiekun;
import Pracownicy.PracownikTechniczny;
import Pracownicy.TYP_PRACOWNIKA;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TKK
 */
public class PracownikMapper implements IMapResultSetIntoEntity<APracownik>{

    @Override
    public APracownik map(ResultSet rs) throws SQLException {
        int typ_pracownika=rs.getInt("id_typ_pracownika");
        
        switch (TYP_PRACOWNIKA.getEnumById(typ_pracownika)){
            case OPIEKUN:
                return new PracownikOpiekun(rs.getInt("id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getDouble("pensja"));
            case TECHNICZNY:
                return new PracownikTechniczny(rs.getInt("id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getDouble("pensja"));
            case MAGAZYNIER:
                return new Magazynier(rs.getInt("id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getDouble("pensja"));
            default:
                return null;
                
                
           
                
        }
        
        
    }
    
    
}
