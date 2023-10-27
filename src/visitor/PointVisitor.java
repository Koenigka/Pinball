package visitor;

import flipperElements.*;

public class PointVisitor implements Visitor {

    private long point = 0;

    @Override
    public void visit(Bumper bumper) {
        if (bumper.getHitCount() >= 4) {
            this.point += 1000;
            System.out.println(1000 + "Bonus Points");
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.getHitCount() >= 2) {
            this.point += 1000;
            System.out.println("YOU GOT " + 1000 + " BONUS POINTS");
        }
    }

    @Override
    public void visit(Target target) {
        if (target.getHitCount() > 3) {
            this.point += 500;
            System.out.println("YOU GOT " + 500 + " BONUS POINTS");
        }
    }

    @Override
    public void visit(Flipper flipper) {

    }

    @Override
    public void visit(Hole hole) {

    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }


}

