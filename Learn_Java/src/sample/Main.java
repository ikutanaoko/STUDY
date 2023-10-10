
package sample;
import sample.Game.Game;
import sample.Game.Player;
import sample.Game.ComputerPlayer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(20); // Start the game with 20 stones
        Player player = new Player("Player 1");
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer");

        while (!game.isGameOver()) {
            game.displayStones();
            game.playTurn(player);
            if (game.isGameOver()) {
                System.out.println(player.getName() + " wins!");
                break;
            }
            game.displayStones();
            game.playTurn(computerPlayer);
            if (game.isGameOver()) {
                System.out.println(computerPlayer.getName() + " wins!");
            }
        }
    }
}
