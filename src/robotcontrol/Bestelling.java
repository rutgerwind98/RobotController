/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrol;

/**
 *
 * @author Rutger
 */
public class Bestelling {
    public int artikelNummer;
    public String artikelCode;
    private String datum;
    private int orderNummer;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String postcode;
    private String plaats;
    
    public void Bestelling(int artn, String dat, int ornum, String voor, String achter,
            String adr, String post, String plats){
        artikelNummer = artn;
        datum = dat;
        orderNummer = ornum;
        voornaam = voor;
        achternaam = achter;
        adres = adr;
        postcode = post;
        plaats = plats;
        
    }
    public void nummerNaarCode(int artn){
        artikelCode = Integer.toString(artn);
    }
}
