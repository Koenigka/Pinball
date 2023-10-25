package elementsComposite;

public class Bumper implements FlipperElement {

    @Override
    public void hit() {
        // Logik für das Treffen des Bumpers
        System.out.println("Bumper getroffen! Kleiner Punktebonus hinzugefügt.");
    }
}