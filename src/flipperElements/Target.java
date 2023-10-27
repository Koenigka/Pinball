package flipperElements;

import commands.Command;
import mediator.FlipperMediator;
import mediator.Mediator;
import visitor.Visitor;

public class Target implements FlipperElement{

    private String targetName;
    private int hitCount = 0;
    private Command command;
    private FlipperMediator mediator;
    private boolean isTargetDown = false;

    @Override
    public void hit() {
        if (!isTargetDown) {
            this.hitCount++;
            setTargetDown(true);
            command.execute(this);
            mediator.hitTarget();
            System.out.println(targetName + " is hit!");
        } else {
            System.out.println(targetName + " is down!");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Target(String targetName, Command command) {
        this.targetName = targetName;
        this.command = command;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public FlipperMediator getMediator() {
        return mediator;
    }

    public void setMediator(FlipperMediator mediator) {
        this.mediator = mediator;
    }

    public boolean isTargetDown() {
        return isTargetDown;
    }

    public void setTargetDown(boolean targetDown) {
        isTargetDown = targetDown;
    }
}
