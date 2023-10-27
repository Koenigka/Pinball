package flipperElements;

import visitor.Visitor;

public class Flipper implements FlipperElement{
    private String name;

    public Flipper(String name) {
        this.name = name;
    }


    @Override
    public void hit() {
        System.out.println(name + " is hit!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
