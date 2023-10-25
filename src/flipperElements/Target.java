package flipperElements;

import commands.Command;
import mediator.Mediator;
import visitor.Visitor;

public class Target implements FlipperElement{

    private String targetName;
    private int hitCount = 0;
    private Command activationCommand;
    private Mediator mediator;
    private boolean isTargetDown = false;

    @Override
    public void hit() {
        if (!isTargetDown) {
            this.hitCount++;
            setTargetDown(true);
            activationCommand.execute(this);
            mediator.hitTarget();
            System.out.println("The " + targetName + " target is hit!");
        } else {
            System.out.println("The " + targetName + " target is down!");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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

    public Command getActivationCommand() {
        return activationCommand;
    }

    public void setActivationCommand(Command activationCommand) {
        this.activationCommand = activationCommand;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isTargetDown() {
        return isTargetDown;
    }

    public void setTargetDown(boolean targetDown) {
        isTargetDown = targetDown;
    }

    public Target(String targetName, Command activationCommand) {
        this.targetName = targetName;
        this.activationCommand = activationCommand;
    }

}
