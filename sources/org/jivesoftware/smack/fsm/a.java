package org.jivesoftware.smack.fsm;

import java.io.PrintWriter;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrintWriter f24117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24118b;

    public /* synthetic */ a(PrintWriter printWriter, boolean z10) {
        this.f24117a = printWriter;
        this.f24118b = z10;
    }

    public final void accept(Object obj) {
        StateDescriptorGraph.lambda$stateDescriptorGraphToDot$1(this.f24117a, this.f24118b, (StateDescriptorGraph.GraphVertex) obj);
    }
}
