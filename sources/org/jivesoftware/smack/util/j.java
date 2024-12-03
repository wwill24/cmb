package org.jivesoftware.smack.util;

import java.util.List;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f24191a;

    public /* synthetic */ j(Object obj) {
        this.f24191a = obj;
    }

    public final void accept(Object obj) {
        ((List) obj).add(0, this.f24191a);
    }
}
