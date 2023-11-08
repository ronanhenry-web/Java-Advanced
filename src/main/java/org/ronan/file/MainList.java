package org.ronan.file;

import java.io.File;

public class MainList {
    public static void main(String[] args) {
        // Crée un objet File pour représenter le répertoire racine du lecteur C: (c:\)
        var racine = new File("c:\\");

        // Utilise la méthode list() pour obtenir la liste des noms de fichiers et répertoires dans le répertoire racine
        for (String fichier :  racine.list()) {
            System.out.println(fichier);
        }

        System.out.println("===============");

        // Utilise la méthode listFiles() pour obtenir la liste des objets File représentant les fichiers et répertoires dans le répertoire racine
        for (File fichier :  racine.listFiles()) {
            if (fichier.isFile()) {
                System.out.println(fichier);
            }

        }
    }
}
