package Domain.Marfa;

public class Marfa {

    private String denumire;
    private double greutate; //in tone
    private double pret;

    public Marfa(String denumire, double greutate, double pret) {
        this.denumire = denumire;
        this.greutate = greutate;
        this.pret = pret;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Marfa{" +
                "denumire = '" + denumire + "'" +
                ", greutate = " + greutate + " tone" +
                ", pret = " + pret + "}";
    }
}
