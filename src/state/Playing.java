package state;

import automat.PinballAutomat;

public class Playing extends State {

    public Playing(PinballAutomat automaton) {
        super(automaton);
    }

    @Override
    public void insertCoin() {
        automaton.addCredit();
    }

    @Override
    public void pressStart() {
        System.out.println("Autoren der Software: ..."); // Hier sollten die Namen der Autoren aufgelistet werden.
    }

    @Override
    public void ballLost() {
        automaton.decreaseBallCount();
        if (automaton.getBallCount() <= 0) {
            automaton.setCurrentState(new EndState(automaton));
        }
    }
}

