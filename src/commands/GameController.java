package commands;

import automat.Machine;
import flipperElements.FlipperElement;
import visitor.PointVisitor;
import visitor.ResetVisitor;

public class GameController implements Command{


    private Machine machine;
    private int level = 1;
    private ResetVisitor reset;
    private PointVisitor counter;

    public GameController(Machine machine,  ResetVisitor reset, PointVisitor counter) {
        this.machine = machine;
        this.reset = reset;
        this.counter = counter;
    }

    @Override
    public void execute(FlipperElement flipperElement) {

            flipperElement.accept(counter);
            if (counter.getPoint() >= 500L * level) {
                setLevel(level + 1);
                System.out.println("Your level is" + this.level);
            }
            machine.setScore(machine.getScore() + (level * 1000L));
            System.out.println(machine.getScore());
        }

    public void setLevel(int level) {
        this.level = level;
    }

}
