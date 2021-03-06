package com.github.sikoried.sl.live;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EDTest {

    @Test
    void edit() {
        assertEquals(4.0, ED.edit("Haus", "", 1, 1, 1));
        assertEquals(0.0, ED.edit("Haus", "Haus", 1, 1, 1));
        assertEquals(1.0, ED.edit("Haus", "Hans", 1, 1, 1));
        assertEquals(4.0, ED.edit("", "Hans", 1, 1, 1));
        assertEquals(6.0, ED.edit("kühler schrank", "schüler krank", 1, 1, 1));
        assertEquals(7.0,0, ED.edit("gurken schaben", "schurkengaben", 1, 1, 1));
        assertEquals(4.0, ED.edit("nicht ausgeloggt", "licht ausgenockt", 1, 1, 1));
    }

    @Test
    void loadVocab() throws IOException, URISyntaxException {
        ED.loadVocab().stream().limit(5).forEach(System.out::println);
    }

    @Test
    void suggest() throws IOException, URISyntaxException {
        List<Pair<String, Long>> vocab = ED.loadVocab();

        ED.suggest(vocab, "about", 5)
                .forEach(System.out::println);
    }

    @Test
    void edit2() {

        System.out.println(ED.weight('a', 'q'));
        System.out.println(ED.weight('a', 'w'));
        System.out.println(ED.weight('a', 's'));
        System.out.println(ED.weight('a', 'd'));
        System.out.println(ED.weight('a', 'g'));
        System.out.println(ED.weight('a', 'h'));

        System.out.println();

        System.out.println(ED.edit("nicht ausgeloggt", "licht ausgenockt", 1, 1, 1));
        System.out.println(ED.edit2("nicht ausgeloggt", "licht ausgenockt", 1, 1, 1));

        System.out.println();

        System.out.println(ED.edit("hans", "haus", 1, 1, 1));
        System.out.println(ED.edit2("hans", "haus", 1, 1, 1));
        System.out.println(ED.edit2("hans", "haps", 1, 1, 1));
    }
}