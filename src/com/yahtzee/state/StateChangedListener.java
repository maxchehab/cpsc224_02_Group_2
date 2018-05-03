
package com.yahtzee.state;
/* 
 * StateChangedListener is an interface utilized by the StateManager
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

public interface StateChangedListener {
    /*
     * onChange is a callback which is triggered when a state has beeen changed.
     * 
     * @param String key, Object state
     * 
     * @returns void
     * 
     * @throw null
     */
    void onChange(String key, Object state);
}