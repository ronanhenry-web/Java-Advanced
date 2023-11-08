package org.ronan.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream1 = Arrays.stream(args);

        Stream<String> stream2 = // nombres en lettres de 1 à 10
        Stream.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix");

        List<String> liste = List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix");
        Stream<String> stream3 = // à partir d'une collection
                liste.stream();

        System.out.println(liste);
        // Comptage des 4 premiers éléments qui suivent les 3 premiers
        System.out.println(stream3.skip(3).limit(4).count());

        // Comptage des 4 premiers éléments qui suivent les 3 premiers et qui on un nombre de lettres pair
        stream3 = liste.stream();
        System.out.println(stream3.skip(3)
                .peek( (s) -> System.out.println(s))
                .filter((String p) -> p.length() % 2 == 0)
                .limit(4)
                .count());

        System.out.println("===================================");

        stream3 = liste.stream();
        System.out.println(stream3.map((nombre) -> nombre.length())
                .min((n1, n2) -> n1 - n2)
        );
        System.out.println(Stream.of(new String[][]{{"un", "deux"}, {"trois", "quatre"}})
                        .flatMap(
                                (tableau) ->Arrays.stream(tableau)
                        )
                .peek(System.out::println)
                .map((nombre) -> nombre.length())
                .min((n1, n2) -> n1 - n2)
        );

        System.out.println("===================================");
        stream3 = liste.stream();
        stream3
                .filter((nom) -> nom.length() % 2 == 0)
                .forEach((e) -> System.out.println(e));

        liste.forEach((e) -> System.out.println(e));

        System.out.println(
                liste.stream().filter((ch) -> ch.contains("e")).findFirst()
        );

        Stream<String> stream4 = liste.stream();
        stream4 = stream4.filter((ch) -> ch.contains("e"));
        List<String> liste3 = stream4.collect(Collectors.toList());

        System.out.println(liste3);
    }
}
