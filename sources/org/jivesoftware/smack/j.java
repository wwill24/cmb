package org.jivesoftware.smack;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24125a;

    public /* synthetic */ j(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24125a = abstractXMPPConnection;
    }

    public final Object get() {
        return this.f24125a.lambda$bindResourceAndEstablishSession$4();
    }
}
