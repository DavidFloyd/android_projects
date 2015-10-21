package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 15/10/2015.
 */
public class Round {

    private ArrayList<Match> theMatches;

    public Round() {
        this.theMatches = new ArrayList<Match>();
    }

    public void addMatch(Match aMatch) {
        this.theMatches.add(aMatch);
    }

    public List<Team> playMatchesForRound() {
        ArrayList<Team> winners = new ArrayList<Team>();
        for (Match aMatch : theMatches) {
            winners.add(aMatch.chooseAWinner());
        }
        return winners;
    }

    public ArrayList<Match> getTheMatches() {
        return theMatches;
    }

    public void setTheMatches(ArrayList<Match> theMatches) {
        this.theMatches = theMatches;
    }
}
