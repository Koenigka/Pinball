package flipperElements;

import commands.Command;
import visitor.Visitor;

public class Ramp implements FlipperElement{

    private String rampName;
    private boolean isOpened = false;
    private int hitCount = 0;
    private Command activationCommand;
    @Override
    public void hit() {
        if (isOpened) {
            this.hitCount++;
            activationCommand.execute(this);
            System.out.println(rampName + " is hit!");
        } else {
            System.out.println(rampName + " is closed!");
        }
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public Ramp(String rampName, Command activationCommand) {
        this.rampName = rampName;
        this.activationCommand = activationCommand;
    }

    public String getRampName() {
        return rampName;
    }

    public void setRampName(String rampName) {
        this.rampName = rampName;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
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


}
