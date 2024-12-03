package org.jivesoftware.smack.debugger;

import org.jivesoftware.smack.util.ReaderListener;

public final /* synthetic */ class b implements ReaderListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SmackDebugger f24108a;

    public /* synthetic */ b(SmackDebugger smackDebugger) {
        this.f24108a = smackDebugger;
    }

    public final void read(String str) {
        this.f24108a.lambda$newConnectionReader$1(str);
    }
}
