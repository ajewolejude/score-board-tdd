package com.adedamola.scoreboard;

import java.util.List;

public abstract class ScoreboardSummaryFormatter {
    protected String formatMatchesSummary(List<Match> summary) {
        StringBuilder formattedSummary = new StringBuilder("\n");
        for (Match match : summary) {
            formattedSummary.append(match.getHomeTeam()).append(" ").append(match.getHomeScore()).append(" - ")
                    .append(match.getAwayTeam()).append(" ").append(match.getAwayScore()).append("\n");
        }
        return formattedSummary.toString();
    }
}
