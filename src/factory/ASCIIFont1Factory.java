package factory;

public class ASCIIFont1Factory extends DisplayFactory {
    @Override
    public String createStartMessage() {
        return "ASCII 1 Start Message";
    }

    @Override
    public String createGameOverMessage() {
        return "ASCII 1 Game Over Message";
    }

    // ... Implementierung weiterer Methoden
}