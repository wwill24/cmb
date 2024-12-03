package org.jivesoftware.smack;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;
import lm.c;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageOrPresence;
import org.jivesoftware.smack.packet.MessageOrPresenceBuilder;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.StreamOpen;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.NonzaProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.core.SASLAnonymous;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class AbstractXMPPConnection implements XMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: protected */
    public static final AsyncButOrdered<AbstractXMPPConnection> ASYNC_BUT_ORDERED = new AsyncButOrdered<>();
    private static final ExecutorService CACHED_EXECUTOR_SERVICE = Executors.newCachedThreadPool(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("Smack Cached Executor");
            thread.setDaemon(true);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th2) {
                    Logger access$000 = AbstractXMPPConnection.LOGGER;
                    Level level = Level.WARNING;
                    access$000.log(level, thread + " encountered uncaught exception", th2);
                }
            });
            return thread;
        }
    });
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(AbstractXMPPConnection.class.getName());
    protected static final SmackReactor SMACK_REACTOR = SmackReactor.getInstance();
    private static final AtomicInteger connectionCounter = new AtomicInteger(0);
    private final Map<StanzaListener, ListenerWrapper> asyncRecvListeners = new LinkedHashMap();
    protected boolean authenticated = false;
    protected long authenticatedConnectionInitiallyEstablishedTimestamp;
    /* access modifiers changed from: protected */
    public boolean closingStreamReceived;
    private final Collection<StanzaCollector> collectors = new ConcurrentLinkedQueue();
    protected XMPPInputOutputStream compressionHandler;
    protected final ConnectionConfiguration config;
    protected boolean connected = false;
    protected final int connectionCounterValue = connectionCounter.getAndIncrement();
    protected final Set<ConnectionListener> connectionListeners = new CopyOnWriteArraySet();
    protected final Lock connectionLock = new ReentrantLock();
    private int currentAsyncRunnables;
    /* access modifiers changed from: protected */
    public SmackException currentSmackException;
    protected XMPPException currentXmppException;
    protected final SmackDebugger debugger;
    /* access modifiers changed from: private */
    public final Queue<Runnable> deferredAsyncRunnables = new LinkedList();
    private int deferredAsyncRunnablesCount;
    private int deferredAsyncRunnablesCountPrevious;
    private XMPPConnection.FromMode fromMode = XMPPConnection.FromMode.OMITTED;
    private final Map<QName, IQRequestHandler> getIqRequestHandler = new HashMap();
    protected String host;
    protected final AsyncButOrdered<StanzaListener> inOrderListeners = new AsyncButOrdered<>();
    private XmlEnvironment incomingStreamXmlEnvironment;
    private final Map<StanzaListener, InterceptorWrapper> interceptors = new HashMap();
    private final Object internalMonitor = new Object();
    protected boolean lastFeaturesReceived;
    private long lastStanzaReceived;
    private int maxAsyncRunnables = SmackConfiguration.getDefaultConcurrencyLevelLimit();
    private final Map<Consumer<MessageBuilder>, GenericInterceptorWrapper<MessageBuilder, Message>> messageInterceptors = new HashMap();
    final MultiMap<QName, NonzaCallback> nonzaCallbacksMap = new MultiMap<>();
    private final Object notifyConnectionErrorMonitor = new Object();
    /* access modifiers changed from: protected */
    public XmlEnvironment outgoingStreamXmlEnvironment;
    private ParsingExceptionCallback parsingExceptionCallback = SmackConfiguration.getDefaultParsingExceptionCallback();
    protected UInt16 port;
    private final Map<Consumer<PresenceBuilder>, GenericInterceptorWrapper<PresenceBuilder, Presence>> presenceInterceptors = new HashMap();
    protected Reader reader;
    private final Map<StanzaListener, ListenerWrapper> recvListeners = new LinkedHashMap();
    private long replyTimeout = ((long) SmackConfiguration.getDefaultReplyTimeout());
    private final SASLAuthentication saslAuthentication;
    protected boolean saslFeatureReceived;
    private final Map<StanzaListener, ListenerWrapper> sendListeners = new HashMap();
    private final Map<QName, IQRequestHandler> setIqRequestHandler = new HashMap();
    private final StanzaFactory stanzaFactory;
    protected final Map<QName, FullyQualifiedElement> streamFeatures = new HashMap();
    protected String streamId;
    /* access modifiers changed from: private */
    public final Map<StanzaListener, ListenerWrapper> syncRecvListeners = new LinkedHashMap();
    protected boolean tlsHandled;
    private SmackConfiguration.UnknownIqRequestReplyMode unknownIqRequestReplyMode = SmackConfiguration.getUnknownIqRequestReplyMode();
    private String usedPassword;
    private Resourcepart usedResource;
    private String usedUsername;
    protected EntityFullJid user;
    protected boolean wasAuthenticated = false;
    /* access modifiers changed from: protected */
    public Writer writer;
    private DomainBareJid xmppServiceDomain;

    /* renamed from: org.jivesoftware.smack.AbstractXMPPConnection$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|22|23|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|19|20|21|22|23|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        static {
            /*
                org.jivesoftware.smack.iqrequest.IQRequestHandler$Mode[] r0 = org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode = r0
                r1 = 1
                org.jivesoftware.smack.iqrequest.IQRequestHandler$Mode r2 = org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode.sync     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.iqrequest.IQRequestHandler$Mode r3 = org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode.async     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.jivesoftware.smack.SmackConfiguration$UnknownIqRequestReplyMode[] r2 = org.jivesoftware.smack.SmackConfiguration.UnknownIqRequestReplyMode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode = r2
                org.jivesoftware.smack.SmackConfiguration$UnknownIqRequestReplyMode r3 = org.jivesoftware.smack.SmackConfiguration.UnknownIqRequestReplyMode.doNotReply     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.jivesoftware.smack.SmackConfiguration$UnknownIqRequestReplyMode r3 = org.jivesoftware.smack.SmackConfiguration.UnknownIqRequestReplyMode.replyFeatureNotImplemented     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.jivesoftware.smack.SmackConfiguration$UnknownIqRequestReplyMode r4 = org.jivesoftware.smack.SmackConfiguration.UnknownIqRequestReplyMode.replyServiceUnavailable     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                org.jivesoftware.smack.packet.IQ$Type[] r3 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r3
                org.jivesoftware.smack.packet.IQ$Type r4 = org.jivesoftware.smack.packet.IQ.Type.set     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x005e }
                org.jivesoftware.smack.packet.IQ$Type r4 = org.jivesoftware.smack.packet.IQ.Type.get     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                org.jivesoftware.smack.XMPPConnection$FromMode[] r3 = org.jivesoftware.smack.XMPPConnection.FromMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode = r3
                org.jivesoftware.smack.XMPPConnection$FromMode r4 = org.jivesoftware.smack.XMPPConnection.FromMode.OMITTED     // Catch:{ NoSuchFieldError -> 0x006f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode     // Catch:{ NoSuchFieldError -> 0x0079 }
                org.jivesoftware.smack.XMPPConnection$FromMode r3 = org.jivesoftware.smack.XMPPConnection.FromMode.USER     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode     // Catch:{ NoSuchFieldError -> 0x0083 }
                org.jivesoftware.smack.XMPPConnection$FromMode r1 = org.jivesoftware.smack.XMPPConnection.FromMode.UNCHANGED     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.AbstractXMPPConnection.AnonymousClass11.<clinit>():void");
        }
    }

    private static final class GenericInterceptorWrapper<MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> {
        private final Predicate<MP> stanzaFilter;
        private final Consumer<MPB> stanzaInterceptor;

        /* access modifiers changed from: private */
        public boolean filterMatches(MP mp) {
            Predicate<MP> predicate = this.stanzaFilter;
            return predicate == null || predicate.test(mp);
        }

        public Consumer<MPB> getInterceptor() {
            return this.stanzaInterceptor;
        }

        private GenericInterceptorWrapper(Consumer<MPB> consumer, Predicate<MP> predicate) {
            this.stanzaInterceptor = consumer;
            this.stanzaFilter = predicate;
        }
    }

    @Deprecated
    protected static class InterceptorWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetInterceptor;

        public InterceptorWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetInterceptor = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getInterceptor() {
            return this.packetInterceptor;
        }
    }

    protected static class ListenerWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetListener;

        public ListenerWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetListener = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getListener() {
            return this.packetListener;
        }
    }

    protected enum SyncPointState {
        initial,
        request_sent,
        successful
    }

    static {
        Smack.ensureInitialized();
    }

    protected AbstractXMPPConnection(ConnectionConfiguration connectionConfiguration) {
        this.saslAuthentication = new SASLAuthentication(this, connectionConfiguration);
        this.config = connectionConfiguration;
        buildNonzaCallback().listenFor(SaslNonza.Challenge.class, new g(this)).listenFor(SaslNonza.Success.class, new h(this)).listenFor(SaslNonza.SASLFailure.class, new i(this)).install();
        SmackDebuggerFactory debuggerFactory = connectionConfiguration.getDebuggerFactory();
        if (debuggerFactory != null) {
            this.debugger = debuggerFactory.create(this);
        } else {
            this.debugger = null;
        }
        for (ConnectionCreationListener connectionCreated : XMPPConnectionRegistry.getConnectionCreationListeners()) {
            connectionCreated.connectionCreated(this);
        }
        this.stanzaFactory = new StanzaFactory(connectionConfiguration.constructStanzaIdSource());
    }

    static /* synthetic */ int access$510(AbstractXMPPConnection abstractXMPPConnection) {
        int i10 = abstractXMPPConnection.currentAsyncRunnables;
        abstractXMPPConnection.currentAsyncRunnables = i10 - 1;
        return i10;
    }

    static /* synthetic */ int access$610(AbstractXMPPConnection abstractXMPPConnection) {
        int i10 = abstractXMPPConnection.deferredAsyncRunnablesCount;
        abstractXMPPConnection.deferredAsyncRunnablesCount = i10 - 1;
        return i10;
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> void addInterceptor(Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map, Consumer<MPB> consumer, Predicate<MP> predicate) {
        Objects.requireNonNull(consumer, "Interceptor must not be null");
        GenericInterceptorWrapper genericInterceptorWrapper = new GenericInterceptorWrapper(consumer, predicate);
        synchronized (map) {
            map.put(consumer, genericInterceptorWrapper);
        }
    }

    /* access modifiers changed from: protected */
    public static void asyncGo(Runnable runnable) {
        CACHED_EXECUTOR_SERVICE.execute(runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: callConnectionClosedOnErrorListener */
    public void lambda$notifyConnectionError$5(Exception exc) {
        boolean z10;
        if (!(exc instanceof XMPPException.StreamErrorException) || ((XMPPException.StreamErrorException) exc).getStreamError().getCondition() != StreamError.Condition.not_authorized || !this.wasAuthenticated) {
            z10 = true;
        } else {
            z10 = false;
            LOGGER.log(Level.FINE, "Connection closed with not-authorized stream error after it was already authenticated. The account was likely deleted/unregistered on the server");
        }
        if (z10) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Connection " + this + " closed with error", exc);
        }
        for (ConnectionListener connectionClosedOnError : this.connectionListeners) {
            try {
                connectionClosedOnError.connectionClosedOnError(exc);
            } catch (Exception e10) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", e10);
            }
        }
    }

    private static void extractMatchingListeners(Stanza stanza, Map<StanzaListener, ListenerWrapper> map, Collection<StanzaListener> collection) {
        synchronized (map) {
            for (ListenerWrapper next : map.values()) {
                if (next.filterMatches(stanza)) {
                    collection.add(next.getListener());
                }
            }
        }
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> MP fireMessageOrPresenceInterceptors(MP mp, Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map) {
        LinkedList<Consumer> linkedList = new LinkedList<>();
        synchronized (map) {
            for (GenericInterceptorWrapper next : map.values()) {
                if (next.filterMatches(mp)) {
                    linkedList.add(next.getInterceptor());
                }
            }
        }
        if (linkedList.isEmpty()) {
            return mp;
        }
        MessageOrPresenceBuilder asBuilder = mp.asBuilder();
        for (Consumer accept : linkedList) {
            accept.accept(asBuilder);
        }
        return asBuilder.build();
    }

    private Stanza firePacketInterceptors(Stanza stanza) {
        LinkedList<StanzaListener> linkedList = new LinkedList<>();
        synchronized (this.interceptors) {
            for (InterceptorWrapper next : this.interceptors.values()) {
                if (next.filterMatches(stanza)) {
                    linkedList.add(next.getInterceptor());
                }
            }
        }
        for (StanzaListener processStanza : linkedList) {
            try {
                processStanza.processStanza(stanza);
            } catch (Exception e10) {
                LOGGER.log(Level.SEVERE, "Packet interceptor threw exception", e10);
            }
        }
        if (stanza instanceof Message) {
            return fireMessageOrPresenceInterceptors((Message) stanza, this.messageInterceptors);
        }
        if (stanza instanceof Presence) {
            return fireMessageOrPresenceInterceptors((Presence) stanza, this.presenceInterceptors);
        }
        return stanza;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$bindResourceAndEstablishSession$4() {
        return Boolean.valueOf(this.lastFeaturesReceived);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeStanzaCollectorsAndNotifyRecvListeners$7(ErrorIQ errorIQ) {
        try {
            sendStanza(errorIQ);
        } catch (InterruptedException | SmackException.NotConnectedException e10) {
            LOGGER.log(Level.WARNING, "Exception while sending error IQ to unkown IQ request", e10);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$invokeStanzaCollectorsAndNotifyRecvListeners$8(StanzaListener stanzaListener, Stanza stanza) {
        try {
            stanzaListener.processStanza(stanza);
        } catch (SmackException.NotConnectedException e10) {
            LOGGER.log(Level.WARNING, "Got not connected exception, aborting", e10);
        } catch (Exception e11) {
            LOGGER.log(Level.SEVERE, "Exception in packet listener", e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SaslNonza.Challenge challenge) throws IOException {
        try {
            this.saslAuthentication.challengeReceived(challenge);
        } catch (InterruptedException | SmackException e10) {
            this.saslAuthentication.authenticationFailed(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(SaslNonza.Success success) throws IOException {
        try {
            this.saslAuthentication.authenticated(success);
        } catch (InterruptedException | SmackException.NotConnectedException | SmackException.SmackSaslException e10) {
            this.saslAuthentication.authenticationFailed(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(SaslNonza.SASLFailure sASLFailure) throws IOException {
        this.saslAuthentication.authenticationFailed(sASLFailure);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$waitForClosingStreamTagFromServer$6() {
        return Boolean.valueOf(this.closingStreamReceived);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$waitForConditionOrConnectionException$3(Supplier supplier) {
        return Boolean.valueOf(((Boolean) supplier.get()).booleanValue() || hasCurrentConnectionException());
    }

    private void maybeNotifyDebuggerAboutIncoming(TopLevelStreamElement topLevelStreamElement) {
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.onIncomingStreamElement(topLevelStreamElement);
        }
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> void removeInterceptor(Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map, Consumer<MPB> consumer) {
        synchronized (map) {
            map.remove(consumer);
        }
    }

    protected static ScheduledAction schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return SMACK_REACTOR.schedule(runnable, j10, timeUnit, ScheduledAction.Kind.NonBlocking);
    }

    public void addAsyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener != null) {
            ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
            synchronized (this.asyncRecvListeners) {
                this.asyncRecvListeners.put(stanzaListener, listenerWrapper);
            }
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void addConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener != null) {
            this.connectionListeners.add(connectionListener);
        }
    }

    public void addMessageInterceptor(Consumer<MessageBuilder> consumer, Predicate<Message> predicate) {
        addInterceptor(this.messageInterceptors, consumer, predicate);
    }

    public void addOneTimeSyncCallback(final StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        final AnonymousClass8 r02 = new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                try {
                    stanzaListener.processStanza(stanza);
                } finally {
                    AbstractXMPPConnection.this.removeSyncStanzaListener(this);
                }
            }
        };
        addSyncStanzaListener(r02, stanzaFilter);
        schedule(new Runnable() {
            public void run() {
                AbstractXMPPConnection.this.removeSyncStanzaListener(r02);
            }
        }, getReplyTimeout(), TimeUnit.MILLISECONDS);
    }

    public void addPresenceInterceptor(Consumer<PresenceBuilder> consumer, Predicate<Presence> predicate) {
        addInterceptor(this.presenceInterceptors, consumer, predicate);
    }

    @Deprecated
    public void addStanzaInterceptor(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener != null) {
            InterceptorWrapper interceptorWrapper = new InterceptorWrapper(stanzaListener, stanzaFilter);
            synchronized (this.interceptors) {
                this.interceptors.put(stanzaListener, interceptorWrapper);
            }
            return;
        }
        throw new NullPointerException("Packet interceptor is null.");
    }

    public final void addStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener != null) {
            ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
            synchronized (this.recvListeners) {
                this.recvListeners.put(stanzaListener, listenerWrapper);
            }
            return;
        }
        throw new NullPointerException("Given stanza listener must not be null");
    }

    public void addStanzaSendingListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener != null) {
            ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
            synchronized (this.sendListeners) {
                this.sendListeners.put(stanzaListener, listenerWrapper);
            }
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* access modifiers changed from: protected */
    public void addStreamFeature(FullyQualifiedElement fullyQualifiedElement) {
        this.streamFeatures.put(fullyQualifiedElement.getQName(), fullyQualifiedElement);
    }

    public void addSyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener != null) {
            ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
            synchronized (this.syncRecvListeners) {
                this.syncRecvListeners.put(stanzaListener, listenerWrapper);
            }
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* access modifiers changed from: protected */
    public void afterFeaturesReceived() throws SmackException.SecurityRequiredException, SmackException.NotConnectedException, InterruptedException {
    }

    /* access modifiers changed from: protected */
    public void afterSaslAuthenticationSuccess() throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackWrappedException {
        sendStreamOpen();
    }

    /* access modifiers changed from: protected */
    public void afterSuccessfulLogin(boolean z10) throws SmackException.NotConnectedException, InterruptedException {
        if (!z10) {
            this.authenticatedConnectionInitiallyEstablishedTimestamp = System.currentTimeMillis();
        }
        this.authenticated = true;
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.userHasLogged(this.user);
        }
        callConnectionAuthenticatedListener(z10);
        if (this.config.isSendPresence() && !z10) {
            sendStanza(getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.available).build());
        }
    }

    /* access modifiers changed from: protected */
    public void asyncGoLimited(final Runnable runnable) {
        AnonymousClass10 r02 = new Runnable() {
            public void run() {
                runnable.run();
                synchronized (AbstractXMPPConnection.this.deferredAsyncRunnables) {
                    Runnable runnable = (Runnable) AbstractXMPPConnection.this.deferredAsyncRunnables.poll();
                    if (runnable == null) {
                        AbstractXMPPConnection.access$510(AbstractXMPPConnection.this);
                    } else {
                        AbstractXMPPConnection.access$610(AbstractXMPPConnection.this);
                        AbstractXMPPConnection.asyncGo(runnable);
                    }
                }
            }
        };
        synchronized (this.deferredAsyncRunnables) {
            int i10 = this.currentAsyncRunnables;
            if (i10 < this.maxAsyncRunnables) {
                this.currentAsyncRunnables = i10 + 1;
                asyncGo(r02);
            } else {
                this.deferredAsyncRunnablesCount++;
                this.deferredAsyncRunnables.add(r02);
            }
            int i11 = this.deferredAsyncRunnablesCount;
            if (i11 >= 100 && this.deferredAsyncRunnablesCountPrevious < 100) {
                LOGGER.log(Level.WARNING, "High watermark of 100 simultaneous executing runnables reached");
            } else if (i11 >= 20 && this.deferredAsyncRunnablesCountPrevious < 20) {
                LOGGER.log(Level.INFO, "20 simultaneous executing runnables reached");
            }
            this.deferredAsyncRunnablesCountPrevious = i11;
        }
    }

    /* access modifiers changed from: protected */
    public final SASLMechanism authenticate(String str, String str2, EntityBareJid entityBareJid, SSLSession sSLSession) throws XMPPException.XMPPErrorException, SASLErrorException, SmackException.SmackSaslException, SmackException.NotConnectedException, SmackException.NoResponseException, IOException, InterruptedException, SmackException.SmackWrappedException {
        SASLMechanism authenticate = this.saslAuthentication.authenticate(str, str2, entityBareJid, sSLSession);
        afterSaslAuthenticationSuccess();
        return authenticate;
    }

    /* access modifiers changed from: protected */
    public Resourcepart bindResourceAndEstablishSession(Resourcepart resourcepart) throws SmackException, InterruptedException, XMPPException {
        LOGGER.finer("Waiting for last features to be received before continuing with resource binding");
        waitForConditionOrThrowConnectionException(new j(this), "last stream features received from server");
        if (hasFeature(Bind.ELEMENT, Bind.NAMESPACE)) {
            Bind newSet = Bind.newSet(resourcepart);
            Bind bind = (Bind) createStanzaCollectorAndSend(new StanzaIdFilter((Stanza) newSet), newSet).nextResultOrThrow();
            EntityFullJid jid = bind.getJid();
            this.user = jid;
            this.xmppServiceDomain = jid.R0();
            Session.Feature feature = (Session.Feature) getFeature(Session.Feature.class);
            if (feature != null && !feature.isOptional()) {
                Session session = new Session();
                createStanzaCollectorAndSend(new StanzaIdFilter((Stanza) session), session).nextResultOrThrow();
            }
            return bind.getJid().q0();
        }
        throw new SmackException.ResourceBindingNotOfferedException();
    }

    /* access modifiers changed from: protected */
    public final NonzaCallback.Builder buildNonzaCallback() {
        return new NonzaCallback.Builder(this);
    }

    /* access modifiers changed from: protected */
    public void callConnectionAuthenticatedListener(boolean z10) {
        for (ConnectionListener authenticated2 : this.connectionListeners) {
            try {
                authenticated2.authenticated(this, z10);
            } catch (Exception e10) {
                LOGGER.log(Level.SEVERE, "Exception in authenticated listener", e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void callConnectionClosedListener() {
        for (ConnectionListener connectionClosed : this.connectionListeners) {
            try {
                connectionClosed.connectionClosed();
            } catch (Exception e10) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", e10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void callConnectionConnectedListener() {
        for (ConnectionListener connected2 : this.connectionListeners) {
            connected2.connected(this);
        }
    }

    /* access modifiers changed from: protected */
    public void callConnectionConnectingListener() {
        for (ConnectionListener connecting : this.connectionListeners) {
            connecting.connecting(this);
        }
    }

    public synchronized AbstractXMPPConnection connect() throws SmackException, IOException, XMPPException, InterruptedException {
        throwAlreadyConnectedExceptionIfAppropriate();
        callConnectionConnectingListener();
        initState();
        this.closingStreamReceived = false;
        this.streamId = null;
        try {
            connectInternal();
            if (!isSecureConnection()) {
                if (getConfiguration().getSecurityMode() == ConnectionConfiguration.SecurityMode.required) {
                    throw new SmackException.SecurityRequiredByClientException();
                }
            }
            callConnectionConnectedListener();
        } catch (IOException | InterruptedException | SmackException | XMPPException e10) {
            instantShutdown();
            throw e10;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void connectInternal() throws SmackException, IOException, XMPPException, InterruptedException;

    public StanzaCollector createStanzaCollector(StanzaFilter stanzaFilter) {
        return createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(stanzaFilter));
    }

    public StanzaCollector createStanzaCollectorAndSend(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        return createStanzaCollectorAndSend(new IQReplyFilter(iq, this), iq);
    }

    public void disconnect() {
        try {
            disconnect(isAuthenticated() ? getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unavailable).build() : null);
        } catch (SmackException.NotConnectedException e10) {
            LOGGER.log(Level.FINEST, "Connection is already disconnected", e10);
        }
    }

    /* access modifiers changed from: protected */
    public void firePacketSendingListeners(TopLevelStreamElement topLevelStreamElement) {
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.onOutgoingStreamElement(topLevelStreamElement);
        }
        if (topLevelStreamElement instanceof Stanza) {
            final Stanza stanza = (Stanza) topLevelStreamElement;
            final LinkedList linkedList = new LinkedList();
            synchronized (this.sendListeners) {
                for (ListenerWrapper next : this.sendListeners.values()) {
                    if (next.filterMatches(stanza)) {
                        linkedList.add(next.getListener());
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                asyncGo(new Runnable() {
                    public void run() {
                        for (StanzaListener processStanza : linkedList) {
                            try {
                                processStanza.processStanza(stanza);
                            } catch (Exception e10) {
                                AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Sending listener threw exception", e10);
                            }
                        }
                    }
                });
            }
        }
    }

    public final long getAuthenticatedConnectionInitiallyEstablishedTimestamp() {
        return this.authenticatedConnectionInitiallyEstablishedTimestamp;
    }

    public ConnectionConfiguration getConfiguration() {
        return this.config;
    }

    public int getConnectionCounter() {
        return this.connectionCounterValue;
    }

    /* access modifiers changed from: protected */
    public Lock getConnectionLock() {
        return this.connectionLock;
    }

    public <F extends FullyQualifiedElement> F getFeature(QName qName) {
        return (FullyQualifiedElement) this.streamFeatures.get(qName);
    }

    public XMPPConnection.FromMode getFromMode() {
        return this.fromMode;
    }

    public String getHost() {
        return this.host;
    }

    public long getLastStanzaReceived() {
        return this.lastStanzaReceived;
    }

    public ParsingExceptionCallback getParsingExceptionCallback() {
        return this.parsingExceptionCallback;
    }

    public int getPort() {
        UInt16 uInt16 = this.port;
        if (uInt16 == null) {
            return -1;
        }
        return uInt16.intValue();
    }

    /* access modifiers changed from: protected */
    public final SmackReactor getReactor() {
        return SMACK_REACTOR;
    }

    public long getReplyTimeout() {
        return this.replyTimeout;
    }

    /* access modifiers changed from: protected */
    public final SmackTlsContext getSmackTlsContext() {
        return this.config.smackTlsContext;
    }

    public final StanzaFactory getStanzaFactory() {
        return this.stanzaFactory;
    }

    public String getStreamId() {
        if (!isConnected()) {
            return null;
        }
        return this.streamId;
    }

    public final String getUsedSaslMechansism() {
        return this.saslAuthentication.getNameOfLastUsedSaslMechansism();
    }

    public final EntityFullJid getUser() {
        return this.user;
    }

    public DomainBareJid getXMPPServiceDomain() {
        DomainBareJid domainBareJid = this.xmppServiceDomain;
        if (domainBareJid != null) {
            return domainBareJid;
        }
        return this.config.getXMPPServiceDomain();
    }

    /* access modifiers changed from: protected */
    public final boolean hasCurrentConnectionException() {
        return (this.currentSmackException == null && this.currentXmppException == null) ? false : true;
    }

    public boolean hasFeature(QName qName) {
        return this.streamFeatures.containsKey(qName);
    }

    /* access modifiers changed from: protected */
    public void initDebugger() {
        Reader reader2 = this.reader;
        if (reader2 == null || this.writer == null) {
            throw new NullPointerException("Reader or writer isn't initialized.");
        }
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            this.reader = smackDebugger.newConnectionReader(reader2);
            this.writer = this.debugger.newConnectionWriter(this.writer);
        }
    }

    /* access modifiers changed from: protected */
    public void initState() {
        this.currentSmackException = null;
        this.currentXmppException = null;
        this.tlsHandled = false;
        this.lastFeaturesReceived = false;
        this.saslFeatureReceived = false;
    }

    public abstract void instantShutdown();

    /* access modifiers changed from: protected */
    public void invokeStanzaCollectorsAndNotifyRecvListeners(final Stanza stanza) {
        final IQRequestHandler iQRequestHandler;
        StanzaError.Condition condition;
        if (stanza instanceof IQ) {
            final IQ iq = (IQ) stanza;
            if (iq.isRequestIQ()) {
                QName childElementQName = iq.getChildElementQName();
                int i10 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[iq.getType().ordinal()];
                if (i10 == 1) {
                    synchronized (this.setIqRequestHandler) {
                        iQRequestHandler = this.setIqRequestHandler.get(childElementQName);
                    }
                } else if (i10 == 2) {
                    synchronized (this.getIqRequestHandler) {
                        iQRequestHandler = this.getIqRequestHandler.get(childElementQName);
                    }
                } else {
                    throw new IllegalStateException("Should only encounter IQ type 'get' or 'set'");
                }
                if (iQRequestHandler == null) {
                    int i11 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode[this.unknownIqRequestReplyMode.ordinal()];
                    if (i11 != 1) {
                        if (i11 == 2) {
                            condition = StanzaError.Condition.feature_not_implemented;
                        } else if (i11 == 3) {
                            condition = StanzaError.Condition.service_unavailable;
                        } else {
                            throw new AssertionError();
                        }
                        asyncGo(new a(this, IQ.createErrorResponse(iq, StanzaError.getBuilder(condition).build())));
                        return;
                    }
                    return;
                }
                Executor executor = null;
                int i12 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode[iQRequestHandler.getMode().ordinal()];
                if (i12 == 1) {
                    executor = ASYNC_BUT_ORDERED.asExecutorFor(this);
                } else if (i12 == 2) {
                    executor = new b(this);
                }
                executor.execute(new Runnable(iq) {
                    static final /* synthetic */ boolean $assertionsDisabled = false;
                    final /* synthetic */ IQ val$iq;

                    {
                        this.val$iq = r3;
                    }

                    public void run() {
                        IQ handleIQRequest = iQRequestHandler.handleIQRequest(this.val$iq);
                        if (handleIQRequest != null) {
                            handleIQRequest.setTo(iq.getFrom());
                            handleIQRequest.setStanzaId(iq.getStanzaId());
                            try {
                                AbstractXMPPConnection.this.sendStanza(handleIQRequest);
                            } catch (InterruptedException | SmackException.NotConnectedException e10) {
                                AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Exception while sending response to IQ request", e10);
                            }
                        }
                    }
                });
                return;
            }
        }
        final LinkedList<StanzaListener> linkedList = new LinkedList<>();
        extractMatchingListeners(stanza, this.asyncRecvListeners, linkedList);
        for (final StanzaListener stanzaListener : linkedList) {
            asyncGoLimited(new Runnable() {
                public void run() {
                    try {
                        stanzaListener.processStanza(stanza);
                    } catch (Exception e10) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in async packet listener", e10);
                    }
                }
            });
        }
        for (StanzaCollector processStanza : this.collectors) {
            processStanza.processStanza(stanza);
        }
        linkedList.clear();
        extractMatchingListeners(stanza, this.recvListeners, linkedList);
        for (StanzaListener stanzaListener2 : linkedList) {
            this.inOrderListeners.performAsyncButOrdered(stanzaListener2, new c(stanzaListener2, stanza));
        }
        linkedList.clear();
        extractMatchingListeners(stanza, this.syncRecvListeners, linkedList);
        ASYNC_BUT_ORDERED.performAsyncButOrdered(this, new Runnable() {
            public void run() {
                Iterator it = linkedList.iterator();
                synchronized (AbstractXMPPConnection.this.syncRecvListeners) {
                    while (it.hasNext()) {
                        if (!AbstractXMPPConnection.this.syncRecvListeners.containsKey((StanzaListener) it.next())) {
                            it.remove();
                        }
                    }
                }
                for (StanzaListener processStanza : linkedList) {
                    try {
                        processStanza.processStanza(stanza);
                    } catch (SmackException.NotConnectedException e10) {
                        AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Got not connected exception, aborting", e10);
                        return;
                    } catch (Exception e11) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in packet listener", e11);
                    }
                }
            }
        });
    }

    public final boolean isAnonymous() {
        return isAuthenticated() && SASLAnonymous.NAME.equals(getUsedSaslMechansism());
    }

    public final boolean isAuthenticated() {
        return this.authenticated;
    }

    public final boolean isConnected() {
        return this.connected;
    }

    /* access modifiers changed from: protected */
    public final boolean isSaslAuthenticated() {
        return this.saslAuthentication.authenticationSuccessful();
    }

    public abstract boolean isSecureConnection();

    public abstract boolean isUsingCompression();

    public synchronized void login() throws XMPPException, SmackException, IOException, InterruptedException {
        CharSequence charSequence = this.usedUsername;
        if (charSequence == null) {
            charSequence = this.config.getUsername();
        }
        String str = this.usedPassword;
        if (str == null) {
            str = this.config.getPassword();
        }
        Resourcepart resourcepart = this.usedResource;
        if (resourcepart == null) {
            resourcepart = this.config.getResource();
        }
        login(charSequence, str, resourcepart);
    }

    /* access modifiers changed from: protected */
    public abstract void loginInternal(String str, String str2, Resourcepart resourcepart) throws XMPPException, SmackException, IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public final void notifyConnectionError(Exception exc) {
        synchronized (this.notifyConnectionErrorMonitor) {
            if (!isConnected()) {
                Logger logger = LOGGER;
                Level level = Level.INFO;
                logger.log(level, "Connection was already disconnected when attempting to handle " + exc, exc);
                return;
            }
            setCurrentConnectionExceptionAndNotify(exc);
            instantShutdown();
            for (StanzaCollector notifyConnectionError : this.collectors) {
                notifyConnectionError.notifyConnectionError(exc);
            }
            e eVar = new e(this, exc);
            Async.go(eVar, this + " callConnectionClosedOnErrorListener()");
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyWaitingThreads() {
        synchronized (this.internalMonitor) {
            this.internalMonitor.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void onStreamOpen(XmlPullParser xmlPullParser) {
        if ("jabber:client".equals(xmlPullParser.getNamespace((String) null))) {
            this.streamId = xmlPullParser.getAttributeValue("", "id");
            this.incomingStreamXmlEnvironment = XmlEnvironment.from(xmlPullParser);
            String attributeValue = xmlPullParser.getAttributeValue("", "from");
            if (attributeValue != null) {
                try {
                    DomainBareJid e10 = a.e(attributeValue);
                    DomainBareJid xMPPServiceDomain = this.config.getXMPPServiceDomain();
                    if (!xMPPServiceDomain.Y(e10)) {
                        Logger logger = LOGGER;
                        logger.warning("Domain reported by server '" + e10 + "' does not match configured domain '" + xMPPServiceDomain + "'");
                    }
                } catch (XmppStringprepException e11) {
                    Logger logger2 = LOGGER;
                    Level level = Level.WARNING;
                    logger2.log(level, "XMPP service domain '" + attributeValue + "' as reported by server could not be transformed to a valid JID", e11);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void parseAndProcessNonza(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, SmackParsingException {
        ArrayList<T> newListWith;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        QName qName = new QName(xmlPullParser.getNamespace(), xmlPullParser.getName());
        NonzaProvider<? extends Nonza> nonzaProvider = ProviderManager.getNonzaProvider(qName);
        if (nonzaProvider == null) {
            Logger logger = LOGGER;
            logger.severe("Unknown nonza: " + qName);
            ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
            return;
        }
        synchronized (this.nonzaCallbacksMap) {
            newListWith = CollectionUtil.newListWith(this.nonzaCallbacksMap.getAll(qName));
        }
        if (newListWith == null) {
            Logger logger2 = LOGGER;
            logger2.info("No nonza callback for " + qName);
            ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
            return;
        }
        Nonza nonza = (Nonza) nonzaProvider.parse(xmlPullParser, this.incomingStreamXmlEnvironment);
        maybeNotifyDebuggerAboutIncoming(nonza);
        for (T onNonzaReceived : newListWith) {
            onNonzaReceived.onNonzaReceived(nonza);
        }
    }

    /* access modifiers changed from: protected */
    public void parseAndProcessStanza(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, InterruptedException {
        Stanza stanza;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        try {
            stanza = PacketParserUtils.parseStanza(xmlPullParser, this.incomingStreamXmlEnvironment);
        } catch (IOException | IllegalArgumentException | SmackParsingException | XmlPullParserException e10) {
            UnparseableStanza unparseableStanza = new UnparseableStanza(PacketParserUtils.parseContentDepth(xmlPullParser, depth), e10);
            ParsingExceptionCallback parsingExceptionCallback2 = getParsingExceptionCallback();
            if (parsingExceptionCallback2 != null) {
                parsingExceptionCallback2.handleUnparsableStanza(unparseableStanza);
            }
            stanza = null;
        }
        ParserUtils.assertAtEndTag(xmlPullParser);
        if (stanza != null) {
            processStanza(stanza);
        }
    }

    /* access modifiers changed from: protected */
    public final void parseFeatures(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        this.streamFeatures.clear();
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getDepth() == depth + 1) {
                FullyQualifiedElement fullyQualifiedElement = null;
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                char c10 = 65535;
                switch (name.hashCode()) {
                    case -676919238:
                        if (name.equals(Mechanisms.ELEMENT)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3023933:
                        if (name.equals(Bind.ELEMENT)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 1316817241:
                        if (name.equals(StartTls.ELEMENT)) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 1431984486:
                        if (name.equals(Compress.Feature.ELEMENT)) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 1984987798:
                        if (name.equals(Session.ELEMENT)) {
                            c10 = 4;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        fullyQualifiedElement = new Mechanisms(PacketParserUtils.parseMechanisms(xmlPullParser));
                        break;
                    case 1:
                        fullyQualifiedElement = Bind.Feature.INSTANCE;
                        break;
                    case 2:
                        fullyQualifiedElement = PacketParserUtils.parseStartTlsFeature(xmlPullParser);
                        break;
                    case 3:
                        fullyQualifiedElement = PacketParserUtils.parseCompressionFeature(xmlPullParser);
                        break;
                    case 4:
                        fullyQualifiedElement = PacketParserUtils.parseSessionFeature(xmlPullParser);
                        break;
                    default:
                        ExtensionElementProvider<ExtensionElement> streamFeatureProvider = ProviderManager.getStreamFeatureProvider(name, namespace);
                        if (streamFeatureProvider != null) {
                            fullyQualifiedElement = (FullyQualifiedElement) streamFeatureProvider.parse(xmlPullParser, this.incomingStreamXmlEnvironment);
                            break;
                        }
                        break;
                }
                if (fullyQualifiedElement != null) {
                    addStreamFeature(fullyQualifiedElement);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void parseFeaturesAndNotify(XmlPullParser xmlPullParser) throws Exception {
        parseFeatures(xmlPullParser);
        if (hasFeature(Mechanisms.ELEMENT, "urn:ietf:params:xml:ns:xmpp-sasl") && (!hasFeature(StartTls.ELEMENT, "urn:ietf:params:xml:ns:xmpp-tls") || this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled)) {
            this.saslFeatureReceived = true;
            this.tlsHandled = true;
            notifyWaitingThreads();
        }
        if (hasFeature(Bind.ELEMENT, Bind.NAMESPACE) && (!hasFeature(Compress.Feature.ELEMENT, "http://jabber.org/protocol/compress") || !this.config.isCompressionEnabled())) {
            this.lastFeaturesReceived = true;
            notifyWaitingThreads();
        }
        afterFeaturesReceived();
    }

    /* access modifiers changed from: protected */
    public void processStanza(Stanza stanza) throws InterruptedException {
        maybeNotifyDebuggerAboutIncoming(stanza);
        this.lastStanzaReceived = System.currentTimeMillis();
        invokeStanzaCollectorsAndNotifyRecvListeners(stanza);
    }

    public IQRequestHandler registerIQRequestHandler(IQRequestHandler iQRequestHandler) {
        IQRequestHandler put;
        IQRequestHandler put2;
        QName qName = iQRequestHandler.getQName();
        int i10 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[iQRequestHandler.getType().ordinal()];
        if (i10 == 1) {
            synchronized (this.setIqRequestHandler) {
                put = this.setIqRequestHandler.put(qName, iQRequestHandler);
            }
            return put;
        } else if (i10 == 2) {
            synchronized (this.getIqRequestHandler) {
                put2 = this.getIqRequestHandler.put(qName, iQRequestHandler);
            }
            return put2;
        } else {
            throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
        }
    }

    public boolean removeAsyncStanzaListener(StanzaListener stanzaListener) {
        boolean z10;
        synchronized (this.asyncRecvListeners) {
            if (this.asyncRecvListeners.remove(stanzaListener) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void removeConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.remove(connectionListener);
    }

    public void removeMessageInterceptor(Consumer<MessageBuilder> consumer) {
        removeInterceptor(this.messageInterceptors, consumer);
    }

    public void removePresenceInterceptor(Consumer<PresenceBuilder> consumer) {
        removeInterceptor(this.presenceInterceptors, consumer);
    }

    public void removeStanzaCollector(StanzaCollector stanzaCollector) {
        this.collectors.remove(stanzaCollector);
    }

    @Deprecated
    public void removeStanzaInterceptor(StanzaListener stanzaListener) {
        synchronized (this.interceptors) {
            this.interceptors.remove(stanzaListener);
        }
    }

    public final boolean removeStanzaListener(StanzaListener stanzaListener) {
        boolean z10;
        synchronized (this.recvListeners) {
            if (this.recvListeners.remove(stanzaListener) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void removeStanzaSendingListener(StanzaListener stanzaListener) {
        synchronized (this.sendListeners) {
            this.sendListeners.remove(stanzaListener);
        }
    }

    public boolean removeSyncStanzaListener(StanzaListener stanzaListener) {
        boolean z10;
        synchronized (this.syncRecvListeners) {
            if (this.syncRecvListeners.remove(stanzaListener) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.FailedNonzaException {
        return NonzaCallback.sendAndWaitForResponse(buildNonzaCallback(), nonza, cls, cls2);
    }

    public <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s10, StanzaFilter stanzaFilter) {
        return sendAsync(s10, stanzaFilter, getReplyTimeout());
    }

    public <I extends IQ> I sendIqRequestAndWaitForResponse(IQ iq) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return (IQ) createStanzaCollectorAndSend(iq).nextResultOrThrow();
    }

    public SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq) {
        return sendIqRequestAsync(iq, getReplyTimeout());
    }

    public abstract void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException;

    public final void sendStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        Objects.requireNonNull(stanza, "Stanza must not be null");
        throwNotConnectedExceptionIfAppropriate();
        int i10 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[this.fromMode.ordinal()];
        if (i10 == 1) {
            stanza.setFrom((Jid) null);
        } else if (i10 == 2) {
            stanza.setFrom(getUser());
        }
        sendStanzaInternal(firePacketInterceptors(stanza));
    }

    /* access modifiers changed from: protected */
    public abstract void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException;

    /* access modifiers changed from: protected */
    public void sendStreamOpen() throws SmackException.NotConnectedException, InterruptedException {
        String str;
        DomainBareJid xMPPServiceDomain = getXMPPServiceDomain();
        CharSequence username = this.config.getUsername();
        if (username != null) {
            str = c.a(username, xMPPServiceDomain);
        } else {
            str = null;
        }
        StreamOpen streamOpen = new StreamOpen(xMPPServiceDomain, str, getStreamId(), this.config.getXmlLang(), StreamOpen.StreamContentNamespace.client);
        sendNonza(streamOpen);
        XmlEnvironment.Builder builder = XmlEnvironment.builder();
        builder.with(streamOpen);
        this.outgoingStreamXmlEnvironment = builder.build();
    }

    /* access modifiers changed from: protected */
    public final void setCurrentConnectionExceptionAndNotify(Exception exc) {
        if (exc instanceof SmackException) {
            this.currentSmackException = (SmackException) exc;
        } else if (exc instanceof XMPPException) {
            this.currentXmppException = (XMPPException) exc;
        } else {
            this.currentSmackException = new SmackException.SmackWrappedException(exc);
        }
        notifyWaitingThreads();
    }

    public void setFromMode(XMPPConnection.FromMode fromMode2) {
        this.fromMode = fromMode2;
    }

    public void setMaxAsyncOperations(int i10) {
        if (i10 >= 1) {
            synchronized (this.deferredAsyncRunnables) {
                this.maxAsyncRunnables = i10;
            }
            return;
        }
        throw new IllegalArgumentException("Max async operations must be greater than 0");
    }

    public void setParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback2) {
        this.parsingExceptionCallback = parsingExceptionCallback2;
    }

    public void setReplyTimeout(long j10) {
        if (Long.MAX_VALUE - System.currentTimeMillis() >= j10) {
            this.replyTimeout = j10;
            return;
        }
        throw new IllegalArgumentException("Extremely long reply timeout");
    }

    public void setUnknownIqRequestReplyMode(SmackConfiguration.UnknownIqRequestReplyMode unknownIqRequestReplyMode2) {
        this.unknownIqRequestReplyMode = (SmackConfiguration.UnknownIqRequestReplyMode) Objects.requireNonNull(unknownIqRequestReplyMode2, "Mode must not be null");
    }

    /* access modifiers changed from: protected */
    public void setWasAuthenticated() {
        if (!this.wasAuthenticated) {
            this.wasAuthenticated = this.authenticated;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void shutdown();

    /* access modifiers changed from: protected */
    public void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected()) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    /* access modifiers changed from: protected */
    public void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated()) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    /* access modifiers changed from: protected */
    public final void throwCurrentConnectionException() throws SmackException, XMPPException {
        SmackException smackException = this.currentSmackException;
        if (smackException == null) {
            XMPPException xMPPException = this.currentXmppException;
            if (xMPPException != null) {
                throw xMPPException;
            }
            throw new AssertionError("No current connection exception set, although throwCurrentException() was called");
        }
        throw smackException;
    }

    /* access modifiers changed from: protected */
    public void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        throwNotConnectedExceptionIfAppropriate((String) null);
    }

    public final String toString() {
        String str;
        EntityFullJid user2 = getUser();
        if (user2 == null) {
            str = "not-authenticated";
        } else {
            str = user2.toString();
        }
        return getClass().getSimpleName() + '[' + str + "] (" + getConnectionCounter() + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean trySendStanza(Stanza stanza) throws SmackException.NotConnectedException {
        try {
            sendStanza(stanza);
            return true;
        } catch (InterruptedException e10) {
            LOGGER.log(Level.FINER, "Thread blocked in fallback implementation of trySendStanza(Stanza) was interrupted", e10);
            return false;
        }
    }

    public final IQRequestHandler unregisterIQRequestHandler(IQRequestHandler iQRequestHandler) {
        return unregisterIQRequestHandler(iQRequestHandler.getElement(), iQRequestHandler.getNamespace(), iQRequestHandler.getType());
    }

    /* access modifiers changed from: protected */
    public final boolean waitFor(Supplier<Boolean> supplier) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + getReplyTimeout();
        synchronized (this.internalMonitor) {
            while (!supplier.get().booleanValue()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    return false;
                }
                this.internalMonitor.wait(currentTimeMillis - currentTimeMillis2);
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean waitForClosingStreamTagFromServer() {
        try {
            waitForConditionOrThrowConnectionException(new d(this), "closing stream tag from the server");
            return true;
        } catch (InterruptedException | SmackException | XMPPException e10) {
            Logger logger = LOGGER;
            Level level = Level.INFO;
            logger.log(level, "Exception while waiting for closing stream element from the server " + this, e10);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean waitForConditionOrConnectionException(Supplier<Boolean> supplier) throws InterruptedException {
        return waitFor(new f(this, supplier));
    }

    /* access modifiers changed from: protected */
    public final void waitForConditionOrThrowConnectionException(Supplier<Boolean> supplier, String str) throws InterruptedException, SmackException, XMPPException {
        waitForConditionOrConnectionException(supplier, str);
        if (hasCurrentConnectionException()) {
            throwCurrentConnectionException();
        }
    }

    public <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s10, final StanzaFilter stanzaFilter, long j10) {
        Objects.requireNonNull(s10, "stanza must not be null");
        Objects.requireNonNull(stanzaFilter, "replyFilter must not be null");
        final SmackFuture.InternalSmackFuture internalSmackFuture = new SmackFuture.InternalSmackFuture();
        final AnonymousClass6 r12 = new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                if (AbstractXMPPConnection.this.removeAsyncStanzaListener(this)) {
                    try {
                        XMPPException.XMPPErrorException.ifHasErrorThenThrow(stanza);
                        internalSmackFuture.setResult(stanza);
                    } catch (XMPPException.XMPPErrorException e10) {
                        internalSmackFuture.setException(e10);
                    }
                }
            }
        };
        schedule(new Runnable() {
            public void run() {
                Exception exc;
                if (AbstractXMPPConnection.this.removeAsyncStanzaListener(r12)) {
                    if (!AbstractXMPPConnection.this.isConnected()) {
                        exc = new SmackException.NotConnectedException((XMPPConnection) AbstractXMPPConnection.this, stanzaFilter);
                    } else {
                        exc = SmackException.NoResponseException.newWith((XMPPConnection) AbstractXMPPConnection.this, stanzaFilter);
                    }
                    internalSmackFuture.setException(exc);
                }
            }
        }, j10, TimeUnit.MILLISECONDS);
        addAsyncStanzaListener(r12, stanzaFilter);
        try {
            sendStanza(s10);
        } catch (InterruptedException | SmackException.NotConnectedException e10) {
            internalSmackFuture.setException(e10);
        }
        return internalSmackFuture;
    }

    public SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq, long j10) {
        return sendAsync(iq, new IQReplyFilter(iq, this), j10);
    }

    /* access modifiers changed from: protected */
    public void throwNotConnectedExceptionIfAppropriate(String str) throws SmackException.NotConnectedException {
        if (!isConnected()) {
            throw new SmackException.NotConnectedException(str);
        }
    }

    /* access modifiers changed from: protected */
    public final void waitForConditionOrConnectionException(Supplier<Boolean> supplier, String str) throws InterruptedException, SmackException.NoResponseException {
        if (!waitForConditionOrConnectionException(supplier)) {
            throw SmackException.NoResponseException.newWith((XMPPConnection) this, str);
        }
    }

    public StanzaCollector createStanzaCollector(StanzaCollector.Configuration configuration) {
        StanzaCollector stanzaCollector = new StanzaCollector(this, configuration);
        this.collectors.add(stanzaCollector);
        return stanzaCollector;
    }

    public StanzaCollector createStanzaCollectorAndSend(StanzaFilter stanzaFilter, Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        StanzaCollector createStanzaCollector = createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(stanzaFilter).setRequest(stanza));
        try {
            sendStanza(stanza);
            return createStanzaCollector;
        } catch (InterruptedException | RuntimeException | SmackException.NotConnectedException e10) {
            createStanzaCollector.cancel();
            throw e10;
        }
    }

    public boolean trySendStanza(Stanza stanza, long j10, TimeUnit timeUnit) throws SmackException.NotConnectedException, InterruptedException {
        sendStanza(stanza);
        return true;
    }

    public IQRequestHandler unregisterIQRequestHandler(String str, String str2, IQ.Type type) {
        IQRequestHandler remove;
        IQRequestHandler remove2;
        QName qName = new QName(str2, str);
        int i10 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type.ordinal()];
        if (i10 == 1) {
            synchronized (this.setIqRequestHandler) {
                remove = this.setIqRequestHandler.remove(qName);
            }
            return remove;
        } else if (i10 == 2) {
            synchronized (this.getIqRequestHandler) {
                remove2 = this.getIqRequestHandler.remove(qName);
            }
            return remove2;
        } else {
            throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
        }
    }

    public synchronized void login(CharSequence charSequence, String str) throws XMPPException, SmackException, IOException, InterruptedException {
        login(charSequence, str, this.config.getResource());
    }

    public synchronized void disconnect(Presence presence) throws SmackException.NotConnectedException {
        if (presence != null) {
            try {
                sendStanza(presence);
            } catch (InterruptedException e10) {
                LOGGER.log(Level.FINE, "Was interrupted while sending unavailable presence. Continuing to disconnect the connection", e10);
            }
        }
        shutdown();
        callConnectionClosedListener();
    }

    public synchronized void login(CharSequence charSequence, String str, Resourcepart resourcepart) throws XMPPException, SmackException, IOException, InterruptedException {
        if (!this.config.allowNullOrEmptyUsername) {
            StringUtils.requireNotNullNorEmpty(charSequence, "Username must not be null nor empty");
        }
        throwNotConnectedExceptionIfAppropriate("Did you call connect() before login()?");
        throwAlreadyLoggedInExceptionIfAppropriate();
        String charSequence2 = charSequence != null ? charSequence.toString() : null;
        this.usedUsername = charSequence2;
        this.usedPassword = str;
        this.usedResource = resourcepart;
        loginInternal(charSequence2, str, resourcepart);
    }
}
