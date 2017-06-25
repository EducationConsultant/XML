package com.firma.models.zahtev;

import java.util.Date;

public class ZahtevZaDobijanjeIzvodaJSON {
	
	public String brojRacuna;
	
    public ZahtevZaDobijanjeIzvodaJSON() {
		super();
	}
    
    public Date datum;
    
    public String getBrojRacuna() {
        return brojRacuna;
    }
    
    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }
    
    public Date getDatum() {
        return datum;
    }
    
    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
