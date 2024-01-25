package klient;

import java.util.Scanner;
import impl.Film;

public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);
    public Film lesFilm() {
        //leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
        System.out.println("Skriv inn tittel på film: ");
        String temp = scanner.nextLine();
    }

    public void skrivUtFilm(Film film) {
        //Skriver ut en film med alle opplysninger på skjerm

    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell delstreng i tittelen

    }

    public void skrivUtFilmProduusent(FilmarkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell produsent

    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        //Skriver ut en enkel statistikk som inneholder antall filmer totalt og hvor mange i hver sjanger

    }
}
