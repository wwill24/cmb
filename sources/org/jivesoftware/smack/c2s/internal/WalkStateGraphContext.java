package org.jivesoftware.smack.c2s.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.fsm.LoginContext;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.parts.Resourcepart;

public final class WalkStateGraphContext {
    final Map<State, StateTransitionResult> failedStates = new LinkedHashMap();
    private final Class<? extends StateDescriptor> finalStateClass;
    private final Class<? extends StateDescriptor> initialStateClass;
    private final LoginContext loginContext;
    private final Class<? extends StateDescriptor> mandatoryIntermediateState;
    boolean mandatoryIntermediateStateHandled;
    private final List<State> walkedStateGraphPath = new ArrayList();

    public static final class Builder {
        /* access modifiers changed from: private */
        public final Class<? extends StateDescriptor> finalStateClass;
        /* access modifiers changed from: private */
        public final Class<? extends StateDescriptor> initialStateClass;
        /* access modifiers changed from: private */
        public LoginContext loginContext;
        /* access modifiers changed from: private */
        public Class<? extends StateDescriptor> mandatoryIntermediateState;

        public WalkStateGraphContext build() {
            return new WalkStateGraphContext(this);
        }

        public Builder withLoginContext(String str, String str2, Resourcepart resourcepart) {
            return withLoginContext(new LoginContext(str, str2, resourcepart));
        }

        public Builder withMandatoryIntermediateState(Class<? extends StateDescriptor> cls) {
            this.mandatoryIntermediateState = cls;
            return this;
        }

        private Builder(Class<? extends StateDescriptor> cls, Class<? extends StateDescriptor> cls2) {
            this.initialStateClass = (Class) Objects.requireNonNull(cls);
            this.finalStateClass = (Class) Objects.requireNonNull(cls2);
        }

        public Builder withLoginContext(LoginContext loginContext2) {
            this.loginContext = loginContext2;
            return this;
        }
    }

    WalkStateGraphContext(Builder builder) {
        this.initialStateClass = builder.initialStateClass;
        this.finalStateClass = builder.finalStateClass;
        this.mandatoryIntermediateState = builder.mandatoryIntermediateState;
        this.loginContext = builder.loginContext;
    }

    public static Builder builder(Class<? extends StateDescriptor> cls, Class<? extends StateDescriptor> cls2) {
        return new Builder(cls, cls2);
    }

    private boolean wouldCycleRecursive(StateDescriptorGraph.GraphVertex<State> graphVertex, Set<Class<? extends StateDescriptor>> set) {
        Class<?> cls = graphVertex.getElement().getStateDescriptor().getClass();
        if (cls == this.initialStateClass) {
            return true;
        }
        if (this.finalStateClass != cls && !set.contains(cls)) {
            set.add(cls);
            for (StateDescriptorGraph.GraphVertex<State> wouldCycleRecursive : graphVertex.getOutgoingEdges()) {
                if (wouldCycleRecursive(wouldCycleRecursive, set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void appendWalkTo(List<State> list) {
        list.addAll(this.walkedStateGraphPath);
    }

    public Map<State, StateTransitionResult> getFailedStates() {
        return new HashMap(this.failedStates);
    }

    public LoginContext getLoginContext() {
        return this.loginContext;
    }

    public List<State> getWalk() {
        return CollectionUtil.newListWith(this.walkedStateGraphPath);
    }

    public int getWalkLength() {
        return this.walkedStateGraphPath.size();
    }

    public boolean isFinalStateAuthenticatedAndResourceBound() {
        return this.finalStateClass == ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class;
    }

    public boolean isWalksFinalState(StateDescriptor stateDescriptor) {
        return stateDescriptor.getClass() == this.finalStateClass;
    }

    public StateDescriptorGraph.GraphVertex<State> maybeReturnMandatoryImmediateState(List<StateDescriptorGraph.GraphVertex<State>> list) {
        for (StateDescriptorGraph.GraphVertex<State> next : list) {
            if (next.getElement().getStateDescriptor().getClass() == this.mandatoryIntermediateState) {
                this.mandatoryIntermediateStateHandled = true;
                return next;
            }
        }
        return null;
    }

    public void recordFailedState(State state, StateTransitionResult stateTransitionResult) {
        this.failedStates.put(state, stateTransitionResult);
    }

    public void recordWalkTo(State state) {
        this.walkedStateGraphPath.add(state);
    }

    public boolean stateAlreadyVisited(State state) {
        return this.walkedStateGraphPath.contains(state);
    }

    public boolean wouldCauseCycle(StateDescriptorGraph.GraphVertex<State> graphVertex) {
        return wouldCycleRecursive(graphVertex, new HashSet());
    }
}
