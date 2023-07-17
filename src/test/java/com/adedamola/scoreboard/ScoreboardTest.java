package com.adedamola.scoreboard;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ScoreboardTest {
    private Scoreboard scoreboardManager =  new Scoreboard();

    @Test
    public void testStartMatch() {
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
    }

    @Test
    public void testStartOneMatch() {
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
        List<Match> matches = scoreboardManager.getMatchesSummary();
        assertEquals(1, matches.size());
    }

    @Test
    public void testStartMultipleMatchesAndCheckSummary() {
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

    @Test(expected = IllegalArgumentException.class)
    public void testStartMatchWithNullHomeTeam() {
        ScoreboardManager scoreboard = new Scoreboard();
        scoreboard.startMatch(null, "Away Team");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartMatchWithEmptyAwayTeam() {
        ScoreboardManager scoreboard = new Scoreboard();
        scoreboard.startMatch("Home Team", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartMatchWithNullAwayTeam() {
        ScoreboardManager scoreboard = new Scoreboard();
        scoreboard.startMatch("Home Team", null);
    }


    @Test
    public void testUpdateScore() {
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.updateScore("Mexico", "Canada", 4, 5);

        List<Match> matches = scoreboardManager.getMatchesSummary();
        Match match = matches.get(0);
        Assertions.assertEquals(4, match.getHomeScore());
        Assertions.assertEquals(5, match.getAwayScore());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testUpdateScoresWhenTheNatchDoesNotExist() {
        ScoreboardManager scoreboardManager = new Scoreboard();
        scoreboardManager.updateScore("Mexico", "Canada", 4, 5);
    }


    @Test
    public void testFinishMatch() {
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.startMatch("Spain", "Brazil");
        scoreboardManager.startMatch("Morocco", "England");

        scoreboardManager.finishMatch("Mexico", "Canada");

        List<Match> matches = scoreboardManager.getMatchesSummary();
        Assertions.assertEquals(2, matches.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFinishMatchWhenTheNatchDoesNotExist() {
        ScoreboardManager scoreboardManager = new Scoreboard();
        scoreboardManager.startMatch("Spain", "Brazil");
        scoreboardManager.startMatch("Morocco", "England");
        scoreboardManager.finishMatch("Mexico", "Canada");
    }


    @Test
    public void testReturnMatchSummary() {
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.updateScore("Mexico", "Canada", 4, 5);

        List<Match> matches = scoreboardManager.getMatchesSummary();
        Match match = matches.get(0);
        Assertions.assertEquals(4, match.getHomeScore());
        Assertions.assertEquals(5, match.getAwayScore());
    }

    @Test
    public void testReturnMatchSummaryInOrderOfTotalGoals() {
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.startMatch("Spain", "Brazil");
        scoreboardManager.startMatch("Morocco", "England");
        scoreboardManager.updateScore("Mexico", "Canada", 2, 2);
        scoreboardManager.updateScore("Spain", "Brazil", 7, 1);
        scoreboardManager.updateScore("Morocco", "England", 0, 1);

        List<Match> matches = scoreboardManager.getMatchesSummary();
        Assertions.assertEquals(7, matches.get(0).getHomeScore());
        Assertions.assertEquals(1, matches.get(0).getAwayScore());
        Assertions.assertEquals(2, matches.get(1).getHomeScore());
        Assertions.assertEquals(2, matches.get(1).getAwayScore());
        Assertions.assertEquals(0, matches.get(2).getHomeScore());
        Assertions.assertEquals(1, matches.get(2).getAwayScore());
    }

    @Test
    public void testReturnFormattedMatchSummary() {
        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.startMatch("Spain", "Brazil");
        scoreboardManager.startMatch("Morocco", "England");
        scoreboardManager.updateScore("Mexico", "Canada", 2, 2);
        scoreboardManager.updateScore("Spain", "Brazil", 7, 1);
        scoreboardManager.updateScore("Morocco", "England", 0, 1);


        String summary = scoreboardManager.getFormattedMatchesSummary();
        assertNotNull(summary);
    }

    @Test
    public void testReturnMatchSummaryWhenTwoMatchesHasSameGoals() {

        scoreboardManager.startMatch("Mexico", "Canada");
        scoreboardManager.startMatch("Morocco", "England");
        scoreboardManager.startMatch("Qatar", "Egypt");
        scoreboardManager.startMatch("Spain", "Brazil");
        scoreboardManager.updateScore("Mexico", "Canada", 2, 2);
        scoreboardManager.updateScore("Spain", "Brazil", 7, 1);
        scoreboardManager.updateScore("Qatar", "Egypt", 7, 1);
        scoreboardManager.updateScore("Morocco", "England", 0, 1);


        List<Match> matches = scoreboardManager.getMatchesSummary();
        Assertions.assertEquals("Qatar", matches.get(0).getHomeTeam());
        Assertions.assertEquals("Egypt", matches.get(0).getAwayTeam());
        Assertions.assertEquals("Spain", matches.get(1).getHomeTeam());
        Assertions.assertEquals("Brazil", matches.get(1).getAwayTeam());
    }



}
