package org.jivesoftware.smack;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.util.Async;

public final class ReconnectionManager {
    private static final Map<AbstractXMPPConnection, ReconnectionManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(ReconnectionManager.class.getName());
    private static int defaultFixedDelay = 15;
    private static ReconnectionPolicy defaultReconnectionPolicy = ReconnectionPolicy.RANDOM_INCREASING_DELAY;
    private static boolean enabledPerDefault = false;
    private boolean automaticReconnectEnabled = false;
    private final ConnectionListener connectionListener = new ConnectionListener() {
        public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
            ReconnectionManager.this.done = false;
        }

        public void connectionClosed() {
            ReconnectionManager.this.done = true;
        }

        public void connectionClosedOnError(Exception exc) {
            ReconnectionManager reconnectionManager = ReconnectionManager.this;
            reconnectionManager.done = false;
            if (reconnectionManager.isAutomaticReconnectEnabled()) {
                if (exc instanceof XMPPException.StreamErrorException) {
                    if (StreamError.Condition.conflict == ((XMPPException.StreamErrorException) exc).getStreamError().getCondition()) {
                        return;
                    }
                }
                ReconnectionManager.this.reconnect();
            }
        }
    };
    boolean done = false;
    /* access modifiers changed from: private */
    public volatile int fixedDelay = defaultFixedDelay;
    /* access modifiers changed from: private */
    public final int randomBase = (new Random().nextInt(13) + 2);
    /* access modifiers changed from: private */
    public final Set<ReconnectionListener> reconnectionListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public volatile ReconnectionPolicy reconnectionPolicy = defaultReconnectionPolicy;
    private final Runnable reconnectionRunnable;
    private Thread reconnectionThread;
    /* access modifiers changed from: private */
    public final WeakReference<AbstractXMPPConnection> weakRefConnection;

    /* renamed from: org.jivesoftware.smack.ReconnectionManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.ReconnectionManager$ReconnectionPolicy[] r0 = org.jivesoftware.smack.ReconnectionManager.ReconnectionPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy = r0
                org.jivesoftware.smack.ReconnectionManager$ReconnectionPolicy r1 = org.jivesoftware.smack.ReconnectionManager.ReconnectionPolicy.FIXED_DELAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.ReconnectionManager$ReconnectionPolicy r1 = org.jivesoftware.smack.ReconnectionManager.ReconnectionPolicy.RANDOM_INCREASING_DELAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.ReconnectionManager.AnonymousClass4.<clinit>():void");
        }
    }

    public enum ReconnectionPolicy {
        RANDOM_INCREASING_DELAY,
        FIXED_DELAY
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (xMPPConnection instanceof AbstractXMPPConnection) {
                    ReconnectionManager.getInstanceFor((AbstractXMPPConnection) xMPPConnection);
                }
            }
        });
    }

    private ReconnectionManager(AbstractXMPPConnection abstractXMPPConnection) {
        this.weakRefConnection = new WeakReference<>(abstractXMPPConnection);
        this.reconnectionRunnable = new Runnable() {
            private int attempts = 0;

            private int timeDelay() {
                this.attempts++;
                int i10 = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy[ReconnectionManager.this.reconnectionPolicy.ordinal()];
                if (i10 == 1) {
                    return ReconnectionManager.this.fixedDelay;
                }
                if (i10 == 2) {
                    int i11 = this.attempts;
                    if (i11 > 13) {
                        return ReconnectionManager.this.randomBase * 6 * 5;
                    }
                    if (i11 > 7) {
                        return ReconnectionManager.this.randomBase * 6;
                    }
                    return ReconnectionManager.this.randomBase;
                }
                throw new AssertionError("Unknown reconnection policy " + ReconnectionManager.this.reconnectionPolicy);
            }

            public void run() {
                AbstractXMPPConnection abstractXMPPConnection = (AbstractXMPPConnection) ReconnectionManager.this.weakRefConnection.get();
                if (abstractXMPPConnection != null) {
                    this.attempts = 0;
                    while (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection)) {
                        int timeDelay = timeDelay();
                        while (timeDelay > 0) {
                            if (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection)) {
                                try {
                                    Thread.sleep(1000);
                                    timeDelay--;
                                    for (ReconnectionListener reconnectingIn : ReconnectionManager.this.reconnectionListeners) {
                                        reconnectingIn.reconnectingIn(timeDelay);
                                    }
                                } catch (InterruptedException e10) {
                                    ReconnectionManager.LOGGER.log(Level.FINE, "Reconnection Thread was interrupted, aborting reconnection mechanism", e10);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        for (ReconnectionListener reconnectingIn2 : ReconnectionManager.this.reconnectionListeners) {
                            reconnectingIn2.reconnectingIn(0);
                        }
                        if (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection)) {
                            try {
                                abstractXMPPConnection.connect();
                            } catch (SmackException.AlreadyConnectedException e11) {
                                try {
                                    ReconnectionManager.LOGGER.log(Level.FINER, "Connection was already connected on reconnection attempt", e11);
                                } catch (SmackException.AlreadyLoggedInException e12) {
                                    ReconnectionManager.LOGGER.log(Level.FINER, "Reconnection not required, was already logged in", e12);
                                    return;
                                } catch (IOException | SmackException | XMPPException e13) {
                                    for (ReconnectionListener reconnectionFailed : ReconnectionManager.this.reconnectionListeners) {
                                        reconnectionFailed.reconnectionFailed(e13);
                                    }
                                } catch (InterruptedException e14) {
                                    ReconnectionManager.LOGGER.log(Level.FINE, "Reconnection Thread was interrupted, aborting reconnection mechanism", e14);
                                    return;
                                }
                            }
                            abstractXMPPConnection.login();
                            return;
                        }
                        return;
                    }
                }
            }
        };
        if (getEnabledPerDefault()) {
            enableAutomaticReconnection();
        }
    }

    public static boolean getEnabledPerDefault() {
        return enabledPerDefault;
    }

    public static synchronized ReconnectionManager getInstanceFor(AbstractXMPPConnection abstractXMPPConnection) {
        ReconnectionManager reconnectionManager;
        synchronized (ReconnectionManager.class) {
            Map<AbstractXMPPConnection, ReconnectionManager> map = INSTANCES;
            reconnectionManager = map.get(abstractXMPPConnection);
            if (reconnectionManager == null) {
                reconnectionManager = new ReconnectionManager(abstractXMPPConnection);
                map.put(abstractXMPPConnection, reconnectionManager);
            }
        }
        return reconnectionManager;
    }

    /* access modifiers changed from: private */
    public boolean isReconnectionPossible(XMPPConnection xMPPConnection) {
        if (this.done || xMPPConnection.isConnected() || !isAutomaticReconnectEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public synchronized void reconnect() {
        XMPPConnection xMPPConnection = this.weakRefConnection.get();
        if (xMPPConnection == null) {
            LOGGER.fine("Connection is null, will not reconnect");
            return;
        }
        Thread thread = this.reconnectionThread;
        if (thread == null || !thread.isAlive()) {
            Runnable runnable = this.reconnectionRunnable;
            this.reconnectionThread = Async.go(runnable, "Smack Reconnection Manager (" + xMPPConnection.getConnectionCounter() + PropertyUtils.MAPPED_DELIM2);
        }
    }

    public static void setDefaultFixedDelay(int i10) {
        defaultFixedDelay = i10;
        setDefaultReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public static void setDefaultReconnectionPolicy(ReconnectionPolicy reconnectionPolicy2) {
        defaultReconnectionPolicy = reconnectionPolicy2;
    }

    public static void setEnabledPerDefault(boolean z10) {
        enabledPerDefault = z10;
    }

    public synchronized void abortPossiblyRunningReconnection() {
        Thread thread = this.reconnectionThread;
        if (thread != null) {
            thread.interrupt();
            this.reconnectionThread = null;
        }
    }

    public boolean addReconnectionListener(ReconnectionListener reconnectionListener) {
        return this.reconnectionListeners.add(reconnectionListener);
    }

    public synchronized void disableAutomaticReconnection() {
        if (this.automaticReconnectEnabled) {
            XMPPConnection xMPPConnection = this.weakRefConnection.get();
            if (xMPPConnection != null) {
                xMPPConnection.removeConnectionListener(this.connectionListener);
                this.automaticReconnectEnabled = false;
                return;
            }
            throw new IllegalStateException("Connection instance no longer available");
        }
    }

    public synchronized void enableAutomaticReconnection() {
        if (!this.automaticReconnectEnabled) {
            XMPPConnection xMPPConnection = this.weakRefConnection.get();
            if (xMPPConnection != null) {
                xMPPConnection.addConnectionListener(this.connectionListener);
                this.automaticReconnectEnabled = true;
                return;
            }
            throw new IllegalStateException("Connection instance no longer available");
        }
    }

    public synchronized boolean isAutomaticReconnectEnabled() {
        return this.automaticReconnectEnabled;
    }

    public boolean removeReconnectionListener(ReconnectionListener reconnectionListener) {
        return this.reconnectionListeners.remove(reconnectionListener);
    }

    public void setFixedDelay(int i10) {
        this.fixedDelay = i10;
        setReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public void setReconnectionPolicy(ReconnectionPolicy reconnectionPolicy2) {
        this.reconnectionPolicy = reconnectionPolicy2;
    }
}
