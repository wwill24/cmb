package org.jivesoftware.smack;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24106a;

    public /* synthetic */ d(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24106a = abstractXMPPConnection;
    }

    public final Object get() {
        return this.f24106a.lambda$waitForClosingStreamTagFromServer$6();
    }
}
