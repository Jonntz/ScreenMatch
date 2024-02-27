package br.com.screenMatch.models;

import br.com.screenMatch.calc.Classify;

public class Movie extends Titles implements Classify {
    private String director;

    public Movie (String name, int year) {
        super (name, year);
    }

    public String getDirector () {
        return director;
    }

    public void setDirector ( String director ) {
        this.director = director;
    }

    @Override
    public int getClassify() {
        return (int) getRating() / 2;
    }

    @Override
    public String toString () {
        return "Filme:" + this.getName() + " (" + this.getYear() + ")";
    }
}
