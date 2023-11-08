package org.ronan.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre  extends JFrame {

    public Fenetre() {
        this.setTitle("Fenêtre");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.initMenuBar();
        this.initContent();
    }

    private void initContent() {
//        JButton bouton1 = new JButton("Premier bouton");
//        this.getContentPane().add(bouton1, BorderLayout.NORTH);
//        JButton bouton2 = new JButton("Second bouton");
//        this.getContentPane().add(bouton2, BorderLayout.SOUTH);

        this.getContentPane().setLayout((new GridBagLayout()));

        GridBagConstraints constrainte1 = new GridBagConstraints();
        constrainte1.gridx = 1;
        constrainte1.gridy = 1;
        constrainte1.gridwidth = 1;
        constrainte1.gridheight = 1;
        constrainte1.weightx = 1;
        constrainte1.weighty = 1;
        constrainte1.fill = GridBagConstraints.VERTICAL;
        JButton bouton1 = new JButton("Premier bouton");
        this.getContentPane().add(bouton1, constrainte1);

        GridBagConstraints constrainte2 = new GridBagConstraints();
        constrainte2.gridx = 2;
        constrainte2.gridy = 1;
        JButton bouton2 = new JButton("Second bouton");
        this.getContentPane().add(bouton2, constrainte2);

//        bouton1.addActionListener( (event) -> {
//            System.out.println("OK" + event);
//        });

        bouton1.addActionListener(this::direOK);
    }

    private void direOK(ActionEvent event) {
        System.out.println("OK" + event);
        var modale = new ConfirmationFermeture(this,
                "Confirmation de fermeture");
        modale.afficher();
        if (modale.isConfirme()) {
            this.dispose();
            System.exit(0);
        }
    }

    private void initMenuBar() {
        var menuBar = new JMenuBar();

        var menuFichiers = new JMenu("Fichiers");
        menuFichiers.setMnemonic('f');
        var menuOptions = new JMenu("Options");
        menuOptions.setMnemonic(('o'));
        menuBar.add(menuFichiers);
        menuBar.add(menuOptions);

        var menuFichierItem1 = new JMenuItem("Ouvrir");
        menuFichierItem1.addActionListener(this::direOK);
        var menuFichierItem2 = new JMenuItem("Quitter");
        menuFichierItem2.addActionListener( (event) -> {
            this.dispose();
            System.exit(0);
        });
        menuFichiers.add(menuFichierItem1);
        menuFichiers.add(menuFichierItem2);

        var menuOptionsItem1 = new JMenuItem("Options ...");
        menuOptions.add(menuOptionsItem1);

        var menuOptionsItem2 = new JMenu("Avancé");
        menuOptionsItem2.add(new JMenuItem("Danger !!!"));
        menuOptions.add(menuOptionsItem2);

        menuOptions.add(new JSeparator());

        menuOptions.add(new JCheckBoxMenuItem("auto", true));

        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        var fenetre = new Fenetre();
        fenetre.setVisible(true);
    }


}
