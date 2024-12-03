package org.jivesoftware.smack.fsm;

import java.io.PrintWriter;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;

public final /* synthetic */ class b implements StateDescriptorGraph.DfsEdgeFound {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrintWriter f24119a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24120b;

    public /* synthetic */ b(PrintWriter printWriter, boolean z10) {
        this.f24119a = printWriter;
        this.f24120b = z10;
    }

    public final void onEdgeFound(StateDescriptorGraph.GraphVertex graphVertex, StateDescriptorGraph.GraphVertex graphVertex2, int i10, int i11) {
        StateDescriptorGraph.lambda$stateDescriptorGraphToDot$2(this.f24119a, this.f24120b, graphVertex, graphVertex2, i10, i11);
    }
}
