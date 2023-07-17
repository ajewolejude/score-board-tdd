package com.adedamola.scoreboard;

import java.util.List;

public interface ScoreboardManager {
    void startMatch(String homeTeam, String awayTeam);

    List<Match> getMatchesSummary();

    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);
}
