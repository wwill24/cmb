package org.jivesoftware.smack;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24111a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f24112b;

    public /* synthetic */ e(AbstractXMPPConnection abstractXMPPConnection, Exception exc) {
        this.f24111a = abstractXMPPConnection;
        this.f24112b = exc;
    }

    public final void run() {
        this.f24111a.lambda$notifyConnectionError$5(this.f24112b);
    }
}
