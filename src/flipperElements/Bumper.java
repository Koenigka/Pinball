package flipperElements;

import commands.Command;
import visitor.Visitor;

public class Bumper implements FlipperElement{
    private String bumperName;
    private boolean isActivated = false;
    private Command activationCommand;
    private int hitCount = 0;


    public Bumper(String bumperName, Command activationCommand) {
        this.bumperName = bumperName;
        this.activationCommand = activationCommand;
    }

    @Override
    public void hit() {
        this.hitCount++;
        activateBumper();
        activationCommand.execute(this);
        System.out.println(bumperName + " is hit!");
    }

    private void activateBumper() {
        isActivated = true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String getBumperName() {
        return bumperName;
    }

    public void setBumperName(String bumperName) {
        this.bumperName = bumperName;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public Command getActivationCommand() {
        return activationCommand;
    }

    public void setActivationCommand(Command activationCommand) {
        this.activationCommand = activationCommand;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

}
