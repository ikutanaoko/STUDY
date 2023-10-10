package sample.Game;

public class Game {
    protected int stones;

    public Game(int initialStones) {
        this.stones = initialStones;
    }

    public void displayStones() {
        System.out.println("Remaining stones: " + stones);
    }

    public boolean isGameOver() {
        return stones <= 0;
    }

    public void playTurn(Player player) {
        int stonesToRemove = player.makeMove();
        stones -= stonesToRemove;
        System.out.println(player.getName() + " removed " + stonesToRemove + " stones.");
    }
}
