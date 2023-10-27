package commands;

import automat.Machine;
import flipperElements.FlipperElement;

import java.util.ArrayList;
import java.util.List;

public class RampController implements Command {

    private Machine machine;
    private List<FlipperElement> elements;


    public RampController(Machine machine) {
        this.machine = machine;
        this.elements = new ArrayList<>();
    }

    @Override
    public void execute(FlipperElement element) {
        machine.setScore(machine.getScore() + 10000);
        for (FlipperElement element1: this.elements) {
            element1.hit();
        }
    }

    public void add(FlipperElement element) {
        elements.add(element);
    }

    public void remove(FlipperElement element) {
        elements.remove(element);
    }
}
