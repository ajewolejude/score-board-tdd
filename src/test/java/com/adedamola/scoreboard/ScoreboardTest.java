package com.adedamola.scoreboard;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.security.PrivateKey;
import java.util.List;
import java.util.PropertyResourceBundle;

import static org.junit.Assert.assertEquals;

public class ScoreboardTest {

    private List<Match> matches;

    private ScoreboardManager scoreboardManager;

    @BeforeEach
    public void setup() {
        scoreboardManager = new Scoreboard();
    }

    @Test
    public void testStartMatch() {
         scoreboardManager = new Scoreboard();
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
    }

    @Test
    public void testStartOneMatch() {
         scoreboardManager = new Scoreboard();
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
        List<Match> matches = scoreboardManager.getMatchesSummary();
        assertEquals(1, matches.size());
    }

    @Test
    public void testStartMultipleMatchesAndCheckSummary() {
        scoreboardManager = new Scoreboard();
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.startMatch("Brazil", "Italy");
        scoreboardManager.startMatch("Congo", "India");
        List<Match> matches = scoreboardManager.getMatchesSummary();
        assertEquals(3, matches.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testStartMatchWithEmptyHomeTeam() {
        ScoreboardManager scoreboard = new Scoreboard();
        scoreboard.startMatch("", "Away Team");
    }



}
