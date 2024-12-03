package org.jivesoftware.smack.tcp;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.SmackReactor;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.TlsFailure;
import org.jivesoftware.smack.packet.TlsProceed;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;
import org.jxmpp.xml.splitter.d;
import org.jxmpp.xml.splitter.e;
import org.jxmpp.xml.splitter.g;
import org.jxmpp.xml.splitter.h;

public class XmppTcpTransportModule extends ModularXmppClientToServerConnectionModule<XmppTcpTransportModuleDescriptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CALLBACK_MAX_BYTES_READ = 10485760;
    private static final int CALLBACK_MAX_BYTES_WRITEN = 10485760;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(XmppTcpTransportModule.class.getName());
    private static final int MAX_ELEMENT_SIZE = 65536;
    private static final Level SSL_ENGINE_DEBUG_LOG_LEVEL = Level.FINEST;
    /* access modifiers changed from: private */
    public static final Level STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL = Level.FINER;
    /* access modifiers changed from: private */
    public final AtomicLong afterOutgoingElementsQueueModifiedSetInterestOps = new AtomicLong();
    private final Map<ByteBuffer, List<TopLevelStreamElement>> bufferToElementMap = new IdentityHashMap();
    /* access modifiers changed from: private */
    public long callbackPreemtBecauseBytesRead;
    /* access modifiers changed from: private */
    public long callbackPreemtBecauseBytesWritten;
    /* access modifiers changed from: private */
    public final ReentrantLock channelSelectedCallbackLock = new ReentrantLock();
    private final List<TopLevelStreamElement> currentlyOutgoingElements = new ArrayList();
    XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredTcpEndpoints;
    private ByteBuffer filteredOutgoingBuffer;
    /* access modifiers changed from: private */
    public long handledChannelSelectedCallbacks;
    private final ByteBuffer incomingBuffer = ByteBuffer.allocateDirect(8192);
    private Jid lastDestinationAddress;
    /* access modifiers changed from: private */
    public int maxPendingSslEngineDelegatedTasks;
    private final List<ByteBuffer> networkOutgoingBuffers = new ArrayList();
    private long networkOutgoingBuffersBytes;
    private ByteBuffer outgoingBuffer;
    private Iterator<CharSequence> outgoingCharSequenceIterator;
    private h outputDebugSplitter;
    /* access modifiers changed from: private */
    public boolean pendingInputFilterData;
    /* access modifiers changed from: private */
    public boolean pendingOutputFilterData;
    private boolean pendingWriteInterestAfterRead;
    /* access modifiers changed from: private */
    public final AtomicLong reactorThreadAlreadyRacing = new AtomicLong();
    /* access modifiers changed from: private */
    public final AtomicLong rejectedChannelSelectedCallbacks = new AtomicLong();
    /* access modifiers changed from: private */
    public InetSocketAddress remoteAddress;
    /* access modifiers changed from: private */
    public SelectionKey selectionKey;
    /* access modifiers changed from: private */
    public SmackReactor.SelectionKeyAttachment selectionKeyAttachment;
    /* access modifiers changed from: private */
    public final AtomicLong setWriteInterestAfterChannelSelectedCallback = new AtomicLong();
    /* access modifiers changed from: private */
    public SocketChannel socketChannel;
    private d splitter;
    /* access modifiers changed from: private */
    public int sslEngineDelegatedTasks;
    /* access modifiers changed from: private */
    public final XmppTcpNioTransport tcpNioTransport;
    /* access modifiers changed from: private */
    public TlsState tlsState;
    /* access modifiers changed from: private */
    public long totalBytesRead;
    /* access modifiers changed from: private */
    public long totalBytesReadAfterFilter;
    /* access modifiers changed from: private */
    public long totalBytesWritten;
    /* access modifiers changed from: private */
    public long totalBytesWrittenBeforeFilter;
    private final g xmppElementCallback;

    /* renamed from: org.jivesoftware.smack.tcp.XmppTcpTransportModule$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        static {
            /*
                javax.net.ssl.SSLEngineResult$Status[] r0 = javax.net.ssl.SSLEngineResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status = r0
                r1 = 1
                javax.net.ssl.SSLEngineResult$Status r2 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.net.ssl.SSLEngineResult$Status r3 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.net.ssl.SSLEngineResult$Status r4 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                javax.net.ssl.SSLEngineResult$HandshakeStatus[] r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = r4
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x004e }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0058 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r4 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0062 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                org.jivesoftware.smack.ConnectionConfiguration$SecurityMode[] r3 = org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode = r3
                org.jivesoftware.smack.ConnectionConfiguration$SecurityMode r4 = org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.required     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode     // Catch:{ NoSuchFieldError -> 0x007d }
                org.jivesoftware.smack.ConnectionConfiguration$SecurityMode r3 = org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.ifpossible     // Catch:{ NoSuchFieldError -> 0x007d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode     // Catch:{ NoSuchFieldError -> 0x0087 }
                org.jivesoftware.smack.ConnectionConfiguration$SecurityMode r1 = org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.disabled     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XmppTcpTransportModule.AnonymousClass2.<clinit>():void");
        }
    }

    private final class EstablishTlsState extends State {
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) throws SmackException.SecurityRequiredByClientException, SmackException.SecurityRequiredByServerException {
            StartTls startTls = (StartTls) this.connectionInternal.connection.getFeature(StartTls.class);
            ConnectionConfiguration.SecurityMode securityMode = this.connectionInternal.connection.getConfiguration().getSecurityMode();
            int i10 = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode[securityMode.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (startTls != null) {
                    return null;
                }
                if (securityMode == ConnectionConfiguration.SecurityMode.ifpossible) {
                    return new StateTransitionResult.TransitionImpossibleReason("Server does not announce support for TLS and we do not required it");
                }
                throw new SmackException.SecurityRequiredByClientException();
            } else if (i10 != 3) {
                throw new AssertionError("Unknown security mode: " + securityMode);
            } else if (startTls == null || !startTls.required()) {
                return new StateTransitionResult.TransitionImpossibleReason("TLS disabled in client settings and server does not require it");
            } else {
                throw new SmackException.SecurityRequiredByServerException();
            }
        }

        public void resetState() {
            TlsState unused = XmppTcpTransportModule.this.tlsState = null;
        }

        /* JADX INFO: finally extract failed */
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws IOException, InterruptedException, SmackException, XMPPException {
            this.connectionInternal.sendAndWaitForResponse(StartTls.INSTANCE, TlsProceed.class, TlsFailure.class);
            TlsState unused = XmppTcpTransportModule.this.tlsState = new TlsState(this.connectionInternal.getSmackTlsContext());
            this.connectionInternal.addXmppInputOutputFilter(XmppTcpTransportModule.this.tlsState);
            XmppTcpTransportModule.this.channelSelectedCallbackLock.lock();
            try {
                boolean unused2 = XmppTcpTransportModule.this.pendingOutputFilterData = true;
                XmppTcpTransportModule.this.tlsState.engine.beginHandshake();
                TlsHandshakeStatus unused3 = XmppTcpTransportModule.this.tlsState.handshakeStatus = TlsHandshakeStatus.initiated;
                XmppTcpTransportModule.this.channelSelectedCallbackLock.unlock();
                this.connectionInternal.setInterestOps(XmppTcpTransportModule.this.selectionKey, 5);
                try {
                    XmppTcpTransportModule.this.tlsState.waitForHandshakeFinished();
                    this.connectionInternal.newStreamOpenWaitForFeaturesSequence("stream features after TLS established");
                    return new TlsEstablishedResult(XmppTcpTransportModule.this.tlsState.engine);
                } catch (CertificateException e10) {
                    throw new SmackException.SmackCertificateException(e10);
                }
            } catch (Throwable th2) {
                XmppTcpTransportModule.this.channelSelectedCallbackLock.unlock();
                throw th2;
            }
        }

        private EstablishTlsState(EstablishTlsStateDescriptor establishTlsStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(establishTlsStateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    static final class EstablishTlsStateDescriptor extends StateDescriptor {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private EstablishTlsStateDescriptor() {
            super((Class<? extends State>) EstablishTlsState.class, "RFC 6120 § 5");
            Class<ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor> cls = ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class;
            addSuccessor(cls);
            declarePrecedenceOver((Class<? extends StateDescriptor>) cls);
        }

        /* access modifiers changed from: protected */
        public EstablishTlsState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((XmppTcpTransportModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(XmppTcpTransportModuleDescriptor.class)).constructEstablishingTlsState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    final class EstablishingTcpConnectionState extends State {
        public void resetState() {
            XmppTcpTransportModule.this.closeSocketAndCleanup();
        }

        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws InterruptedException, IOException, SmackException, XMPPException {
            ConnectionAttemptState connectionAttemptState = new ConnectionAttemptState(this.connectionInternal, XmppTcpTransportModule.this.discoveredTcpEndpoints, this);
            StateTransitionResult.Failure establishTcpConnection = connectionAttemptState.establishTcpConnection();
            if (establishTcpConnection != null) {
                return establishTcpConnection;
            }
            SocketChannel unused = XmppTcpTransportModule.this.socketChannel = connectionAttemptState.socketChannel;
            XmppTcpTransportModule xmppTcpTransportModule = XmppTcpTransportModule.this;
            InetSocketAddress unused2 = xmppTcpTransportModule.remoteAddress = (InetSocketAddress) xmppTcpTransportModule.socketChannel.socket().getRemoteSocketAddress();
            XmppTcpTransportModule xmppTcpTransportModule2 = XmppTcpTransportModule.this;
            SelectionKey unused3 = xmppTcpTransportModule2.selectionKey = this.connectionInternal.registerWithSelector(xmppTcpTransportModule2.socketChannel, 1, new p(XmppTcpTransportModule.this));
            XmppTcpTransportModule xmppTcpTransportModule3 = XmppTcpTransportModule.this;
            SmackReactor.SelectionKeyAttachment unused4 = xmppTcpTransportModule3.selectionKeyAttachment = (SmackReactor.SelectionKeyAttachment) xmppTcpTransportModule3.selectionKey.attachment();
            this.connectionInternal.setTransport(XmppTcpTransportModule.this.tcpNioTransport);
            this.connectionInternal.newStreamOpenWaitForFeaturesSequence("stream features after initial connection");
            return new TcpSocketConnectedResult(XmppTcpTransportModule.this.remoteAddress);
        }

        private EstablishingTcpConnectionState(EstablishingTcpConnectionStateDescriptor establishingTcpConnectionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(establishingTcpConnectionStateDescriptor, modularXmppClientToServerConnectionInternal);
        }
    }

    static final class EstablishingTcpConnectionStateDescriptor extends StateDescriptor {
        private EstablishingTcpConnectionStateDescriptor() {
            super((Class<? extends State>) EstablishingTcpConnectionState.class);
            addPredeccessor(ModularXmppClientToServerConnection.LookupRemoteConnectionEndpointsStateDescriptor.class);
            addSuccessor(EstablishTlsStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
        }

        /* access modifiers changed from: protected */
        public EstablishingTcpConnectionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((XmppTcpTransportModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(XmppTcpTransportModuleDescriptor.class)).constructEstablishingTcpConnectionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    public static final class Stats extends XmppClientToServerTransport.Stats {
        public final long afterOutgoingElementsQueueModifiedSetInterestOps;
        public final long callbackPreemtBecauseBytesRead;
        public final long callbackPreemtBecauseBytesWritten;
        public final long handledChannelSelectedCallbacks;
        public final int maxPendingSslEngineDelegatedTasks;
        public final long reactorThreadAlreadyRacing;
        public final double readRatio;
        public final long rejectedChannelSelectedCallbacks;
        public final long setWriteInterestAfterChannelSelectedCallback;
        public final int sslEngineDelegatedTasks;
        private transient String toStringCache;
        public final long totalBytesRead;
        public final long totalBytesReadAfterFilter;
        public final long totalBytesWritten;
        public final long totalBytesWrittenBeforeFilter;
        public final long totalCallbackRequests;
        public final double writeRatio;

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "Total bytes\nrecv: " + this.totalBytesRead + 10 + "send: " + this.totalBytesWritten + 10 + "recv-aft-filter: " + this.totalBytesReadAfterFilter + 10 + "send-bef-filter: " + this.totalBytesWrittenBeforeFilter + 10 + "read-ratio: " + this.readRatio + 10 + "write-ratio: " + this.writeRatio + 10 + "Events\ntotal-callback-requests: " + this.totalCallbackRequests + 10 + "handled-channel-selected-callbacks: " + this.handledChannelSelectedCallbacks + 10 + "rejected-channel-selected-callbacks: " + this.rejectedChannelSelectedCallbacks + 10 + "set-write-interest-after-callback: " + this.setWriteInterestAfterChannelSelectedCallback + 10 + "reactor-thread-already-racing: " + this.reactorThreadAlreadyRacing + 10 + "after-queue-modified-set-interest-ops: " + this.afterOutgoingElementsQueueModifiedSetInterestOps + 10 + "callback-preemt-because-bytes-read: " + this.callbackPreemtBecauseBytesRead + 10 + "callback-preemt-because-bytes-written: " + this.callbackPreemtBecauseBytesWritten + 10 + "ssl-engine-delegated-tasks: " + this.sslEngineDelegatedTasks + 10 + "max-pending-ssl-engine-delegated-tasks: " + this.maxPendingSslEngineDelegatedTasks + 10;
            this.toStringCache = str2;
            return str2;
        }

        private Stats(XmppTcpTransportModule xmppTcpTransportModule) {
            long access$4600 = xmppTcpTransportModule.totalBytesWritten;
            this.totalBytesWritten = access$4600;
            long access$4700 = xmppTcpTransportModule.totalBytesWrittenBeforeFilter;
            this.totalBytesWrittenBeforeFilter = access$4700;
            this.writeRatio = ((double) access$4600) / ((double) access$4700);
            long access$4800 = xmppTcpTransportModule.totalBytesReadAfterFilter;
            this.totalBytesReadAfterFilter = access$4800;
            long access$4900 = xmppTcpTransportModule.totalBytesRead;
            this.totalBytesRead = access$4900;
            this.readRatio = ((double) access$4900) / ((double) access$4800);
            long access$5000 = xmppTcpTransportModule.handledChannelSelectedCallbacks;
            this.handledChannelSelectedCallbacks = access$5000;
            this.setWriteInterestAfterChannelSelectedCallback = xmppTcpTransportModule.setWriteInterestAfterChannelSelectedCallback.get();
            this.reactorThreadAlreadyRacing = xmppTcpTransportModule.reactorThreadAlreadyRacing.get();
            this.afterOutgoingElementsQueueModifiedSetInterestOps = xmppTcpTransportModule.afterOutgoingElementsQueueModifiedSetInterestOps.get();
            long j10 = xmppTcpTransportModule.rejectedChannelSelectedCallbacks.get();
            this.rejectedChannelSelectedCallbacks = j10;
            this.totalCallbackRequests = access$5000 + j10;
            this.callbackPreemtBecauseBytesRead = xmppTcpTransportModule.callbackPreemtBecauseBytesRead;
            this.callbackPreemtBecauseBytesWritten = xmppTcpTransportModule.callbackPreemtBecauseBytesWritten;
            this.sslEngineDelegatedTasks = xmppTcpTransportModule.sslEngineDelegatedTasks;
            this.maxPendingSslEngineDelegatedTasks = xmppTcpTransportModule.maxPendingSslEngineDelegatedTasks;
        }
    }

    public static final class TcpSocketConnectedResult extends StateTransitionResult.Success {
        private final InetSocketAddress remoteAddress;

        public InetSocketAddress getRemoteAddress() {
            return this.remoteAddress;
        }

        private TcpSocketConnectedResult(InetSocketAddress inetSocketAddress) {
            super("TCP connection established to " + inetSocketAddress);
            this.remoteAddress = inetSocketAddress;
        }
    }

    public static final class TlsEstablishedResult extends StateTransitionResult.Success {
        private TlsEstablishedResult(SSLEngine sSLEngine) {
            super("TLS established: " + sSLEngine.getSession());
        }
    }

    private enum TlsHandshakeStatus {
        initial,
        initiated,
        successful,
        failed
    }

    private final class TlsState implements XmppInputOutputFilter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MAX_PENDING_OUTPUT_BYTES = 8096;
        /* access modifiers changed from: private */
        public final SSLEngine engine;
        private SSLException handshakeException;
        /* access modifiers changed from: private */
        public TlsHandshakeStatus handshakeStatus;
        private ByteBuffer myNetData;
        private ByteBuffer peerAppData;
        private final AtomicInteger pendingDelegatedTasks;
        private ByteBuffer pendingInputData;
        private int pendingOutputBytes;
        private final List<ByteBuffer> pendingOutputData;
        private final SmackTlsContext smackTlsContext;
        /* access modifiers changed from: private */
        public long unwrapInBytes;
        /* access modifiers changed from: private */
        public long unwrapOutBytes;
        /* access modifiers changed from: private */
        public long wrapInBytes;
        /* access modifiers changed from: private */
        public long wrapOutBytes;

        private void addAsPendingInputData(ByteBuffer byteBuffer) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            this.pendingInputData = allocate;
            allocate.put(byteBuffer).flip();
            boolean unused = XmppTcpTransportModule.this.pendingInputFilterData = this.pendingInputData.hasRemaining();
        }

        private SSLEngineResult.HandshakeStatus handleHandshakeStatus(SSLEngineResult sSLEngineResult) {
            int i10 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResult.getHandshakeStatus().ordinal()];
            if (i10 == 3) {
                while (true) {
                    Runnable delegatedTask = this.engine.getDelegatedTask();
                    if (delegatedTask == null) {
                        break;
                    }
                    XmppTcpTransportModule.access$3308(XmppTcpTransportModule.this);
                    int incrementAndGet = this.pendingDelegatedTasks.incrementAndGet();
                    if (incrementAndGet > XmppTcpTransportModule.this.maxPendingSslEngineDelegatedTasks) {
                        int unused = XmppTcpTransportModule.this.maxPendingSslEngineDelegatedTasks = incrementAndGet;
                    }
                    XmppTcpTransportModule.this.connectionInternal.asyncGo(new s(this, delegatedTask));
                }
            } else if (i10 == 4) {
                onHandshakeFinished();
            }
            return this.engine.getHandshakeStatus();
        }

        private void handleSslException(SSLException sSLException) {
            this.handshakeException = sSLException;
            this.handshakeStatus = TlsHandshakeStatus.failed;
            XmppTcpTransportModule.this.connectionInternal.notifyWaitingThreads();
        }

        private boolean isHandshakeFinished() {
            TlsHandshakeStatus tlsHandshakeStatus = this.handshakeStatus;
            return tlsHandshakeStatus == TlsHandshakeStatus.successful || tlsHandshakeStatus == TlsHandshakeStatus.failed;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$handleHandshakeStatus$1(Runnable runnable) {
            runnable.run();
            if (this.pendingDelegatedTasks.decrementAndGet() == 0) {
                XmppTcpTransportModule.this.callChannelSelectedCallback(true, true);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$input$0() {
            XmppTcpTransportModule.this.callChannelSelectedCallback(false, true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Boolean lambda$waitForHandshakeFinished$2() {
            return Boolean.valueOf(isHandshakeFinished());
        }

        private void onHandshakeFinished() {
            this.handshakeStatus = TlsHandshakeStatus.successful;
            XmppTcpTransportModule.this.connectionInternal.notifyWaitingThreads();
        }

        /* access modifiers changed from: private */
        public void waitForHandshakeFinished() throws InterruptedException, CertificateException, SSLException, SmackException, XMPPException {
            XmppTcpTransportModule.this.connectionInternal.waitForConditionOrThrowConnectionException(new r(this), "TLS handshake to finish");
            if (this.handshakeStatus != TlsHandshakeStatus.failed) {
                SmackDaneVerifier smackDaneVerifier = this.smackTlsContext.daneVerifier;
                if (smackDaneVerifier != null) {
                    smackDaneVerifier.finish(this.engine.getSession());
                    return;
                }
                return;
            }
            throw this.handshakeException;
        }

        public void closeInputOutput() {
            this.engine.closeOutbound();
            try {
                this.engine.closeInbound();
            } catch (SSLException e10) {
                XmppTcpTransportModule.LOGGER.log(Level.FINEST, "SSLException when closing inbound TLS session. This can likely be ignored if a possible truncation attack is suggested. You may want to ask your XMPP server vendor to implement a clean TLS session shutdown sending close_notify after </stream>", e10);
            }
        }

        public String getFilterName() {
            return "TLS (" + this.engine + PropertyUtils.MAPPED_DELIM2;
        }

        public Object getStats() {
            return new TlsStateStats(this);
        }

        public ByteBuffer input(ByteBuffer byteBuffer) throws SSLException {
            ByteBuffer byteBuffer2 = this.pendingInputData;
            if (byteBuffer2 != null) {
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer2.remaining() + byteBuffer.remaining());
                allocate.put(this.pendingInputData).put(byteBuffer).flip();
                this.pendingInputData = null;
                byteBuffer = allocate;
            }
            this.peerAppData.clear();
            while (true) {
                try {
                    SSLEngineResult unwrap = this.engine.unwrap(byteBuffer, this.peerAppData);
                    XmppTcpTransportModule.debugLogSslEngineResult("unwrap", unwrap);
                    SSLEngineResult.Status status = unwrap.getStatus();
                    if (status == SSLEngineResult.Status.OK) {
                        this.unwrapInBytes += (long) unwrap.bytesConsumed();
                        this.unwrapOutBytes += (long) unwrap.bytesProduced();
                        int i10 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handleHandshakeStatus(unwrap).ordinal()];
                        if (i10 == 1) {
                            continue;
                        } else if (i10 == 2) {
                            addAsPendingInputData(byteBuffer);
                            XmppTcpTransportModule.this.connectionInternal.asyncGo(new q(this));
                            return null;
                        } else if (i10 == 3) {
                            addAsPendingInputData(byteBuffer);
                            return null;
                        }
                    }
                    int i11 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[status.ordinal()];
                    if (i11 != 1) {
                        if (i11 == 2) {
                            return null;
                        }
                        if (i11 == 3) {
                            this.peerAppData = ByteBuffer.allocate(this.engine.getSession().getApplicationBufferSize());
                        } else if (i11 == 4) {
                            addAsPendingInputData(byteBuffer);
                            return null;
                        }
                    } else if (!byteBuffer.hasRemaining()) {
                        return this.peerAppData;
                    }
                } catch (SSLException e10) {
                    handleSslException(e10);
                    throw e10;
                }
            }
        }

        public XmppInputOutputFilter.OutputResult output(ByteBuffer byteBuffer, boolean z10, boolean z11, boolean z12) throws SSLException {
            int i10;
            if (byteBuffer != null) {
                this.pendingOutputData.add(byteBuffer);
                int remaining = this.pendingOutputBytes + byteBuffer.remaining();
                this.pendingOutputBytes = remaining;
                if (z12 && remaining < MAX_PENDING_OUTPUT_BYTES) {
                    return XmppInputOutputFilter.OutputResult.NO_OUTPUT;
                }
            }
            List<ByteBuffer> list = this.pendingOutputData;
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) list.toArray(new ByteBuffer[list.size()]);
            this.myNetData.clear();
            while (true) {
                try {
                    SSLEngineResult wrap = this.engine.wrap(byteBufferArr, this.myNetData);
                    XmppTcpTransportModule.debugLogSslEngineResult("wrap", wrap);
                    SSLEngineResult.Status status = wrap.getStatus();
                    this.pendingOutputBytes -= wrap.bytesConsumed();
                    if (status == SSLEngineResult.Status.OK) {
                        this.wrapInBytes += (long) wrap.bytesConsumed();
                        this.wrapOutBytes += (long) wrap.bytesProduced();
                        int i11 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handleHandshakeStatus(wrap).ordinal()];
                        if (i11 == 2 || i11 == 3) {
                        }
                    }
                    int i12 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[status.ordinal()];
                    if (i12 == 1) {
                        List unused = XmppTcpTransportModule.pruneBufferList(this.pendingOutputData);
                        return new XmppInputOutputFilter.OutputResult(!this.pendingOutputData.isEmpty(), this.myNetData);
                    } else if (i12 == 2) {
                        this.pendingOutputData.clear();
                        return XmppInputOutputFilter.OutputResult.NO_OUTPUT;
                    } else if (i12 == 3) {
                        XmppTcpTransportModule.LOGGER.warning("SSLEngine status BUFFER_OVERFLOW, this is hopefully uncommon");
                        if (byteBuffer != null) {
                            i10 = byteBuffer.remaining();
                        } else {
                            i10 = 0;
                        }
                        int i13 = (int) (((double) i10) * 1.3d);
                        if (i13 <= this.myNetData.capacity()) {
                            i13 = this.myNetData.capacity() * 2;
                        }
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i13);
                        this.myNetData.flip();
                        allocateDirect.put(this.myNetData);
                        this.myNetData = allocateDirect;
                    } else if (i12 == 4) {
                        throw new IllegalStateException("Buffer underflow as result of SSLEngine.wrap() should never happen");
                    }
                } catch (SSLException e10) {
                    handleSslException(e10);
                    throw e10;
                }
            }
            return new XmppInputOutputFilter.OutputResult(true, this.myNetData);
        }

        public void waitUntilInputOutputClosed() throws IOException, CertificateException, InterruptedException, SmackException, XMPPException {
            waitForHandshakeFinished();
        }

        private TlsState(SmackTlsContext smackTlsContext2) throws IOException {
            this.handshakeStatus = TlsHandshakeStatus.initial;
            this.pendingOutputData = new ArrayList();
            this.pendingDelegatedTasks = new AtomicInteger();
            this.smackTlsContext = smackTlsContext2;
            SSLEngine createSSLEngine = smackTlsContext2.sslContext.createSSLEngine(XmppTcpTransportModule.this.connectionInternal.connection.getConfiguration().getXMPPServiceDomain().toString(), XmppTcpTransportModule.this.remoteAddress.getPort());
            this.engine = createSSLEngine;
            createSSLEngine.setUseClientMode(true);
            SSLSession session = createSSLEngine.getSession();
            int applicationBufferSize = session.getApplicationBufferSize();
            this.myNetData = ByteBuffer.allocateDirect(session.getPacketBufferSize());
            this.peerAppData = ByteBuffer.allocate(applicationBufferSize);
        }
    }

    public static final class TlsStateStats {
        private transient String toStringCache;
        public final long unwrapInBytes;
        public final long unwrapOutBytes;
        public final double unwrapRatio;
        public final long wrapInBytes;
        public final long wrapOutBytes;
        public final double wrapRatio;

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "wrap-in-bytes: " + this.wrapInBytes + 10 + "wrap-out-bytes: " + this.wrapOutBytes + 10 + "wrap-ratio: " + this.wrapRatio + 10 + "unwrap-in-bytes: " + this.unwrapInBytes + 10 + "unwrap-out-bytes: " + this.unwrapOutBytes + 10 + "unwrap-ratio: " + this.unwrapRatio + 10;
            this.toStringCache = str2;
            return str2;
        }

        private TlsStateStats(TlsState tlsState) {
            long access$4100 = tlsState.wrapOutBytes;
            this.wrapOutBytes = access$4100;
            long access$4200 = tlsState.wrapInBytes;
            this.wrapInBytes = access$4200;
            this.wrapRatio = ((double) access$4100) / ((double) access$4200);
            long access$4300 = tlsState.unwrapOutBytes;
            this.unwrapOutBytes = access$4300;
            long access$4400 = tlsState.unwrapInBytes;
            this.unwrapInBytes = access$4400;
            this.unwrapRatio = ((double) access$4400) / ((double) access$4300);
        }
    }

    final class XmppTcpNioTransport extends XmppClientToServerTransport {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        final class DiscoveredTcpEndpoints implements XmppClientToServerTransport.LookupConnectionEndpointsSuccess {
            final RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result;

            DiscoveredTcpEndpoints(RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result2) {
                this.result = result2;
            }
        }

        final class TcpEndpointDiscoveryFailed implements XmppClientToServerTransport.LookupConnectionEndpointsFailed {
            final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

            TcpEndpointDiscoveryFailed(RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result) {
                this.lookupFailures = result.lookupFailures;
            }
        }

        protected XmppTcpNioTransport(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(modularXmppClientToServerConnectionInternal);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$lookupConnectionEndpoints$0(SmackFuture.InternalSmackFuture internalSmackFuture) {
            Object obj;
            RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> lookup = RemoteXmppTcpConnectionEndpoints.lookup(this.connectionInternal.connection.getConfiguration());
            if (lookup.discoveredRemoteConnectionEndpoints.isEmpty()) {
                obj = new TcpEndpointDiscoveryFailed(lookup);
            } else {
                obj = new DiscoveredTcpEndpoints(lookup);
            }
            internalSmackFuture.setResult(obj);
        }

        /* access modifiers changed from: protected */
        public void afterFiltersClosed() {
            XmppTcpTransportModule xmppTcpTransportModule = XmppTcpTransportModule.this;
            boolean unused = xmppTcpTransportModule.pendingInputFilterData = xmppTcpTransportModule.pendingOutputFilterData = true;
            XmppTcpTransportModule.this.afterOutgoingElementsQueueModified();
        }

        /* access modifiers changed from: protected */
        public void disconnect() {
            XmppTcpTransportModule.this.closeSocketAndCleanup();
        }

        public SSLSession getSslSession() {
            TlsState access$1100 = XmppTcpTransportModule.this.tlsState;
            if (access$1100 == null) {
                return null;
            }
            return access$1100.engine.getSession();
        }

        public boolean isConnected() {
            SocketChannel access$1300 = XmppTcpTransportModule.this.socketChannel;
            if (access$1300 == null) {
                return false;
            }
            return access$1300.isConnected();
        }

        public boolean isTransportSecured() {
            TlsState access$1100 = XmppTcpTransportModule.this.tlsState;
            if (access$1100 == null || access$1100.handshakeStatus != TlsHandshakeStatus.successful) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public void loadConnectionEndpoints(XmppClientToServerTransport.LookupConnectionEndpointsSuccess lookupConnectionEndpointsSuccess) {
            XmppTcpTransportModule.this.discoveredTcpEndpoints = (DiscoveredTcpEndpoints) lookupConnectionEndpointsSuccess;
        }

        /* access modifiers changed from: protected */
        public List<SmackFuture<XmppClientToServerTransport.LookupConnectionEndpointsResult, Exception>> lookupConnectionEndpoints() {
            ArrayList arrayList = new ArrayList(2);
            SmackFuture.InternalSmackFuture internalSmackFuture = new SmackFuture.InternalSmackFuture();
            this.connectionInternal.asyncGo(new t(this, internalSmackFuture));
            arrayList.add(internalSmackFuture);
            if (!((XmppTcpTransportModuleDescriptor) XmppTcpTransportModule.this.moduleDescriptor).isDirectTlsEnabled()) {
                return arrayList;
            }
            throw new IllegalArgumentException("DirectTLS is not implemented yet");
        }

        /* access modifiers changed from: protected */
        public void notifyAboutNewOutgoingElements() {
            XmppTcpTransportModule.this.afterOutgoingElementsQueueModified();
        }

        /* access modifiers changed from: protected */
        public void resetDiscoveredConnectionEndpoints() {
            XmppTcpTransportModule.this.discoveredTcpEndpoints = null;
        }

        public Stats getStats() {
            return XmppTcpTransportModule.this.getStats();
        }
    }

    XmppTcpTransportModule(XmppTcpTransportModuleDescriptor xmppTcpTransportModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(xmppTcpTransportModuleDescriptor, modularXmppClientToServerConnectionInternal);
        e eVar;
        AnonymousClass1 r42 = new g() {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private String streamClose;
            private String streamOpen;

            public void onCompleteElement(String str) {
                XmppTcpTransportModule.this.connectionInternal.withSmackDebugger(new o());
                XmppTcpTransportModule.this.connectionInternal.parseAndProcessElement(this.streamOpen + str + this.streamClose);
            }

            public void streamClosed() {
                if (XmppTcpTransportModule.LOGGER.isLoggable(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL)) {
                    Logger access$300 = XmppTcpTransportModule.LOGGER;
                    Level access$200 = XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL;
                    access$300.log(access$200, "Stream of " + this + " closed");
                }
                XmppTcpTransportModule.this.connectionInternal.onStreamClosed();
            }

            public void streamOpened(String str, Map<String, String> map) {
                if (XmppTcpTransportModule.LOGGER.isLoggable(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL)) {
                    XmppTcpTransportModule.LOGGER.log(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL, "Stream of " + this + " opened. prefix=" + str + " attributes=" + map);
                }
                String str2 = "xmlns:" + str;
                StringBuilder sb2 = new StringBuilder(32);
                StringBuilder sb3 = new StringBuilder(256);
                sb3.append('<');
                sb2.append("</");
                if (StringUtils.isNotEmpty((CharSequence) str)) {
                    sb3.append(str);
                    sb3.append(':');
                    sb2.append(str);
                    sb2.append(':');
                }
                sb3.append("stream");
                sb2.append("stream>");
                for (Map.Entry next : map.entrySet()) {
                    String str3 = (String) next.getKey();
                    String str4 = (String) next.getValue();
                    str3.hashCode();
                    char c10 = 65535;
                    switch (str3.hashCode()) {
                        case -213677199:
                            if (str3.equals("xml:lang")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case 3355:
                            if (str3.equals("id")) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case 3707:
                            if (str3.equals("to")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 3151786:
                            if (str3.equals("from")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 114177052:
                            if (str3.equals("xmlns")) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case 351608024:
                            if (str3.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                                c10 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c10) {
                        case 0:
                            sb3.append(" xml:lang='");
                            sb3.append(str4);
                            sb3.append('\'');
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                            break;
                        case 4:
                            sb3.append(" xmlns='");
                            sb3.append(str4);
                            sb3.append('\'');
                            break;
                        default:
                            if (!str3.equals(str2)) {
                                XmppTcpTransportModule.LOGGER.info("Unknown <stream/> attribute: " + str3);
                                break;
                            } else {
                                sb3.append(' ');
                                sb3.append(str2);
                                sb3.append("='");
                                sb3.append(str4);
                                sb3.append('\'');
                                break;
                            }
                    }
                }
                sb3.append('>');
                this.streamOpen = sb3.toString();
                this.streamClose = sb2.toString();
                try {
                    XmppTcpTransportModule.this.connectionInternal.onStreamOpen(PacketParserUtils.getParserFor(this.streamOpen));
                } catch (IOException | XmlPullParserException e10) {
                    throw new AssertionError(e10);
                }
            }
        };
        this.xmppElementCallback = r42;
        this.tcpNioTransport = new XmppTcpNioTransport(modularXmppClientToServerConnectionInternal);
        SmackDebugger smackDebugger = modularXmppClientToServerConnectionInternal.smackDebugger;
        if (smackDebugger != null) {
            eVar = e.f().h(new m(smackDebugger)).g();
            this.outputDebugSplitter = new h(e.f().h(new n(smackDebugger)).g());
        } else {
            eVar = null;
        }
        this.splitter = new d(new h(65536, r42, eVar));
    }

    static /* synthetic */ int access$3308(XmppTcpTransportModule xmppTcpTransportModule) {
        int i10 = xmppTcpTransportModule.sslEngineDelegatedTasks;
        xmppTcpTransportModule.sslEngineDelegatedTasks = i10 + 1;
        return i10;
    }

    /* access modifiers changed from: private */
    public void afterOutgoingElementsQueueModified() {
        SmackReactor.SelectionKeyAttachment selectionKeyAttachment2 = this.selectionKeyAttachment;
        if (selectionKeyAttachment2 == null || !selectionKeyAttachment2.isReactorThreadRacing()) {
            this.afterOutgoingElementsQueueModifiedSetInterestOps.incrementAndGet();
            this.connectionInternal.setInterestOps(this.selectionKey, 5);
            return;
        }
        this.reactorThreadAlreadyRacing.incrementAndGet();
    }

    /* access modifiers changed from: private */
    public void callChannelSelectedCallback(boolean z10, boolean z11) {
        SocketChannel socketChannel2 = this.socketChannel;
        SelectionKey selectionKey2 = this.selectionKey;
        if (socketChannel2 == null || selectionKey2 == null) {
            LOGGER.info("Not calling channel selected callback because the connection was eventually disconnected");
            return;
        }
        this.channelSelectedCallbackLock.lock();
        if (z10) {
            try {
                this.pendingInputFilterData = true;
            } catch (Throwable th2) {
                this.channelSelectedCallbackLock.unlock();
                throw th2;
            }
        }
        if (z11) {
            this.pendingOutputFilterData = true;
        }
        onChannelSelected(socketChannel2, selectionKey2);
        this.channelSelectedCallbackLock.unlock();
    }

    /* access modifiers changed from: private */
    public void closeSocketAndCleanup() {
        SelectionKey selectionKey2 = this.selectionKey;
        if (selectionKey2 != null) {
            selectionKey2.cancel();
        }
        SocketChannel socketChannel2 = this.socketChannel;
        if (socketChannel2 != null) {
            try {
                socketChannel2.close();
            } catch (IOException unused) {
            }
        }
        this.selectionKey = null;
        this.socketChannel = null;
        this.selectionKeyAttachment = null;
        this.remoteAddress = null;
    }

    /* access modifiers changed from: private */
    public EstablishingTcpConnectionState constructEstablishingTcpConnectionState(EstablishingTcpConnectionStateDescriptor establishingTcpConnectionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EstablishingTcpConnectionState(establishingTcpConnectionStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    /* access modifiers changed from: private */
    public EstablishTlsState constructEstablishingTlsState(EstablishTlsStateDescriptor establishTlsStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EstablishTlsState(establishTlsStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    /* access modifiers changed from: private */
    public static void debugLogSslEngineResult(String str, SSLEngineResult sSLEngineResult) {
        Logger logger = LOGGER;
        Level level = SSL_ENGINE_DEBUG_LOG_LEVEL;
        if (logger.isLoggable(level)) {
            logger.log(level, "SSLEngineResult of " + str + "(): " + sSLEngineResult);
        }
    }

    private void handleReadWriteIoException(IOException iOException) {
        if (!(iOException instanceof ClosedChannelException) || this.tcpNioTransport.isConnected()) {
            this.connectionInternal.notifyConnectionError(iOException);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0191, code lost:
        if (r3 < 8096) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        r1.callbackPreemtBecauseBytesRead++;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0176 A[SYNTHETIC, Splitter:B:103:0x0176] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0216 A[EDGE_INSN: B:142:0x0216->B:143:? ?: BREAK  , SYNTHETIC, Splitter:B:142:0x0216] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x021f A[Catch:{ IOException -> 0x02c4, all -> 0x0319 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[SYNTHETIC, Splitter:B:18:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x01b4 A[EDGE_INSN: B:204:0x01b4->B:117:0x01b4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChannelSelected(java.nio.channels.SelectableChannel r21, java.nio.channels.SelectionKey r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.nio.channels.SocketChannel r2 = (java.nio.channels.SocketChannel) r2
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            boolean r0 = r0.tryLock()
            if (r0 != 0) goto L_0x0014
            java.util.concurrent.atomic.AtomicLong r0 = r1.rejectedChannelSelectedCallbacks
            r0.incrementAndGet()
            return
        L_0x0014:
            long r3 = r1.handledChannelSelectedCallbacks
            r5 = 1
            long r3 = r3 + r5
            r1.handledChannelSelectedCallbacks = r3
            r0 = 0
            r7 = 0
            r11 = r0
            r12 = r11
            r8 = r7
            r13 = r8
            r14 = r13
            r9 = 0
        L_0x0024:
            r15 = 1
            if (r8 == 0) goto L_0x0039
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r5 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            java.util.Queue<org.jivesoftware.smack.packet.TopLevelStreamElement> r5 = r5.outgoingElementsQueue     // Catch:{ all -> 0x0034 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0034 }
            if (r5 != 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            r5 = r7
            goto L_0x003a
        L_0x0034:
            r0 = move-exception
            r3 = 0
            goto L_0x0321
        L_0x0039:
            r5 = r15
        L_0x003a:
            java.nio.ByteBuffer r6 = r1.filteredOutgoingBuffer     // Catch:{ all -> 0x031d }
            r16 = 10485760(0xa00000, double:5.180654E-317)
            r18 = 5
            if (r6 != 0) goto L_0x0171
            java.util.List<java.nio.ByteBuffer> r6 = r1.networkOutgoingBuffers     // Catch:{ all -> 0x0034 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0034 }
            if (r6 != 0) goto L_0x004d
            goto L_0x0171
        L_0x004d:
            java.nio.ByteBuffer r6 = r1.outgoingBuffer     // Catch:{ all -> 0x0034 }
            if (r6 != 0) goto L_0x00f1
            boolean r3 = r1.pendingOutputFilterData     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0057
            goto L_0x00f1
        L_0x0057:
            java.util.Iterator<java.lang.CharSequence> r3 = r1.outgoingCharSequenceIterator     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r3.next()     // Catch:{ all -> 0x0034 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0034 }
            java.nio.ByteBuffer r4 = org.jivesoftware.smack.util.UTF8.encode((java.lang.CharSequence) r3)     // Catch:{ all -> 0x0034 }
            r1.outgoingBuffer = r4     // Catch:{ all -> 0x0034 }
            java.util.Iterator<java.lang.CharSequence> r4 = r1.outgoingCharSequenceIterator     // Catch:{ all -> 0x0034 }
            boolean r4 = r4.hasNext()     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0072
            r1.outgoingCharSequenceIterator = r0     // Catch:{ all -> 0x0034 }
            goto L_0x0073
        L_0x0072:
            r15 = r7
        L_0x0073:
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r4 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.debugger.SmackDebugger r4 = r4.smackDebugger     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x0097
            if (r12 != 0) goto L_0x0081
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r5.<init>()     // Catch:{ all -> 0x0034 }
            r12 = r5
        L_0x0081:
            r12.append(r3)     // Catch:{ all -> 0x0034 }
            if (r15 == 0) goto L_0x0097
            org.jxmpp.xml.splitter.h r3 = r1.outputDebugSplitter     // Catch:{ IOException -> 0x0090 }
            r3.append(r12)     // Catch:{ IOException -> 0x0090 }
            r4.onOutgoingElementCompleted()     // Catch:{ all -> 0x0034 }
            r12 = r0
            goto L_0x0097
        L_0x0090:
            r0 = move-exception
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0034 }
            r2.<init>(r0)     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x0097:
            r8 = r15
        L_0x0098:
            r5 = 0
            goto L_0x0195
        L_0x009c:
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r3 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            java.util.Queue<org.jivesoftware.smack.packet.TopLevelStreamElement> r3 = r3.outgoingElementsQueue     // Catch:{ all -> 0x0034 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0034 }
            if (r3 != 0) goto L_0x013b
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r3 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            java.util.Queue<org.jivesoftware.smack.packet.TopLevelStreamElement> r3 = r3.outgoingElementsQueue     // Catch:{ all -> 0x0034 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.packet.TopLevelStreamElement r3 = (org.jivesoftware.smack.packet.TopLevelStreamElement) r3     // Catch:{ all -> 0x0034 }
            boolean r4 = r3 instanceof org.jivesoftware.smack.packet.Stanza     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x00c8
            r4 = r3
            org.jivesoftware.smack.packet.Stanza r4 = (org.jivesoftware.smack.packet.Stanza) r4     // Catch:{ all -> 0x0034 }
            org.jxmpp.jid.Jid r4 = r4.getTo()     // Catch:{ all -> 0x0034 }
            org.jxmpp.jid.Jid r5 = r1.lastDestinationAddress     // Catch:{ all -> 0x0034 }
            boolean r5 = im.a.a(r5, r4)     // Catch:{ all -> 0x0034 }
            if (r5 != 0) goto L_0x00c5
            r14 = r15
            goto L_0x00c6
        L_0x00c5:
            r14 = r7
        L_0x00c6:
            r1.lastDestinationAddress = r4     // Catch:{ all -> 0x0034 }
        L_0x00c8:
            java.lang.String r4 = "jabber:client"
            java.lang.CharSequence r4 = r3.toXML((java.lang.String) r4)     // Catch:{ all -> 0x0034 }
            boolean r5 = r4 instanceof org.jivesoftware.smack.util.XmlStringBuilder     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x00e5
            org.jivesoftware.smack.util.XmlStringBuilder r4 = (org.jivesoftware.smack.util.XmlStringBuilder) r4     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r5 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.packet.XmlEnvironment r5 = r5.getOutgoingStreamXmlEnvironment()     // Catch:{ all -> 0x0034 }
            java.util.List r4 = r4.toList(r5)     // Catch:{ all -> 0x0034 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0034 }
            r1.outgoingCharSequenceIterator = r4     // Catch:{ all -> 0x0034 }
            goto L_0x00ef
        L_0x00e5:
            java.util.List r4 = java.util.Collections.singletonList(r4)     // Catch:{ all -> 0x0034 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0034 }
            r1.outgoingCharSequenceIterator = r4     // Catch:{ all -> 0x0034 }
        L_0x00ef:
            r11 = r3
            goto L_0x0098
        L_0x00f1:
            r1.pendingOutputFilterData = r7     // Catch:{ all -> 0x0034 }
            if (r6 == 0) goto L_0x0109
            long r3 = r1.totalBytesWrittenBeforeFilter     // Catch:{ all -> 0x0034 }
            int r6 = r6.remaining()     // Catch:{ all -> 0x0034 }
            r19 = r8
            long r7 = (long) r6     // Catch:{ all -> 0x0034 }
            long r3 = r3 + r7
            r1.totalBytesWrittenBeforeFilter = r3     // Catch:{ all -> 0x0034 }
            if (r19 == 0) goto L_0x010b
            java.util.List<org.jivesoftware.smack.packet.TopLevelStreamElement> r3 = r1.currentlyOutgoingElements     // Catch:{ all -> 0x0034 }
            r3.add(r11)     // Catch:{ all -> 0x0034 }
            goto L_0x010b
        L_0x0109:
            r19 = r8
        L_0x010b:
            java.nio.ByteBuffer r3 = r1.outgoingBuffer     // Catch:{ all -> 0x0034 }
            r1.outgoingBuffer = r0     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r4 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            java.util.ListIterator r4 = r4.getXmppInputOutputFilterBeginIterator()     // Catch:{ all -> 0x0034 }
        L_0x0115:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0034 }
            if (r6 == 0) goto L_0x013f
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.XmppInputOutputFilter r6 = (org.jivesoftware.smack.XmppInputOutputFilter) r6     // Catch:{ all -> 0x0034 }
            r7 = r19
            org.jivesoftware.smack.XmppInputOutputFilter$OutputResult r3 = r6.output(r3, r7, r14, r5)     // Catch:{ IOException -> 0x0134 }
            boolean r6 = r3.pendingFilterData     // Catch:{ all -> 0x0034 }
            r13 = r13 | r6
            java.nio.ByteBuffer r3 = r3.filteredOutputData     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0131
            r3.flip()     // Catch:{ all -> 0x0034 }
        L_0x0131:
            r19 = r7
            goto L_0x0115
        L_0x0134:
            r0 = move-exception
            r3 = r0
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r0 = r1.connectionInternal     // Catch:{ all -> 0x0034 }
            r0.notifyConnectionError(r3)     // Catch:{ all -> 0x0034 }
        L_0x013b:
            r5 = 0
            goto L_0x0207
        L_0x013f:
            r7 = r19
            if (r3 == 0) goto L_0x014c
            boolean r4 = r3.hasRemaining()     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x014c
            r1.filteredOutgoingBuffer = r3     // Catch:{ all -> 0x0034 }
            goto L_0x014e
        L_0x014c:
            r1.filteredOutgoingBuffer = r0     // Catch:{ all -> 0x0034 }
        L_0x014e:
            java.nio.ByteBuffer r3 = r1.filteredOutgoingBuffer     // Catch:{ all -> 0x0034 }
            if (r3 != 0) goto L_0x0156
            if (r13 == 0) goto L_0x0156
            r1.pendingWriteInterestAfterRead = r15     // Catch:{ all -> 0x0034 }
        L_0x0156:
            if (r3 == 0) goto L_0x016b
            if (r7 == 0) goto L_0x016b
            java.util.Map<java.nio.ByteBuffer, java.util.List<org.jivesoftware.smack.packet.TopLevelStreamElement>> r4 = r1.bufferToElementMap     // Catch:{ all -> 0x0034 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0034 }
            java.util.List<org.jivesoftware.smack.packet.TopLevelStreamElement> r6 = r1.currentlyOutgoingElements     // Catch:{ all -> 0x0034 }
            r5.<init>(r6)     // Catch:{ all -> 0x0034 }
            r4.put(r3, r5)     // Catch:{ all -> 0x0034 }
            java.util.List<org.jivesoftware.smack.packet.TopLevelStreamElement> r3 = r1.currentlyOutgoingElements     // Catch:{ all -> 0x0034 }
            r3.clear()     // Catch:{ all -> 0x0034 }
        L_0x016b:
            if (r14 == 0) goto L_0x016e
            r14 = 0
        L_0x016e:
            r8 = r7
            goto L_0x0098
        L_0x0171:
            r7 = r8
            java.nio.ByteBuffer r3 = r1.filteredOutgoingBuffer     // Catch:{ all -> 0x031d }
            if (r3 == 0) goto L_0x019a
            java.util.List<java.nio.ByteBuffer> r4 = r1.networkOutgoingBuffers     // Catch:{ all -> 0x0034 }
            r4.add(r3)     // Catch:{ all -> 0x0034 }
            long r3 = r1.networkOutgoingBuffersBytes     // Catch:{ all -> 0x0034 }
            java.nio.ByteBuffer r6 = r1.filteredOutgoingBuffer     // Catch:{ all -> 0x0034 }
            int r6 = r6.remaining()     // Catch:{ all -> 0x0034 }
            r19 = r7
            long r6 = (long) r6     // Catch:{ all -> 0x0034 }
            long r3 = r3 + r6
            r1.networkOutgoingBuffersBytes = r3     // Catch:{ all -> 0x0034 }
            r1.filteredOutgoingBuffer = r0     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x019c
            r5 = 8096(0x1fa0, double:4.0E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x019c
        L_0x0193:
            r8 = r19
        L_0x0195:
            r5 = 1
            r7 = 0
            goto L_0x0024
        L_0x019a:
            r19 = r7
        L_0x019c:
            java.util.List<java.nio.ByteBuffer> r3 = r1.networkOutgoingBuffers     // Catch:{ all -> 0x031d }
            int r4 = r3.size()     // Catch:{ all -> 0x031d }
            java.nio.ByteBuffer[] r4 = new java.nio.ByteBuffer[r4]     // Catch:{ all -> 0x031d }
            java.lang.Object[] r3 = r3.toArray(r4)     // Catch:{ all -> 0x031d }
            java.nio.ByteBuffer[] r3 = (java.nio.ByteBuffer[]) r3     // Catch:{ all -> 0x031d }
            long r3 = r2.write(r3)     // Catch:{ IOException -> 0x0200 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b7
        L_0x01b4:
            r15 = r18
            goto L_0x0207
        L_0x01b7:
            long r9 = r9 + r3
            long r7 = r1.networkOutgoingBuffersBytes     // Catch:{ all -> 0x031b }
            long r7 = r7 - r3
            r1.networkOutgoingBuffersBytes = r7     // Catch:{ all -> 0x031b }
            java.util.List<java.nio.ByteBuffer> r3 = r1.networkOutgoingBuffers     // Catch:{ all -> 0x031b }
            java.util.List r3 = pruneBufferList(r3)     // Catch:{ all -> 0x031b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x031b }
        L_0x01c7:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x031b }
            if (r4 == 0) goto L_0x01f4
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x031b }
            java.nio.Buffer r4 = (java.nio.Buffer) r4     // Catch:{ all -> 0x031b }
            java.util.Map<java.nio.ByteBuffer, java.util.List<org.jivesoftware.smack.packet.TopLevelStreamElement>> r7 = r1.bufferToElementMap     // Catch:{ all -> 0x031b }
            java.lang.Object r4 = r7.remove(r4)     // Catch:{ all -> 0x031b }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x031b }
            if (r4 != 0) goto L_0x01de
            goto L_0x01c7
        L_0x01de:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x031b }
        L_0x01e2:
            boolean r7 = r4.hasNext()     // Catch:{ all -> 0x031b }
            if (r7 == 0) goto L_0x01c7
            java.lang.Object r7 = r4.next()     // Catch:{ all -> 0x031b }
            org.jivesoftware.smack.packet.TopLevelStreamElement r7 = (org.jivesoftware.smack.packet.TopLevelStreamElement) r7     // Catch:{ all -> 0x031b }
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r8 = r1.connectionInternal     // Catch:{ all -> 0x031b }
            r8.fireFirstLevelElementSendListeners(r7)     // Catch:{ all -> 0x031b }
            goto L_0x01e2
        L_0x01f4:
            int r3 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0193
            long r3 = r1.callbackPreemtBecauseBytesWritten     // Catch:{ all -> 0x031b }
            r7 = 1
            long r3 = r3 + r7
            r1.callbackPreemtBecauseBytesWritten = r3     // Catch:{ all -> 0x031b }
            goto L_0x01b4
        L_0x0200:
            r0 = move-exception
            r5 = 0
            r3 = r0
            r1.handleReadWriteIoException(r3)     // Catch:{ all -> 0x031b }
        L_0x0207:
            r1.pendingOutputFilterData = r13     // Catch:{ all -> 0x031b }
            boolean r0 = r1.pendingWriteInterestAfterRead     // Catch:{ all -> 0x031b }
            if (r0 != 0) goto L_0x0211
            if (r13 == 0) goto L_0x0211
            r15 = r15 | 4
        L_0x0211:
            r3 = r5
        L_0x0212:
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x021f
            long r5 = r1.callbackPreemtBecauseBytesRead     // Catch:{ all -> 0x0319 }
            r7 = 1
            long r5 = r5 + r7
            r1.callbackPreemtBecauseBytesRead = r5     // Catch:{ all -> 0x0319 }
            goto L_0x0295
        L_0x021f:
            r7 = 1
            java.nio.ByteBuffer r0 = r1.incomingBuffer     // Catch:{ all -> 0x0319 }
            r0.clear()     // Catch:{ all -> 0x0319 }
            java.nio.ByteBuffer r0 = r1.incomingBuffer     // Catch:{ IOException -> 0x0305 }
            int r0 = r2.read(r0)     // Catch:{ IOException -> 0x0305 }
            if (r0 >= 0) goto L_0x0261
            java.util.logging.Logger r2 = LOGGER     // Catch:{ all -> 0x0319 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r5.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r6 = "NIO read() returned "
            r5.append(r6)     // Catch:{ all -> 0x0319 }
            r5.append(r0)     // Catch:{ all -> 0x0319 }
            java.lang.String r0 = " for "
            r5.append(r0)     // Catch:{ all -> 0x0319 }
            r5.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r0 = ". This probably means that the TCP connection was terminated."
            r5.append(r0)     // Catch:{ all -> 0x0319 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0319 }
            r2.finer(r0)     // Catch:{ all -> 0x0319 }
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            r0.unlock()
            return
        L_0x0261:
            boolean r5 = r1.pendingInputFilterData     // Catch:{ all -> 0x0319 }
            if (r5 != 0) goto L_0x026a
            if (r0 != 0) goto L_0x0268
            goto L_0x0295
        L_0x0268:
            r5 = 0
            goto L_0x026d
        L_0x026a:
            r5 = 0
            r1.pendingInputFilterData = r5     // Catch:{ all -> 0x0319 }
        L_0x026d:
            boolean r6 = r1.pendingWriteInterestAfterRead     // Catch:{ all -> 0x0319 }
            if (r6 == 0) goto L_0x0276
            r1.pendingWriteInterestAfterRead = r5     // Catch:{ all -> 0x0319 }
            r6 = r15 | 4
            r15 = r6
        L_0x0276:
            long r11 = (long) r0     // Catch:{ all -> 0x0319 }
            long r3 = r3 + r11
            java.nio.ByteBuffer r0 = r1.incomingBuffer     // Catch:{ all -> 0x0319 }
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r6 = r1.connectionInternal     // Catch:{ all -> 0x0319 }
            java.util.ListIterator r6 = r6.getXmppInputOutputFilterEndIterator()     // Catch:{ all -> 0x0319 }
        L_0x0280:
            boolean r11 = r6.hasPrevious()     // Catch:{ all -> 0x0319 }
            if (r11 == 0) goto L_0x02da
            r0.flip()     // Catch:{ all -> 0x0319 }
            java.lang.Object r11 = r6.previous()     // Catch:{ IOException -> 0x02c4 }
            org.jivesoftware.smack.XmppInputOutputFilter r11 = (org.jivesoftware.smack.XmppInputOutputFilter) r11     // Catch:{ IOException -> 0x02c4 }
            java.nio.ByteBuffer r0 = r11.input(r0)     // Catch:{ IOException -> 0x02c4 }
            if (r0 != 0) goto L_0x0280
        L_0x0295:
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            r0.unlock()
            org.jivesoftware.smack.SmackReactor$SelectionKeyAttachment r0 = r1.selectionKeyAttachment
            if (r0 == 0) goto L_0x02ab
            r0.resetReactorThreadRacing()
        L_0x02ab:
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r0 = r1.connectionInternal
            java.util.Queue<org.jivesoftware.smack.packet.TopLevelStreamElement> r0 = r0.outgoingElementsQueue
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x02bc
            java.util.concurrent.atomic.AtomicLong r0 = r1.setWriteInterestAfterChannelSelectedCallback
            r0.incrementAndGet()
            r15 = r15 | 4
        L_0x02bc:
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r0 = r1.connectionInternal
            java.nio.channels.SelectionKey r2 = r1.selectionKey
            r0.setInterestOps(r2, r15)
            return
        L_0x02c4:
            r0 = move-exception
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r2 = r1.connectionInternal     // Catch:{ all -> 0x0319 }
            r2.notifyConnectionError(r0)     // Catch:{ all -> 0x0319 }
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            r0.unlock()
            return
        L_0x02da:
            java.nio.Buffer r6 = r0.flip()     // Catch:{ all -> 0x0319 }
            int r6 = r6.remaining()     // Catch:{ all -> 0x0319 }
            long r11 = r1.totalBytesReadAfterFilter     // Catch:{ all -> 0x0319 }
            long r13 = (long) r6     // Catch:{ all -> 0x0319 }
            long r11 = r11 + r13
            r1.totalBytesReadAfterFilter = r11     // Catch:{ all -> 0x0319 }
            org.jxmpp.xml.splitter.d r6 = r1.splitter     // Catch:{ IOException -> 0x02ef }
            r6.g(r0)     // Catch:{ IOException -> 0x02ef }
            goto L_0x0212
        L_0x02ef:
            r0 = move-exception
            org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal r2 = r1.connectionInternal     // Catch:{ all -> 0x0319 }
            r2.notifyConnectionError(r0)     // Catch:{ all -> 0x0319 }
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            r0.unlock()
            return
        L_0x0305:
            r0 = move-exception
            r1.handleReadWriteIoException(r0)     // Catch:{ all -> 0x0319 }
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r0 = r1.channelSelectedCallbackLock
            r0.unlock()
            return
        L_0x0319:
            r0 = move-exception
            goto L_0x0321
        L_0x031b:
            r0 = move-exception
            goto L_0x0320
        L_0x031d:
            r0 = move-exception
            r5 = 0
        L_0x0320:
            r3 = r5
        L_0x0321:
            long r5 = r1.totalBytesWritten
            long r5 = r5 + r9
            r1.totalBytesWritten = r5
            long r5 = r1.totalBytesRead
            long r5 = r5 + r3
            r1.totalBytesRead = r5
            java.util.concurrent.locks.ReentrantLock r2 = r1.channelSelectedCallbackLock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XmppTcpTransportModule.onChannelSelected(java.nio.channels.SelectableChannel, java.nio.channels.SelectionKey):void");
    }

    /* access modifiers changed from: private */
    public static List<? extends Buffer> pruneBufferList(Collection<? extends Buffer> collection) {
        return CollectionUtil.removeUntil(collection, new l());
    }

    public Stats getStats() {
        return new Stats();
    }

    /* access modifiers changed from: protected */
    public XmppTcpNioTransport getTransport() {
        return this.tcpNioTransport;
    }
}
