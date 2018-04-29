
package com.yahtzee.state;

public interface StateChangedListener {
    void onChange(String key, Object state);
}