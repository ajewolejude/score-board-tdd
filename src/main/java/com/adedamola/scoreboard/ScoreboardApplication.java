package com.adedamola.scoreboard;

public class ScoreboardApplication {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();

        // Start matches
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.startMatch("Germany", "France");

        // Update scores
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.updateScore("Germany", "France", 2, 2);

        System.out.println("Matches Summary 1: " + scoreboard.getFormattedMatchesSummary());

        // Finish matches
        scoreboard.finishMatch("Mexico", "Canada");

        // Get matches summary
        System.out.println("Matches Summary 2: " + scoreboard.getFormattedMatchesSummary());


    }
}

