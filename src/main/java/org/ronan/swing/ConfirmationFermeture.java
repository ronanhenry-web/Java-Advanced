package org.ronan.swing;

import javax.swing.*;
import java.awt.*;

public class ConfirmationFermeture extends JDialog {

    private boolean confirme = false;
    public ConfirmationFermeture(JFrame parent, String titre) {
        super(parent, true);
        this.setTitle(titre);
        this.setSize(400, 300);

        JLabel texte = new JLabel("Merci de confirmer.");
        this.getContentPane().add(texte, BorderLayout.CENTER);

        JButton valider = new JButton("Valider");
        this.getContentPane().add(valider, BorderLayout.SOUTH);
        valider.addActionListener( (event) -> {
            this.confirme = true;
            this.dispose();
        });
    }

    public boolean isConfirme() {
        return this.confirme;
    }

    public void afficher() {
        this.setVisible(true);
    }
}
