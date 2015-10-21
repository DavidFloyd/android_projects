package model;

import java.util.List;

/**
 * Created by David on 15/10/2015.
 */
public class WorldCup {

    private Round quarterFinals;
    private Round semiFinals;
    private Round theFinal;

    public List<Team> playTheQuarters() {
        return quarterFinals.playMatchesForRound();
    }

    public List<Team> playTheSemis() {
        return semiFinals.playMatchesForRound();
    }

    public List<Team> playTheFinal() {
        return theFinal.playMatchesForRound();
    }

    public Round getQuarterFinals() {
        return quarterFinals;
    }

    public void setQuarterFinals(Round quarterFinals) {
        this.quarterFinals = quarterFinals;
    }

    public Round getSemiFinals() {
        return semiFinals;
    }

    public void setSemiFinals(Round semiFinals) {
        this.semiFinals = semiFinals;
    }

    public Round getTheFinal() {
        return theFinal;
    }

    public void setTheFinal(Round theFinal) {
        this.theFinal = theFinal;
    }
}
