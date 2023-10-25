package state;


import automat.PinballAutomat;

public class NoCredit extends State {

    public NoCredit(PinballAutomat automaton) {
        super(automaton);
    }

    @Override
    public void insertCoin() {
        automaton.addCredit();
        automaton.setCurrentState(new Ready(automaton));
    }

    @Override
    public void pressStart() {
        System.out.println("Kein Guthaben vorhanden!");
    }

    @Override
    public void ballLost() {
        // In diesem Zustand passiert nichts, wenn eine Kugel verloren geht.
    }
}
