package org.jivesoftware.smack.fsm;

import java.util.List;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f24121a;

    public /* synthetic */ c(List list) {
        this.f24121a = list;
    }

    public final void accept(Object obj) {
        this.f24121a.add(0, (StateDescriptorGraph.GraphVertex) obj);
    }
}
