package org.ronan.reflexibilite.mermaid;

import org.ronan.reflexibilite.javaBean.Personne;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MermaidGenerator {
    // Méthode pour générer un diagramme de classe Mermaid
    public static void generate(StringBuilder builder, Class classe) {
        builder.append("class ").append(classe.getSimpleName());
        builder.append(" {\n");

        // Parcourt les champs (fields) de la classe
        for (Field champ : classe.getDeclaredFields()) {
            int mods = champ.getModifiers();
            builder.append(getPrefix(mods));
            builder.append(champ.getType().getSimpleName());
            builder.append(" ").append(champ.getName());
            builder.append("\n");
        }

        // Parcourt les méthodes de la classe
        for (Method methode : classe.getDeclaredMethods()) {
            int mods = methode.getModifiers();
            builder.append(getPrefix(mods));
            builder.append(methode.getReturnType().getSimpleName());
            builder.append(" ").append(methode.getName());
            builder.append("(");
            boolean first = true;
            for (Parameter parametre : methode.getParameters()) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append(parametre.getType().getSimpleName()).append(" ").append(parametre.getName());
            }
            builder.append(")\n");
        }
        builder.append("}\n");
    }

    // Méthode pour obtenir le préfixe d'accessibilité du champ ou de la méthode
    private static String getPrefix(int mods) {
        if (Modifier.isPrivate(mods)) {
            return  "-";
        } else if (Modifier.isPublic(mods)) {
            return "+";
        } else if (Modifier.isProtected(mods)) {
            return "#";
        }
        return "";
    }

    public static void main (String[] args) {
        // Crée un objet StringBuilder pour construire le diagramme Mermaid
        StringBuilder sb = new StringBuilder();
        sb.append("classDiagram\n");

        // Appelle la méthode generate pour générer le diagramme de la classe Personne
        generate(sb, Personne.class);
        System.out.println(sb.toString());
    }
}
