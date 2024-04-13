package Firma_Transport_ADR.Clienti;

import Firma_Transport_ADR.Proprietati.Teren;

public class Client2 extends Client{

    private int ani_colaborare;
    private static final String detaliiClient = " Oviser ";

    public Client2(Teren teren, double pret, int ani_colaborare) {
        super(detaliiClient, teren, pret);
        this.ani_colaborare = ani_colaborare;
    }

    public int getAni_colaborare() {
        return ani_colaborare;
    }

    @Override
    public String calculTarif(double distanta) {
        double reducere = 0.10 * ani_colaborare;
        double tarif_redus = pret - ( pret * reducere );
        return "Tariful pentru " + distanta + " km este de " + distanta * tarif_redus + " lei.";
    }

    @Override
    public String toString() {
        return "Client2: " +
                "nume = '" + nume + '\'' +
                ", teren = " + teren +
                ", pret = " + pret +
                ", ani_colaborare = " + ani_colaborare +
                '}';
    }
}
