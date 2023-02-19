package drift.states;

public abstract class State {
    private static State currentState;

    public State() {
        currentState = null;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
        State.currentState.startState();
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void startState();
}