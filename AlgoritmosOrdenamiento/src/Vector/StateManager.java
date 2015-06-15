package Vector;

import Vector.Vector;
import java.util.LinkedList;

/**
 *
 * @author AnaTere
 */
public class StateManager {

    private LinkedList<Vector> states;
    private static int currentState;

    public StateManager() {
        states = new LinkedList();
        currentState = 0;
    }

    public void saveState(Vector o) {
        states.add(o);
    }

    public void remove(int i) {
        states.remove(i);
    }

    public Vector getLast() {
        return states.getLast();
    }

    public Vector getCurrentState() {
        return states.get(currentState);
    }

    public Vector nextState() {
        currentState++;
        return states.get(currentState);
    }

    public Vector aboveState() {
        currentState--;
        return states.get(currentState);
    }

    public int size() {
        return states.size();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < states.size(); i++) {
            sb.append(states.get(i)).append("\n");
        }

        return sb.toString();
    }
}
