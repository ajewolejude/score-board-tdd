package com.adedamola.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard implements ScoreboardManager {

    private List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }
    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        if (homeTeam.equals("")) {
            throw new IllegalArgumentException("Home team cannot be empty.");
        }

        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    @Override
    public List<Match> getMatchesSummary() {
        List<Match> summary = new ArrayList<>(matches);
        return summary;
    }

}
