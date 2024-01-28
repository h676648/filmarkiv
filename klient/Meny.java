package klient;
import impl.Film;
import adt.FilmArkivADT;

public class Meny {
    public FilmArkivADT filmarkiv;
    Tekstgrensesnitt tekstgr;
    public Meny(FilmArkivADT filmarkiv) {
        this.tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        //legg inn en del forhåndsdefinerte filmer for å teste metodene
        ferdigFilmer();

        //Main meny loop
        while (true) {
            tekstgr.visMelding("Velg en handling:");
            tekstgr.visMelding("1. Legg til ny film");
            tekstgr.visMelding("2. Finn film");
            tekstgr.visMelding("3. Slett film");
            tekstgr.visMelding("4. Vis alle filmer");
            tekstgr.visMelding("5. Avslutt");

            int valg = tekstgr.lesHeltall("Skriv inn valget ditt: ");

            switch (valg) {
                case 1:
                    leggTilNyFilm();
                    break;
                case 2:
                    finnFilm();
                    break;
                case 3:
                    slettFilm();
                    break;
                case 4:
                    visAlleFilmer();
                    break;
                case 5:
                    tekstgr.visMelding("Avslutter programmet.");
                    System.exit(0);
                default:
                    tekstgr.visMelding("Ugyldig valg. Prov igjen");
            }
        }

    }

    public void ferdigFilmer() {
        Film film1 = new Film(1, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film3 = new Film(3, "Produsent 1", "The Matrix Revolution", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film4 = new Film(4, "Produsent 2", "Barbie", 2002, "Selskap 2", Film.Sjanger.COMEDY);
        Film film5 = new Film(5, "Produsent 3", "Oppenheimer", 2002, "Selskap 3", Film.Sjanger.DRAMA);
        Film film6 = new Film(6, "Produsent 4", "Shrek 3", 2002, "Selskap 4", Film.Sjanger.COMEDY);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
    }

    private void leggTilNyFilm() {
        int filmNr = filmarkiv.antall()+1;
        String tittel = tekstgr.lesString("Skriv inn tittel: ");
        String prod = tekstgr.lesString("Skriv inn produsent: ");
        int year = tekstgr.lesHeltall("Skriv inn aar: ");
        String selskap = tekstgr.lesString("Skriv inn filmselskap: ");
        Film.Sjanger sjanger = tekstgr.lesSjanger("Skriv inn sjanger: (Comedy, Scifi, Drama, History, Thriller, Action) ");
        Film film = new Film(filmNr,tittel, prod, year, selskap, sjanger);
        filmarkiv.leggTilFilm(film);
        tekstgr.visMelding("Film lagt til!");
    }

    private void finnFilm() {
        tekstgr.visMelding("Hvordan vil du finne film?" );
        int input = tekstgr.lesHeltall
                ("""
                        1: Soek etter tittel
                        2: Soek etter produsent
                        3: Soek etter filmnr
                        """
                );

        switch (input) {
            case 1:
                soekTittel();
                break;
            case 2:
                soekProd();
                break;
            case 3:
                finnFilmnr();
                break;
            default:
                tekstgr.visMelding("Feil ved inntast. Prov igjen. ");
        }
    }


    private void soekTittel() {
        Film[] soekTittel = filmarkiv.soekTittel(tekstgr.lesString("Skriv tittel:"));
        for (Film film : soekTittel) {
            System.out.println(film.toString()+"\n");
        }
    }

    private void soekProd() {
        Film[] soekProd = filmarkiv.soekProdusent(tekstgr.lesString("Skriv produsent: "));
        for (Film film : soekProd) {
            System.out.println(film.toString()+"\n");
        }
    }
    private void finnFilmnr() {
        int filmnr = tekstgr.lesHeltall("Skriv filmnr: (Heltall over 0) ");
        Film film = filmarkiv.finnFilm(filmnr);
        System.out.println(film.toString(film));
    }

    private void slettFilm() {
        tekstgr.visMelding("Hvordan vil du finne film? ");
        int input = tekstgr.lesHeltall
                ("""
                        1: Soek etter tittel
                        2: Soek etter produsent
                        3: Soek etter filmnr
                        """
                );

        switch (input) {
            case 1:
                Film[] soekTittel = filmarkiv.soekTittel(tekstgr.lesString("Skriv tittel: "));
                for (Film film : soekTittel) {
                    int filmnr = film.getFilmnr();
                    filmarkiv.slettFilm(filmnr);
                    tekstgr.visMelding("Film slettet! ");
                }
                break;
            case 2:
                Film[] soekProd = filmarkiv.soekProdusent(tekstgr.lesString("Skriv produsent: "));
                for (Film film : soekProd) {
                    int filmnr = film.getFilmnr();
                    filmarkiv.slettFilm(filmnr);
                    tekstgr.visMelding("Film slettet! ");
                }
                break;
            case 3:
                int filmnr = tekstgr.lesHeltall("Skriv filmnr: (Heltall over 0) ");
                filmarkiv.slettFilm(filmnr);
                tekstgr.visMelding("Film slettet! ");
                break;
            default:
                tekstgr.visMelding("Feil ved inntast. Prov igjen. ");
        }
    }

    private void visAlleFilmer() {
        Film[] filmer = filmarkiv.soekTittel("");
        for (Film film : filmer) {
            try {
                if (film != null) {
                    System.out.println(film);
                }
            } catch (NullPointerException e) {
                return;
            }
        }
    }
}


