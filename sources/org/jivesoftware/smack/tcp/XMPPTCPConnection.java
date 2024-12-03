package org.jivesoftware.smack.tcp;

import com.google.android.gms.common.api.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.sm.StreamManagementException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.sm.predicates.Predicate;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;
import org.jivesoftware.smack.xml.SmackXmlParser;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.minidns.dnsname.DnsName;

public class XMPPTCPConnection extends AbstractXMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(XMPPTCPConnection.class.getName());
    private static final int QUEUE_SIZE = 500;
    private static BundleAndDeferCallback defaultBundleAndDeferCallback;
    private static boolean useSmDefault = true;
    private static boolean useSmResumptionDefault = true;
    /* access modifiers changed from: private */
    public BundleAndDeferCallback bundleAndDeferCallback;
    /* access modifiers changed from: private */
    public long clientHandledStanzasCount;
    /* access modifiers changed from: private */
    public boolean compressSyncPoint;
    private final XMPPTCPConnectionConfiguration config;
    private boolean disconnectedButResumeable;
    protected final PacketReader packetReader;
    protected final PacketWriter packetWriter;
    private final Set<StanzaFilter> requestAckPredicates;
    private SSLSocket secureSocket;
    private long serverHandledStanzasCount;
    private int smClientMaxResumptionTime;
    /* access modifiers changed from: private */
    public volatile boolean smEnabledSyncPoint;
    /* access modifiers changed from: private */
    public volatile AbstractXMPPConnection.SyncPointState smResumedSyncPoint;
    /* access modifiers changed from: private */
    public StreamManagement.Failed smResumptionFailed;
    /* access modifiers changed from: private */
    public int smServerMaxResumptionTime;
    /* access modifiers changed from: private */
    public String smSessionId;
    /* access modifiers changed from: private */
    public boolean smWasEnabledAtLeastOnce;
    private Socket socket;
    /* access modifiers changed from: private */
    public final Collection<StanzaListener> stanzaAcknowledgedListeners;
    private final Collection<StanzaListener> stanzaDroppedListeners;
    /* access modifiers changed from: private */
    public final Map<String, StanzaListener> stanzaIdAcknowledgedListeners;
    private boolean streamFeaturesAfterAuthenticationReceived;
    /* access modifiers changed from: private */
    public BlockingQueue<Stanza> unacknowledgedStanzas;
    private boolean useSm;
    private boolean useSmResumption;

    /* renamed from: org.jivesoftware.smack.tcp.XMPPTCPConnection$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.AnonymousClass4.<clinit>():void");
        }
    }

    protected class PacketReader {
        private volatile boolean done;
        XmlPullParser parser;
        /* access modifiers changed from: private */
        public boolean running;
        /* access modifiers changed from: private */
        public final String threadName;

        protected PacketReader() {
            this.threadName = "Smack Reader (" + XMPPTCPConnection.this.getConnectionCounter() + PropertyUtils.MAPPED_DELIM2;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void parsePackets() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.openStreamAndResetParser()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r2.getEventType()     // Catch:{ Exception -> 0x0343 }
            L_0x000d:
                boolean r3 = r9.done     // Catch:{ Exception -> 0x0343 }
                if (r3 != 0) goto L_0x038c
                int[] r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.AnonymousClass4.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ Exception -> 0x0343 }
                int r2 = r2.ordinal()     // Catch:{ Exception -> 0x0343 }
                r2 = r3[r2]     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "stream"
                r4 = 3
                r5 = 2
                r6 = 1
                if (r2 == r6) goto L_0x00b0
                if (r2 == r5) goto L_0x002e
                if (r2 == r4) goto L_0x0026
                goto L_0x033b
            L_0x0026:
                org.jivesoftware.smack.SmackException$SmackMessageException r2 = new org.jivesoftware.smack.SmackException$SmackMessageException     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "Parser got END_DOCUMENT event. This could happen e.g. if the server closed the connection without sending a closing stream element"
                r2.<init>(r3)     // Catch:{ Exception -> 0x0343 }
                throw r2     // Catch:{ Exception -> 0x0343 }
            L_0x002e:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0343 }
                boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x033b
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                java.lang.String r2 = r2.getNamespace()     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "http://etherx.jabber.org/streams"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 != 0) goto L_0x006d
                java.util.logging.Logger r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.LOGGER     // Catch:{ Exception -> 0x0343 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0343 }
                r3.<init>()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r4 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r3.append(r4)     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = " </stream> but different namespace "
                r3.append(r4)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser r4 = r9.parser     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = r4.getNamespace()     // Catch:{ Exception -> 0x0343 }
                r3.append(r4)     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0343 }
                r2.warning(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x006d:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection$PacketWriter r2 = r2.packetWriter     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown r2 = r2.queue     // Catch:{ Exception -> 0x0343 }
                boolean r2 = r2.isShutdown()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean unused = r3.closingStreamReceived = r6     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r3.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0086
                return
            L_0x0086:
                java.util.logging.Logger r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.LOGGER     // Catch:{ Exception -> 0x0343 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0343 }
                r3.<init>()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r4 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r3.append(r4)     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = " received closing </stream> element. Server wants to terminate the connection, calling disconnect()"
                r3.append(r4)     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0343 }
                r2.info(r3)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.AsyncButOrdered r2 = org.jivesoftware.smack.AbstractXMPPConnection.ASYNC_BUT_ORDERED     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection$PacketReader$2 r4 = new org.jivesoftware.smack.tcp.XMPPTCPConnection$PacketReader$2     // Catch:{ Exception -> 0x0343 }
                r4.<init>()     // Catch:{ Exception -> 0x0343 }
                r2.performAsyncButOrdered(r3, r4)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x00b0:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0343 }
                int r7 = r2.hashCode()     // Catch:{ Exception -> 0x0343 }
                r8 = -1
                switch(r7) {
                    case -1609594047: goto L_0x0148;
                    case -1281977283: goto L_0x013d;
                    case -1276666629: goto L_0x0133;
                    case -1086574198: goto L_0x0129;
                    case -891990144: goto L_0x0122;
                    case -369449087: goto L_0x0117;
                    case -309519186: goto L_0x010d;
                    case -290659267: goto L_0x0103;
                    case 97: goto L_0x00f8;
                    case 114: goto L_0x00ed;
                    case 3368: goto L_0x00e2;
                    case 96784904: goto L_0x00d7;
                    case 954925063: goto L_0x00cc;
                    case 1097547223: goto L_0x00c0;
                    default: goto L_0x00be;
                }     // Catch:{ Exception -> 0x0343 }
            L_0x00be:
                goto L_0x0153
            L_0x00c0:
                java.lang.String r3 = "resumed"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 11
                goto L_0x0154
            L_0x00cc:
                java.lang.String r3 = "message"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = r1
                goto L_0x0154
            L_0x00d7:
                java.lang.String r3 = "error"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 4
                goto L_0x0154
            L_0x00e2:
                java.lang.String r3 = "iq"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = r6
                goto L_0x0154
            L_0x00ed:
                java.lang.String r3 = "r"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 13
                goto L_0x0154
            L_0x00f8:
                java.lang.String r3 = "a"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 12
                goto L_0x0154
            L_0x0103:
                java.lang.String r3 = "features"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 5
                goto L_0x0154
            L_0x010d:
                java.lang.String r3 = "proceed"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 6
                goto L_0x0154
            L_0x0117:
                java.lang.String r3 = "compressed"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 8
                goto L_0x0154
            L_0x0122:
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                goto L_0x0154
            L_0x0129:
                java.lang.String r3 = "failure"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 7
                goto L_0x0154
            L_0x0133:
                java.lang.String r3 = "presence"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = r5
                goto L_0x0154
            L_0x013d:
                java.lang.String r3 = "failed"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 10
                goto L_0x0154
            L_0x0148:
                java.lang.String r3 = "enabled"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x0153
                r4 = 9
                goto L_0x0154
            L_0x0153:
                r4 = r8
            L_0x0154:
                switch(r4) {
                    case 0: goto L_0x0312;
                    case 1: goto L_0x0312;
                    case 2: goto L_0x0312;
                    case 3: goto L_0x030a;
                    case 4: goto L_0x02fe;
                    case 5: goto L_0x02f6;
                    case 6: goto L_0x02eb;
                    case 7: goto L_0x029d;
                    case 8: goto L_0x0287;
                    case 9: goto L_0x0232;
                    case 10: goto L_0x0206;
                    case 11: goto L_0x018b;
                    case 12: goto L_0x017a;
                    case 13: goto L_0x015b;
                    default: goto L_0x0157;
                }     // Catch:{ Exception -> 0x0343 }
            L_0x0157:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                goto L_0x0336
            L_0x015b:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.provider.ParseStreamManagement.ackRequest(r2)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean r2 = r2.smEnabledSyncPoint     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x016f
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.sendSmAcknowledgementInternal()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x016f:
                java.util.logging.Logger r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.LOGGER     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "SM Ack Request received while SM is not enabled"
                r2.warning(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x017a:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.packet.StreamManagement$AckAnswer r2 = org.jivesoftware.smack.sm.provider.ParseStreamManagement.ackAnswer(r2)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                long r4 = r2.getHandledCount()     // Catch:{ Exception -> 0x0343 }
                r3.processHandledCount(r4)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x018b:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.packet.StreamManagement$Resumed r2 = org.jivesoftware.smack.sm.provider.ParseStreamManagement.resumed(r2)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = r3.smSessionId     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = r2.getPrevId()     // Catch:{ Exception -> 0x0343 }
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0343 }
                if (r3 == 0) goto L_0x01f6
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean unused = r3.smEnabledSyncPoint = r6     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                long r4 = r2.getHandledCount()     // Catch:{ Exception -> 0x0343 }
                r3.processHandledCount(r4)     // Catch:{ Exception -> 0x0343 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.util.concurrent.BlockingQueue r3 = r3.unacknowledgedStanzas     // Catch:{ Exception -> 0x0343 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0343 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.util.concurrent.BlockingQueue r3 = r3.unacknowledgedStanzas     // Catch:{ Exception -> 0x0343 }
                r3.drainTo(r2)     // Catch:{ Exception -> 0x0343 }
                java.util.Iterator r3 = r2.iterator()     // Catch:{ Exception -> 0x0343 }
            L_0x01cb:
                boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0343 }
                if (r4 == 0) goto L_0x01dd
                java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.packet.Stanza r4 = (org.jivesoftware.smack.packet.Stanza) r4     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r5 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r5.sendStanzaInternal(r4)     // Catch:{ Exception -> 0x0343 }
                goto L_0x01cb
            L_0x01dd:
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0343 }
                if (r2 != 0) goto L_0x01e8
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.requestSmAcknowledgementInternal()     // Catch:{ Exception -> 0x0343 }
            L_0x01e8:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.AbstractXMPPConnection$SyncPointState r3 = org.jivesoftware.smack.AbstractXMPPConnection.SyncPointState.successful     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.AbstractXMPPConnection.SyncPointState unused = r2.smResumedSyncPoint = r3     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x01f6:
                org.jivesoftware.smack.sm.StreamManagementException$StreamIdDoesNotMatchException r3 = new org.jivesoftware.smack.sm.StreamManagementException$StreamIdDoesNotMatchException     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r4 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = r4.smSessionId     // Catch:{ Exception -> 0x0343 }
                java.lang.String r2 = r2.getPrevId()     // Catch:{ Exception -> 0x0343 }
                r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0343 }
                throw r3     // Catch:{ Exception -> 0x0343 }
            L_0x0206:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.packet.StreamManagement$Failed r2 = org.jivesoftware.smack.sm.provider.ParseStreamManagement.failed(r2)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.AbstractXMPPConnection$SyncPointState r3 = r3.smResumedSyncPoint     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.AbstractXMPPConnection$SyncPointState r4 = org.jivesoftware.smack.AbstractXMPPConnection.SyncPointState.request_sent     // Catch:{ Exception -> 0x0343 }
                if (r3 != r4) goto L_0x0222
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.packet.StreamManagement.Failed unused = r3.smResumptionFailed = r2     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x0222:
                org.jivesoftware.smack.XMPPException$FailedNonzaException r3 = new org.jivesoftware.smack.XMPPException$FailedNonzaException     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.packet.StanzaError$Condition r4 = r2.getStanzaErrorCondition()     // Catch:{ Exception -> 0x0343 }
                r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.setCurrentConnectionExceptionAndNotify(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x0232:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.sm.packet.StreamManagement$Enabled r2 = org.jivesoftware.smack.sm.provider.ParseStreamManagement.enabled(r2)     // Catch:{ Exception -> 0x0343 }
                boolean r3 = r2.isResumeSet()     // Catch:{ Exception -> 0x0343 }
                if (r3 == 0) goto L_0x026a
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = r2.getId()     // Catch:{ Exception -> 0x0343 }
                java.lang.String unused = r3.smSessionId = r4     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = r3.smSessionId     // Catch:{ Exception -> 0x0343 }
                boolean r3 = org.jivesoftware.smack.util.StringUtils.isNullOrEmpty((java.lang.CharSequence) r3)     // Catch:{ Exception -> 0x0343 }
                if (r3 != 0) goto L_0x025d
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                int r2 = r2.getMaxResumptionTime()     // Catch:{ Exception -> 0x0343 }
                int unused = r3.smServerMaxResumptionTime = r2     // Catch:{ Exception -> 0x0343 }
                goto L_0x026f
            L_0x025d:
                org.jivesoftware.smack.SmackException$SmackMessageException r2 = new org.jivesoftware.smack.SmackException$SmackMessageException     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "Stream Management 'enabled' element with resume attribute but without session id received"
                r2.<init>(r3)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r3.setCurrentConnectionExceptionAndNotify(r2)     // Catch:{ Exception -> 0x0343 }
                throw r2     // Catch:{ Exception -> 0x0343 }
            L_0x026a:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                java.lang.String unused = r2.smSessionId = r0     // Catch:{ Exception -> 0x0343 }
            L_0x026f:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r3 = 0
                long unused = r2.clientHandledStanzasCount = r3     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean unused = r2.smWasEnabledAtLeastOnce = r6     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean unused = r2.smEnabledSyncPoint = r6     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x0287:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.initReaderAndWriter()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.openStreamAndResetParser()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                boolean unused = r2.compressSyncPoint = r6     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x029d:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                java.lang.String r2 = r2.getNamespace(r0)     // Catch:{ Exception -> 0x0343 }
                int r3 = r2.hashCode()     // Catch:{ Exception -> 0x0343 }
                r4 = 919182852(0x36c99e04, float:6.0086622E-6)
                if (r3 == r4) goto L_0x02bc
                r4 = 2117926358(0x7e3cfdd6, float:6.2803214E37)
                if (r3 == r4) goto L_0x02b2
                goto L_0x02c5
            L_0x02b2:
                java.lang.String r3 = "http://jabber.org/protocol/compress"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x02c5
                r8 = r6
                goto L_0x02c5
            L_0x02bc:
                java.lang.String r3 = "urn:ietf:params:xml:ns:xmpp-tls"
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0343 }
                if (r2 == 0) goto L_0x02c5
                r8 = r1
            L_0x02c5:
                if (r8 == 0) goto L_0x02e3
                if (r8 == r6) goto L_0x02d1
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser r3 = r9.parser     // Catch:{ Exception -> 0x0343 }
                r2.parseAndProcessNonza(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x02d1:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.SmackException$SmackMessageException r3 = new org.jivesoftware.smack.SmackException$SmackMessageException     // Catch:{ Exception -> 0x0343 }
                java.lang.String r4 = "Could not establish compression"
                r3.<init>(r4)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.SmackException unused = r2.currentSmackException = r3     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.notifyWaitingThreads()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x02e3:
                org.jivesoftware.smack.SmackException$SmackMessageException r2 = new org.jivesoftware.smack.SmackException$SmackMessageException     // Catch:{ Exception -> 0x0343 }
                java.lang.String r3 = "TLS negotiation has failed"
                r2.<init>(r3)     // Catch:{ Exception -> 0x0343 }
                throw r2     // Catch:{ Exception -> 0x0343 }
            L_0x02eb:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.proceedTLSReceived()     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                r2.openStreamAndResetParser()     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x02f6:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser r3 = r9.parser     // Catch:{ Exception -> 0x0343 }
                r2.parseFeaturesAndNotify(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x02fe:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.packet.StreamError r2 = org.jivesoftware.smack.util.PacketParserUtils.parseStreamError(r2)     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.XMPPException$StreamErrorException r3 = new org.jivesoftware.smack.XMPPException$StreamErrorException     // Catch:{ Exception -> 0x0343 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0343 }
                throw r3     // Catch:{ Exception -> 0x0343 }
            L_0x030a:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser r3 = r9.parser     // Catch:{ Exception -> 0x0343 }
                r2.onStreamOpen(r3)     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x0312:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ all -> 0x0327 }
                org.jivesoftware.smack.xml.XmlPullParser r3 = r9.parser     // Catch:{ all -> 0x0327 }
                r2.parseAndProcessStanza(r3)     // Catch:{ all -> 0x0327 }
                org.jivesoftware.smack.tcp.XMPPTCPConnection r2 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                long r3 = r2.clientHandledStanzasCount     // Catch:{ Exception -> 0x0343 }
                long r3 = org.jivesoftware.smack.sm.SMUtils.incrementHeight(r3)     // Catch:{ Exception -> 0x0343 }
                long unused = r2.clientHandledStanzasCount = r3     // Catch:{ Exception -> 0x0343 }
                goto L_0x033b
            L_0x0327:
                r2 = move-exception
                org.jivesoftware.smack.tcp.XMPPTCPConnection r3 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this     // Catch:{ Exception -> 0x0343 }
                long r4 = r3.clientHandledStanzasCount     // Catch:{ Exception -> 0x0343 }
                long r4 = org.jivesoftware.smack.sm.SMUtils.incrementHeight(r4)     // Catch:{ Exception -> 0x0343 }
                long unused = r3.clientHandledStanzasCount = r4     // Catch:{ Exception -> 0x0343 }
                throw r2     // Catch:{ Exception -> 0x0343 }
            L_0x0336:
                org.jivesoftware.smack.xml.XmlPullParser r3 = r9.parser     // Catch:{ Exception -> 0x0343 }
                r2.parseAndProcessNonza(r3)     // Catch:{ Exception -> 0x0343 }
            L_0x033b:
                org.jivesoftware.smack.xml.XmlPullParser r2 = r9.parser     // Catch:{ Exception -> 0x0343 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r2.next()     // Catch:{ Exception -> 0x0343 }
                goto L_0x000d
            L_0x0343:
                r2 = move-exception
                r9.running = r1
                org.jivesoftware.smack.tcp.XMPPTCPConnection r1 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this
                org.jivesoftware.smack.tcp.XMPPTCPConnection$PacketWriter r1 = r1.packetWriter
                org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown r1 = r1.queue
                boolean r1 = r1.isShutdown()
                if (r1 == 0) goto L_0x0357
                java.lang.String r0 = "writer"
                goto L_0x035d
            L_0x0357:
                boolean r1 = r9.done
                if (r1 == 0) goto L_0x035d
                java.lang.String r0 = "reader"
            L_0x035d:
                if (r0 == 0) goto L_0x0387
                java.util.logging.Logger r1 = org.jivesoftware.smack.tcp.XMPPTCPConnection.LOGGER
                java.util.logging.Level r3 = java.util.logging.Level.FINER
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Ignoring "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = " as "
                r4.append(r2)
                r4.append(r0)
                java.lang.String r0 = " was already shut down"
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.log(r3, r0)
                return
            L_0x0387:
                org.jivesoftware.smack.tcp.XMPPTCPConnection r0 = org.jivesoftware.smack.tcp.XMPPTCPConnection.this
                r0.notifyConnectionError(r2)
            L_0x038c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketReader.parsePackets():void");
        }

        /* access modifiers changed from: package-private */
        public void init() {
            this.done = false;
            this.running = true;
            Async.go(new Runnable() {
                public void run() {
                    Logger access$600 = XMPPTCPConnection.LOGGER;
                    access$600.finer(PacketReader.this.threadName + " start");
                    try {
                        PacketReader.this.parsePackets();
                    } finally {
                        Logger access$6002 = XMPPTCPConnection.LOGGER;
                        access$6002.finer(PacketReader.this.threadName + " exit");
                        boolean unused = PacketReader.this.running = false;
                        XMPPTCPConnection.this.notifyWaitingThreads();
                    }
                }
            }, this.threadName);
        }

        /* access modifiers changed from: package-private */
        public void shutdown() {
            this.done = true;
        }
    }

    protected class PacketWriter {
        public static final int QUEUE_SIZE = 500;
        public static final int UNACKKNOWLEDGED_STANZAS_QUEUE_SIZE = 1024;
        public static final int UNACKKNOWLEDGED_STANZAS_QUEUE_SIZE_HIGH_WATER_MARK = 307;
        private volatile boolean instantShutdown;
        /* access modifiers changed from: private */
        public final ArrayBlockingQueueWithShutdown<Element> queue = new ArrayBlockingQueueWithShutdown<>(500, true);
        /* access modifiers changed from: private */
        public boolean running;
        private boolean shouldBundleAndDefer;
        protected volatile Long shutdownTimestamp = null;
        /* access modifiers changed from: private */
        public final String threadName;

        protected PacketWriter() {
            this.threadName = "Smack Writer (" + XMPPTCPConnection.this.getConnectionCounter() + PropertyUtils.MAPPED_DELIM2;
        }

        /* access modifiers changed from: private */
        public boolean done() {
            return this.shutdownTimestamp != null;
        }

        private void drainWriterQueueToUnacknowledgedStanzas() {
            ArrayList arrayList = new ArrayList(this.queue.size());
            this.queue.drainTo(arrayList);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Element element = (Element) arrayList.get(i10);
                if (XMPPTCPConnection.this.unacknowledgedStanzas.remainingCapacity() == 0) {
                    XMPPTCPConnection.LOGGER.log(Level.WARNING, "Some stanzas may be lost as not all could be drained to the unacknowledged stanzas queue", StreamManagementException.UnacknowledgedQueueFullException.newWith(i10, arrayList, XMPPTCPConnection.this.unacknowledgedStanzas));
                    return;
                }
                if (element instanceof Stanza) {
                    XMPPTCPConnection.this.unacknowledgedStanzas.add((Stanza) element);
                }
            }
        }

        private void maybeAddToUnacknowledgedStanzas(Stanza stanza) throws IOException {
            if (XMPPTCPConnection.this.unacknowledgedStanzas != null && stanza != null) {
                if (XMPPTCPConnection.this.unacknowledgedStanzas.size() == 307) {
                    XMPPTCPConnection.this.writer.write(StreamManagement.AckRequest.INSTANCE.toXML().toString());
                }
                try {
                    XMPPTCPConnection.this.unacknowledgedStanzas.put(stanza);
                } catch (InterruptedException e10) {
                    throw new IllegalStateException(e10);
                }
            }
        }

        private Element nextStreamElement() {
            if (this.queue.isEmpty()) {
                this.shouldBundleAndDefer = true;
            }
            try {
                return this.queue.take();
            } catch (InterruptedException e10) {
                if (this.queue.isShutdown()) {
                    return null;
                }
                XMPPTCPConnection.LOGGER.log(Level.WARNING, "Writer thread was interrupted. Don't do that. Use disconnect() instead.", e10);
                return null;
            }
        }

        /* access modifiers changed from: private */
        public void writePackets() {
            Element nextStreamElement;
            while (!done()) {
                try {
                    nextStreamElement = nextStreamElement();
                    if (nextStreamElement != null) {
                        BundleAndDeferCallback access$4400 = XMPPTCPConnection.this.bundleAndDeferCallback;
                        if (access$4400 != null && XMPPTCPConnection.this.isAuthenticated() && this.shouldBundleAndDefer) {
                            this.shouldBundleAndDefer = false;
                            AtomicBoolean atomicBoolean = new AtomicBoolean();
                            int bundleAndDeferMillis = access$4400.getBundleAndDeferMillis(new BundleAndDefer(atomicBoolean));
                            if (bundleAndDeferMillis > 0) {
                                long j10 = (long) bundleAndDeferMillis;
                                long currentTimeMillis = System.currentTimeMillis();
                                synchronized (atomicBoolean) {
                                    long j11 = j10;
                                    while (!atomicBoolean.get() && j11 > 0) {
                                        atomicBoolean.wait(j11);
                                        j11 = j10 - (System.currentTimeMillis() - currentTimeMillis);
                                    }
                                }
                            }
                        }
                        Stanza stanza = null;
                        if (nextStreamElement instanceof Stanza) {
                            stanza = (Stanza) nextStreamElement;
                        } else if (nextStreamElement instanceof StreamManagement.Enable) {
                            BlockingQueue unused = XMPPTCPConnection.this.unacknowledgedStanzas = new ArrayBlockingQueue(1024);
                        }
                        maybeAddToUnacknowledgedStanzas(stanza);
                        CharSequence xml = nextStreamElement.toXML(XMPPTCPConnection.this.outgoingStreamXmlEnvironment);
                        if (xml instanceof XmlStringBuilder) {
                            ((XmlStringBuilder) xml).write(XMPPTCPConnection.this.writer, XMPPTCPConnection.this.outgoingStreamXmlEnvironment);
                        } else {
                            XMPPTCPConnection.this.writer.write(xml.toString());
                        }
                        if (this.queue.isEmpty()) {
                            XMPPTCPConnection.this.writer.flush();
                        }
                        if (stanza != null) {
                            XMPPTCPConnection.this.firePacketSendingListeners(stanza);
                        }
                    }
                } catch (NullPointerException e10) {
                    Logger access$600 = XMPPTCPConnection.LOGGER;
                    Level level = Level.FINE;
                    access$600.log(level, "NPE in XmlStringBuilder of " + nextStreamElement.getClass() + ": " + nextStreamElement, e10);
                    throw e10;
                } catch (Exception e11) {
                    if (done() || this.queue.isShutdown()) {
                        XMPPTCPConnection.LOGGER.log(Level.FINE, "Ignoring Exception in writePackets()", e11);
                        return;
                    }
                    this.running = false;
                    XMPPTCPConnection.this.notifyConnectionError(e11);
                    return;
                }
            }
            if (!this.instantShutdown) {
                while (!this.queue.isEmpty()) {
                    try {
                        Element remove = this.queue.remove();
                        if (remove instanceof Stanza) {
                            maybeAddToUnacknowledgedStanzas((Stanza) remove);
                        }
                        XMPPTCPConnection.this.writer.write(remove.toXML().toString());
                    } catch (Exception e12) {
                        XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception flushing queue during shutdown, ignore and continue", e12);
                    }
                }
                try {
                    XMPPTCPConnection.this.writer.write("</stream:stream>");
                    XMPPTCPConnection.this.writer.flush();
                } catch (Exception e13) {
                    XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception writing closing stream element", e13);
                }
                this.queue.clear();
            } else if (this.instantShutdown && XMPPTCPConnection.this.isSmEnabled()) {
                drainWriterQueueToUnacknowledgedStanzas();
            }
        }

        /* access modifiers changed from: package-private */
        public void init() {
            this.shutdownTimestamp = null;
            if (XMPPTCPConnection.this.unacknowledgedStanzas != null) {
                drainWriterQueueToUnacknowledgedStanzas();
            }
            this.queue.start();
            this.running = true;
            Async.go(new Runnable() {
                public void run() {
                    Logger access$600 = XMPPTCPConnection.LOGGER;
                    access$600.finer(PacketWriter.this.threadName + " start");
                    try {
                        PacketWriter.this.writePackets();
                    } finally {
                        Logger access$6002 = XMPPTCPConnection.LOGGER;
                        access$6002.finer(PacketWriter.this.threadName + " exit");
                        boolean unused = PacketWriter.this.running = false;
                        XMPPTCPConnection.this.notifyWaitingThreads();
                    }
                }
            }, this.threadName);
        }

        /* access modifiers changed from: protected */
        public void sendStreamElement(Element element) throws SmackException.NotConnectedException, InterruptedException {
            throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
            try {
                this.queue.put(element);
            } catch (InterruptedException e10) {
                throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
                throw e10;
            }
        }

        /* access modifiers changed from: package-private */
        public void shutdown(boolean z10) {
            this.instantShutdown = z10;
            this.queue.shutdown();
            this.shutdownTimestamp = Long.valueOf(System.currentTimeMillis());
        }

        /* access modifiers changed from: protected */
        public void throwNotConnectedExceptionIfDoneAndResumptionNotPossible() throws SmackException.NotConnectedException {
            boolean isSmResumptionPossible;
            boolean done = done();
            if (done && !isSmResumptionPossible) {
                XMPPTCPConnection xMPPTCPConnection = XMPPTCPConnection.this;
                throw new SmackException.NotConnectedException((XMPPConnection) xMPPTCPConnection, "done=" + done + " smResumptionPossible=" + (isSmResumptionPossible = XMPPTCPConnection.this.isSmResumptionPossible()));
            }
        }
    }

    public XMPPTCPConnection(XMPPTCPConnectionConfiguration xMPPTCPConnectionConfiguration) {
        super(xMPPTCPConnectionConfiguration);
        this.disconnectedButResumeable = false;
        this.packetWriter = new PacketWriter();
        this.packetReader = new PacketReader();
        this.bundleAndDeferCallback = defaultBundleAndDeferCallback;
        this.smClientMaxResumptionTime = -1;
        this.smServerMaxResumptionTime = -1;
        this.useSm = useSmDefault;
        this.useSmResumption = useSmResumptionDefault;
        this.serverHandledStanzasCount = 0;
        this.clientHandledStanzasCount = 0;
        this.smWasEnabledAtLeastOnce = false;
        this.stanzaAcknowledgedListeners = new ConcurrentLinkedQueue();
        this.stanzaDroppedListeners = new ConcurrentLinkedQueue();
        this.stanzaIdAcknowledgedListeners = new ConcurrentHashMap();
        this.requestAckPredicates = new LinkedHashSet();
        this.config = xMPPTCPConnectionConfiguration;
        addConnectionListener(new ConnectionListener() {
            public void connectionClosedOnError(Exception exc) {
                if ((exc instanceof XMPPException.StreamErrorException) || (exc instanceof StreamManagementException)) {
                    XMPPTCPConnection.this.dropSmState();
                }
            }
        });
        buildNonzaCallback().listenFor(SaslNonza.Success.class, new d(this)).install();
    }

    private void connectUsingConfiguration() throws SmackException.ConnectionException, IOException, InterruptedException {
        RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result;
        ProxyInfo proxyInfo;
        Iterator<RCE> it;
        RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> lookup = RemoteXmppTcpConnectionEndpoints.lookup(this.config);
        ArrayList arrayList = new ArrayList();
        SocketFactory socketFactory = this.config.getSocketFactory();
        ProxyInfo proxyInfo2 = this.config.getProxyInfo();
        int connectTimeout = this.config.getConnectTimeout();
        if (socketFactory == null) {
            socketFactory = SocketFactory.getDefault();
        }
        SocketFactory socketFactory2 = socketFactory;
        Iterator<RCE> it2 = lookup.discoveredRemoteConnectionEndpoints.iterator();
        while (it2.hasNext()) {
            Rfc6120TcpRemoteConnectionEndpoint rfc6120TcpRemoteConnectionEndpoint = (Rfc6120TcpRemoteConnectionEndpoint) it2.next();
            String charSequence = rfc6120TcpRemoteConnectionEndpoint.getHost().toString();
            UInt16 port = rfc6120TcpRemoteConnectionEndpoint.getPort();
            int intValue = port.intValue();
            if (proxyInfo2 == null) {
                Iterator<? extends InetAddress> it3 = rfc6120TcpRemoteConnectionEndpoint.getInetAddresses().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        result = lookup;
                        proxyInfo = proxyInfo2;
                        it = it2;
                        break;
                    }
                    SmackFuture.SocketFuture socketFuture = new SmackFuture.SocketFuture(socketFactory2);
                    InetAddress inetAddress = (InetAddress) it3.next();
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, intValue);
                    it = it2;
                    Logger logger = LOGGER;
                    result = lookup;
                    StringBuilder sb2 = new StringBuilder();
                    proxyInfo = proxyInfo2;
                    sb2.append("Trying to establish TCP connection to ");
                    sb2.append(inetSocketAddress);
                    logger.finer(sb2.toString());
                    socketFuture.connectAsync(inetSocketAddress, connectTimeout);
                    try {
                        this.socket = (Socket) socketFuture.getOrThrow();
                        logger.finer("Established TCP connection to " + inetSocketAddress);
                        this.host = charSequence;
                        this.port = port;
                        return;
                    } catch (IOException e10) {
                        arrayList.add(new RemoteConnectionException(rfc6120TcpRemoteConnectionEndpoint, inetAddress, e10));
                        if (!it3.hasNext()) {
                            break;
                        }
                        it2 = it;
                        lookup = result;
                        proxyInfo2 = proxyInfo;
                    }
                }
            } else {
                result = lookup;
                proxyInfo = proxyInfo2;
                it = it2;
                this.socket = socketFactory2.createSocket();
                StringUtils.requireNotNullNorEmpty(charSequence, "Host of endpoint " + rfc6120TcpRemoteConnectionEndpoint + " must not be null when using a Proxy");
                String str = charSequence + " at port " + intValue;
                Logger logger2 = LOGGER;
                logger2.finer("Trying to establish TCP connection via Proxy to " + str);
                try {
                    proxyInfo.getProxySocketConnection().connect(this.socket, charSequence, intValue, connectTimeout);
                    logger2.finer("Established TCP connection to " + str);
                    this.host = charSequence;
                    this.port = port;
                    return;
                } catch (IOException e11) {
                    CloseableUtil.maybeClose(this.socket, LOGGER);
                    arrayList.add(new RemoteConnectionException(rfc6120TcpRemoteConnectionEndpoint, (InetAddress) null, e11));
                }
            }
            it2 = it;
            lookup = result;
            proxyInfo2 = proxyInfo;
        }
        throw SmackException.EndpointConnectionException.from(lookup.lookupFailures, arrayList);
    }

    /* access modifiers changed from: private */
    public void dropSmState() {
        this.smSessionId = null;
        this.unacknowledgedStanzas = null;
    }

    private void initConnection() throws IOException, InterruptedException {
        this.compressionHandler = null;
        initReaderAndWriter();
        this.packetWriter.init();
        this.packetReader.init();
    }

    /* access modifiers changed from: private */
    public void initReaderAndWriter() throws IOException {
        InputStream inputStream = this.socket.getInputStream();
        OutputStream outputStream = this.socket.getOutputStream();
        XMPPInputOutputStream xMPPInputOutputStream = this.compressionHandler;
        if (xMPPInputOutputStream != null) {
            inputStream = xMPPInputOutputStream.getInputStream(inputStream);
            outputStream = this.compressionHandler.getOutputStream(outputStream);
        }
        this.writer = new OutputStreamWriter(outputStream, "UTF-8");
        this.reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        initDebugger();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$connectInternal$6() {
        return Boolean.valueOf(this.tlsHandled);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$connectInternal$7() {
        return Boolean.valueOf(this.saslFeatureReceived);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$loginInternal$1() {
        return Boolean.valueOf(this.streamFeaturesAfterAuthenticationReceived);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$loginInternal$2() {
        return Boolean.valueOf(this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful || this.smResumptionFailed != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$loginInternal$3() {
        return Boolean.valueOf(this.smEnabledSyncPoint);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$maybeEnableCompression$5() {
        return Boolean.valueOf(this.compressSyncPoint);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SaslNonza.Success success) throws IOException {
        resetParser();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$shutdown$4() {
        return Boolean.valueOf(!this.packetWriter.running && !this.packetReader.running);
    }

    private void maybeEnableCompression() throws SmackException, InterruptedException, XMPPException {
        Compress.Feature feature;
        if (this.config.isCompressionEnabled() && (feature = (Compress.Feature) getFeature(Compress.Feature.class)) != null) {
            XMPPInputOutputStream maybeGetCompressionHandler = maybeGetCompressionHandler(feature);
            this.compressionHandler = maybeGetCompressionHandler;
            if (maybeGetCompressionHandler != null) {
                this.compressSyncPoint = false;
                sendNonza(new Compress(maybeGetCompressionHandler.getCompressionMethod()));
                waitForConditionOrThrowConnectionException(new k(this), "establishing stream compression");
                return;
            }
            LOGGER.warning("Could not enable compression because no matching handler/method pair was found");
        }
    }

    private static XMPPInputOutputStream maybeGetCompressionHandler(Compress.Feature feature) {
        for (XMPPInputOutputStream next : SmackConfiguration.getCompressionHandlers()) {
            if (feature.getMethods().contains(next.getCompressionMethod())) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void openStreamAndResetParser() throws IOException, SmackException.NotConnectedException, InterruptedException {
        sendStreamOpen();
        resetParser();
    }

    /* access modifiers changed from: private */
    public void proceedTLSReceived() throws IOException, SmackException.SecurityNotPossibleException, CertificateException {
        String str;
        SmackTlsContext smackTlsContext = getSmackTlsContext();
        Socket socket2 = this.socket;
        int port = socket2.getPort();
        Socket createSocket = smackTlsContext.sslContext.getSocketFactory().createSocket(socket2, this.config.getXMPPServiceDomain().toString(), port, true);
        this.socket = createSocket;
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        TLSUtils.setEnabledProtocolsAndCiphers(sSLSocket, this.config.getEnabledSSLProtocols(), this.config.getEnabledSSLCiphers());
        initReaderAndWriter();
        sSLSocket.startHandshake();
        SmackDaneVerifier smackDaneVerifier = smackTlsContext.daneVerifier;
        if (smackDaneVerifier != null) {
            smackDaneVerifier.finish(sSLSocket.getSession());
        }
        HostnameVerifier hostnameVerifier = getConfiguration().getHostnameVerifier();
        if (hostnameVerifier != null) {
            DnsName xmppServiceDomainAsDnsNameIfPossible = getConfiguration().getXmppServiceDomainAsDnsNameIfPossible();
            if (xmppServiceDomainAsDnsNameIfPossible != null) {
                str = xmppServiceDomainAsDnsNameIfPossible.ace;
            } else {
                Logger logger = LOGGER;
                Level level = Level.WARNING;
                logger.log(level, "XMPP service domain name '" + getXMPPServiceDomain() + "' can not be represented as DNS name. TLS X.509 certificate validiation may fail.");
                str = getXMPPServiceDomain().toString();
            }
            if (hostnameVerifier.verify(str, sSLSocket.getSession())) {
                this.secureSocket = sSLSocket;
                return;
            }
            throw new CertificateException("Hostname verification of certificate failed. Certificate does not authenticate " + getXMPPServiceDomain());
        }
        throw new IllegalStateException("No HostnameVerifier set. Use connectionConfiguration.setHostnameVerifier() to configure.");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processHandledCount(long r11) throws org.jivesoftware.smack.sm.StreamManagementException.StreamManagementCounterError {
        /*
            r10 = this;
            long r0 = r10.serverHandledStanzasCount
            long r7 = org.jivesoftware.smack.sm.SMUtils.calculateDelta(r11, r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            int r0 = (int) r7
            goto L_0x0014
        L_0x0011:
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x0014:
            r9.<init>(r0)
            r0 = 0
        L_0x0019:
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x0038
            java.util.concurrent.BlockingQueue<org.jivesoftware.smack.packet.Stanza> r2 = r10.unacknowledgedStanzas
            java.lang.Object r2 = r2.poll()
            org.jivesoftware.smack.packet.Stanza r2 = (org.jivesoftware.smack.packet.Stanza) r2
            if (r2 == 0) goto L_0x002e
            r9.add(r2)
            r2 = 1
            long r0 = r0 + r2
            goto L_0x0019
        L_0x002e:
            org.jivesoftware.smack.sm.StreamManagementException$StreamManagementCounterError r0 = new org.jivesoftware.smack.sm.StreamManagementException$StreamManagementCounterError
            long r5 = r10.serverHandledStanzasCount
            r2 = r0
            r3 = r11
            r2.<init>(r3, r5, r7, r9)
            throw r0
        L_0x0038:
            r0 = 0
            java.util.Collection<org.jivesoftware.smack.StanzaListener> r1 = r10.stanzaAcknowledgedListeners
            boolean r1 = r1.isEmpty()
            r2 = 1
            if (r1 != 0) goto L_0x0044
        L_0x0042:
            r0 = r2
            goto L_0x0063
        L_0x0044:
            java.util.Iterator r1 = r9.iterator()
        L_0x0048:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r1.next()
            org.jivesoftware.smack.packet.Stanza r3 = (org.jivesoftware.smack.packet.Stanza) r3
            java.lang.String r3 = r3.getStanzaId()
            if (r3 == 0) goto L_0x0048
            java.util.Map<java.lang.String, org.jivesoftware.smack.StanzaListener> r4 = r10.stanzaIdAcknowledgedListeners
            boolean r3 = r4.containsKey(r3)
            if (r3 == 0) goto L_0x0048
            goto L_0x0042
        L_0x0063:
            if (r0 == 0) goto L_0x006d
            org.jivesoftware.smack.tcp.XMPPTCPConnection$3 r0 = new org.jivesoftware.smack.tcp.XMPPTCPConnection$3
            r0.<init>(r9)
            org.jivesoftware.smack.AbstractXMPPConnection.asyncGo(r0)
        L_0x006d:
            r10.serverHandledStanzasCount = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.processHandledCount(long):void");
    }

    /* access modifiers changed from: private */
    public void requestSmAcknowledgementInternal() throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(StreamManagement.AckRequest.INSTANCE);
    }

    private void resetParser() throws IOException {
        try {
            this.packetReader.parser = SmackXmlParser.newXmlParser(this.reader);
        } catch (XmlPullParserException e10) {
            throw new IOException(e10);
        }
    }

    /* access modifiers changed from: private */
    public void sendSmAcknowledgementInternal() throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.queue.putIfNotShutdown(new StreamManagement.AckAnswer(this.clientHandledStanzasCount));
    }

    public static void setDefaultBundleAndDeferCallback(BundleAndDeferCallback bundleAndDeferCallback2) {
        defaultBundleAndDeferCallback = bundleAndDeferCallback2;
    }

    public static void setUseStreamManagementDefault(boolean z10) {
        useSmDefault = z10;
    }

    @Deprecated
    public static void setUseStreamManagementResumptiodDefault(boolean z10) {
        setUseStreamManagementResumptionDefault(z10);
    }

    public static void setUseStreamManagementResumptionDefault(boolean z10) {
        if (z10) {
            setUseStreamManagementDefault(z10);
        }
        useSmResumptionDefault = z10;
    }

    public boolean addRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean add;
        synchronized (this.requestAckPredicates) {
            add = this.requestAckPredicates.add(stanzaFilter);
        }
        return add;
    }

    public void addStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        this.stanzaAcknowledgedListeners.add(stanzaListener);
    }

    public void addStanzaDroppedListener(StanzaListener stanzaListener) {
        this.stanzaDroppedListeners.add(stanzaListener);
    }

    public StanzaListener addStanzaIdAcknowledgedListener(final String str, StanzaListener stanzaListener) throws StreamManagementException.StreamManagementNotEnabledException {
        if (this.smWasEnabledAtLeastOnce) {
            AbstractXMPPConnection.schedule(new Runnable() {
                public void run() {
                    XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(str);
                }
            }, (long) Math.min(getMaxSmResumptionTime(), 10800), TimeUnit.SECONDS);
            return this.stanzaIdAcknowledgedListeners.put(str, stanzaListener);
        }
        throw new StreamManagementException.StreamManagementNotEnabledException();
    }

    /* access modifiers changed from: protected */
    public void afterFeaturesReceived() throws SmackException.NotConnectedException, InterruptedException, SmackException.SecurityRequiredByServerException {
        StartTls startTls = (StartTls) getFeature(StartTls.class);
        if (startTls == null) {
            this.tlsHandled = true;
            notifyWaitingThreads();
        } else if (startTls.required() && this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled) {
            SmackException.SecurityRequiredByServerException securityRequiredByServerException = new SmackException.SecurityRequiredByServerException();
            this.currentSmackException = securityRequiredByServerException;
            notifyWaitingThreads();
            throw securityRequiredByServerException;
        } else if (this.config.getSecurityMode() != ConnectionConfiguration.SecurityMode.disabled) {
            sendNonza(new StartTls());
        } else {
            this.tlsHandled = true;
            notifyWaitingThreads();
        }
        if (isSaslAuthenticated()) {
            this.streamFeaturesAfterAuthenticationReceived = true;
            notifyWaitingThreads();
        }
    }

    /* access modifiers changed from: protected */
    public void afterSuccessfulLogin(boolean z10) throws SmackException.NotConnectedException, InterruptedException {
        this.disconnectedButResumeable = false;
        super.afterSuccessfulLogin(z10);
    }

    /* access modifiers changed from: protected */
    public void connectInternal() throws SmackException, IOException, XMPPException, InterruptedException {
        connectUsingConfiguration();
        this.connected = true;
        initConnection();
        waitForConditionOrThrowConnectionException(new i(this), "establishing TLS");
        waitForConditionOrThrowConnectionException(new j(this), "SASL mechanisms stream feature from server");
    }

    public int getMaxSmResumptionTime() {
        int i10 = this.smClientMaxResumptionTime;
        int i11 = a.e.API_PRIORITY_OTHER;
        if (i10 <= 0) {
            i10 = Integer.MAX_VALUE;
        }
        int i12 = this.smServerMaxResumptionTime;
        if (i12 > 0) {
            i11 = i12;
        }
        return Math.min(i10, i11);
    }

    public synchronized void instantShutdown() {
        shutdown(true);
    }

    public boolean isDisconnectedButSmResumptionPossible() {
        return this.disconnectedButResumeable && isSmResumptionPossible();
    }

    public boolean isSecureConnection() {
        return this.secureSocket != null;
    }

    public boolean isSmAvailable() {
        return hasFeature(StreamManagement.StreamManagementFeature.ELEMENT, StreamManagement.NAMESPACE);
    }

    public boolean isSmEnabled() {
        return this.smEnabledSyncPoint;
    }

    public boolean isSmResumptionPossible() {
        if (this.smSessionId == null) {
            return false;
        }
        Long l10 = this.packetWriter.shutdownTimestamp;
        if (l10 == null) {
            return true;
        }
        if (System.currentTimeMillis() > l10.longValue() + (((long) getMaxSmResumptionTime()) * 1000)) {
            return false;
        }
        return true;
    }

    public boolean isUsingCompression() {
        return this.compressionHandler != null && this.compressSyncPoint;
    }

    /* access modifiers changed from: protected */
    public synchronized void loginInternal(String str, String str2, Resourcepart resourcepart) throws XMPPException, SmackException, IOException, InterruptedException {
        SSLSession sSLSession;
        SSLSocket sSLSocket = this.secureSocket;
        if (sSLSocket != null) {
            sSLSession = sSLSocket.getSession();
        } else {
            sSLSession = null;
        }
        this.streamFeaturesAfterAuthenticationReceived = false;
        authenticate(str, str2, this.config.getAuthzid(), sSLSession);
        waitForConditionOrThrowConnectionException(new f(this), "compress features from server");
        maybeEnableCompression();
        this.smResumedSyncPoint = AbstractXMPPConnection.SyncPointState.initial;
        this.smResumptionFailed = null;
        if (isSmResumptionPossible()) {
            this.smResumedSyncPoint = AbstractXMPPConnection.SyncPointState.request_sent;
            sendNonza(new StreamManagement.Resume(this.clientHandledStanzasCount, this.smSessionId));
            waitForConditionOrConnectionException(new g(this), "resume previous stream");
            if (this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful) {
                afterSuccessfulLogin(true);
                return;
            }
            LOGGER.fine("Stream resumption failed, continuing with normal stream establishment process: " + this.smResumptionFailed);
        }
        this.smEnabledSyncPoint = false;
        LinkedList<Stanza> linkedList = new LinkedList<>();
        BlockingQueue<Stanza> blockingQueue = this.unacknowledgedStanzas;
        if (blockingQueue != null) {
            blockingQueue.drainTo(linkedList);
            dropSmState();
        }
        bindResourceAndEstablishSession(resourcepart);
        if (isSmAvailable() && this.useSm) {
            this.serverHandledStanzasCount = 0;
            sendNonza(new StreamManagement.Enable(this.useSmResumption, this.smClientMaxResumptionTime));
            waitForConditionOrThrowConnectionException(new h(this), "enabling stream mangement");
            synchronized (this.requestAckPredicates) {
                if (this.requestAckPredicates.isEmpty()) {
                    this.requestAckPredicates.add(Predicate.forMessagesOrAfter5Stanzas());
                }
            }
        }
        if (!this.stanzaDroppedListeners.isEmpty()) {
            for (Stanza stanza : linkedList) {
                for (StanzaListener processStanza : this.stanzaDroppedListeners) {
                    try {
                        processStanza.processStanza(stanza);
                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e10) {
                        LOGGER.log(Level.FINER, "StanzaDroppedListener received exception", e10);
                    }
                }
            }
        } else {
            for (Stanza sendStanzaInternal : linkedList) {
                sendStanzaInternal(sendStanzaInternal);
            }
        }
        afterSuccessfulLogin(false);
    }

    public void removeAllRequestAckPredicates() {
        synchronized (this.requestAckPredicates) {
            this.requestAckPredicates.clear();
        }
    }

    public void removeAllStanzaAcknowledgedListeners() {
        this.stanzaAcknowledgedListeners.clear();
    }

    public void removeAllStanzaIdAcknowledgedListeners() {
        this.stanzaIdAcknowledgedListeners.clear();
    }

    public boolean removeRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean remove;
        synchronized (this.requestAckPredicates) {
            remove = this.requestAckPredicates.remove(stanzaFilter);
        }
        return remove;
    }

    public boolean removeStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        return this.stanzaAcknowledgedListeners.remove(stanzaListener);
    }

    public boolean removeStanzaDroppedListener(StanzaListener stanzaListener) {
        return this.stanzaDroppedListeners.remove(stanzaListener);
    }

    public StanzaListener removeStanzaIdAcknowledgedListener(String str) {
        return this.stanzaIdAcknowledgedListeners.remove(str);
    }

    public void requestSmAcknowledgement() throws StreamManagementException.StreamManagementNotEnabledException, SmackException.NotConnectedException, InterruptedException {
        if (isSmEnabled()) {
            requestSmAcknowledgementInternal();
            return;
        }
        throw new StreamManagementException.StreamManagementNotEnabledException();
    }

    public void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(nonza);
    }

    public void sendSmAcknowledgement() throws StreamManagementException.StreamManagementNotEnabledException, SmackException.NotConnectedException, InterruptedException {
        if (isSmEnabled()) {
            sendSmAcknowledgementInternal();
            return;
        }
        throw new StreamManagementException.StreamManagementNotEnabledException();
    }

    /* access modifiers changed from: protected */
    public void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(stanza);
        if (isSmEnabled()) {
            for (StanzaFilter accept : this.requestAckPredicates) {
                if (accept.accept(stanza)) {
                    requestSmAcknowledgementInternal();
                    return;
                }
            }
        }
    }

    public void setBundleandDeferCallback(BundleAndDeferCallback bundleAndDeferCallback2) {
        this.bundleAndDeferCallback = bundleAndDeferCallback2;
    }

    public void setPreferredResumptionTime(int i10) {
        this.smClientMaxResumptionTime = i10;
    }

    public void setUseStreamManagement(boolean z10) {
        this.useSm = z10;
    }

    public void setUseStreamManagementResumption(boolean z10) {
        if (z10) {
            setUseStreamManagement(z10);
        }
        this.useSmResumption = z10;
    }

    /* access modifiers changed from: protected */
    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        if (isSmEnabled()) {
            try {
                sendSmAcknowledgementInternal();
            } catch (InterruptedException | SmackException.NotConnectedException e10) {
                LOGGER.log(Level.FINE, "Can not send final SM ack as connection is not connected", e10);
            }
        }
        shutdown(false);
    }

    public boolean streamWasResumed() {
        return this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful;
    }

    /* access modifiers changed from: protected */
    public void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    /* access modifiers changed from: protected */
    public void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    /* access modifiers changed from: protected */
    public void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        PacketWriter packetWriter2 = this.packetWriter;
        if (packetWriter2 != null) {
            packetWriter2.throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
            return;
        }
        throw new SmackException.NotConnectedException();
    }

    private void shutdown(boolean z10) {
        if (!this.packetWriter.done()) {
            Logger logger = LOGGER;
            logger.finer(this.packetWriter.threadName + " shutdown()");
            this.packetWriter.shutdown(z10);
            logger.finer(this.packetWriter.threadName + " shutdown() returned");
            if (!z10) {
                waitForClosingStreamTagFromServer();
            }
        }
        Logger logger2 = LOGGER;
        logger2.finer(this.packetReader.threadName + " shutdown()");
        this.packetReader.shutdown();
        logger2.finer(this.packetReader.threadName + " shutdown() returned");
        CloseableUtil.maybeClose(this.socket, logger2);
        setWasAuthenticated();
        try {
            if (!waitFor(new e(this))) {
                logger2.severe("Reader and/or writer threads did not terminate timely. Writer running: " + this.packetWriter.running + ", Reader running: " + this.packetReader.running);
            } else {
                logger2.fine("Reader and writer threads terminated");
            }
        } catch (InterruptedException e10) {
            LOGGER.log(Level.FINE, "Interrupted while waiting for reader and writer threads to terminate", e10);
        }
        if (!this.disconnectedButResumeable) {
            if (z10) {
                boolean isSmResumptionPossible = isSmResumptionPossible();
                this.disconnectedButResumeable = isSmResumptionPossible;
                if (!isSmResumptionPossible) {
                    this.smSessionId = null;
                }
            } else {
                this.disconnectedButResumeable = false;
                dropSmState();
            }
            this.authenticated = false;
            this.connected = false;
            this.secureSocket = null;
            this.reader = null;
            this.writer = null;
            initState();
        }
    }

    public XMPPTCPConnection(CharSequence charSequence, String str) throws XmppStringprepException {
        this(((XMPPTCPConnectionConfiguration.Builder) XMPPTCPConnectionConfiguration.builder().setXmppAddressAndPassword(charSequence, str)).build());
    }

    public XMPPTCPConnection(CharSequence charSequence, String str, String str2) throws XmppStringprepException {
        this(((XMPPTCPConnectionConfiguration.Builder) ((XMPPTCPConnectionConfiguration.Builder) XMPPTCPConnectionConfiguration.builder().setUsernameAndPassword(charSequence, str)).setXmppDomain(org.jxmpp.jid.impl.a.e(str2))).build());
    }
}
