package org.ronan.thread;

import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore semaphore;
    public static void compter(String nom) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            System.out.println(nom + " " + i);
            Thread.sleep(1000);
        }
        semaphore.release(1);
    }

    public static void main(String[] args) throws InterruptedException {
        semaphore = new Semaphore(0);

        var compteur1 = new ThreadCompteur("Premier");
        var compteur2 = new ThreadCompteur("Deuxieme");
        compteur1.start();
        compteur2.start();
        // Ex: Lambda
        new Thread(() -> {
            try {
                Main.compter("Troisième");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        semaphore.acquire(2);
        System.out.println("C'est fini");
    }
}