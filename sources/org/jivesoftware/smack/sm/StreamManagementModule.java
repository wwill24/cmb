package org.jivesoftware.smack.sm;

import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.compression.CompressionModule;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

public class StreamManagementModule extends ModularXmppClientToServerConnectionModule<StreamManagementModuleDescriptor> {
    /* access modifiers changed from: private */
    public boolean useSm = true;
    /* access modifiers changed from: private */
    public boolean useSmResumption = true;

    private final class EnableStreamManagementState extends State {
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!StreamManagementModule.this.useSm) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream management not enabled");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("SM not implemented");
        }

        private EnableStreamManagementState(EnableStreamManagementStateDescriptor enableStreamManagementStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(enableStreamManagementStateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class EnableStreamManagementStateDescriptor extends StateDescriptor {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private EnableStreamManagementStateDescriptor() {
            super(EnableStreamManagementState.class, Opcodes.IFNULL, StateDescriptor.Property.notImplemented);
            Class<ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor> cls = ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class;
            addPredeccessor(ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
            addSuccessor(cls);
            declarePrecedenceOver((Class<? extends StateDescriptor>) cls);
        }

        /* access modifiers changed from: protected */
        public EnableStreamManagementState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((StreamManagementModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(StreamManagementModuleDescriptor.class)).constructEnableStreamMangementState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    private final class ResumeStreamState extends State {
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!StreamManagementModule.this.useSmResumption) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream resumption not enabled");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("Stream resumption not implemented");
        }

        private ResumeStreamState(ResumeStreamStateDescriptor resumeStreamStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(resumeStreamStateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class ResumeStreamStateDescriptor extends StateDescriptor {
        private ResumeStreamStateDescriptor() {
            super(ResumeStreamState.class, Opcodes.IFNULL, StateDescriptor.Property.notImplemented);
            addPredeccessor(ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            declarePrecedenceOver((Class<? extends StateDescriptor>) ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
            declareInferiorityTo((Class<? extends StateDescriptor>) CompressionModule.CompressionStateDescriptor.class);
        }

        /* access modifiers changed from: protected */
        public ResumeStreamState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((StreamManagementModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(StreamManagementModuleDescriptor.class)).constructResumeStreamState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    protected StreamManagementModule(StreamManagementModuleDescriptor streamManagementModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(streamManagementModuleDescriptor, modularXmppClientToServerConnectionInternal);
    }

    /* access modifiers changed from: private */
    public EnableStreamManagementState constructEnableStreamMangementState(EnableStreamManagementStateDescriptor enableStreamManagementStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EnableStreamManagementState(enableStreamManagementStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    /* access modifiers changed from: private */
    public ResumeStreamState constructResumeStreamState(ResumeStreamStateDescriptor resumeStreamStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new ResumeStreamState(resumeStreamStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public void setStreamManagementEnabled(boolean z10) {
        this.useSm = z10;
    }

    public void setStreamResumptionEnabled(boolean z10) {
        this.useSmResumption = z10;
    }
}
