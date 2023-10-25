package factory;

public class ASCIIFont2Factory extends DisplayFactory {
    @Override
    public String createStartMessage() {
        return "ASCII 2 Start Message";
    }

    @Override
    public String createGameOverMessage() {
        return "ASCII 2 Game Over Message";
    }

    // ... Implementierung weiterer Methoden
}