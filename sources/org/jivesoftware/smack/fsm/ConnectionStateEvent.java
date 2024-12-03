package org.jivesoftware.smack.fsm;

import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.fsm.StateTransitionResult;

public class ConnectionStateEvent {
    private final StateDescriptor currentStateDescriptor;
    private final StateDescriptor successorStateDescriptor;
    private final long timestamp;

    public static class AboutToTransitionInto extends ConnectionStateEvent {
        public AboutToTransitionInto(State state, State state2) {
            super(state.getStateDescriptor(), state2.getStateDescriptor());
        }
    }

    public static abstract class DetailedTransitionIntoInformation extends ConnectionStateEvent {
        protected DetailedTransitionIntoInformation(State state) {
            super(state.getStateDescriptor());
        }
    }

    public static class FinalStateReached extends ConnectionStateEvent {
        public FinalStateReached(State state) {
            super(state.getStateDescriptor());
        }
    }

    public static class StateRevertBackwardsWalk extends ConnectionStateEvent {
        public StateRevertBackwardsWalk(State state) {
            super(state.getStateDescriptor());
        }
    }

    public static class SuccessfullyTransitionedInto extends ConnectionStateEvent {
        private final StateTransitionResult.Success transitionSuccessResult;

        public SuccessfullyTransitionedInto(State state, StateTransitionResult.Success success) {
            super(state.getStateDescriptor());
            this.transitionSuccessResult = success;
        }

        public String toString() {
            return ConnectionStateEvent.super.toString() + ": " + this.transitionSuccessResult;
        }
    }

    public static class TransitionFailed extends ConnectionStateEvent {
        private final StateTransitionResult.Failure transitionFailedReason;

        public TransitionFailed(State state, State state2, StateTransitionResult.Failure failure) {
            super(state.getStateDescriptor(), state2.getStateDescriptor());
            this.transitionFailedReason = failure;
        }

        public String toString() {
            return ConnectionStateEvent.super.toString() + ": " + this.transitionFailedReason;
        }
    }

    public static class TransitionIgnoredDueCycle extends ConnectionStateEvent {
        public TransitionIgnoredDueCycle(StateDescriptorGraph.GraphVertex<State> graphVertex, StateDescriptorGraph.GraphVertex<State> graphVertex2) {
            super(graphVertex.getElement().getStateDescriptor(), graphVertex2.getElement().getStateDescriptor());
        }
    }

    public static class TransitionNotPossible extends ConnectionStateEvent {
        private final StateTransitionResult.TransitionImpossible transitionImpossibleReason;

        public TransitionNotPossible(State state, State state2, StateTransitionResult.TransitionImpossible transitionImpossible) {
            super(state.getStateDescriptor(), state2.getStateDescriptor());
            this.transitionImpossibleReason = transitionImpossible;
        }

        public String toString() {
            return ConnectionStateEvent.super.toString() + ": " + this.transitionImpossibleReason;
        }
    }

    public ConnectionStateEvent(StateDescriptor stateDescriptor) {
        this(stateDescriptor, (StateDescriptor) null);
    }

    public StateDescriptor getStateDescriptor() {
        return this.currentStateDescriptor;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        if (this.successorStateDescriptor == null) {
            return getClass().getSimpleName() + ": " + this.currentStateDescriptor.getStateName();
        }
        return this.currentStateDescriptor.getStateName() + ' ' + getClass().getSimpleName() + ' ' + this.successorStateDescriptor.getStateName();
    }

    public ConnectionStateEvent(StateDescriptor stateDescriptor, StateDescriptor stateDescriptor2) {
        this.currentStateDescriptor = stateDescriptor;
        this.successorStateDescriptor = stateDescriptor2;
        this.timestamp = System.currentTimeMillis();
    }
}
