package Domain.Clienti;

import Domain.Proprietati.Teren;

public class Client1 extends Client{

    private static final String detaliiClient = "Socar StreamDown";

    public Client1(Teren teren, double pret) {
        super(detaliiClient, teren, pret);
    }

    @Override
    public String calculTarif(double distanta) {
        return "Tariful pentru " + distanta + " km este de " + distanta * pret + " lei.";
    }

    @Override
    public String toString() {
        return "Client1: " +
                "nume = '" + nume + '\'' +
                ", teren = " + teren +
                ", pret = " + pret +
                '}';
    }
}
