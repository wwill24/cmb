package org.jivesoftware.smack.util;

import java.util.List;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f24190a;

    public /* synthetic */ i(Object obj) {
        this.f24190a = obj;
    }

    public final void accept(Object obj) {
        ((List) obj).add(this.f24190a);
    }
}
