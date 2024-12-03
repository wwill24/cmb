package org.jivesoftware.smackx.ping;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.jxmpp.jid.Jid;

public final class PingManager extends Manager {
    private static final Map<XMPPConnection, PingManager> INSTANCES = new WeakHashMap();
    private static final Logger LOGGER = Logger.getLogger(PingManager.class.getName());
    private static int defaultPingInterval = 1800;
    private ScheduledAction nextAutomaticPing;
    /* access modifiers changed from: private */
    public final Set<PingFailedListener> pingFailedListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public int pingInterval = defaultPingInterval;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PingManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private PingManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(Ping.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(Ping.ELEMENT, Ping.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                return ((Ping) iq).getPong();
            }
        });
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                PingManager.this.maybeSchedulePingServerTask();
            }

            public void connectionTerminated() {
                PingManager.this.maybeStopPingServerTask();
            }
        });
        maybeSchedulePingServerTask();
    }

    public static synchronized PingManager getInstanceFor(XMPPConnection xMPPConnection) {
        PingManager pingManager;
        synchronized (PingManager.class) {
            Map<XMPPConnection, PingManager> map = INSTANCES;
            pingManager = map.get(xMPPConnection);
            if (pingManager == null) {
                pingManager = new PingManager(xMPPConnection);
                map.put(xMPPConnection, pingManager);
            }
        }
        return pingManager;
    }

    /* access modifiers changed from: private */
    public boolean isValidErrorPong(Jid jid, XMPPException.XMPPErrorException xMPPErrorException) {
        if (jid.Y(connection().getXMPPServiceDomain())) {
            return true;
        }
        StanzaError stanzaError = xMPPErrorException.getStanzaError();
        StanzaError.Type type = stanzaError.getType();
        StanzaError.Condition condition = stanzaError.getCondition();
        if (type == StanzaError.Type.CANCEL && condition == StanzaError.Condition.feature_not_implemented) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void maybeSchedulePingServerTask() {
        maybeSchedulePingServerTask(0);
    }

    /* access modifiers changed from: private */
    public void maybeStopPingServerTask() {
        ScheduledAction scheduledAction = this.nextAutomaticPing;
        if (scheduledAction != null) {
            scheduledAction.cancel();
            this.nextAutomaticPing = null;
        }
    }

    public static void setDefaultPingInterval(int i10) {
        defaultPingInterval = i10;
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public boolean isPingSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Ping.NAMESPACE);
    }

    public boolean ping(Jid jid, long j10) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException {
        XMPPConnection connection = connection();
        if (connection.isAuthenticated()) {
            try {
                connection.createStanzaCollectorAndSend(new Ping(connection, jid)).nextResultOrThrow(j10);
                return true;
            } catch (XMPPException.XMPPErrorException e10) {
                return isValidErrorPong(jid, e10);
            }
        } else {
            throw new SmackException.NotConnectedException();
        }
    }

    public SmackFuture<Boolean, Exception> pingAsync(Jid jid) {
        return pingAsync(jid, connection().getReplyTimeout());
    }

    public boolean pingMyServer() throws SmackException.NotConnectedException, InterruptedException {
        return pingMyServer(true);
    }

    public void pingServerIfNecessary() {
        int currentTimeMillis;
        final XMPPConnection connection = connection();
        if (connection != null && this.pingInterval > 0) {
            long lastStanzaReceived = connection.getLastStanzaReceived();
            if (lastStanzaReceived > 0 && (currentTimeMillis = (int) ((System.currentTimeMillis() - lastStanzaReceived) / 1000)) < this.pingInterval) {
                maybeSchedulePingServerTask(currentTimeMillis);
            } else if (!connection.isAuthenticated()) {
                Logger logger = LOGGER;
                logger.warning(connection + " was not authenticated");
            } else {
                long millis = TimeUnit.MINUTES.toMillis(2);
                long replyTimeout = connection.getReplyTimeout();
                if (replyTimeout > millis) {
                    millis = replyTimeout;
                }
                SmackFuture<Boolean, Exception> pingAsync = pingAsync(connection.getXMPPServiceDomain(), millis);
                pingAsync.onSuccess(new SuccessCallback<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        PingManager.this.maybeSchedulePingServerTask();
                    }
                });
                pingAsync.onError(new ExceptionCallback<Exception>() {
                    public void processException(Exception exc) {
                        int currentTimeMillis;
                        long lastStanzaReceived = connection.getLastStanzaReceived();
                        if (lastStanzaReceived <= 0 || (currentTimeMillis = (int) ((System.currentTimeMillis() - lastStanzaReceived) / 1000)) >= PingManager.this.pingInterval) {
                            for (PingFailedListener pingFailed : PingManager.this.pingFailedListeners) {
                                pingFailed.pingFailed();
                            }
                            return;
                        }
                        PingManager.this.maybeSchedulePingServerTask(currentTimeMillis);
                    }
                });
            }
        }
    }

    public void registerPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.add(pingFailedListener);
    }

    public void setPingInterval(int i10) {
        this.pingInterval = i10;
        maybeSchedulePingServerTask();
    }

    public void unregisterPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.remove(pingFailedListener);
    }

    /* access modifiers changed from: private */
    public synchronized void maybeSchedulePingServerTask(int i10) {
        maybeStopPingServerTask();
        int i11 = this.pingInterval;
        if (i11 > 0) {
            int i12 = i11 - i10;
            Logger logger = LOGGER;
            logger.fine("Scheduling ServerPingTask in " + i12 + " seconds (pingInterval=" + this.pingInterval + ", delta=" + i10 + ")");
            this.nextAutomaticPing = Manager.schedule(new a(this), (long) i12, TimeUnit.SECONDS);
        }
    }

    public SmackFuture<Boolean, Exception> pingAsync(final Jid jid, long j10) {
        final AnonymousClass4 r02 = new SmackFuture.InternalProcessStanzaSmackFuture<Boolean, Exception>() {
            public void handleStanza(Stanza stanza) {
                setResult(Boolean.TRUE);
            }

            public boolean isNonFatalException(Exception exc) {
                if (!(exc instanceof XMPPException.XMPPErrorException)) {
                    return false;
                }
                if (!PingManager.this.isValidErrorPong(jid, (XMPPException.XMPPErrorException) exc)) {
                    return false;
                }
                setResult(Boolean.TRUE);
                return true;
            }
        };
        XMPPConnection connection = connection();
        connection.sendIqRequestAsync(new Ping(connection, jid), j10).onSuccess(new SuccessCallback<IQ>() {
            public void onSuccess(IQ iq) {
                r02.processStanza(iq);
            }
        }).onError(new ExceptionCallback<Exception>() {
            public void processException(Exception exc) {
                r02.processException(exc);
            }
        });
        return r02;
    }

    public boolean pingMyServer(boolean z10) throws SmackException.NotConnectedException, InterruptedException {
        return pingMyServer(z10, connection().getReplyTimeout());
    }

    public boolean pingMyServer(boolean z10, long j10) throws SmackException.NotConnectedException, InterruptedException {
        boolean z11;
        try {
            z11 = ping(connection().getXMPPServiceDomain(), j10);
        } catch (SmackException.NoResponseException unused) {
            z11 = false;
        }
        if (!z11 && z10) {
            for (PingFailedListener pingFailed : this.pingFailedListeners) {
                pingFailed.pingFailed();
            }
        }
        return z11;
    }

    public boolean ping(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException {
        return ping(jid, connection().getReplyTimeout());
    }
}
