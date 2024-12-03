package org.jivesoftware.smack;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24113a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f24114b;

    public /* synthetic */ f(AbstractXMPPConnection abstractXMPPConnection, Supplier supplier) {
        this.f24113a = abstractXMPPConnection;
        this.f24114b = supplier;
    }

    public final Object get() {
        return this.f24113a.lambda$waitForConditionOrConnectionException$3(this.f24114b);
    }
}
