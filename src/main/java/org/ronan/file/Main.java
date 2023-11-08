package org.ronan.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        // Chemin du fichier d'entrée
        String chemin = "./file.txt";

        // Utilisation du bloc try-with-resources pour gérer automatiquement la fermeture des ressources
        try (
                var fr = new FileReader(chemin, Charset.forName("UTF-8"));
                var br = new BufferedReader(fr);
                var fw = new FileWriter(chemin + " out", Charset.forName("UTF-8"), false)
        ) {
            // Variable pour stocker chaque ligne lue
            String ligne;
            do {
                // Lecture de la ligne
                ligne = br.readLine();
                if (ligne != null) {
                    // Conversion de la ligne en majuscules et affichage
                    System.out.println(ligne.toUpperCase());
                    // Écriture de la ligne convertie dans un nouveau fichier avec un saut de ligne
                    fw.append(ligne.toUpperCase()).append(System.lineSeparator());
                }
            } while (ligne != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
