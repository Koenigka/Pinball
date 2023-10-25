package flipperElements;

import visitor.Visitor;

public interface FlipperElement {
    void hit();
    void accept(Visitor visitor);
}
