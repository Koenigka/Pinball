package visitor;

import flipperElements.Bumper;
import flipperElements.Ramp;
import flipperElements.Slingshot;
import flipperElements.Target;

public interface Visitor {

    void visit(Bumper bumper);
    void visit(Ramp ramp);
    void visit(Target target);
    void visit(Slingshot slingshot);
}
