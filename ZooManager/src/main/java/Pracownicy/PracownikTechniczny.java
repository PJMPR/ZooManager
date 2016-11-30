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
public class PracownikTechniczny extends APracownik{
    private final static TYP_PRACOWNIKA typPracownika = TYP_PRACOWNIKA.TECHNICZNY;
    
    public PracownikTechniczny(int kod, String imie, String nazwisko) {
        super(kod, imie, nazwisko,typPracownika);
    }
    
    public PracownikTechniczny(int kod, String imie, String nazwisko,double pensja) {
        super(kod, imie, nazwisko,pensja,typPracownika);
    }
    
    
    private void naprawWybieg ( wybieg.Wybieg wybieg) {
    }
    
}
