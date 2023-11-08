package org.ronan.thread;

public class ThreadCompteur extends Thread {
    private String nom;

    public ThreadCompteur(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        try {
            Main.compter(nom);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
