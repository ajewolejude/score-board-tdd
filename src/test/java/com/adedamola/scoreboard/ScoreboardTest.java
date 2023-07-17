package com.adedamola.scoreboard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreboardTest {

    @Test
    public void testStartMatch() {
        ScoreboardManager scoreboardManager = new Scoreboard();
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
    }

    @Test
    public void testStartMatchAndCheckMatchesStarted() {
        ScoreboardManager scoreboardManager = new Scoreboard();
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
        List<Match> matches = scoreboardManager.getMatchesSummary();
        assertEquals(1, matches.size());
    }



}
