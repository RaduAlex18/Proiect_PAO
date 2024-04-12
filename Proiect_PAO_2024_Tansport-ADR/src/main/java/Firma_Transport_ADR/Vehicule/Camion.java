package Firma_Transport_ADR.Vehicule;

import Firma_Transport_ADR.Angajati.Sofer;

import java.util.*;

public class Camion extends Vehicul{

    private int capacitate_motor;
    private String culoare;
    private List<Sofer> soferi;

    public Camion(String marca, String numarInmatriculare, int an, int km, String culoare, int capacitate_motor) {
        super(marca, numarInmatriculare, an, km);
        this.culoare = culoare;
        this.capacitate_motor = capacitate_motor;
        this.soferi = new ArrayList<>();
    }

    public int getCapacitate_motor() {
        return this.capacitate_motor;
    }

    public String getCuloare() {
        return this.culoare;
    }

    public void adaugaSofer(Sofer sofer) {
        soferi.add(sofer);
    }

    public void stergeSofer(Sofer sofer) {
        Iterator<Sofer> iterator = soferi.iterator();
        while (iterator.hasNext()) {
            Sofer s = iterator.next();
            if (s.equals(sofer)) {
                iterator.remove();
                System.out.println("Soferul " + sofer.getNume() + " " + sofer.getPrenume() + " a fost eliminat.");
                return;
            }
        }
        System.out.println("Soferul nu a fost pe acest camion.");
    }

    @Override
    public void afisareDetaliiVehicul() {
        System.out.println("Camionul: " + marca + " [" + numarInmatriculare + "] cu capacitatea motorului de " + capacitate_motor + " si culoarea " + culoare + ".");
        if(!soferi.isEmpty()) {
            System.out.println("Soferii de pe masina sunt:");
            for (Sofer s : soferi){
                System.out.println("\t" + s.getNume() + "_" + s.getPrenume());
            }
        } else {
            System.out.println("\tNiciun sofer pe acest camion.");
        }
    }
}