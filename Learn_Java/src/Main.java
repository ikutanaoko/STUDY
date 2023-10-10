import game.Turn;
import game.PlayerTurn;
import game.ComputerTurn;

public class Main {
 public static void main(String[] args) {
  // Turnクラスのインスタンスを作成→呼び出す
  Turn turn = new Turn();
  turn.takeTurn();

  // PlayerTurnクラスのインスタンスを作成→呼び出す
  Turn playerTurn = new PlayerTurn();
  playerTurn.takeTurn();

  // ComputerTurnクラスのインスタンスを作成→呼び出す
  Turn computerTurn = new ComputerTurn();
  computerTurn.takeTurn();
 }
 
}
