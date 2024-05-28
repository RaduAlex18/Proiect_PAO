package Domain.Proprietati;

public class Teren {

    private String adresa;
    private double suprafata;
    private String tip;
    private boolean facilitatiSecuritate;

    public Teren(String adresa, double suprafata, String tip, boolean facilitatiSecuritate) {
        this.adresa = adresa;
        this.suprafata = suprafata;
        this.tip = tip;
        this.facilitatiSecuritate = facilitatiSecuritate;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setSuprafata(double suprafata) {
        this.suprafata = suprafata;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setFacilitatiSecuritate(boolean facilitatiSecuritate) {
        this.facilitatiSecuritate = facilitatiSecuritate;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public double getSuprafata() {
        return this.suprafata;
    }

    public String getTip() {
        return this.tip;
    }

    public boolean getFacilitatiSecuritate() {
        return this.facilitatiSecuritate;
    }

    public double suprafataDisponibilaPentruConstructii() {
        if (tip.equals("Industrial")) {
            return suprafata * 0.8;
        }
        else {
            return suprafata;
        }
    }

    @Override
    public String toString() {
        return "Teren{" +
                "adresa = '" + adresa + "'" +
                ", suprafata = " + suprafata +
                ", tip = '" + tip + "'" +
                ", Paza = " + facilitatiSecuritate + "}";
    }
}