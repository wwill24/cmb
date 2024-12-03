package org.jivesoftware.smack.debugger;

import org.jivesoftware.smack.util.WriterListener;

public final /* synthetic */ class d implements WriterListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SmackDebugger f24110a;

    public /* synthetic */ d(SmackDebugger smackDebugger) {
        this.f24110a = smackDebugger;
    }

    public final void write(String str) {
        this.f24110a.lambda$newConnectionWriter$3(str);
    }
}
