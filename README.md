
# Live Football World Cup Scoreboard

This is a Java application that provides a Live Football World Cup Scoreboard. It allows users to manage ongoing matches, update scores, finish matches, and retrieve match summaries.

## Architecture

The application follows a layered architecture with the following components:

1. Presentation Layer: The main class (`ScoreboardApplication`) serves as the entry point for the application, allowing users to interact with the scoreboard.

2. Domain Layer: The `Match` class represents a football match, encapsulating the match details and scores.

3. Service Layer: The `Scoreboard` class acts as the service layer and implements the `ScoreboardManager` interface. It provides methods to manage matches, update scores, and retrieve match summaries. The class extends the `ScoreboardSummaryFormatter` abstract class to format match summaries.

4. Testing Layer: The test classes (`MatchTest` and `ScoreboardTest`) contain unit tests to ensure the functionality and behavior of the `Match` and `Scoreboard` classes.

## Testing Strategy

The application follows a Test-Driven Development (TDD) approach. The test cases were written first to define the expected behavior and drive the development process. The tests cover various scenarios, including starting matches, updating scores, finishing matches, and retrieving match summaries.

## Usage

To use the Live Football World Cup Scoreboard, follow these steps:

1. Instantiate the `Scoreboard` class.
2. Start a match using the `startMatch()` method, providing the home team and away team names.
3. Update the score of a match using the `updateScore()` method, specifying the home team, away team, and new scores.
4. Finish a match using the `finishMatch()` method, providing the home team and away team names.
5. Retrieve the match summaries using the `getMatchesSummary()` method, which returns string representation of the ongoing matches and their scores.
5. Retrieve the match summaries using the `getFormattedMatchesSummary()` method, which returns a formatted string representation of the ongoing matches and their scores.

## Example

```java
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
```

## Requirements

- Java 8 or higher

## License

This project is licensed under the [MIT License](LICENSE).