package br.com.screenMatch.calc;

import br.com.screenMatch.models.Titles;

public class TimeCalc {
    private int timeTotal;

    public int getTimeTotal () {
        return timeTotal;
    }

    public void include(Titles title){
        this.timeTotal += title.getTimeInMinutes();
    }

}
