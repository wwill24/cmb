package org.jivesoftware.smack.c2s;

import java.util.List;
import javax.net.ssl.SSLSession;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

public abstract class XmppClientToServerTransport {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;

    public interface LookupConnectionEndpointsFailed extends LookupConnectionEndpointsResult {
    }

    protected interface LookupConnectionEndpointsResult {
    }

    protected interface LookupConnectionEndpointsSuccess extends LookupConnectionEndpointsResult {
    }

    public static abstract class Stats {
    }

    protected XmppClientToServerTransport(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    /* access modifiers changed from: protected */
    public abstract void afterFiltersClosed();

    /* access modifiers changed from: protected */
    public abstract void disconnect();

    public abstract SSLSession getSslSession();

    public abstract Stats getStats();

    public abstract boolean isConnected();

    public boolean isTransportSecured() {
        return getSslSession() != null;
    }

    /* access modifiers changed from: protected */
    public abstract void loadConnectionEndpoints(LookupConnectionEndpointsSuccess lookupConnectionEndpointsSuccess);

    /* access modifiers changed from: protected */
    public abstract List<SmackFuture<LookupConnectionEndpointsResult, Exception>> lookupConnectionEndpoints();

    /* access modifiers changed from: protected */
    public abstract void notifyAboutNewOutgoingElements();

    /* access modifiers changed from: protected */
    public abstract void resetDiscoveredConnectionEndpoints();
}
