/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownicy;

/**
 *
 * @author TKK
 */
public enum TYP_PRACOWNIKA {
    OPIEKUN (1), TECHNICZNY (2), MAGAZYNIER (3);
    private final int id;

    private TYP_PRACOWNIKA(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static TYP_PRACOWNIKA getEnumById (int id){
       for (TYP_PRACOWNIKA typ : TYP_PRACOWNIKA.values()){
           if (typ.getId() == id)
               return typ;
       } 
       return null;
    }
   
    
}
