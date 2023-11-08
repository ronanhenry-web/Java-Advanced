package org.ronan.sansLambda.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {
    public void afficher(String message1, String message2) {
        System.out.println(message1 + " : " + message2);
    }
    public static void main(String[] args) {
        int CONSTANTE = 7;

//        Somme<Double> somme = (p1, p2) -> p1 + p2;
//        System.out.println(somme.appliquer(4., 7.));
        // Déclaration d'une interface fonctionnelle BiFunction pour calculer la somme
        BiFunction<Integer, Double, Double> somme = (p1, p2) -> CONSTANTE + p1 + p2;
        System.out.println(somme.apply(4, 7.));

        // Déclaration d'une interface fonctionnelle Consumer (inutilisée)
        Consumer<String> consommateur = (String p4) -> {};

        // Création d'une instance de la classe Main
        Main mainObj = new Main();
        // Utilisation d'une référence de méthode pour appeler la méthode 'afficher' de l'instance mainObj
        BiConsumer<String, String> ref = mainObj::afficher;
        ref.accept("CRIRIQUE", "C'est la pause");
//        Main::main;
    }
}
