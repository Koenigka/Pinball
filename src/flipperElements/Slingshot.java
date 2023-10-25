package flipperElements;

import commands.Command;
import mediator.Mediator;
import visitor.Visitor;

public class Slingshot implements FlipperElement{

    private String slingshotName;
    private Command activationCommand;
    private Mediator mediator;

    public Slingshot(String slingshotName, Command activationCommand) {
        this.slingshotName = slingshotName;
        this.activationCommand = activationCommand;
    }

    @Override
    public void hit() {
        activationCommand.execute(this);
        mediator.hitSlingshot();
        System.out.println("The " + slingshotName + " slingshot is activated!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String getSlingshotName() {
        return slingshotName;
    }

    public void setSlingshotName(String slingshotName) {
        this.slingshotName = slingshotName;
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

}
