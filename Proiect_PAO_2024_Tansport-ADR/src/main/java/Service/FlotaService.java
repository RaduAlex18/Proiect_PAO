package Service;

import Domain.Marfa.Marfa;
import Domain.Vehicule.Camion;
import Domain.Vehicule.Cisterna;
import Domain.Vehicule.Vehicul;

import java.util.*;

public class FlotaService {
    private List<Cisterna> cisterne;
    private Map<String, Camion> camioane;
    private List<Marfa> marfuri;
    private List<Vehicul> vehicule;

    public FlotaService() {
        this.cisterne = new ArrayList<>();
        this.camioane = new TreeMap<>(); //implementare a interfetei Map;
                                         //cheile sunt sortate in ordinea lor naturala
        this.marfuri = new ArrayList<>();
        this.vehicule = new ArrayList<>();
    }

    public void adaugaCamion(Camion camion) {
        camioane.put(camion.getNumarInmatriculare(), camion);
        vehicule.add(camion);
    }

    public void stergeCamion(String numarInmatriculare) {
        Camion camion = camioane.remove(numarInmatriculare);
        vehicule.remove(camion);
    }

    public Map<String, Camion> getCamioane() {
        return camioane;
    }

    public void adaugaCisterna(Cisterna cisterna) {
        cisterne.add(cisterna);
        vehicule.add(cisterna);
    }

    public void stergeCisterna(Cisterna cisterna) {
        cisterne.remove(cisterna);
        vehicule.remove(cisterna);
    }

    public List<Cisterna> getCisterne() {
        return cisterne;
    }

    // sortarea listei de marfuri
    public void adaugaMarfa(Marfa marfa) {
        marfuri.add(marfa);
        marfuri.sort(Comparator.comparing(Marfa::getPret));
    }

    public void stergeMarfa(Marfa marfa) {
        marfuri.remove(marfa);
    }

    public List<Marfa> getMarfuri() {
        return marfuri;
    }

    public List<Vehicul> getVehicule() {
        return vehicule;
    }

    public void gasesteVehiculDupaNumarInmatriculare(String numarInmatriculare) {
        for (Vehicul vehicul : vehicule) {
            if (vehicul.getNumarInmatriculare().equals(numarInmatriculare)) {
                vehicul.afisareDetaliiVehicul();
                return;
            }
        }
        System.out.println("Vehiculul cu numarul de inmatriculare [" + numarInmatriculare + "] nu a fost gasit.");
    }

    public String numaraCamioaneLibere() {
        int count = 0;
        for(Vehicul vehicul : vehicule) {
            if(vehicul instanceof Camion && ((Camion) vehicul).getSoferi().isEmpty()) {
                count ++;
            }
        }
        return "Numarul de camioane libere este: " + count + ".";
    }

    public double calculareKilometriTotaliCamioane() {
        double kilometriTotali = 0;
        for(Vehicul vehicul : vehicule) {
            if (vehicul instanceof Camion) {
                kilometriTotali += vehicul.getKm();
            }
        }
        return kilometriTotali;
    }


}
