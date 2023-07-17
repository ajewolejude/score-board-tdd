package com.adedamola.scoreboard;

import java.util.*;

public class Scoreboard extends ScoreboardSummaryFormatter implements ScoreboardManager {

    private List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }
    @Override
    public void startMatch(String homeTeam, String awayTeam) {

        if (homeTeam == null || Objects.equals(homeTeam, "") || awayTeam == null || Objects.equals(awayTeam, "")) {
            throw new IllegalArgumentException("Home team and Away Team cannot be empty, Home team cannot be null");
        }

        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    @Override
    public List<Match> getMatchesSummary() {
        List<Match> summary = new ArrayList<>(matches);
        Collections.sort(summary, Comparator.comparing(Match::getTotalScore).reversed());
        return summary;
    }

    @Override
    protected String formatMatchesSummary(List<Match> summary) {
        return super.formatMatchesSummary(summary);
    }

    public String getFormattedMatchesSummary() {
        return formatMatchesSummary(getMatchesSummary());
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = findMatch(homeTeam, awayTeam);
        if (match == null) {
            throw new IllegalArgumentException("Match does not exist");
        }
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);

    }

    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        Match match = findMatch(homeTeam, awayTeam);
        if (match == null) {
            throw new IllegalArgumentException("Match does not exist");
        }
        matches.remove(match);
    }

    private Match findMatch(String homeTeam, String awayTeam) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                return match;
            }
        }
        return null;
    }

}
