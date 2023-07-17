package com.adedamola.scoreboard;

import org.junit.Test;

public class ScoreboardTest {

    @Test
    public void testStartMatch() {
        ScoreboardManager scoreboardManager = new Scoreboard();
        String homeTeam = "Mexico";
        String awayTeam = "Canada";

        scoreboardManager.startMatch(homeTeam, awayTeam);
    }
}
