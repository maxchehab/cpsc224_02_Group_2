/* 
 * StateManager is a wrapper for a hashmap. Using an interface (StateChangedListener),
 * the StateManager allows communication between classes.
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */
package com.yahtzee.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateManager {
    private static List<StateChangedListener> stateChangedListeners = new ArrayList<StateChangedListener>();

    private static Map<String, Object> states = new HashMap<String, Object>();

    public static final String CHANGE_PANEL = "CHANGE_PANEL";
    public static final String EXIT = "EXIT";
    public static final String UPDATE_FLAGDICE = "UPDATE_FLAGDICE";
    public static final String FLAGDICE = "FLAGDICE";

    /*
     * addStateChangedListener adds a StateChangedListener to be called when the
     * state is chagned
     * 
     * @param StateChangedListener listener
     * 
     * @returns void
     * 
     * @throw null
     */
    public static void addStateChangedListener(StateChangedListener listener) {
        stateChangedListeners.add(listener);
    }

    /*
     * changeState updates a provided state
     * 
     * @param String name, Object state
     * 
     * @returns void
     * 
     * @throw null
     */
    public static void changeState(String name, Object state) {
        if (state == null)
            return;
        states.put(name, state);
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onChange(name, state);
        }
    }

    /*
     * getState querys a State with a provided key
     * 
     * @param String name
     * 
     * @returns Object
     * 
     * @throw null
     */
    public static Object getState(String name) {
        return states.get(name);
    }

    /*
     * getStateOrDefault will query a state or return a default object if the state
     * does not exists
     * 
     * @param String name, Object defaultState
     * 
     * @returns Object
     * 
     * @throw null
     */
    public static Object getStateOrDefault(String name, Object defaultState) {
        Object state = states.get(name);
        return (state == null ? defaultState : state);
    }
}