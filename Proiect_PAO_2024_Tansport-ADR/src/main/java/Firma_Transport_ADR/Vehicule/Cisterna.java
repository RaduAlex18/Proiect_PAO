package Firma_Transport_ADR.Vehicule;

public class Cisterna extends Vehicul {

    private int volumLitri;

    public Cisterna(String marca, String numarInmatriculare, int an, int km, int volumLitri) {
        super(marca, numarInmatriculare, an, km);
        this.volumLitri = volumLitri;
    }

    public int getVolumLitri() {
        return this.volumLitri;
    }

    @Override
    public void afisareDetaliiVehicul() {
        System.out.println("Cisterna: " + marca + " [" + numarInmatriculare + "] cu volumul de " + volumLitri + " litri.");
    }

    @Override
    public String toString() {
        return "{" + marca + ", [" + numarInmatriculare + "], " + an + ", " + km + ", " + volumLitri + "}";
    }
}
