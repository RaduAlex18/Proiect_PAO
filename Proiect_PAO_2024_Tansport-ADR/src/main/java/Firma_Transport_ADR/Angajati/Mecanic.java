package Firma_Transport_ADR.Angajati;

import java.util.*;

public class Mecanic extends Angajat{

    private int ani_experienta;

    private int masini_reparate;

    public Mecanic(String nume, String prenume, int ani_experienta, int masini_reparate) {
        super(nume, prenume);
        this.ani_experienta = ani_experienta;
        this.masini_reparate = masini_reparate;
    }

    public int getAni_experienta() {
        return this.ani_experienta;
    }

    public int getMasini_reparate () {
        return this.masini_reparate;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Mecanicul: " + nume + " " + prenume + " a reparat masini timp de " + ani_experienta + " numarul acestora fiind de " + masini_reparate);
    }
}