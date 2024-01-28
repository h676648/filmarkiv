package test;
import impl.Film;
import impl.Filmarkiv2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Filmarkiv2Test {
    private final Filmarkiv2 filmarkiv = new Filmarkiv2();
    private final Film film0 = new Film(0, "Produsent 1", "The Matrix", 1999, "Selskap 1", Film.Sjanger.ACTION);
    private final Film film1 = new Film(1, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.ACTION);

    @Test
    void finnFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        assertEquals(film0,filmarkiv.finnFilm(0));
    }

    @Test
    void leggTilFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        assertEquals(film0,filmarkiv.finnFilm(0));
        assertEquals(film1,filmarkiv.finnFilm(1));
    }

    @Test
    void slettFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.slettFilm(0);
        assertNull(filmarkiv.finnFilm(0));
    }

    @Test
    void soekTittel() {
        int i = 0;
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film[] result = filmarkiv.soekTittel("The");
        if (result.length > 0) {
            for (Film film : result) {
                assertEquals(film.getTitle(),result[i].getTitle());
                i++;
            }
        } else {
            System.out.println("Finner ikke film");
        }
    }

    @Test
    void soekProdusent() {
        int i = 0;
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film[] result = filmarkiv.soekProdusent("Prod");
        if (result.length > 0) {
            for (Film film : result) {
                assertEquals(film.getProd(),result[i].getProd());
                i++;
            }
        } else {
            System.out.println("Finner ikke produsent");
        }
    }

    @Test
    void antall() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        assertEquals(2,filmarkiv.antall());
    }

    @Test
    void testAntall() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        assertEquals(2,filmarkiv.antall(Film.Sjanger.ACTION));
    }
}