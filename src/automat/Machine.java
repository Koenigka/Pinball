package automat;

import factory.MainFactory;
import flipperElements.FlipperElement;
import state.NoCredit;
import state.State;

import java.util.List;

public class Machine {


    private static Machine machineInstance = new Machine(new NoCredit());
    private State state;
    private int credit = 0;
    private int balls = 0;
    private MainFactory factory;
    private List<FlipperElement> elements;
    private long score = 0;

    public Machine(State state) {
        this.state = state;
    }

    public static Machine getMachineInstance() {
        return machineInstance;
    }

    public static void setMachineInstance(Machine machineInstance) {
        Machine.machineInstance = machineInstance;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public MainFactory getFactory() {
        return factory;
    }

    public void setFactory(MainFactory factory) {
        this.factory = factory;
    }

    public List<FlipperElement> getElements() {
        return elements;
    }

    public void setElements(List<FlipperElement> elements) {
        this.elements = elements;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}


