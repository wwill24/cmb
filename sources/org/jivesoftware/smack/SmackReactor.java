package org.jivesoftware.smack;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ScheduledAction;

public class SmackReactor {
    private static final int DEFAULT_REACTOR_THREAD_COUNT = 2;
    private static SmackReactor INSTANCE = null;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(SmackReactor.class.getName());
    private static final int PENDING_SET_INTEREST_OPS_MAX_BATCH_SIZE = 1024;
    /* access modifiers changed from: private */
    public final Semaphore actionsSemaphore = new Semaphore(-1, false);
    /* access modifiers changed from: private */
    public final Queue<SelectionKey> pendingSelectionKeys = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public final Queue<SetInterestOps> pendingSetInterestOps = new ConcurrentLinkedQueue();
    private final String reactorName;
    /* access modifiers changed from: private */
    public final List<Reactor> reactorThreads = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final Lock registrationLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public final DelayQueue<ScheduledAction> scheduledActions = new DelayQueue<>();
    /* access modifiers changed from: private */
    public final Selector selector;

    public interface ChannelSelectedCallback {
        void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey);
    }

    private class Reactor extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile long shutdownRequestTimestamp;

        private Reactor() {
            this.shutdownRequestTimestamp = -1;
        }

        private void handlePendingSelectionKeys() {
            int size = SmackReactor.this.pendingSelectionKeys.size();
            if (size != 0) {
                int size2 = size / SmackReactor.this.reactorThreads.size();
                ArrayList arrayList = new ArrayList(size2);
                for (int i10 = 0; i10 < size2; i10++) {
                    SelectionKey selectionKey = (SelectionKey) SmackReactor.this.pendingSelectionKeys.poll();
                    if (selectionKey == null) {
                        break;
                    }
                    arrayList.add(selectionKey);
                }
                if (!SmackReactor.this.pendingSelectionKeys.isEmpty()) {
                    SmackReactor.this.selector.wakeup();
                }
                SmackReactor.handleSelectedKeys(arrayList);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ec, code lost:
            r0 = r4.size();
            r3 = org.jivesoftware.smack.SmackReactor.access$300(r10.this$0).size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fa, code lost:
            if (r0 <= r3) goto L_0x00ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fc, code lost:
            r5 = r0 / r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ff, code lost:
            r5 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0100, code lost:
            r6 = java.util.logging.Level.FINE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
            if (org.jivesoftware.smack.SmackReactor.access$200().isLoggable(r6) == false) goto L_0x013c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x010c, code lost:
            org.jivesoftware.smack.SmackReactor.access$200().log(r6, "New selected key count: " + r2 + ". Total selected key count " + r0 + ". My key count: " + r5 + ". Current reactor thread count: " + r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x013c, code lost:
            r2 = new java.util.ArrayList(r5);
            r3 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
            if (r1 >= r5) goto L_0x0153;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
            r2.add((java.nio.channels.SelectionKey) r3.next());
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0157, code lost:
            if (r3.hasNext() == false) goto L_0x0169;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0159, code lost:
            org.jivesoftware.smack.SmackReactor.access$1200(r10.this$0).add((java.nio.channels.SelectionKey) r3.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x016a, code lost:
            if ((r0 - r5) <= 0) goto L_0x0175;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x016c, code lost:
            org.jivesoftware.smack.SmackReactor.access$600(r10.this$0).wakeup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0175, code lost:
            org.jivesoftware.smack.SmackReactor.access$1300(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0178, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void handleScheduledActionsOrPerformSelect() {
            /*
                r10 = this;
                org.jivesoftware.smack.SmackReactor r0 = org.jivesoftware.smack.SmackReactor.this
                java.util.concurrent.Semaphore r0 = r0.actionsSemaphore
                boolean r0 = r0.tryAcquire()
                if (r0 == 0) goto L_0x002d
                org.jivesoftware.smack.SmackReactor r0 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0022 }
                java.util.concurrent.DelayQueue r0 = r0.scheduledActions     // Catch:{ all -> 0x0022 }
                java.util.concurrent.Delayed r0 = r0.poll()     // Catch:{ all -> 0x0022 }
                org.jivesoftware.smack.ScheduledAction r0 = (org.jivesoftware.smack.ScheduledAction) r0     // Catch:{ all -> 0x0022 }
                org.jivesoftware.smack.SmackReactor r1 = org.jivesoftware.smack.SmackReactor.this
                java.util.concurrent.Semaphore r1 = r1.actionsSemaphore
                r1.release()
                goto L_0x002e
            L_0x0022:
                r0 = move-exception
                org.jivesoftware.smack.SmackReactor r1 = org.jivesoftware.smack.SmackReactor.this
                java.util.concurrent.Semaphore r1 = r1.actionsSemaphore
                r1.release()
                throw r0
            L_0x002d:
                r0 = 0
            L_0x002e:
                if (r0 == 0) goto L_0x0034
                r0.run()
                return
            L_0x0034:
                org.jivesoftware.smack.SmackReactor r0 = org.jivesoftware.smack.SmackReactor.this
                java.nio.channels.Selector r0 = r0.selector
                monitor-enter(r0)
                org.jivesoftware.smack.SmackReactor r1 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.util.concurrent.DelayQueue r1 = r1.scheduledActions     // Catch:{ all -> 0x0187 }
                java.util.concurrent.Delayed r1 = r1.peek()     // Catch:{ all -> 0x0187 }
                org.jivesoftware.smack.ScheduledAction r1 = (org.jivesoftware.smack.ScheduledAction) r1     // Catch:{ all -> 0x0187 }
                r2 = 0
                if (r1 != 0) goto L_0x004c
                goto L_0x0057
            L_0x004c:
                long r4 = r1.getTimeToDueMillis()     // Catch:{ all -> 0x0187 }
                int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r1 > 0) goto L_0x0056
                monitor-exit(r0)     // Catch:{ all -> 0x0187 }
                return
            L_0x0056:
                r2 = r4
            L_0x0057:
                r1 = 0
                r4 = r1
            L_0x0059:
                org.jivesoftware.smack.SmackReactor r5 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.util.Queue r5 = r5.pendingSetInterestOps     // Catch:{ all -> 0x0187 }
                java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x0187 }
                org.jivesoftware.smack.SmackReactor$SetInterestOps r5 = (org.jivesoftware.smack.SmackReactor.SetInterestOps) r5     // Catch:{ all -> 0x0187 }
                if (r5 == 0) goto L_0x0084
                java.nio.channels.SelectionKey r6 = r5.selectionKey     // Catch:{ all -> 0x0187 }
                int r5 = r5.interestOps     // Catch:{ all -> 0x0187 }
                r10.setInterestOpsCancelledKeySafe(r6, r5)     // Catch:{ all -> 0x0187 }
                int r5 = r4 + 1
                r6 = 1024(0x400, float:1.435E-42)
                if (r4 < r6) goto L_0x0082
                org.jivesoftware.smack.SmackReactor r4 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.nio.channels.Selector r4 = r4.selector     // Catch:{ all -> 0x0187 }
                r4.wakeup()     // Catch:{ all -> 0x0187 }
                goto L_0x0084
            L_0x0082:
                r4 = r5
                goto L_0x0059
            L_0x0084:
                org.jivesoftware.smack.SmackReactor r4 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.util.concurrent.locks.Lock r4 = r4.registrationLock     // Catch:{ all -> 0x0187 }
                r4.lock()     // Catch:{ all -> 0x0187 }
                org.jivesoftware.smack.SmackReactor r4 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.util.concurrent.locks.Lock r4 = r4.registrationLock     // Catch:{ all -> 0x0187 }
                r4.unlock()     // Catch:{ all -> 0x0187 }
                org.jivesoftware.smack.SmackReactor r4 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ IOException -> 0x0179 }
                java.nio.channels.Selector r4 = r4.selector     // Catch:{ IOException -> 0x0179 }
                int r2 = r4.select(r2)     // Catch:{ IOException -> 0x0179 }
                if (r2 != 0) goto L_0x00a4
                monitor-exit(r0)     // Catch:{ all -> 0x0187 }
                return
            L_0x00a4:
                org.jivesoftware.smack.SmackReactor r3 = org.jivesoftware.smack.SmackReactor.this     // Catch:{ all -> 0x0187 }
                java.nio.channels.Selector r3 = r3.selector     // Catch:{ all -> 0x0187 }
                java.util.Set r3 = r3.selectedKeys()     // Catch:{ all -> 0x0187 }
                java.util.Iterator r4 = r3.iterator()     // Catch:{ all -> 0x0187 }
            L_0x00b2:
                boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0187 }
                if (r5 == 0) goto L_0x00c8
                java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0187 }
                java.nio.channels.SelectionKey r5 = (java.nio.channels.SelectionKey) r5     // Catch:{ all -> 0x0187 }
                java.lang.Object r5 = r5.attachment()     // Catch:{ all -> 0x0187 }
                org.jivesoftware.smack.SmackReactor$SelectionKeyAttachment r5 = (org.jivesoftware.smack.SmackReactor.SelectionKeyAttachment) r5     // Catch:{ all -> 0x0187 }
                r5.setRacing()     // Catch:{ all -> 0x0187 }
                goto L_0x00b2
            L_0x00c8:
                java.util.Iterator r4 = r3.iterator()     // Catch:{ all -> 0x0187 }
            L_0x00cc:
                boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0187 }
                if (r5 == 0) goto L_0x00dc
                java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0187 }
                java.nio.channels.SelectionKey r5 = (java.nio.channels.SelectionKey) r5     // Catch:{ all -> 0x0187 }
                r10.setInterestOpsCancelledKeySafe(r5, r1)     // Catch:{ all -> 0x0187 }
                goto L_0x00cc
            L_0x00dc:
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0187 }
                int r5 = r3.size()     // Catch:{ all -> 0x0187 }
                r4.<init>(r5)     // Catch:{ all -> 0x0187 }
                r4.addAll(r3)     // Catch:{ all -> 0x0187 }
                r3.clear()     // Catch:{ all -> 0x0187 }
                monitor-exit(r0)     // Catch:{ all -> 0x0187 }
                int r0 = r4.size()
                org.jivesoftware.smack.SmackReactor r3 = org.jivesoftware.smack.SmackReactor.this
                java.util.List r3 = r3.reactorThreads
                int r3 = r3.size()
                if (r0 <= r3) goto L_0x00ff
                int r5 = r0 / r3
                goto L_0x0100
            L_0x00ff:
                r5 = r0
            L_0x0100:
                java.util.logging.Level r6 = java.util.logging.Level.FINE
                java.util.logging.Logger r7 = org.jivesoftware.smack.SmackReactor.LOGGER
                boolean r7 = r7.isLoggable(r6)
                if (r7 == 0) goto L_0x013c
                java.util.logging.Logger r7 = org.jivesoftware.smack.SmackReactor.LOGGER
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "New selected key count: "
                r8.append(r9)
                r8.append(r2)
                java.lang.String r2 = ". Total selected key count "
                r8.append(r2)
                r8.append(r0)
                java.lang.String r2 = ". My key count: "
                r8.append(r2)
                r8.append(r5)
                java.lang.String r2 = ". Current reactor thread count: "
                r8.append(r2)
                r8.append(r3)
                java.lang.String r2 = r8.toString()
                r7.log(r6, r2)
            L_0x013c:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>(r5)
                java.util.Iterator r3 = r4.iterator()
            L_0x0145:
                if (r1 >= r5) goto L_0x0153
                java.lang.Object r4 = r3.next()
                java.nio.channels.SelectionKey r4 = (java.nio.channels.SelectionKey) r4
                r2.add(r4)
                int r1 = r1 + 1
                goto L_0x0145
            L_0x0153:
                boolean r1 = r3.hasNext()
                if (r1 == 0) goto L_0x0169
                java.lang.Object r1 = r3.next()
                java.nio.channels.SelectionKey r1 = (java.nio.channels.SelectionKey) r1
                org.jivesoftware.smack.SmackReactor r4 = org.jivesoftware.smack.SmackReactor.this
                java.util.Queue r4 = r4.pendingSelectionKeys
                r4.add(r1)
                goto L_0x0153
            L_0x0169:
                int r0 = r0 - r5
                if (r0 <= 0) goto L_0x0175
                org.jivesoftware.smack.SmackReactor r0 = org.jivesoftware.smack.SmackReactor.this
                java.nio.channels.Selector r0 = r0.selector
                r0.wakeup()
            L_0x0175:
                org.jivesoftware.smack.SmackReactor.handleSelectedKeys(r2)
                return
            L_0x0179:
                r1 = move-exception
                java.util.logging.Logger r2 = org.jivesoftware.smack.SmackReactor.LOGGER     // Catch:{ all -> 0x0187 }
                java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0187 }
                java.lang.String r4 = "IOException while using select()"
                r2.log(r3, r4, r1)     // Catch:{ all -> 0x0187 }
                monitor-exit(r0)     // Catch:{ all -> 0x0187 }
                return
            L_0x0187:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0187 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackReactor.Reactor.handleScheduledActionsOrPerformSelect():void");
        }

        private void reactorLoop() {
            while (this.shutdownRequestTimestamp < 0) {
                handleScheduledActionsOrPerformSelect();
                handlePendingSelectionKeys();
            }
        }

        private void setInterestOpsCancelledKeySafe(SelectionKey selectionKey, int i10) {
            try {
                selectionKey.interestOps(i10);
            } catch (CancelledKeyException e10) {
                Level level = Level.FINER;
                if (SmackReactor.LOGGER.isLoggable(level)) {
                    Logger access$200 = SmackReactor.LOGGER;
                    access$200.log(level, "Key '" + selectionKey + "' has been cancelled", e10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void requestShutdown() {
            this.shutdownRequestTimestamp = System.currentTimeMillis();
        }

        public void run() {
            try {
                reactorLoop();
                if (this.shutdownRequestTimestamp > 0) {
                    long currentTimeMillis = System.currentTimeMillis() - this.shutdownRequestTimestamp;
                    Logger access$200 = SmackReactor.LOGGER;
                    access$200.info(this + " shut down after " + currentTimeMillis + "ms");
                    return;
                }
                SmackReactor.this.reactorThreads.remove(this);
            } catch (Throwable th2) {
                if (this.shutdownRequestTimestamp <= 0) {
                    SmackReactor.this.reactorThreads.remove(this);
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.shutdownRequestTimestamp;
                    Logger access$2002 = SmackReactor.LOGGER;
                    access$2002.info(this + " shut down after " + currentTimeMillis2 + "ms");
                }
                throw th2;
            }
        }
    }

    public static final class SelectionKeyAttachment {
        /* access modifiers changed from: private */
        public final ChannelSelectedCallback channelSelectedCallback;
        private final AtomicBoolean reactorThreadRacing;

        /* access modifiers changed from: private */
        public void setRacing() {
            this.reactorThreadRacing.lazySet(true);
        }

        public boolean isReactorThreadRacing() {
            return this.reactorThreadRacing.get();
        }

        public void resetReactorThreadRacing() {
            this.reactorThreadRacing.set(false);
        }

        private SelectionKeyAttachment(ChannelSelectedCallback channelSelectedCallback2) {
            this.reactorThreadRacing = new AtomicBoolean();
            this.channelSelectedCallback = channelSelectedCallback2;
        }
    }

    private static final class SetInterestOps {
        /* access modifiers changed from: private */
        public final int interestOps;
        /* access modifiers changed from: private */
        public final SelectionKey selectionKey;

        private SetInterestOps(SelectionKey selectionKey2, int i10) {
            this.selectionKey = selectionKey2;
            this.interestOps = i10;
        }
    }

    SmackReactor(String str) {
        this.reactorName = str;
        try {
            this.selector = Selector.open();
            setReactorThreadCount(2);
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static synchronized SmackReactor getInstance() {
        SmackReactor smackReactor;
        synchronized (SmackReactor.class) {
            if (INSTANCE == null) {
                INSTANCE = new SmackReactor("DefaultReactor");
            }
            smackReactor = INSTANCE;
        }
        return smackReactor;
    }

    /* access modifiers changed from: private */
    public static void handleSelectedKeys(Collection<SelectionKey> collection) {
        for (SelectionKey next : collection) {
            ((SelectionKeyAttachment) next.attachment()).channelSelectedCallback.onChannelSelected(next.channel(), next);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean cancel(ScheduledAction scheduledAction) {
        return this.scheduledActions.remove(scheduledAction);
    }

    public SelectionKey registerWithSelector(SelectableChannel selectableChannel, int i10, ChannelSelectedCallback channelSelectedCallback) throws ClosedChannelException {
        SelectionKeyAttachment selectionKeyAttachment = new SelectionKeyAttachment(channelSelectedCallback);
        this.registrationLock.lock();
        try {
            this.selector.wakeup();
            return selectableChannel.register(this.selector, i10, selectionKeyAttachment);
        } finally {
            this.registrationLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public ScheduledAction schedule(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledAction.Kind kind) {
        ScheduledAction scheduledAction = new ScheduledAction(runnable, new Date(System.currentTimeMillis() + timeUnit.toMillis(j10)), this, kind);
        this.scheduledActions.add(scheduledAction);
        this.selector.wakeup();
        return scheduledAction;
    }

    public void setInterestOps(SelectionKey selectionKey, int i10) {
        this.pendingSetInterestOps.add(new SetInterestOps(selectionKey, i10));
        this.selector.wakeup();
    }

    public void setReactorThreadCount(int i10) {
        if (i10 >= 2) {
            synchronized (this.reactorThreads) {
                int size = i10 - this.reactorThreads.size();
                if (size > 0) {
                    for (int i11 = 0; i11 < size; i11++) {
                        Reactor reactor = new Reactor();
                        reactor.setDaemon(true);
                        reactor.setName("Smack " + this.reactorName + " Thread #" + i11);
                        this.reactorThreads.add(reactor);
                        reactor.start();
                    }
                    this.actionsSemaphore.release(size);
                } else {
                    int i12 = (size - size) - 1;
                    for (int i13 = i12; i13 > 0; i13--) {
                        this.actionsSemaphore.acquireUninterruptibly();
                    }
                    while (i12 > 0) {
                        this.reactorThreads.remove(i12).requestShutdown();
                        i12--;
                    }
                    this.selector.wakeup();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Must have at least two reactor threads, but you requested " + i10);
    }
}
