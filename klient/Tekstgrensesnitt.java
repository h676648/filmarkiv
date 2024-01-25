package klient;

import java.util.Arrays;
import java.util.Scanner;

import adt.FilmArkivADT;
import impl.Film;
import impl.Filmarkiv;
import klient.Meny;

public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);
    public Film lesFilm(FilmArkivADT arkiv, int x) {
        //leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
        return arkiv.finnFilm(x);
    }

    public void skrivUtFilm(Film film) {
        //Skriver ut en film med alle opplysninger på skjerm
        System.out.println("Filmnr: "+film.getFilmnr()+ "/nTittel: " + film.getTitle() + "/nProdusent: " + film.getProd() + "/nYear: " + film.getYear() + "/nFilmselskap: "
                            + film.getFilmselskap()+"/nSjanger: " + film.getSjanger());
    }

    public void skrivUtFilmDelstrengITittel(FilmArkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell delstreng i tittelen
        System.out.println("Delstreng i tittel: ");
        String temp = scanner.nextLine();
        System.out.println(Arrays.toString(arkiv.soekTittel(delstreng)));
        scanner.close();
    }

    public void skrivUtFilmProduusent(FilmArkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell produsent
        System.out.println("Delstreng i produsent: ");
        String temp = scanner.nextLine();
        System.out.println(Arrays.toString(arkiv.soekProdusent(delstreng)));
        scanner.close();
    }

    public void skrivUtStatistikk(FilmArkivADT arkiv) {
        //Skriver ut en enkel statistikk som inneholder antall filmer totalt og hvor mange i hver sjanger
        System.out.println("Det finnes: "+ arkiv.antall()+ " filmer totalt");
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.ACTION)+ " Action filmer");
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.SCIFI)+ " Sci-Fi filmer");
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.HISTORY)+ " History filmer");
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.DRAMA)+ " Drama filmer");

    }
}
