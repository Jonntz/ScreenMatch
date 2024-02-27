package br.com.screenMatch.models;

public class Serie extends Titles {
    private int seasons;
    private boolean isActive;
    private int episodesBySeason;
    private int minutesByEpisodes;

    public Serie ( String name, int year ) {
        super (name, year);
    }

    public int getSeasons () {
        return seasons;
    }

    public void setSeasons ( int seasons ) {
        this.seasons = seasons;
    }

    public boolean getIsActive () {
        return isActive;
    }

    public void setActive ( boolean active ) {
        this.isActive = active;
    }

    public int getEpisodesBySeason () {
        return episodesBySeason;
    }

    public void setEpisodesBySeason ( int episodesBySeason ) {
        this.episodesBySeason = episodesBySeason;
    }

    public int getMinutesByEpisodes () {
        return minutesByEpisodes;
    }

    public void setMinutesByEpisodes ( int minutesByEpisodes ) {
        this.minutesByEpisodes = minutesByEpisodes;
    }

    @Override
    public String toString () {
        return "Serie:" + this.getName() + " (" + this.getYear() + ")";
    }
    @Override
    public int getTimeInMinutes () {
        return seasons * episodesBySeason * minutesByEpisodes;
    }
}
