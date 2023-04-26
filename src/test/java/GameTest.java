import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Данила", 100);
    Player player2 = new Player(2, "Егор", 25);
    Player player3 = new Player(3, "Кирилл", 25);
    Player player4 = new Player(4, "Марк", 35);
    Player player5 = new Player(5, "Тарас", 150);
    Player player6 = new Player(6, "Юрий", 350);
    Game game = new Game();

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
    }

    @Test
    public void gameTournamentTestTheFirst() {
        int expected = 2;
        int actual = game.round("Данила", "Юрий");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheSecond() {
        int expected = 1;
        int actual = game.round("Тарас", "Марк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheThird() {
        int expected = 0;
        int actual = game.round("Кирилл", "Егор");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheFourth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Кирилл", "Игорь");
        });
    }

    @Test
    public void gameTournamentTestTheFifth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Валера", "Марк");
        });
    }

    @Test
    public void gameTournamentTestTheSixth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Слава");
        });
    }

    @Test
    public void getIdTestTheSeventh() {
        int expected = 4;
        int actual = player4.getId();
        Assertions.assertEquals(expected, actual);
    }
}
