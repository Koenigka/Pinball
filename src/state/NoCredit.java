package state;

import automat.Machine;

public class NoCredit extends State {

    public NoCredit() {
    }

    @Override
    public void addCoin(Machine machine) {
        machine.setState(new Ready());
        super.addCoin(machine);
    }

    @Override
    public void start(Machine machine) {
        super.start(machine);
    }
}
