package org.jivesoftware.smack.c2s;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.ConnectionStateEvent;
import org.jivesoftware.smack.fsm.ConnectionStateMachineListener;
import org.jivesoftware.smack.fsm.LoginContext;
import org.jivesoftware.smack.fsm.NoOpState;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.fsm.StateMachineException;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.internal.AbstractStats;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StreamClose;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown;
import org.jivesoftware.smack.util.ExtendedAppendable;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.parts.Resourcepart;

public final class ModularXmppClientToServerConnection extends AbstractXMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(ModularXmppClientToServerConnectionConfiguration.class.getName());
    /* access modifiers changed from: private */
    public XmppClientToServerTransport activeTransport;
    /* access modifiers changed from: private */
    public boolean compressionEnabled;
    private final ModularXmppClientToServerConnectionConfiguration configuration;
    private final ModularXmppClientToServerConnectionInternal connectionInternal;
    private final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor>> connectionModules = new HashMap();
    private final List<ConnectionStateMachineListener> connectionStateMachineListeners = new CopyOnWriteArrayList();
    private StateDescriptorGraph.GraphVertex<State> currentStateVertex;
    private boolean featuresReceived;
    /* access modifiers changed from: private */
    public final List<XmppInputOutputFilter> inputOutputFilters = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final ArrayBlockingQueueWithShutdown<TopLevelStreamElement> outgoingElementsQueue;
    /* access modifiers changed from: private */
    public List<XmppInputOutputFilter> previousInputOutputFilters;
    protected boolean streamResumed;
    /* access modifiers changed from: private */
    public final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport> transports = new HashMap();
    /* access modifiers changed from: private */
    public List<State> walkFromDisconnectToAuthenticated;

    /* renamed from: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection.AnonymousClass2.<clinit>():void");
        }
    }

    private final class AuthenticatedAndResourceBoundState extends State {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private AuthenticatedAndResourceBoundState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public void resetState() {
            boolean unused = ModularXmppClientToServerConnection.this.authenticated = false;
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException.NotConnectedException, InterruptedException {
            if (ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated != null) {
                walkStateGraphContext.appendWalkTo(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated);
            } else {
                List unused = ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = new ArrayList(walkStateGraphContext.getWalkLength() + 1);
                walkStateGraphContext.appendWalkTo(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated);
            }
            ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.add(this);
            ModularXmppClientToServerConnection modularXmppClientToServerConnection = ModularXmppClientToServerConnection.this;
            modularXmppClientToServerConnection.afterSuccessfulLogin(modularXmppClientToServerConnection.streamResumed);
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    public static final class AuthenticatedAndResourceBoundStateDescriptor extends StateDescriptor {
        private AuthenticatedAndResourceBoundStateDescriptor() {
            super((Class<? extends State>) AuthenticatedAndResourceBoundState.class, StateDescriptor.Property.finalState);
            addSuccessor(InstantShutdownStateDescriptor.class);
            addSuccessor(ShutdownStateDescriptor.class);
        }
    }

    public static final class AuthenticatedButUnboundStateDescriptor extends StateDescriptor {
        private AuthenticatedButUnboundStateDescriptor() {
            super(StateDescriptor.Property.multiVisitState);
            addSuccessor(ResourceBindingStateDescriptor.class);
        }
    }

    private final class CloseConnectionState extends State {
        private CloseConnectionState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            ModularXmppClientToServerConnection.this.activeTransport.disconnect();
            XmppClientToServerTransport unused = ModularXmppClientToServerConnection.this.activeTransport = null;
            ModularXmppClientToServerConnection modularXmppClientToServerConnection = ModularXmppClientToServerConnection.this;
            boolean unused2 = modularXmppClientToServerConnection.authenticated = modularXmppClientToServerConnection.connected = false;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    private static final class CloseConnectionStateDescriptor extends StateDescriptor {
        private CloseConnectionStateDescriptor() {
            super((Class<? extends State>) CloseConnectionState.class);
            addSuccessor(DisconnectedStateDescriptor.class);
        }
    }

    private final class ConnectedButUnauthenticatedState extends State {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private ConnectedButUnauthenticatedState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public void resetState() {
            boolean unused = ModularXmppClientToServerConnection.this.connected = false;
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            if (walkStateGraphContext.isWalksFinalState(getStateDescriptor())) {
                List unused = ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = walkStateGraphContext.getWalk();
            }
            boolean unused2 = ModularXmppClientToServerConnection.this.connected = true;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    public static final class ConnectedButUnauthenticatedStateDescriptor extends StateDescriptor {
        private ConnectedButUnauthenticatedStateDescriptor() {
            super((Class<? extends State>) ConnectedButUnauthenticatedState.class, StateDescriptor.Property.finalState);
            addSuccessor(SaslAuthenticationStateDescriptor.class);
            addSuccessor(InstantShutdownStateDescriptor.class);
            addSuccessor(ShutdownStateDescriptor.class);
        }
    }

    private final class DisconnectedState extends State {
        private DisconnectedState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            synchronized (ModularXmppClientToServerConnection.this) {
                if (ModularXmppClientToServerConnection.this.inputOutputFilters.isEmpty()) {
                    List unused = ModularXmppClientToServerConnection.this.previousInputOutputFilters = null;
                } else {
                    List unused2 = ModularXmppClientToServerConnection.this.previousInputOutputFilters = new ArrayList(ModularXmppClientToServerConnection.this.inputOutputFilters.size());
                    ModularXmppClientToServerConnection.this.previousInputOutputFilters.addAll(ModularXmppClientToServerConnection.this.inputOutputFilters);
                    ModularXmppClientToServerConnection.this.inputOutputFilters.clear();
                }
            }
            ListIterator listIterator = ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.listIterator(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.size());
            while (listIterator.hasPrevious()) {
                ((State) listIterator.previous()).resetState();
            }
            List unused3 = ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = null;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    public static class DisconnectedStateDescriptor extends StateDescriptor {
        protected DisconnectedStateDescriptor() {
            super((Class<? extends State>) DisconnectedState.class, StateDescriptor.Property.finalState);
            addSuccessor(LookupRemoteConnectionEndpointsStateDescriptor.class);
        }
    }

    private static final class InstantShutdownState extends NoOpState {
        private InstantShutdownState(ModularXmppClientToServerConnection modularXmppClientToServerConnection, StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(modularXmppClientToServerConnection, stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ensureNotOnOurWayToAuthenticatedAndResourceBound(walkStateGraphContext);
            return null;
        }
    }

    static final class InstantShutdownStateDescriptor extends StateDescriptor {
        private InstantShutdownStateDescriptor() {
            super((Class<? extends State>) InstantShutdownState.class);
            addSuccessor(CloseConnectionStateDescriptor.class);
        }
    }

    private final class LookupRemoteConnectionEndpointsState extends State {
        boolean outgoingElementsQueueWasShutdown;

        private LookupRemoteConnectionEndpointsState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public void resetState() {
            for (XmppClientToServerTransport resetDiscoveredConnectionEndpoints : ModularXmppClientToServerConnection.this.transports.values()) {
                resetDiscoveredConnectionEndpoints.resetDiscoveredConnectionEndpoints();
            }
            if (this.outgoingElementsQueueWasShutdown) {
                ModularXmppClientToServerConnection.this.outgoingElementsQueue.shutdown();
            }
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws XMPPException.XMPPErrorException, SASLErrorException, IOException, SmackException, InterruptedException, XMPPException.FailedNonzaException {
            HashMap hashMap = new HashMap(ModularXmppClientToServerConnection.this.transports.size());
            ArrayList arrayList = new ArrayList();
            for (XmppClientToServerTransport xmppClientToServerTransport : ModularXmppClientToServerConnection.this.transports.values()) {
                xmppClientToServerTransport.resetDiscoveredConnectionEndpoints();
                List<SmackFuture<XmppClientToServerTransport.LookupConnectionEndpointsResult, Exception>> lookupConnectionEndpoints = xmppClientToServerTransport.lookupConnectionEndpoints();
                hashMap.put(xmppClientToServerTransport, lookupConnectionEndpoints);
                arrayList.addAll(lookupConnectionEndpoints);
            }
            int size = arrayList.size();
            SmackFuture.await(arrayList, ModularXmppClientToServerConnection.this.getReplyTimeout(), TimeUnit.MILLISECONDS);
            ArrayList arrayList2 = new ArrayList(size);
            boolean z10 = false;
            for (Map.Entry entry : hashMap.entrySet()) {
                XmppClientToServerTransport xmppClientToServerTransport2 = (XmppClientToServerTransport) entry.getKey();
                for (SmackFuture ifAvailable : (List) entry.getValue()) {
                    XmppClientToServerTransport.LookupConnectionEndpointsResult lookupConnectionEndpointsResult = (XmppClientToServerTransport.LookupConnectionEndpointsResult) ifAvailable.getIfAvailable();
                    if (lookupConnectionEndpointsResult != null) {
                        if (lookupConnectionEndpointsResult instanceof XmppClientToServerTransport.LookupConnectionEndpointsFailed) {
                            arrayList2.add((XmppClientToServerTransport.LookupConnectionEndpointsFailed) lookupConnectionEndpointsResult);
                        } else {
                            xmppClientToServerTransport2.loadConnectionEndpoints((XmppClientToServerTransport.LookupConnectionEndpointsSuccess) lookupConnectionEndpointsResult);
                            z10 = true;
                        }
                    }
                }
            }
            if (z10) {
                this.outgoingElementsQueueWasShutdown = ModularXmppClientToServerConnection.this.outgoingElementsQueue.start();
                return StateTransitionResult.Success.EMPTY_INSTANCE;
            }
            throw SmackException.NoEndpointsDiscoveredException.from(arrayList2);
        }
    }

    public static final class LookupRemoteConnectionEndpointsStateDescriptor extends StateDescriptor {
        private LookupRemoteConnectionEndpointsStateDescriptor() {
            super((Class<? extends State>) LookupRemoteConnectionEndpointsState.class);
        }
    }

    private final class ResourceBindingState extends State {
        private ResourceBindingState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws IOException, SmackException, InterruptedException, XMPPException {
            boolean unused = ModularXmppClientToServerConnection.this.lastFeaturesReceived = true;
            ModularXmppClientToServerConnection.this.notifyWaitingThreads();
            LoginContext loginContext = walkStateGraphContext.getLoginContext();
            Resourcepart access$2500 = ModularXmppClientToServerConnection.this.bindResourceAndEstablishSession(loginContext.resource);
            ModularXmppClientToServerConnection.this.streamResumed = false;
            return new ResourceBoundResult(access$2500, loginContext.resource);
        }
    }

    public static final class ResourceBindingStateDescriptor extends StateDescriptor {
        private ResourceBindingStateDescriptor() {
            super((Class<? extends State>) ResourceBindingState.class, "RFC 6120 § 7");
            addSuccessor(AuthenticatedAndResourceBoundStateDescriptor.class);
        }
    }

    public static final class ResourceBoundResult extends StateTransitionResult.Success {
        private final Resourcepart resource;

        public Resourcepart getResource() {
            return this.resource;
        }

        private ResourceBoundResult(Resourcepart resourcepart, Resourcepart resourcepart2) {
            super("Resource '" + resourcepart + "' bound (requested: '" + resourcepart2 + "')");
            this.resource = resourcepart;
        }
    }

    private final class SaslAuthenticationState extends State {
        private SaslAuthenticationState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws IOException, SmackException, InterruptedException, XMPPException {
            ModularXmppClientToServerConnection.this.prepareToWaitForFeaturesReceived();
            LoginContext loginContext = walkStateGraphContext.getLoginContext();
            ModularXmppClientToServerConnection modularXmppClientToServerConnection = ModularXmppClientToServerConnection.this;
            SASLMechanism access$2100 = modularXmppClientToServerConnection.authenticate(loginContext.username, loginContext.password, modularXmppClientToServerConnection.config.getAuthzid(), ModularXmppClientToServerConnection.this.getSSLSession());
            ModularXmppClientToServerConnection.this.waitForFeaturesReceived("server stream features after SASL authentication");
            return new SaslAuthenticationSuccessResult(access$2100);
        }
    }

    public static final class SaslAuthenticationStateDescriptor extends StateDescriptor {
        private SaslAuthenticationStateDescriptor() {
            super((Class<? extends State>) SaslAuthenticationState.class, "RFC 6120 § 6");
            addSuccessor(AuthenticatedButUnboundStateDescriptor.class);
        }
    }

    public static final class SaslAuthenticationSuccessResult extends StateTransitionResult.Success {
        private final String saslMechanismName;

        public String getSaslMechanismName() {
            return this.saslMechanismName;
        }

        private SaslAuthenticationSuccessResult(SASLMechanism sASLMechanism) {
            super("SASL authentication successfull using " + sASLMechanism.getName());
            this.saslMechanismName = sASLMechanism.getName();
        }
    }

    private final class ShutdownState extends State {
        private ShutdownState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ensureNotOnOurWayToAuthenticatedAndResourceBound(walkStateGraphContext);
            return null;
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            boolean unused = ModularXmppClientToServerConnection.this.closingStreamReceived = false;
            if (ModularXmppClientToServerConnection.this.outgoingElementsQueue.offerAndShutdown(StreamClose.INSTANCE)) {
                ModularXmppClientToServerConnection.this.activeTransport.notifyAboutNewOutgoingElements();
                if (ModularXmppClientToServerConnection.this.waitForClosingStreamTagFromServer()) {
                    ListIterator<XmppInputOutputFilter> xmppInputOutputFilterBeginIterator = this.connectionInternal.getXmppInputOutputFilterBeginIterator();
                    while (xmppInputOutputFilterBeginIterator.hasNext()) {
                        xmppInputOutputFilterBeginIterator.next().closeInputOutput();
                    }
                    ModularXmppClientToServerConnection.this.activeTransport.afterFiltersClosed();
                    ListIterator<XmppInputOutputFilter> xmppInputOutputFilterBeginIterator2 = this.connectionInternal.getXmppInputOutputFilterBeginIterator();
                    while (xmppInputOutputFilterBeginIterator2.hasNext()) {
                        try {
                            xmppInputOutputFilterBeginIterator2.next().waitUntilInputOutputClosed();
                        } catch (IOException | InterruptedException | CertificateException | SmackException | XMPPException e10) {
                            ModularXmppClientToServerConnection.LOGGER.log(Level.WARNING, "waitUntilInputOutputClosed() threw", e10);
                        }
                    }
                    boolean unused2 = ModularXmppClientToServerConnection.this.authenticated = false;
                }
            }
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    static final class ShutdownStateDescriptor extends StateDescriptor {
        private ShutdownStateDescriptor() {
            super((Class<? extends State>) ShutdownState.class);
            addSuccessor(CloseConnectionStateDescriptor.class);
        }
    }

    public static final class Stats extends AbstractStats {
        public final Map<String, Object> filtersStats;
        public final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport.Stats> transportsStats;

        public void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException {
            StringUtils.appendHeading(extendedAppendable, "Connection stats", '#').append(10);
            for (Map.Entry next : this.transportsStats.entrySet()) {
                StringUtils.appendHeading(extendedAppendable, ((Class) next.getKey()).getName());
                extendedAppendable.append((CharSequence) ((XmppClientToServerTransport.Stats) next.getValue()).toString()).append(10);
            }
            for (Map.Entry next2 : this.filtersStats.entrySet()) {
                Object value = next2.getValue();
                StringUtils.appendHeading(extendedAppendable, (String) next2.getKey());
                extendedAppendable.append((CharSequence) value.toString()).append(10);
            }
        }

        private Stats(Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport.Stats> map, Map<String, Object> map2) {
            this.transportsStats = Collections.unmodifiableMap(map);
            this.filtersStats = Collections.unmodifiableMap(map2);
        }
    }

    public ModularXmppClientToServerConnection(ModularXmppClientToServerConnectionConfiguration modularXmppClientToServerConnectionConfiguration) {
        super(modularXmppClientToServerConnectionConfiguration);
        ArrayBlockingQueueWithShutdown<TopLevelStreamElement> arrayBlockingQueueWithShutdown = new ArrayBlockingQueueWithShutdown<>(100, true);
        this.outgoingElementsQueue = arrayBlockingQueueWithShutdown;
        this.configuration = modularXmppClientToServerConnectionConfiguration;
        this.connectionInternal = new ModularXmppClientToServerConnectionInternal(this, getReactor(), this.debugger, arrayBlockingQueueWithShutdown) {
            public void addXmppInputOutputFilter(XmppInputOutputFilter xmppInputOutputFilter) {
                ModularXmppClientToServerConnection.this.inputOutputFilters.add(0, xmppInputOutputFilter);
            }

            public void asyncGo(Runnable runnable) {
                AbstractXMPPConnection.asyncGo(runnable);
            }

            public void fireFirstLevelElementSendListeners(TopLevelStreamElement topLevelStreamElement) {
                ModularXmppClientToServerConnection.this.firePacketSendingListeners(topLevelStreamElement);
            }

            public XmlEnvironment getOutgoingStreamXmlEnvironment() {
                return ModularXmppClientToServerConnection.this.outgoingStreamXmlEnvironment;
            }

            public SmackTlsContext getSmackTlsContext() {
                return ModularXmppClientToServerConnection.this.getSmackTlsContext();
            }

            public ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterBeginIterator() {
                return ModularXmppClientToServerConnection.this.inputOutputFilters.listIterator();
            }

            public ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterEndIterator() {
                return ModularXmppClientToServerConnection.this.inputOutputFilters.listIterator(ModularXmppClientToServerConnection.this.inputOutputFilters.size());
            }

            public void invokeConnectionStateMachineListener(ConnectionStateEvent connectionStateEvent) {
                ModularXmppClientToServerConnection.this.invokeConnectionStateMachineListener(connectionStateEvent);
            }

            public void newStreamOpenWaitForFeaturesSequence(String str) throws InterruptedException, SmackException, XMPPException {
                ModularXmppClientToServerConnection.this.newStreamOpenWaitForFeaturesSequence(str);
            }

            public void notifyConnectionError(Exception exc) {
                ModularXmppClientToServerConnection.this.notifyConnectionError(exc);
            }

            public void notifyWaitingThreads() {
                ModularXmppClientToServerConnection.this.notifyWaitingThreads();
            }

            public void onStreamClosed() {
                boolean unused = ModularXmppClientToServerConnection.this.closingStreamReceived = true;
                notifyWaitingThreads();
            }

            public void onStreamOpen(XmlPullParser xmlPullParser) {
                ModularXmppClientToServerConnection.this.onStreamOpen(xmlPullParser);
            }

            public void parseAndProcessElement(String str) {
                ModularXmppClientToServerConnection.this.parseAndProcessElement(str);
            }

            public <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.FailedNonzaException, InterruptedException {
                return ModularXmppClientToServerConnection.this.sendAndWaitForResponse(nonza, cls, cls2);
            }

            public void setCompressionEnabled(boolean z10) {
                boolean unused = ModularXmppClientToServerConnection.this.compressionEnabled = z10;
            }

            public void setTransport(XmppClientToServerTransport xmppClientToServerTransport) {
                XmppClientToServerTransport unused = ModularXmppClientToServerConnection.this.activeTransport = xmppClientToServerTransport;
                boolean unused2 = ModularXmppClientToServerConnection.this.connected = true;
            }

            public void waitForConditionOrThrowConnectionException(Supplier<Boolean> supplier, String str) throws InterruptedException, SmackException, XMPPException {
                ModularXmppClientToServerConnection.this.waitForConditionOrThrowConnectionException(supplier, str);
            }
        };
        for (ModularXmppClientToServerConnectionModuleDescriptor next : modularXmppClientToServerConnectionConfiguration.moduleDescriptors) {
            Class<?> cls = next.getClass();
            ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor> constructXmppConnectionModule = next.constructXmppConnectionModule(this.connectionInternal);
            this.connectionModules.put(cls, constructXmppConnectionModule);
            XmppClientToServerTransport transport = constructXmppConnectionModule.getTransport();
            if (transport != null) {
                this.transports.put(cls, transport);
            }
        }
        this.currentStateVertex = StateDescriptorGraph.convertToStateGraph(modularXmppClientToServerConnectionConfiguration.initialStateDescriptorVertex, this.connectionInternal);
    }

    private StateTransitionResult attemptEnterState(StateDescriptorGraph.GraphVertex<State> graphVertex, WalkStateGraphContext walkStateGraphContext) throws SmackException, XMPPException, IOException, InterruptedException {
        State element = this.currentStateVertex.getElement();
        State element2 = graphVertex.getElement();
        StateDescriptor stateDescriptor = element2.getStateDescriptor();
        if (!stateDescriptor.isMultiVisitState() && walkStateGraphContext.stateAlreadyVisited(element2)) {
            return null;
        }
        if (stateDescriptor.isNotImplemented()) {
            StateTransitionResult.TransitionImpossibleBecauseNotImplemented transitionImpossibleBecauseNotImplemented = new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(stateDescriptor);
            invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionNotPossible(element, element2, transitionImpossibleBecauseNotImplemented));
            return transitionImpossibleBecauseNotImplemented;
        }
        try {
            StateTransitionResult.TransitionImpossible isTransitionToPossible = element2.isTransitionToPossible(walkStateGraphContext);
            if (isTransitionToPossible != null) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionNotPossible(element, element2, isTransitionToPossible));
                return isTransitionToPossible;
            }
            invokeConnectionStateMachineListener(new ConnectionStateEvent.AboutToTransitionInto(element, element2));
            StateTransitionResult.AttemptResult transitionInto = element2.transitionInto(walkStateGraphContext);
            if (transitionInto instanceof StateTransitionResult.Failure) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionFailed(element, element2, (StateTransitionResult.Failure) transitionInto));
                return transitionInto;
            }
            StateTransitionResult.Success success = (StateTransitionResult.Success) transitionInto;
            this.currentStateVertex = graphVertex;
            invokeConnectionStateMachineListener(new ConnectionStateEvent.SuccessfullyTransitionedInto(element2, success));
            return success;
        } catch (IOException | InterruptedException | SmackException | XMPPException e10) {
            unwindState(element2);
            throw e10;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeConnectionStateMachineListener$1(ConnectionStateEvent connectionStateEvent) {
        for (ConnectionStateMachineListener onConnectionStateEvent : this.connectionStateMachineListeners) {
            onConnectionStateEvent.onConnectionStateEvent(connectionStateEvent, this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$waitForFeaturesReceived$0() {
        return Boolean.valueOf(this.featuresReceived);
    }

    private void sendTopLevelStreamElement(TopLevelStreamElement topLevelStreamElement) throws SmackException.NotConnectedException, InterruptedException {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport != null) {
            this.outgoingElementsQueue.put(topLevelStreamElement);
            xmppClientToServerTransport.notifyAboutNewOutgoingElements();
            return;
        }
        throw new SmackException.NotConnectedException();
    }

    private void unwindState(State state) {
        invokeConnectionStateMachineListener(new ConnectionStateEvent.StateRevertBackwardsWalk(state));
        state.resetState();
    }

    private void walkStateGraphInternal(WalkStateGraphContext walkStateGraphContext) throws IOException, SmackException, InterruptedException, XMPPException {
        StateDescriptorGraph.GraphVertex<State> graphVertex = this.currentStateVertex;
        State element = graphVertex.getElement();
        StateDescriptor stateDescriptor = element.getStateDescriptor();
        walkStateGraphContext.recordWalkTo(element);
        if (walkStateGraphContext.isWalksFinalState(stateDescriptor)) {
            invokeConnectionStateMachineListener(new ConnectionStateEvent.FinalStateReached(element));
            return;
        }
        List<StateDescriptorGraph.GraphVertex<State>> outgoingEdges = graphVertex.getOutgoingEdges();
        StateDescriptorGraph.GraphVertex<State> maybeReturnMandatoryImmediateState = walkStateGraphContext.maybeReturnMandatoryImmediateState(outgoingEdges);
        if (maybeReturnMandatoryImmediateState != null) {
            StateTransitionResult attemptEnterState = attemptEnterState(maybeReturnMandatoryImmediateState, walkStateGraphContext);
            if (attemptEnterState instanceof StateTransitionResult.Success) {
                walkStateGraph(walkStateGraphContext);
                return;
            }
            throw new StateMachineException.SmackMandatoryStateFailedException(maybeReturnMandatoryImmediateState.getElement(), attemptEnterState);
        }
        Iterator<StateDescriptorGraph.GraphVertex<State>> it = outgoingEdges.iterator();
        while (it.hasNext()) {
            StateDescriptorGraph.GraphVertex next = it.next();
            State state = (State) next.getElement();
            if (walkStateGraphContext.wouldCauseCycle(next)) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionIgnoredDueCycle(graphVertex, next));
            } else {
                StateTransitionResult attemptEnterState2 = attemptEnterState(next, walkStateGraphContext);
                if (attemptEnterState2 instanceof StateTransitionResult.Success) {
                    break;
                } else if (attemptEnterState2 != null) {
                    walkStateGraphContext.recordFailedState(state, attemptEnterState2);
                }
            }
            if (!it.hasNext()) {
                throw StateMachineException.SmackStateGraphDeadEndException.from(walkStateGraphContext, graphVertex);
            }
        }
        walkStateGraph(walkStateGraphContext);
    }

    public void addConnectionStateMachineListener(ConnectionStateMachineListener connectionStateMachineListener) {
        this.connectionStateMachineListeners.add(connectionStateMachineListener);
    }

    /* access modifiers changed from: protected */
    public void afterFeaturesReceived() {
        this.featuresReceived = true;
        notifyWaitingThreads();
    }

    /* access modifiers changed from: protected */
    public WalkStateGraphContext.Builder buildNewWalkTo(Class<? extends StateDescriptor> cls) {
        return WalkStateGraphContext.builder(this.currentStateVertex.getElement().getStateDescriptor().getClass(), cls);
    }

    /* access modifiers changed from: protected */
    public void connectInternal() throws SmackException, IOException, XMPPException, InterruptedException {
        walkStateGraph(buildNewWalkTo(ConnectedButUnauthenticatedStateDescriptor.class).build());
    }

    public <CM extends ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor>> CM getConnectionModuleFor(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
        return (ModularXmppClientToServerConnectionModule) this.connectionModules.get(cls);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getFilterStats() {
        List<XmppInputOutputFilter> list;
        synchronized (this) {
            if (!this.inputOutputFilters.isEmpty() || (list = this.previousInputOutputFilters) == null) {
                list = this.inputOutputFilters;
            }
        }
        HashMap hashMap = new HashMap(list.size());
        for (XmppInputOutputFilter next : list) {
            hashMap.put(next.getFilterName(), next.getStats());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public SSLSession getSSLSession() {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport == null) {
            return null;
        }
        return xmppClientToServerTransport.getSslSession();
    }

    public Stats getStats() {
        HashMap hashMap = new HashMap(this.transports.size());
        for (Map.Entry next : this.transports.entrySet()) {
            hashMap.put((Class) next.getKey(), ((XmppClientToServerTransport) next.getValue()).getStats());
        }
        return new Stats(hashMap, getFilterStats());
    }

    public synchronized void instantShutdown() {
        shutdown(true);
    }

    /* access modifiers changed from: protected */
    public void invokeConnectionStateMachineListener(ConnectionStateEvent connectionStateEvent) {
        if (!this.connectionStateMachineListeners.isEmpty()) {
            AbstractXMPPConnection.ASYNC_BUT_ORDERED.performAsyncButOrdered(this, new b(this, connectionStateEvent));
        }
    }

    public boolean isSecureConnection() {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport == null) {
            return false;
        }
        return xmppClientToServerTransport.isTransportSecured();
    }

    public boolean isUsingCompression() {
        return this.compressionEnabled;
    }

    /* access modifiers changed from: protected */
    public void loginInternal(String str, String str2, Resourcepart resourcepart) throws XMPPException, SmackException, IOException, InterruptedException {
        walkStateGraph(buildNewWalkTo(AuthenticatedAndResourceBoundStateDescriptor.class).withLoginContext(str, str2, resourcepart).build());
    }

    /* access modifiers changed from: protected */
    public void newStreamOpenWaitForFeaturesSequence(String str) throws InterruptedException, SmackException, XMPPException {
        prepareToWaitForFeaturesReceived();
        sendStreamOpen();
        waitForFeaturesReceived(str);
    }

    /* access modifiers changed from: protected */
    public void parseAndProcessElement(String str) {
        try {
            XmlPullParser parserFor = PacketParserUtils.getParserFor(str);
            parserFor.next();
            XmlPullParser.Event eventType = parserFor.getEventType();
            while (true) {
                int i10 = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[eventType.ordinal()];
                if (i10 == 1) {
                    String name = parserFor.getName();
                    char c10 = 65535;
                    switch (name.hashCode()) {
                        case -1276666629:
                            if (name.equals(Presence.ELEMENT)) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case -290659267:
                            if (name.equals("features")) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case 3368:
                            if (name.equals(IQ.IQ_ELEMENT)) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case 96784904:
                            if (name.equals("error")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 954925063:
                            if (name.equals("message")) {
                                c10 = 0;
                                break;
                            }
                            break;
                    }
                    if (c10 == 0 || c10 == 1 || c10 == 2) {
                        parseAndProcessStanza(parserFor);
                    } else if (c10 == 3) {
                        XMPPException.StreamErrorException streamErrorException = new XMPPException.StreamErrorException(PacketParserUtils.parseStreamError(parserFor, (XmlEnvironment) null));
                        this.currentXmppException = streamErrorException;
                        notifyWaitingThreads();
                        throw streamErrorException;
                    } else if (c10 != 4) {
                        parseAndProcessNonza(parserFor);
                    } else {
                        parseFeatures(parserFor);
                        afterFeaturesReceived();
                    }
                } else if (i10 == 2) {
                    return;
                }
                eventType = parserFor.next();
            }
        } catch (IOException | InterruptedException | XMPPException.StreamErrorException | SmackParsingException | XmlPullParserException e10) {
            notifyConnectionError(e10);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void prepareToWaitForFeaturesReceived() {
        this.featuresReceived = false;
    }

    public boolean removeConnectionStateMachineListener(ConnectionStateMachineListener connectionStateMachineListener) {
        return this.connectionStateMachineListeners.remove(connectionStateMachineListener);
    }

    public void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException {
        sendTopLevelStreamElement(nonza);
    }

    /* access modifiers changed from: protected */
    public void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        sendTopLevelStreamElement(stanza);
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        shutdown(false);
    }

    /* access modifiers changed from: protected */
    public void waitForFeaturesReceived(String str) throws InterruptedException, SmackException, XMPPException {
        waitForConditionOrThrowConnectionException(new a(this), str);
    }

    /* access modifiers changed from: protected */
    public void walkStateGraph(WalkStateGraphContext walkStateGraphContext) throws XMPPException, IOException, SmackException, InterruptedException {
        StateDescriptorGraph.GraphVertex<State> graphVertex = this.currentStateVertex;
        try {
            walkStateGraphInternal(walkStateGraphContext);
        } catch (IOException | InterruptedException | SmackException | XMPPException e10) {
            this.currentStateVertex = graphVertex;
            unwindState(graphVertex.getElement());
            throw e10;
        }
    }

    private void shutdown(boolean z10) {
        Class cls;
        if (z10) {
            cls = InstantShutdownStateDescriptor.class;
        } else {
            cls = ShutdownStateDescriptor.class;
        }
        try {
            walkStateGraph(buildNewWalkTo(DisconnectedStateDescriptor.class).withMandatoryIntermediateState(cls).build());
        } catch (IOException | InterruptedException | SmackException | XMPPException e10) {
            throw new IllegalStateException("A walk to disconnected state should never throw", e10);
        }
    }

    public ModularXmppClientToServerConnectionConfiguration getConfiguration() {
        return this.configuration;
    }
}
