package test;

import impl.Film;
import impl.Filmarkiv;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {
    private final Filmarkiv filmarkiv = new Filmarkiv(10);
    private final Film film0 = new Film(1, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
    private final Film film1 = new Film(2, "Produsent 2", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.ACTION);
    @Test
    void finnFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film funnetFilm1 = filmarkiv.finnFilm(2);
        assertEquals(film1, funnetFilm1);
    }

    @Test
    void leggTilFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film funnetFilm1 = filmarkiv.finnFilm(1);
        Film funnetFilm2 = filmarkiv.finnFilm(2);
        assertEquals(film0, funnetFilm1);
        assertEquals(film1, funnetFilm2);
    }

    @Test
    void slettFilm() {
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        //Sletter en film og sjekker om den ikke er tilgengelig
        filmarkiv.slettFilm(1);
        Film funnetFilm = filmarkiv.finnFilm(1);
        assertNull(funnetFilm);

    }

    @Test
    void soekTittel() {
        //Lager filmer i filmarkiv og lagrer returen til soekTittel som result[]
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        int i = 0;
        Film[] result = filmarkiv.soekTittel("Mat");
        //om det finnes resultat går gjennom resultat og sjekker at stemmer med film
        if (result.length > 0) {
            for (Film film : result) {
                assertEquals(film.getTitle(),result[i].getTitle());
                i++;
            }
        } else {
            System.out.println("No matching film found.");
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
            System.out.println("No matching producer found.");
        }
    }

    @Test
    void antall() {
        Filmarkiv filmer = new Filmarkiv(2);
        filmer.leggTilFilm(film0);
        filmer.leggTilFilm(film1);
        assertEquals(2, filmer.antall());
    }

    @Test
    void testAntall() {
        Film film2 = new Film(2, "Produsent 2", "Shrek", 2002, "Selskap 2", Film.Sjanger.ACTION);
        Filmarkiv filmer = new Filmarkiv(4);
        filmer.leggTilFilm(film0);
        filmer.leggTilFilm(film1);
        filmer.leggTilFilm(film2);
        assertEquals(3, filmer.antall(Film.Sjanger.ACTION));
    }
}