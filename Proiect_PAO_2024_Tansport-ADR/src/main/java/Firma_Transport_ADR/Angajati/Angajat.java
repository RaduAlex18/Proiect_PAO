package Firma_Transport_ADR.Angajati;

import java.util.*;

public abstract class Angajat {
    protected String nume;
    protected String prenume;

    public Angajat(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return this.nume;
    }

    public  String getPrenume() {
        return this.prenume;
    }

    public abstract void afisareDetalii();
}
