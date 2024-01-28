package klient;

import java.util.Arrays;
import java.util.Scanner;

import adt.FilmArkivADT;
import impl.Film;
import impl.Filmarkiv;
import klient.Meny;
public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);
    public Tekstgrensesnitt() {
        this.scanner = new Scanner(System.in);
    }
    public Film lesFilm(FilmArkivADT arkiv, int x) {
        //leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
        return arkiv.finnFilm(x);
    }

    public void skrivUtFilm(Film film) {
        //Skriver ut en film med alle opplysninger på skjerm
        System.out.println("Filmnr: "+film.getFilmnr()+ "/nTittel: " + film.getTitle() + "/nProdusent: " + film.getProd() + "/nYear: " + film.getYear() + "/nFilmselskap: "
                            + film.getFilmselskap()+"/nSjanger: " + film.getSjanger().toString());
    }

    public void skrivUtFilmDelstrengITittel(FilmArkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell delstreng i tittelen
        lesString("Tittel: ");
        System.out.println(Arrays.toString(arkiv.soekTittel(delstreng)));
        scanner.close();
    }

    public void skrivUtFilmProduusent(FilmArkivADT arkiv, String delstreng) {
        //Skriver ut alle filmer med en spesiell produsent
        lesString("Skriv inn produsent: ");
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
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.COMEDY)+ " Comedy filmer");
        System.out.println("Det finnes: "+ arkiv.antall(Film.Sjanger.THRILLER)+ " Thriller filmer");
    }



    public void visMelding(String melding) {
        System.out.println(melding);
    }

    public int lesHeltall(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Ugyldig inntast, prov igjen");
            System.out.print(prompt);
            scanner.next(); //bruker opp ugyldig nummer
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String lesString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public Film.Sjanger lesSjanger(String prompt) {
        System.out.print(prompt);
        String sjangerInput = scanner.nextLine().toUpperCase(); //Konverterer input til store bokstaver

        try {
            return Film.Sjanger.valueOf(sjangerInput);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ugyldig sjanger. Prov igjen");
            return lesSjanger(prompt);
        }
    }
}