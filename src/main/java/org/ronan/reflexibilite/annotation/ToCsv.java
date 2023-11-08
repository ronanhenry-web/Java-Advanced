package org.ronan.reflexibilite.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Définition des métadonnées de l'annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
// Déclaration de l'annotation personnalisée ToCsv
public @interface ToCsv {
    // Définition d'un élément nommé "value" de type String pour l'annotation
    String value();

    
}
