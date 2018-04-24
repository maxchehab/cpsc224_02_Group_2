package com.yahtzee.state;

import java.util.List;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StateManager {
    private static List<StateChangedListener> stateChangedListeners = new ArrayList<StateChangedListener>();

    private static Map<String, Object> states = new HashMap<String, Object>();


    public static final String CHANGE_PANEL = "CHANGE_PANEL";
    public static final String EXIT = "EXIT";


    public static void addStateChangedListener(StateChangedListener listener) {
        stateChangedListeners.add(listener);
    }

    public static void changeState(String name, Object state) {
        states.put(name, state);
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onChange(name, state);
        }
    }

    public static Object getState(String name) {
        return states.get(name);
    }
}