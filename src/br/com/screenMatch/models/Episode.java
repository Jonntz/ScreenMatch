package br.com.screenMatch.models;

import br.com.screenMatch.calc.Classify;

public class Episode implements Classify {
    private int Number;
    private String name;
    private Serie serie;
    private int numberOfViews;

    public int getNumber () {
        return Number;
    }

    public void setNumber ( int number ) {
        Number = number;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Serie getSerie () {
        return serie;
    }

    public void setSerie ( Serie serie ) {
        this.serie = serie;
    }

    public int getNumberOfViews () {
        return numberOfViews;
    }

    public void setNumberOfViews ( int numberOfViews ) {
        this.numberOfViews = numberOfViews;
    }

    @Override
    public int getClassify () {
        if(numberOfViews > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
