package Domain.Tahograf;

import java.util.Date;

public class Tahograf {

    private Date dataInregistrare; // ultima data in care s-au inregistrat informatii
    private int kilometriParcursi;
    private int oreConduse;

    public Tahograf() {
        this.dataInregistrare = new Date();
        this.kilometriParcursi = 0;
        this.oreConduse = 0;
    }

    public Date getDataInregistrare() {
        return this.dataInregistrare;
    }

    public int getKilometriParcursi() {
        return this.kilometriParcursi;
    }

    public void setKilometriParcursi(int kilometriParcursi) {
        this.kilometriParcursi = kilometriParcursi;
    }

    public int getOreConduse() {
        return this.oreConduse;
    }

    public void setOreConduse(int oreConduse) {
        this.oreConduse = oreConduse;
    }

    public void inregistreazaConducere(int ore) {
        this.oreConduse += ore;
    }

    public void inregistreazaKilometri(int kilometri) {
        this.kilometriParcursi += kilometri;
    }

    public void reseteaza() {
        this.dataInregistrare = new Date();
        this.kilometriParcursi = 0;
        this.oreConduse = 0;
    }

    @Override
    public String toString() {
        return "Tahograf: " +
                "data = " + dataInregistrare +
                ", kilometri_parcursi = " + kilometriParcursi +
                ", ore_conduse = " + oreConduse;
    }
}
