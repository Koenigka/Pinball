package state;

import automat.PinballAutomat;

public abstract class State {
    protected PinballAutomat automaton;

    public State(PinballAutomat automaton) {
        this.automaton = automaton;
    }

    public abstract void insertCoin();
    public abstract void pressStart();
    public abstract void ballLost();
}
