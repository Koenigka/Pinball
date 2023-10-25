package elementsComposite;

public class Ramp implements FlipperElement {

    @Override
    public void hit() {
        // Logik für das Treffen der Rampe
        System.out.println("Rampe getroffen! Punkte hinzugefügt.");
    }
}