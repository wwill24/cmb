package org.jivesoftware.smack.util;

import java.util.List;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f24197a;

    public /* synthetic */ s(List list) {
        this.f24197a = list;
    }

    public final void accept(Object obj) {
        this.f24197a.add((CharSequence) obj);
    }
}
