package model;

/**
 * Created by David on 15/10/2015.
 */
public enum Team {

    IRELAND("IRE", "#008001"),
    SCOTLAND("SCO", "#2E2EFE"),
    AUSTRALIA("AUS", "#008000"),
    NEW_ZEALAND("NZL", "#000000"),
    WALES("WAL", "#FF0000"),
    SOUTH_AFRICA("ZAF", "#FFFF00"),
    FRANCE("FRA", "#0000CC"),
    ARGENTINA("ARG", "#74acdf");

    private String name;
    private String teamColor;

    private Team(String teamName, String teamColor) {
        this.name = teamName;
        this.teamColor = teamColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }


}
