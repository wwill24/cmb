package org.jivesoftware.smack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

public final class StanzaCollector implements AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean cancelled;
    private List<Stanza> collectedCache;
    private final StanzaCollector collectorToReset;
    private final XMPPConnection connection;
    private Exception connectionException;
    private final int maxQueueSize;
    private final StanzaFilter packetFilter;
    private final Stanza request;
    private final ArrayDeque<Stanza> resultQueue;
    private String stringCache;
    private volatile long waitStart;

    public static final class Configuration {
        /* access modifiers changed from: private */
        public StanzaCollector collectorToReset;
        /* access modifiers changed from: private */
        public StanzaFilter packetFilter;
        /* access modifiers changed from: private */
        public Stanza request;
        /* access modifiers changed from: private */
        public int size;

        public Configuration setCollectorToReset(StanzaCollector stanzaCollector) {
            this.collectorToReset = stanzaCollector;
            return this;
        }

        public Configuration setRequest(Stanza stanza) {
            this.request = stanza;
            return this;
        }

        public Configuration setSize(int i10) {
            this.size = i10;
            return this;
        }

        public Configuration setStanzaFilter(StanzaFilter stanzaFilter) {
            this.packetFilter = stanzaFilter;
            return this;
        }

        private Configuration() {
            this.size = SmackConfiguration.getStanzaCollectorSize();
        }
    }

    static {
        Class<StanzaCollector> cls = StanzaCollector.class;
    }

    StanzaCollector(XMPPConnection xMPPConnection, Configuration configuration) {
        this.connection = xMPPConnection;
        this.packetFilter = configuration.packetFilter;
        this.resultQueue = new ArrayDeque<>(configuration.size);
        this.maxQueueSize = configuration.size;
        this.collectorToReset = configuration.collectorToReset;
        this.request = configuration.request;
    }

    public static Configuration newConfiguration() {
        return new Configuration();
    }

    private void throwIfCancelled() {
        if (this.cancelled) {
            throw new IllegalStateException("Stanza collector already cancelled");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void cancel() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.cancelled     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.cancelled = r0     // Catch:{ all -> 0x001b }
            org.jivesoftware.smack.XMPPConnection r0 = r1.connection     // Catch:{ all -> 0x001b }
            r0.removeStanzaCollector(r1)     // Catch:{ all -> 0x001b }
            r1.notifyAll()     // Catch:{ all -> 0x001b }
            org.jivesoftware.smack.StanzaCollector r0 = r1.collectorToReset     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            r0.cancel()     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.StanzaCollector.cancel():void");
    }

    public void close() {
        cancel();
    }

    public synchronized int getCollectedCount() {
        return this.resultQueue.size();
    }

    public List<Stanza> getCollectedStanzasAfterCancelled() {
        if (this.cancelled) {
            if (this.collectedCache == null) {
                ArrayList arrayList = new ArrayList(getCollectedCount());
                this.collectedCache = arrayList;
                arrayList.addAll(this.resultQueue);
            }
            return this.collectedCache;
        }
        throw new IllegalStateException("Stanza collector was not yet cancelled");
    }

    public StanzaFilter getStanzaFilter() {
        return this.packetFilter;
    }

    public <P extends Stanza> P nextResult() throws InterruptedException {
        return nextResult(this.connection.getReplyTimeout());
    }

    public synchronized <P extends Stanza> P nextResultBlockForever() throws InterruptedException {
        throwIfCancelled();
        while (true) {
            P p10 = (Stanza) this.resultQueue.poll();
            if (p10 != null) {
                return p10;
            }
            if (this.cancelled) {
                return null;
            }
            wait();
        }
    }

    public <P extends Stanza> P nextResultOrThrow() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        return nextResultOrThrow(this.connection.getReplyTimeout());
    }

    /* access modifiers changed from: package-private */
    public synchronized void notifyConnectionError(Exception exc) {
        this.connectionException = exc;
        notifyAll();
    }

    public synchronized <P extends Stanza> P pollResult() {
        return (Stanza) this.resultQueue.poll();
    }

    public <P extends Stanza> P pollResultOrThrow() throws XMPPException.XMPPErrorException {
        P pollResult = pollResult();
        if (pollResult != null) {
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(pollResult);
        }
        return pollResult;
    }

    /* access modifiers changed from: protected */
    public void processStanza(Stanza stanza) {
        StanzaFilter stanzaFilter = this.packetFilter;
        if (stanzaFilter == null || stanzaFilter.accept(stanza)) {
            synchronized (this) {
                if (this.resultQueue.size() == this.maxQueueSize) {
                    Stanza poll = this.resultQueue.poll();
                }
                this.resultQueue.add(stanza);
                notifyAll();
            }
            StanzaCollector stanzaCollector = this.collectorToReset;
            if (stanzaCollector != null) {
                stanzaCollector.waitStart = System.currentTimeMillis();
            }
        }
    }

    public String toString() {
        if (this.stringCache == null) {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Stanza Collector filter='");
            sb2.append(this.packetFilter);
            sb2.append('\'');
            if (this.request != null) {
                sb2.append(" request='");
                sb2.append(this.request);
                sb2.append('\'');
            }
            this.stringCache = sb2.toString();
        }
        return this.stringCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r1 = r6 - (java.lang.System.currentTimeMillis() - r5.waitStart);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <P extends org.jivesoftware.smack.packet.Stanza> P nextResult(long r6) throws java.lang.InterruptedException {
        /*
            r5 = this;
            r5.throwIfCancelled()
            long r0 = java.lang.System.currentTimeMillis()
            r5.waitStart = r0
            r0 = 0
            r1 = r6
        L_0x000b:
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0037
            java.lang.Exception r3 = r5.connectionException
            if (r3 != 0) goto L_0x0037
            boolean r3 = r5.cancelled
            if (r3 != 0) goto L_0x0037
            monitor-enter(r5)
            java.util.ArrayDeque<org.jivesoftware.smack.packet.Stanza> r0 = r5.resultQueue     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0034 }
            org.jivesoftware.smack.packet.Stanza r0 = (org.jivesoftware.smack.packet.Stanza) r0     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r5)     // Catch:{ all -> 0x0034 }
            return r0
        L_0x0026:
            r5.wait(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r5)     // Catch:{ all -> 0x0034 }
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r5.waitStart
            long r1 = r1 - r3
            long r1 = r6 - r1
            goto L_0x000b
        L_0x0034:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0034 }
            throw r6
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.StanzaCollector.nextResult(long):org.jivesoftware.smack.packet.Stanza");
    }

    public <P extends Stanza> P nextResultOrThrow(long j10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        try {
            P nextResult = nextResult(j10);
            if (nextResult != null) {
                XMPPException.XMPPErrorException.ifHasErrorThenThrow(nextResult);
                return nextResult;
            } else if (this.connectionException != null) {
                throw new SmackException.NotConnectedException(this.connection, this.packetFilter, this.connectionException);
            } else if (!this.connection.isConnected()) {
                throw new SmackException.NotConnectedException(this.connection, this.packetFilter);
            } else {
                throw SmackException.NoResponseException.newWith(j10, this, this.cancelled);
            }
        } finally {
            cancel();
        }
    }
}
