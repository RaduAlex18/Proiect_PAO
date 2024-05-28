package Domain.Angajati;

public class Sofer extends Angajat{

    private int ani_experienta;

    private int km;

    public Sofer(String nume, String prenume, int ani_experienta, int km) {
        super(nume, prenume);
        this.ani_experienta = ani_experienta;
        this.km = km;
    }

    public int getAni_experienta() {
        return this.ani_experienta;
    }

    public int getKm () {
        return this.km;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Soferul: " + nume + " " + prenume + " a condus timp de " + ani_experienta + " " + km);
    }
}