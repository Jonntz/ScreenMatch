package br.com.screenMatch.models;

import br.com.screenMatch.Exceptions.ConvertErrorYearException;
import com.google.gson.annotations.SerializedName;

public class Titles implements Comparable<Titles>{

    private String name;

    private int year;
    private int timeInMinutes;
    private boolean includedOnPlan;
    private double rating;
    private int numberOfRatings;

    public Titles (String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Titles (OmdbTitle title) {
        this.name = title.title();

        if (title.year().length() > 4){
            throw new ConvertErrorYearException("O ano tem mais de 4 caracteres");
        }
        this.year = Integer.valueOf(title.year());
        this.timeInMinutes = Integer.valueOf(title.runtime().substring(0, 2)) * 60;
    }

    public void showInfo(){
        System.out.println("Nome do filme: " + name);
        System.out.println("Ano de Lançamento: " + year);
        System.out.println("Duração: " + timeInMinutes);
        System.out.println("Inclui no plano? " + includedOnPlan);
    }

    public void rate(double grade){
        this.rating += grade;
        this.numberOfRatings++;
    }

    public double calculateAverage(){
        return this.rating / this.numberOfRatings;
    }

    public String getName () {
        return this.name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getYear () {
        return year;
    }

    public void setYear ( int year ) {
        this.year = year;
    }

    public int getTimeInMinutes () {
        return timeInMinutes;
    }

    public void setTimeInMinutes ( int timeInMinutes ) {
        this.timeInMinutes = timeInMinutes;
    }

    public boolean isIncludedOnPlan () {
        return includedOnPlan;
    }

    public void setIncludedOnPlan ( boolean includedOnPlan ) {
        this.includedOnPlan = includedOnPlan;
    }

    public double getRating () {
        return rating;
    }

    public void setRating ( double rating ) {
        this.rating = rating;
    }

    public int getNumberOfRatings () {
        return numberOfRatings;
    }

    public void setNumberOfRatings ( int numberOfRatings ) {
        this.numberOfRatings = numberOfRatings;
    }


    @Override
    public String toString () {
        return "\n(Nome: " + getName()
                + "\nAno de lançamento: " + getYear()
                + "\nDuração (em minutos): " + getTimeInMinutes() + ")";
    }

    @Override
    public int compareTo (Titles anotherTitle ) {
        return this.getName().compareTo(anotherTitle.getName());
    }
}
