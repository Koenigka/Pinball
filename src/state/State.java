package state;


import automat.Machine;

public abstract class State {

    public State() {
    }

    public void addCoin(Machine machine) {
        machine.setCredit(machine.getCredit() + 1);
        System.out.println("Coin added! Current credits: " + machine.getCredit());
    }

    public void start(Machine machine) {
        if (machine.getCredit() > 0) {
            machine.setState(new Ready());
            System.out.println("Game is ready - press PLAY to start!");
        } else {
            machine.setState(new NoCredit());
            System.out.println("Insert coin to play.");
        }
    }
}