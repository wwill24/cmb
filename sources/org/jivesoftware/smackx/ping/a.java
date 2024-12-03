package org.jivesoftware.smackx.ping;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PingManager f24220a;

    public /* synthetic */ a(PingManager pingManager) {
        this.f24220a = pingManager;
    }

    public final void run() {
        this.f24220a.pingServerIfNecessary();
    }
}
