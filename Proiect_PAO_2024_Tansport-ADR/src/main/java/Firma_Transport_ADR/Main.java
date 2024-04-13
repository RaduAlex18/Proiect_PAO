package Firma_Transport_ADR;

import Firma_Transport_ADR.Angajati.Sofer;
import Firma_Transport_ADR.CMR.CMR;
import Firma_Transport_ADR.Clienti.Client;
import Firma_Transport_ADR.Clienti.Client1;
import Firma_Transport_ADR.Cursa.Cursa;
import Firma_Transport_ADR.Marfa.Marfa;
import Firma_Transport_ADR.Proprietati.Teren;
import Firma_Transport_ADR.Serviciu.FlotaService;
import Firma_Transport_ADR.Tahograf.Tahograf;
import Firma_Transport_ADR.Vehicule.Camion;
import Firma_Transport_ADR.Vehicule.Cisterna;
import Firma_Transport_ADR.Vehicule.Vehicul;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // clasa camion
        Camion camion1 = new Camion("Iveco","B262AST",2023,150000,"alb",12882);
        Camion camion2 = new Camion("Volvo","B121AST",2017,753528,"rosu",11327);

        //adaugare sofer
        Sofer sofer1 = new Sofer("Mihai","Ion",2,39809);

        camion1.adaugaSofer(new Sofer("Florin","Matei",10,569023));
        camion1.adaugaSofer(sofer1);
        camion2.adaugaSofer(sofer1);

        Tahograf tahograf = camion2.getTahograf();
        //System.out.println(tahograf);

        tahograf.inregistreazaKilometri(1500);
        tahograf.inregistreazaConducere(20);

        System.out.println("Kilometri parcurși: " + tahograf.getKilometriParcursi());
        System.out.println("Ore conduse: " + tahograf.getOreConduse());

        tahograf.reseteaza();
        System.out.println();

        System.out.println(tahograf.toString());

        System.out.println();

        //afisare camioane
        camion1.afisareDetaliiVehicul();
        System.out.println();
        camion2.afisareDetaliiVehicul();
        System.out.println();

        //stergere sofer
        camion1.stergeSofer(sofer1);
        System.out.println();
        camion1.afisareDetaliiVehicul();
        System.out.println();

        //clasa cisterna
        Cisterna cisterna1 = new Cisterna("Felbinder","PH67AST",2009,123453,23);
        Cisterna cisterna2 = new Cisterna("Magyar","PH13AST",2004,543094,22);

        int volumLitri = cisterna1.getVolumLitri();
        System.out.println("Volum_litri cisterna1: " + volumLitri);
        System.out.println();
        cisterna2.afisareDetaliiVehicul();
        System.out.println();

        //clasa CMR
        Marfa marfa1 = new Marfa("motorina",20,3.20);
        CMR cmr1 = new CMR("Socar","Osiver","Str. Muzicienilor, nr.5", "Str.Mandarinelor, nr.11", new Date(), marfa1);
        System.out.println(cmr1.toString());
        System.out.println();

        //clasa Teren
        Teren teren1 = new Teren("Str. Primaverii", 10000, "Parcare", true);
        Teren constructii = new Teren("Str. Ciocanitorilor", 2459, "Industrial", false);
        System.out.println(teren1.toString());
        System.out.println("Suprafata disponibila pentru constructii este de " + constructii.suprafataDisponibilaPentruConstructii() + " m^2.");
        System.out.println();

        //clasa Cursa
        Cursa cursa1 = new Cursa(cmr1,camion1,cisterna1,"Garaj", "Str. Papadilor");
        System.out.println(cursa1.toString());
        System.out.println();

        //clasa Client
        Teren teren2 = new Teren("Str. Avioanelor", 5374, "Industrial", true);
        Client1 client1 = new Client1(teren2,4.5);
        System.out.println(client1);
        System.out.println(client1.calculTarif(13420));
        System.out.println();

        //clasa FlotaService
        FlotaService flotaService = new FlotaService();
        flotaService.adaugaCamion(camion1);
        flotaService.adaugaCamion(camion2);
        flotaService.adaugaCisterna(cisterna1);
        flotaService.adaugaCisterna(cisterna2);

        //System.out.println(flotaService.getVehicule());
        int contor = 1;
        for (Vehicul vehicul: flotaService.getVehicule()) {
            System.out.println(contor + ": " + vehicul);
            contor++;
        }

        System.out.println();

        //cautare dupa numar de inmatriculare
        String nr_dorit = "PH67AST";
        flotaService.gasesteVehiculDupaNumarInmatriculare(nr_dorit);
        System.out.println();
        flotaService.gasesteVehiculDupaNumarInmatriculare("B121AST");
        System.out.println();
        flotaService.gasesteVehiculDupaNumarInmatriculare("B001AST");

        System.out.println();

        //Lista SORTATA
        Marfa marfa2 = new Marfa("benzina",13,5.20);
        flotaService.adaugaMarfa(marfa2);
        flotaService.adaugaMarfa(marfa1);
        System.out.println(flotaService.getMarfuri());

        //Map (cheie de tip string + tip Camion)
        System.out.println();
        System.out.println(flotaService.getCamioane());

        System.out.println();

        //metoda pentru a afla numarul de camioane libere
        Camion camion3 = new Camion("Scania","B969AST",2024,10,"negru",13864);
        flotaService.adaugaCamion(camion3);
        System.out.println(flotaService.numaraCamioaneLibere());
        System.out.println();
        System.out.println("Numarul total de kilometri al camioanelor este de " + flotaService.calculareKilometriTotaliCamioane() + ".");

        System.out.println();

    }
}
