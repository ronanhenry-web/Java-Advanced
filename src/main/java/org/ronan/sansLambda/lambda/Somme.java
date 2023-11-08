package org.ronan.sansLambda.lambda;

public interface Somme<T> {
    // Before
//    int appliquer(int a, int b);

    // After
    T appliquer(T a, T b);
}
