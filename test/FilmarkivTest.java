package test;

import impl.Film;
import impl.Filmarkiv;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {
    private Filmarkiv filmarkiv;

    public void setUp() {
        filmarkiv = new Filmarkiv(10);
    }

    @Test
    void finnFilm() {
/*        Film film1 = new Film(1, "Produsent 1", "Film 1", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent 2", "Film 2", 2002, "Selskap 2", Film.Sjanger.ACTION);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        Film funnetFilm1 = filmarkiv.finnFilm(1);
        assertEquals(film1, funnetFilm1);

        Film funnetFilm2 = filmarkiv.finnFilm(2);
        assertNull(funnetFilm2);
*/
    }

    @Test
    void leggTilFilm() {
    }

    @Test
    void slettFilm() {
    }

    @Test
    void soekTittel() {
    }

    @Test
    void soekProdusent() {
    }

    @Test
    void antall() {
    }

    @Test
    void testAntall() {
    }
}