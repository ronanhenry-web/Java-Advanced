package org.ronan.thread.recursive;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TraitementRecursif extends RecursiveTask<Long> {

    private int indexInf = 0;
    private int indexSup = 0;
    private int[] tableau;
    private int seuil;

    public TraitementRecursif(int seuil, int[] tableau, int inf, int sup) {
        this.seuil = seuil;
        this.tableau = tableau;
        this.indexSup = sup;
        this.indexInf = inf;
    }

    @Override
    protected Long compute() {
        if (indexSup - indexInf > seuil) {
            Long res = 0L;
            for (int i = indexInf; i <= indexSup; i++) {
                if (tableau[i] >= 11 && tableau[i] <= 26) {
                    res += tableau[i] * 10;
                }
            }
            return res;
        }
        TraitementRecursif traitement1 = new TraitementRecursif(
                seuil, tableau, indexInf, indexInf + seuil
        );

        TraitementRecursif traitement2 = new TraitementRecursif(
                seuil, tableau, indexInf + seuil + 1, indexSup
        );

        // Soumet la première sous-tâche au pool de travail (fork) de manière asynchrone
        ForkJoinTask<Long> res1 = traitement1.fork();
        // Exécute récursivement la deuxième sous-tâche de manière synchrone (join)
        Long res2 = traitement2.join() + traitement2.compute();

        // Combine les résultats des deux sous-tâches
        return res2;
    }

}
