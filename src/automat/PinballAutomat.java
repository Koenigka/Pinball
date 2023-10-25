package automat;

import state.*;

public class PinballAutomat {

    private State currentState;
    private int credit = 0; // Der aktuelle Kredit des Automaten.
    private int ballCount = 3; // Die verbleibende Anzahl der Bälle.

    public PinballAutomat() {
        currentState = new NoCredit(this);
    }

    // Diese Methode ermöglicht den Zuständen den Wechsel des aktuellen Zustands.
    public void setCurrentState(State state) {
        this.currentState = state;
    }

    // Einwurf einer Münze.
    public void insertCoin() {
        currentState.insertCoin();
    }

    // Start-Knopf wurde gedrückt.
    public void pressStart() {
        currentState.pressStart();
    }

    // Eine Kugel wurde verloren.
    public void ballLost() {
        currentState.ballLost();
    }

    // Fügt dem Automaten einen Kredit hinzu.
    public void addCredit() {
        this.credit++;
        System.out.println("Guthaben: " + credit);
    }

    // Startet das Spiel.
    public void startGame() {
        if (credit > 0) {
            credit--;
            System.out.println("Spiel gestartet! Verbleibender Kredit: " + credit);
        } else {
            System.out.println("Nicht genug Guthaben!");
        }
    }

    // Verringert die Anzahl der Bälle.
    public void decreaseBallCount() {
        this.ballCount--;
        System.out.println("Verbleibende Bälle: " + ballCount);
    }

    // Gibt die verbleibende Anzahl der Bälle zurück.
    public int getBallCount() {
        return ballCount;
    }

    // Überprüft, ob noch Kredit vorhanden ist.
    public boolean hasCredit() {
        return credit > 0;
    }

    // Hier können Sie weitere Hilfsmethoden oder Attribute hinzufügen, die für den Flipperautomaten relevant sind.
}
