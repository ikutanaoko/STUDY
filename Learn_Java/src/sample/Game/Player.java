package sample.Game;

import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ", how many stones do you want to remove? ");
        return scanner.nextInt();
    }


}
