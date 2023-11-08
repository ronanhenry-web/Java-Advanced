package org.ronan.sansLambda;

public class ApplicationFiltreMarque implements ApplicationFiltre {
    @Override
    public boolean appliquer(Vehicule vehicule, FiltreVehicule filtre) {
        boolean marqueOK;
        if (filtre.marque != null) {
            marqueOK = filtre.marque.equals(vehicule.getMarque());
        } else {
            marqueOK = false;
        }
        return marqueOK;
    }
}
