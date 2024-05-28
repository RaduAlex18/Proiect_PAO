package Domain.Cursa;

import Domain.CMR.CMR;
import Domain.Vehicule.Camion;
import Domain.Vehicule.Cisterna;

public class Cursa {
    private CMR cmr;
    private Camion camion;
    private Cisterna cisterna;
    private String locatiePlecare;
    private String destinatie;

    public Cursa(CMR cmr, Camion camion, Cisterna cisterna, String locatiePlecare, String destinatie) {
        this.cmr = cmr;
        this.camion = camion;
        this.cisterna = cisterna;
        this.locatiePlecare = locatiePlecare;
        this.destinatie = destinatie;
    }

    public CMR getCmr() {
        return cmr;
    }

    public Camion getCamion() {
        return camion;
    }

    public Cisterna getCisterna() {
        return cisterna;
    }

    public String getLocatiePlecare() {
        return locatiePlecare;
    }

    public String getDestinatie() {
        return destinatie;
    }

    @Override
    public String toString() {
        return "Cursa: " +
                "cmr = " + cmr +
                ", camion = " + camion +
                ", cisterna = " + cisterna +
                ", locatiePlecare = '" + locatiePlecare + '\'' +
                ", destinatie = '" + destinatie + '\'' +
                '}';
    }
}
