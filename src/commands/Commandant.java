package commands;

import automat.Machine;
import flipperElements.FlipperElement;
import flipperElements.Hole;
import visitor.ResetVisitor;
import visitor.PointVisitor;

public class Commandant implements  Command{
    private Machine machine;
    private ResetVisitor reset;
    private PointVisitor point;
    private int lvl = 1;

    public Commandant (Machine m, ResetVisitor r, PointVisitor p){
        machine = m;
        reset = r;
        point = p;
    }

    @Override
    public void execute(FlipperElement element) {

    }
}
