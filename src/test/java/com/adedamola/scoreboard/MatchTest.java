package com.adedamola.scoreboard;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MatchTest {

    String homeTeam = "Mexico";
    String awayTeam = "Canada";

    @Test
    public void testCreateAMatchWithDefaultZeroScores(){
        Match match = new Match(homeTeam, awayTeam);
        assertNotNull(match);
    }

    @Test
    public void testGettersAndSettersOfMatch(){
        Match match = new Match();
        match.setAwayTeam(awayTeam);
        match.setHomeTeam(homeTeam);
        match.setHomeScore(1);
        match.setAwayScore(2);
        assertNotNull(match);
        assertEquals(homeTeam, match.getHomeTeam());
        assertEquals(awayTeam, match.getAwayTeam());
        assertEquals(1, match.getHomeScore());
        assertEquals(2, match.getAwayScore());
    }
}
