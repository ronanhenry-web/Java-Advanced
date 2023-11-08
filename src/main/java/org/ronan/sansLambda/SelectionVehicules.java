package org.ronan.sansLambda;

import java.util.ArrayList;
import java.util.List;

public class SelectionVehicules {

    private List<ApplicationFiltre> filtres;

    public SelectionVehicules() {
        // Initialisation de la liste de filtres
        this.filtres = new ArrayList<>();

        // Ajout de filtres à la liste en utilisant des expressions lambda
        this.filtres.add((vehicule, filtre) -> {
            if (filtre.marque != null) {
                return filtre.marque.equals(vehicule.getMarque());
            }
            return true;
        });
        this.filtres.add((vehicule, filtre) -> {
            if (filtre.nombrePlaces > 0) {
                return filtre.nombrePlaces == vehicule.getNombrePlaces();
            }
            return true;
        });

        // Sans lambda
//        this.filtres.add(new ApplicationFiltreMarque());
//        this.filtres.add(new ApplicationFiltrePlaces());
//        this.filtres.add(new ApplicationFiltre() {
//            @Override
//            public boolean appliquer(Vehicule vehicule, FiltreVehicule filtre) {
//                return false;
//            }
//        });

    }

    public List<Vehicule> selectionner(
            List<Vehicule> listeVehicules,
            FiltreVehicule filtre) {

        List<Vehicule> resultat = new ArrayList<>();
        for (Vehicule vehicule : listeVehicules)  {
            /*
            boolean marqueOk;
            if (filtre.marque != null) {
                marqueOk = filtre.marque.equals(vehicule.getMarque());
            } else {
                marqueOk = true;
            }

            boolean placesOk;
            if (filtre.nombrePlaces > 0) {
                placesOk = filtre.nombrePlaces == vehicule.getNombrePlaces();
            } else {
                placesOk = true;
            }

            if (marqueOk && placesOk) {
                resultat.add(vehicule);
            }
             */
            boolean selectionnable = true;
            for (ApplicationFiltre appFiltre : this.filtres) {
                boolean test = appFiltre.appliquer(vehicule, filtre);
                if (! test) {
                    selectionnable = false;
                    break;
                }
            }
            if (selectionnable) {
                resultat.add(vehicule);
            }
        }

        return resultat;
    }
}
