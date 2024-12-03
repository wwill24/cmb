package org.jivesoftware.smack;

import java.util.concurrent.Executor;

public final /* synthetic */ class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24099a;

    public /* synthetic */ b(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24099a = abstractXMPPConnection;
    }

    public final void execute(Runnable runnable) {
        this.f24099a.asyncGoLimited(runnable);
    }
}
