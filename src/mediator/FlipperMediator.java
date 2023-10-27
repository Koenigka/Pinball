package mediator;

import flipperElements.FlipperElement;
import flipperElements.Ramp;
import flipperElements.Target;

import java.util.List;

public class FlipperMediator implements Mediator{

    private List<FlipperElement> elements;
    private Ramp ramp;

    public FlipperMediator(List<FlipperElement> targets, Ramp ramp) {
        this.elements = targets;
        this.ramp = ramp;
    }

    @Override
    public void hitTarget() {
        boolean isOpen = true;
        for (FlipperElement element : elements) {
            if (element instanceof Target) {
                Target target = (Target) element;
                isOpen &= target.isTargetDown();
                ramp.setOpened(isOpen);
            }
        }
    }
}
