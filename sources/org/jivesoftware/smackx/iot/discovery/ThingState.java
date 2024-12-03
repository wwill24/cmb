package org.jivesoftware.smackx.iot.discovery;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.BareJid;

public class ThingState {
    /* access modifiers changed from: private */
    public final List<ThingStateChangeListener> listeners = new CopyOnWriteArrayList();
    private final NodeInfo nodeInfo;
    private BareJid owner;
    private BareJid registry;
    private boolean removed;

    ThingState(NodeInfo nodeInfo2) {
        this.nodeInfo = nodeInfo2;
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public BareJid getOwner() {
        return this.owner;
    }

    public BareJid getRegistry() {
        return this.registry;
    }

    public boolean isOwned() {
        return this.owner != null;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public boolean removeThingStateChangeListener(ThingStateChangeListener thingStateChangeListener) {
        return this.listeners.remove(thingStateChangeListener);
    }

    /* access modifiers changed from: package-private */
    public void setOwner(final BareJid bareJid) {
        this.owner = bareJid;
        Async.go(new Runnable() {
            public void run() {
                for (ThingStateChangeListener owned : ThingState.this.listeners) {
                    owned.owned(bareJid);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setRegistry(BareJid bareJid) {
        this.registry = bareJid;
    }

    /* access modifiers changed from: package-private */
    public void setRemoved() {
        this.removed = true;
    }

    public boolean setThingStateChangeListener(ThingStateChangeListener thingStateChangeListener) {
        return this.listeners.add(thingStateChangeListener);
    }

    /* access modifiers changed from: package-private */
    public void setUnowned() {
        this.owner = null;
    }

    /* access modifiers changed from: package-private */
    public void setUnregistered() {
        this.registry = null;
    }
}
