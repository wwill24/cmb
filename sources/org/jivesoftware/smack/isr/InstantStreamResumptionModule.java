package org.jivesoftware.smack.isr;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

public class InstantStreamResumptionModule extends ModularXmppClientToServerConnectionModule<InstantStreamResumptionModuleDescriptor> {
    /* access modifiers changed from: private */
    public boolean useIsr = true;

    private final class InstantStreamResumptionState extends State {
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!InstantStreamResumptionModule.this.useIsr) {
                return new StateTransitionResult.TransitionImpossibleReason("Instant stream resumption not enabled nor implemented");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("Instant stream resumption not implemented");
        }

        private InstantStreamResumptionState(InstantStreamResumptionStateDescriptor instantStreamResumptionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(instantStreamResumptionStateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class InstantStreamResumptionStateDescriptor extends StateDescriptor {
        private InstantStreamResumptionStateDescriptor() {
            super(InstantStreamResumptionState.class, 397, StateDescriptor.Property.notImplemented);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            addPredeccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
            declarePrecedenceOver((Class<? extends StateDescriptor>) ModularXmppClientToServerConnection.SaslAuthenticationStateDescriptor.class);
        }

        /* access modifiers changed from: protected */
        public InstantStreamResumptionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((InstantStreamResumptionModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(InstantStreamResumptionModuleDescriptor.class)).constructInstantStreamResumptionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    protected InstantStreamResumptionModule(InstantStreamResumptionModuleDescriptor instantStreamResumptionModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(instantStreamResumptionModuleDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public InstantStreamResumptionState constructInstantStreamResumptionState(InstantStreamResumptionStateDescriptor instantStreamResumptionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new InstantStreamResumptionState(instantStreamResumptionStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public void setInstantStreamResumptionEnabled(boolean z10) {
        this.useIsr = z10;
    }
}
