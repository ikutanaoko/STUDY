package sample.Game;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeMove() {
        Random random = new Random();
        int stonesToRemove = random.nextInt(3) + 1; // Remove 1 to 3 stones randomly
        System.out.println(getName() + " removed " + stonesToRemove + " stones.");
        return stonesToRemove;
    }
}
