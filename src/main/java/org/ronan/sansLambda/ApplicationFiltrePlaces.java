package org.ronan.sansLambda;

public class ApplicationFiltrePlaces implements ApplicationFiltre {
    @Override
    public boolean appliquer(Vehicule vehicule, FiltreVehicule filtre) {
        boolean placesOk;
        if (filtre.nombrePlaces > 0) {
            placesOk = filtre.nombrePlaces == vehicule.getNombrePlaces();
        } else {
            placesOk = true;
        }
        return placesOk;
    }
}
