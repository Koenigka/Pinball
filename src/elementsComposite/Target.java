package elementsComposite;

public class Target implements FlipperElement {

    @Override
    public void hit() {
        // Logik für das Treffen des Ziels
        System.out.println("Ziel getroffen! Bonuspunkte hinzugefügt.");
    }
}