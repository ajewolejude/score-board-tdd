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



}
