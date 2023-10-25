package commands;

import automat.Machine;
import flipperElements.FlipperElement;

import java.util.ArrayList;
import java.util.List;

public class HitCommand implements Command {
    private Machine machine;
    private List<FlipperElement> elements;

    public HitCommand(Machine machine) {
        this.machine = machine;
        this.elements = new ArrayList<>();
    }

    @Override
    public void execute(FlipperElement element) {
        machine.setScore(machine.getScore() + element.getPoints());
        for (FlipperElement e : this.elements) {
            e.hit();
        }
    }

    public void add(FlipperElement element) {
        elements.add(element);
    }

    public void remove(FlipperElement element) {
        elements.remove(element);
    }
}

