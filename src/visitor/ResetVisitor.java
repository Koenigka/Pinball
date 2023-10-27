package visitor;

import flipperElements.*;

public class ResetVisitor implements Visitor{
    @Override
    public void visit(Bumper bumper) {
        if (bumper.isActivated()) {
            bumper.setActivated(false);
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.isOpened()) {
            ramp.setOpened(false);
        }
    }

    @Override
    public void visit(Target target) {
        if (target.isTargetDown()) {
            target.setTargetDown(false);
        }
    }

    @Override
    public void visit(Flipper flipper) {

    }

    @Override
    public void visit(Hole hole) {

    }


}

