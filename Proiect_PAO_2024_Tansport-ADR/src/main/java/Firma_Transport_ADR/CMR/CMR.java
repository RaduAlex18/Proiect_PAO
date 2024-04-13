package Firma_Transport_ADR.CMR;

import Firma_Transport_ADR.Marfa.Marfa;

import java.util.Date;

public class CMR {

//    datele de indentificare ale expeditorului, destinatarului,
//    locul incarcarii,
//    locul descarcarii,
//    denumire+cantitate(marfa)
//    !! trebuie completat tot (nu se poate completa o singura rubrica sau nu poate fi lasat gol)

    private String expeditor;
    private String destinatar;
    private String adresaIncarcare;
    private String adresaDescarcare;
    private Date dataExpediere;
    private Marfa marfa;

    public CMR(String expeditor, String destinatar, String adresaIncarcare, String adresaDescarcare, Date dataExpediere, Marfa marfa) {
        this.expeditor = expeditor;
        this.destinatar = destinatar;
        this.adresaIncarcare = adresaIncarcare;
        this.adresaDescarcare = adresaDescarcare;
        this.dataExpediere = dataExpediere;
        this.marfa = marfa;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public String getDestinatar() {
        return destinatar;
    }

    public String getAdresaIncarcare() {
        return adresaIncarcare;
    }

    public String getAdresaDescarcare() {
        return adresaDescarcare;
    }

    public Date getDataExpediere() {
        return dataExpediere;
    }

    public Marfa getMarfa() {
        return marfa;
    }

    @Override
    public String toString() {
        return "CMR{" +
                "expeditor = '" + expeditor + '\'' +
                ", destinatar = '" + destinatar + '\'' +
                ", adresaIncarcare = '" + adresaIncarcare + '\'' +
                ", adresaDescarcare = '" + adresaDescarcare + '\'' +
                ", dataExpediere = " + dataExpediere +
                ", marfa = " + marfa +
                '}';
    }
}
