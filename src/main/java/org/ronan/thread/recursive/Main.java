package org.ronan.thread.recursive;

import org.ronan.thread.ThreadCompteur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Crée un pool de travail basé sur ForkJoinPool (un mécanisme pour le traitement parallèle)
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Pour l'ajout de tâches
        var tableau = new int[]{3, 78, 11, 9, 13, 20, 8, 6, 5, 4};

        // Crée une tâche de traitement récursif (TraitementRecursif) avec les données d'entrée
        var tache = new TraitementRecursif(5, tableau, 0, tableau.length - 1);
        // Soumet la tâche de traitement récursif au pool pour exécution
        pool.submit(tache);

        // Crée deux threads pour effectuer un comptage (ThreadCompteur)
        var compteur1 = new ThreadCompteur("Premier");
        var compteur2 = new ThreadCompteur("Deuxieme");

        // Soumet les threads de comptage au pool pour exécution
        pool.submit(compteur1);
        pool.submit(compteur2);

        // Attente de la fin des tâches du pool (30 secondes au maximum)
        pool.awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS);
//        pool.shutdown();

        // Obtient le résultat de la tâche de traitement récursif (le résultat de la somme)
        System.out.println(tache.get());

        System.out.println("FIN");
    }
}
