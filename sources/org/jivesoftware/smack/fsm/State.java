package org.jivesoftware.smack.fsm;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.StateTransitionResult;

public abstract class State {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;
    protected final StateDescriptor stateDescriptor;

    protected State(StateDescriptor stateDescriptor2, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.stateDescriptor = stateDescriptor2;
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    /* access modifiers changed from: protected */
    public final void ensureNotOnOurWayToAuthenticatedAndResourceBound(WalkStateGraphContext walkStateGraphContext) {
        if (walkStateGraphContext.isFinalStateAuthenticatedAndResourceBound()) {
            throw new IllegalStateException("Smack should never attempt to reach the authenticated and resource bound state over " + this + ". This is probably a programming error within Smack, please report it to the develoeprs.");
        }
    }

    public StateDescriptor getStateDescriptor() {
        return this.stateDescriptor;
    }

    public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) throws SmackException {
        return null;
    }

    public void resetState() {
    }

    public String toString() {
        return "State " + this.stateDescriptor + ' ' + this.connectionInternal.connection;
    }

    public abstract StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws IOException, SmackException, InterruptedException, XMPPException;
}
