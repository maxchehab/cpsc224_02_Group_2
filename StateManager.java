import java.util.List;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StateManager {
    private static List<StateChangedListener> stateChangedListeners = new ArrayList<StateChangedListener>();

    private static Map<String, State> states = new HashMap<String, State>();

    private static State currentState = new State(new JPanel());

    public static void addStateChangedListener(StateChangedListener listener) {
        stateChangedListeners.add(listener);
    }

    public static void addState(String name, State state) {
        states.put(name, state);
    }

    public static void removeState(String name) {
        states.remove(name);
    }

    public static void changeState(String name) {
        if (states.containsKey(name)) {
            State newState = states.get(name);
            for (StateChangedListener listener : stateChangedListeners) {
                listener.onChange(newState, currentState);
            }

            currentState = newState;
        }
    }
}

interface StateChangedListener {
    void onChange(State newState, State oldState);
}

class State {
    private JPanel panel;

    public State(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}