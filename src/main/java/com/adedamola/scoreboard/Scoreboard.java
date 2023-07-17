package com.adedamola.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scoreboard implements ScoreboardManager {

    private List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }
    @Override
    public void startMatch(String homeTeam, String awayTeam) {

        if (homeTeam == null || Objects.equals(homeTeam, "") || Objects.equals(awayTeam, "")) {
            throw new IllegalArgumentException("Home team and Away Team cannot be empty, Home team cannot be null");
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
