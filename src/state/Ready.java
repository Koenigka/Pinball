package state;

import automat.PinballAutomat;

public class Ready extends State {

    public Ready(PinballAutomat automaton) {
        super(automaton);
    }

    @Override
    public void insertCoin() {
        automaton.addCredit();
    }

    @Override
    public void pressStart() {
        if (automaton.hasCredit()) {
            automaton.startGame();
            automaton.setCurrentState(new Playing(automaton));
        } else {
            System.out.println("Mehr Guthaben erforderlich!");
        }
    }

    @Override
    public void ballLost() {
        // In diesem Zustand passiert nichts, wenn eine Kugel verloren geht.
    }
}

