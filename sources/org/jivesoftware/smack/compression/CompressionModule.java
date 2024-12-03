package org.jivesoftware.smack.compression;

import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compress.packet.Compressed;
import org.jivesoftware.smack.compress.packet.Failure;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

public class CompressionModule extends ModularXmppClientToServerConnectionModule<CompressionModuleDescriptor> {

    private static final class CompressionState extends State {
        private XmppCompressionFactory selectedCompressionFactory;
        private XmppInputOutputFilter usedXmppInputOutputCompressionFitler;

        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ModularXmppClientToServerConnectionConfiguration configuration = this.connectionInternal.connection.getConfiguration();
            if (!configuration.isCompressionEnabled()) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream compression disabled by connection configuration");
            }
            Compress.Feature feature = (Compress.Feature) this.connectionInternal.connection.getFeature(Compress.Feature.class);
            if (feature == null) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream compression not supported or enabled by service");
            }
            XmppCompressionFactory bestFactory = XmppCompressionManager.getBestFactory(feature);
            this.selectedCompressionFactory = bestFactory;
            if (bestFactory == null) {
                return new StateTransitionResult.TransitionImpossibleReason("No matching compression factory for " + feature.getMethods());
            }
            this.usedXmppInputOutputCompressionFitler = bestFactory.fabricate(configuration);
            return null;
        }

        public void resetState() {
            this.selectedCompressionFactory = null;
            this.usedXmppInputOutputCompressionFitler = null;
            this.connectionInternal.setCompressionEnabled(false);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws InterruptedException, SmackException, XMPPException {
            String compressionMethod = this.selectedCompressionFactory.getCompressionMethod();
            this.connectionInternal.sendAndWaitForResponse(new Compress(compressionMethod), Compressed.class, Failure.class);
            this.connectionInternal.addXmppInputOutputFilter(this.usedXmppInputOutputCompressionFitler);
            this.connectionInternal.newStreamOpenWaitForFeaturesSequence("server stream features after compression enabled");
            this.connectionInternal.setCompressionEnabled(true);
            return new CompressionTransitionSuccessResult(compressionMethod);
        }

        private CompressionState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class CompressionStateDescriptor extends StateDescriptor {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private CompressionStateDescriptor() {
            super((Class<? extends State>) CompressionState.class, (int) Opcodes.L2D);
            Class<ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor> cls = ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor.class;
            addPredeccessor(cls);
            addSuccessor(cls);
            declarePrecedenceOver((Class<? extends StateDescriptor>) ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
        }

        /* access modifiers changed from: protected */
        public CompressionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((CompressionModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(CompressionModuleDescriptor.class)).constructCompressionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class CompressionTransitionSuccessResult extends StateTransitionResult.Success {
        private final String compressionMethod;

        public String getCompressionMethod() {
            return this.compressionMethod;
        }

        private CompressionTransitionSuccessResult(String str) {
            super(str + " compression enabled");
            this.compressionMethod = str;
        }
    }

    protected CompressionModule(CompressionModuleDescriptor compressionModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(compressionModuleDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public CompressionState constructCompressionState(CompressionStateDescriptor compressionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new CompressionState(compressionStateDescriptor, modularXmppClientToServerConnectionInternal);
    }
}
