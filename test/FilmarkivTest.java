package test;

import impl.Film;
import impl.Filmarkiv;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {
    private Filmarkiv filmarkiv = new Filmarkiv(10);
    private Film film0;
    private Film film1;
    @Test
    void finnFilm() {
        Film film0 = new Film(1, "Produsent 1", "Film 1", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(2, "Produsent 2", "Film 2", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film funnetFilm1 = filmarkiv.finnFilm(2);
        assertEquals(film1, funnetFilm1);
    }

    @Test
    void leggTilFilm() {
        Film film0 = new Film(0, "Produsent 1", "Film 1", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 2", "Film 2", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);
        Film funnetFilm1 = filmarkiv.finnFilm(0);
        Film funnetFilm2 = filmarkiv.finnFilm(1);
        assertEquals(film0, funnetFilm1);
        assertEquals(film1, funnetFilm2);
    }

    @Test
    void slettFilm() {
        Film film0 = new Film(0, "Produsent 1", "Film 1", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 2", "Film 2", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        filmarkiv.leggTilFilm(film0);
        filmarkiv.leggTilFilm(film1);

        //Sletter en film og sjekker om den ikke er tilgengelig
        filmarkiv.slettFilm(1);
        Film funnetFilm = filmarkiv.finnFilm(1);
        assertNull(funnetFilm);

    }

    @Test
    void soekTittel() {
        int i = 0;
        Film film0 = new Film(0, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 2", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        Filmarkiv filma = new Filmarkiv(4);
        Film[] result = filma.soekTittel("Mat");
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
        Film film0 = new Film(0, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        Filmarkiv filma = new Filmarkiv(4);
        Film[] result = filma.soekTittel("Mat");
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
        Film film0 = new Film(0, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        Filmarkiv filmer = new Filmarkiv(2);
        filmer.leggTilFilm(film0);
        filmer.leggTilFilm(film1);
        assertEquals(2, filmer.antall());
    }

    @Test
    void testAntall() {
        Film film0 = new Film(0, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film1 = new Film(1, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 2", Film.Sjanger.SCIFI);
        Filmarkiv filmer = new Filmarkiv(2);
        filmer.leggTilFilm(film0);
        filmer.leggTilFilm(film1);
        assertEquals(1, filmer.antall(Film.Sjanger.SCIFI));
    }
}