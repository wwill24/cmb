package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.Objects;

public abstract class Manager {
    final WeakReference<XMPPConnection> weakConnection;

    public Manager(XMPPConnection xMPPConnection) {
        Objects.requireNonNull(xMPPConnection, "XMPPConnection must not be null");
        this.weakConnection = new WeakReference<>(xMPPConnection);
    }

    protected static final ScheduledAction schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return schedule(runnable, j10, timeUnit, ScheduledAction.Kind.NonBlocking);
    }

    protected static final ScheduledAction scheduleBlocking(Runnable runnable, long j10, TimeUnit timeUnit) {
        return schedule(runnable, j10, timeUnit, ScheduledAction.Kind.Blocking);
    }

    /* access modifiers changed from: protected */
    public final XMPPConnection connection() {
        return this.weakConnection.get();
    }

    /* access modifiers changed from: protected */
    public final XMPPConnection getAuthenticatedConnectionOrThrow() throws SmackException.NotLoggedInException {
        XMPPConnection connection = connection();
        if (connection.isAuthenticated()) {
            return connection;
        }
        throw new SmackException.NotLoggedInException();
    }

    protected static final ScheduledAction schedule(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledAction.Kind kind) {
        return AbstractXMPPConnection.SMACK_REACTOR.schedule(runnable, j10, timeUnit, kind);
    }
}
