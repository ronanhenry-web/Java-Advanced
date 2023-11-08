package org.ronan.apiDatetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var date1 = LocalDate.now();
        System.out.println("LocalDate actuelle : " + date1);

        var date2 = LocalDateTime.now();
//        System.out.println("LocalDateTime actuelle : " + date2.getDayOfWeek());
        System.out.println("LocalDateTime actuelle : " + date2);

        var date3 = ZonedDateTime.now();
        System.out.println("ZonedDateTime actuel : " + date3);

        var date_dans_120j = ZonedDateTime.now().plusDays(120);
        System.out.println("ZonedDateTime +120j : " + date_dans_120j);

        // Afficher le nom complet du jour de la semaine
        var jourSem = date_dans_120j.getDayOfWeek();
        var localisation = Locale.getDefault();
        System.out.println(jourSem.getDisplayName(
                java.time.format.TextStyle.FULL, localisation
        ));

        // Afficher le nom abrégé du mois en fonction
        var mois = date_dans_120j.getMonth();
        System.out.println(mois.getDisplayName(
                TextStyle.NARROW, localisation
        ));

        // ZoneOffset vs ZoneId
        System.out.println("================================");
        System.out.println(ZoneId.getAvailableZoneIds()
                .stream()
                .filter(nom -> nom.startsWith("Europe"))
                .collect(Collectors.toList())
        );
        System.out.println(ZoneId.of("Europe/Brussels")
                .getRules().getOffset(LocalDateTime.now().plusDays(180))
        );

        // Calcul de la date du jeudi précédent
        System.out.println(
            LocalDateTime.now().with(java.time.temporal.TemporalAdjusters.previous(
                    DayOfWeek.THURSDAY
            ))
        );

        // Temps absolu sans décalage horaire
        System.out.println(Instant.now());

        // Enlève le décalage toInstant
        System.out.println(ZonedDateTime.now().toInstant());

        System.out.println(DateTimeFormatter.ofPattern("dd/MM/YYYY B").format(LocalDateTime.now()));
    }
}
