package flipperElements;

import visitor.Visitor;

public interface FlipperElement {
    void hit();
    int getPoints(Visitor visitor);
}
