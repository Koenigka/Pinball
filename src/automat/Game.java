package automat;

import commands.GameController;
import commands.RampController;
import factory.BallOne;
import factory.BallOne2;
import factory.GraffitiFactory;
import factory.StarFactory;
import flipperElements.*;
import mediator.FlipperMediator;
import visitor.PointVisitor;
import visitor.ResetVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Machine machine = Machine.getMachineInstance();

    private List<FlipperElement> elements = new ArrayList<>();

    private Random random = new Random();


    ResetVisitor reset = new ResetVisitor();
    PointVisitor counter = new PointVisitor();
    GameController gameController = new GameController(machine, reset, counter);
    RampController rampController = new RampController(machine);


    Flipper rightFlipper = new Flipper("Right Flipper");
    Flipper leftFlipper = new Flipper("Left Flipper");

    List<Bumper> bumpers = new ArrayList<>();
    Bumper bumper1 = new Bumper("BUMPER 1", gameController);
    Bumper bumper2 = new Bumper("BUMPER 2", gameController);
    Bumper bumper3 = new Bumper("BUMPER 3", gameController);


    Ramp ramp = new Ramp("RAMP", rampController);

    Hole hole = new Hole("HOLE", gameController);

    List<Target> targets = new ArrayList<>();
    Target target1 = new Target("TARGET 1", gameController);
    Target target2 = new Target("TARGET 2", gameController);
    Target target3 = new Target("TARGET 3", gameController);

    FlipperMediator mediator = new FlipperMediator(elements, ramp);

    public Game() {
    }



    public void setPinballElements() {

        elements.add(hole);
        elements.add(rightFlipper);
        elements.add(leftFlipper);
        elements.add(ramp);
        bumpers.add(bumper1);
        bumpers.add(bumper2);
        bumpers.add(bumper3);
        elements.addAll(bumpers);
        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
        elements.addAll(targets);
        for (Target target : targets) {
            target.setMediator(mediator);
        }
        machine.setElements(elements);
    }

    public void play(Scanner scanner) {
        setPinballElements();
        styleChoice(scanner);
        promptUserActions(scanner);

    }

    public void styleChoice(Scanner scanner){
        System.out.println("Choose your style:");
        System.out.println("************************************************************************************************");
        System.out.println(new BallOne().showBall());
        System.out.println("********************************************** OR **********************************************");
        System.out.println(new BallOne2().showBall());
        System.out.println("************************************************************************************************");

        int factoryChoice;
        do {
            System.out.print("Please enter your choice (1 or 2): ");
            factoryChoice = scanner.nextInt();
            if (factoryChoice == 1) {
                System.out.println("You have chosen Nr. 1");
                machine.setFactory(new StarFactory());
            } else if (factoryChoice == 2) {
                System.out.println("You have chosen Nr. 2");
                machine.setFactory(new GraffitiFactory());
            } else {
                System.out.println("Please choose between 1 or 2");
            }
        } while(factoryChoice != 1 && factoryChoice != 2);
    }


    public void promptUserActions(Scanner scanner) {
        boolean unavailableChoice = true;
        while (unavailableChoice) {
            System.out.println("To add credit press 1, to start the game press 2, to leave the game press 3.");
            System.out.println("Your credit is: " + machine.getCredit());
            int noCreditChoice = scanner.nextInt();
            if (noCreditChoice == 1) {
                machine.getState().addCoin(machine);
                unavailableChoice = true;
            } else if (noCreditChoice == 2) {
                machine.getState().start(machine);
                if(machine.getBalls() > 0) {
                    elementGotHit(scanner);
                }
            } else if (noCreditChoice == 3) {
                unavailableChoice = false;
            } else {
                System.out.println("Please choose between 1, 2 or 3 !");
                unavailableChoice = true;
            }
        }
    }

    public void beforeFlipper(Scanner scanner) {
        if (machine.getBalls() >= 0) {
            boolean notFlipper = true;
            while (notFlipper) {
                System.out.println("Press 1 for Flipper, Press 2 to start, Press 3 to add a coin.");
                int beforeFlipperChoice = scanner.nextInt();
                if (beforeFlipperChoice == 1) {
                    notFlipper = false;
                } else if (beforeFlipperChoice == 2) {
                    machine.getState().start(machine);
                } else if (beforeFlipperChoice == 3) {
                    machine.getState().addCoin(machine);
                }
            }
            useFlipper(scanner);
        } else {
            styleChoice(scanner);
        }

    }

    public void useFlipper(Scanner scanner) {
        boolean isFlipperOrHole = true;
        while (isFlipperOrHole) {
            int option = random.nextInt(elements.size());
            if (!(elements.get(option) instanceof Hole) && !(elements.get(option) instanceof Flipper)) {
                isFlipperOrHole = false;
                elementGotHit(scanner);
            }
        }
    }


    public void elementGotHit(Scanner scanner) {
        if (machine.getBalls() == 3) {
            System.out.println(machine.getFactory().createBall1());
            machine.setBalls(2);
        }
        if (machine.getBalls() >= 0) {
            boolean isNotFlipper = true;
            while (isNotFlipper) {
                int option = random.nextInt(elements.size());
                elements.get(option).hit();
                if (elements.get(option) instanceof Flipper) {
                    isNotFlipper = false;
                } if (elements.get(option) instanceof Hole && machine.getBalls() < 0) {
                    isNotFlipper = false;
                }
            }
            beforeFlipper(scanner);



        } else {
            promptUserActions(scanner);
        }
    }


}
