package visitor;

import flipperElements.*;

public interface Visitor {

    void visit(Bumper bumper);
    void visit(Ramp ramp);
    void visit(Target target);

    void visit(Flipper flipper);

    void visit(Hole hole);
}
