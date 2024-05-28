package Domain.Clienti;

import Domain.Proprietati.Teren;

public abstract class Client {
    protected String nume;
    protected Teren teren;
    protected double pret;

    public Client(String nume, Teren teren, double pret) {
        this.nume = nume;
        this.teren = teren;
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public Teren getTeren() {
        return teren;
    }

    public double getPret() {
        return pret;
    }

    public abstract String calculTarif(double distanta);
}
