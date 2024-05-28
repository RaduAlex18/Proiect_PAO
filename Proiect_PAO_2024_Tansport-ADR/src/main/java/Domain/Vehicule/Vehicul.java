package Domain.Vehicule;

public abstract class Vehicul {

    protected String marca;
    protected String numarInmatriculare;
    protected int an;
    protected int km;

    public Vehicul( String marca, String numarInmatriculare, int an, int km) {
        this.marca = marca;
        this.numarInmatriculare = numarInmatriculare;
        this.an = an;
        this.km = km;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getNumarInmatriculare() {
        return this.numarInmatriculare;
    }

    public int getAn() {
        return this.an;
    }

    public int getKm() {
        return this.km;
    }

    public abstract void afisareDetaliiVehicul();
}
