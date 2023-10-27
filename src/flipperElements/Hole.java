package flipperElements;

import commands.Command;
import visitor.Visitor;

public class Hole implements FlipperElement {
    private String name;
    private Command command;

    public Hole(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        System.out.println("You lost your Ball!");
        command.execute(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
