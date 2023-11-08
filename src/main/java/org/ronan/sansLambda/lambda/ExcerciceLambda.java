package org.ronan.sansLambda.lambda;

import java.util.function.BiFunction;

public class ExcerciceLambda {
    // Méthode qui effectue un calcul en utilisant un opérateur binaire (BiFunction)
    public static void calculer(int operande1, int operande2, BiFunction<Integer, Integer, Double> operateur) {
        if (operande1 != operande2) {
            Object resultat = null;
            resultat = operateur.apply(operande1, operande2);
            System.out.println(resultat);
        }
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> division = (a, b) -> (double)(a / b);
        BiFunction<Integer, Integer, Double> multiplication = (a, b) -> (double)(a * b);

        // Appel de la méthode calculer avec différents opérandes et opérateurs
        calculer(3, 3, multiplication);
        calculer(3, 3, division);
        calculer(19, 3, multiplication);
        calculer(19, 3, division);
    }
}
