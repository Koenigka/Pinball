package state;

import automat.Machine;

public class Playing extends State {

    @Override
    public void addCoin(Machine machine) {
        super.addCoin(machine);
    }

    @Override
    public void start(Machine machine) {
        machine.setState(this);
        System.out.println("Developed by: Spyridoula, Kathi and Karin");
    }

}
