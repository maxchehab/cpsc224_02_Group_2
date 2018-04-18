public interface StateChangedListener {
    void onChange(State newState, State oldState);
}