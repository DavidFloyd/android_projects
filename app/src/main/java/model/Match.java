package model;

/**
 * Created by David on 15/10/2015.
 */
public class Match {

    private Team teamOne;
    private Team teamTwo;


    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public Team chooseAWinner() {
        int randomNum = 2 * (int) Math.random();
        if (randomNum == 0) {
            return teamTwo;
        } else {
            return teamOne;
        }
    }

    public boolean isWinnerValid(String name) {
        if (name.equals(teamOne.getName()) || name.equals(teamTwo.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isiMatchReadyToPlay() {
        if (teamOne != null && teamTwo != null) {
            return true;
        } else {
            return false;
        }
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }
}
