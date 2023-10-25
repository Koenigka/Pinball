package state;

import automat.PinballAutomat;

public class EndState extends State {

    public EndState(PinballAutomat automaton) {
        super(automaton);
    }

    @Override
    public void insertCoin() {
        automaton.addCredit();
    }

    @Override
    public void pressStart() {
        // Hier könnte eine Spielgewinn-Logik implementiert werden
        if (automaton.hasCredit()) {
            automaton.setCurrentState(new Ready(automaton));
        } else {
            automaton.setCurrentState(new NoCredit(automaton));
        }
    }

    @Override
    public void ballLost() {
        // In diesem Zustand sollte nichts passieren, wenn eine Kugel verloren geht.
    }
}
