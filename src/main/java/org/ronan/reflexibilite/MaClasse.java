package org.ronan.reflexibilite;

import org.ronan.reflexibilite.annotation.ToCsv;
import org.ronan.reflexibilite.javaBean.Personne;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MaClasse {
    public static String methodeStatique() {
        return "Hello";
    }

    private Long methodeObjet(String param1) {
        return 5L;
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder(" ");

        // Parcourt les méthodes déclarées de la classe MaClasse
        for (Method methode : MaClasse.class.getDeclaredMethods()) {
            for (var type: methode.getParameterTypes()) {
                sb.append(" ").append(type.getName());
            }
            System.out.println(methode.getName() + " " + methode.getReturnType() + " " + sb.toString());
        }



        // Java Bean avec une Personne
        Object object = new Personne();
        Method setter = object.getClass().getMethod("setPrenom", String.class);
        setter.invoke(object, "Mon prenom");
//        System.out.println(((Personne) object).getPrenom());

        // Utilise la réflexion pour accéder au champ "prenom" de l'objet Personne et le modifier
        try {
            object.getClass().getDeclaredField("prenom").set(object, "Second prenom");
        } catch (Exception e) {
            System.out.println("!!! Echec de la modification de l'attribut " + e.getMessage());
        }
        System.out.println(((Personne) object).getPrenom());

        // Parcourt les champs de la classe de l'objet Personne et affiche leurs noms, modificateurs et types
        for (Field champ : object.getClass().getDeclaredFields()) {
            System.out.println(champ.getName() + " " + champ.getModifiers() + " " + champ.getType().getName());
            System.out.println(Modifier.isPrivate(champ.getModifiers()));
        }

        System.out.println("===================================");
        ((Personne)object).setNom("GUIZMO");
        ((Personne)object).setAnneeNaissance(1975);

        // Parcourt à nouveau les champs de la classe de l'objet Personne
        // et vérifie si un champ a l'annotation ToCsv, puis affiche les données correspondantes
        for (Field champ : object.getClass().getDeclaredFields()) {
            if (champ.isAnnotationPresent(ToCsv.class)) {
                ToCsv annotation = champ.getAnnotation(ToCsv.class);
                String annot = annotation.value();
                String nomGetter = "get" + champ.getName().substring(0, 1).toUpperCase();
                Object data = object.getClass().getMethod(nomGetter).invoke(object);
                System.out.println(annot + " " + data);
            }
        }
    }
}
