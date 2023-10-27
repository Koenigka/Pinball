import automat.Game;

import java.util.Scanner;

public class ThePinBallGame {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        game.play(scanner);
    }
}