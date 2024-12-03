package org.jivesoftware.smackx.disco;

import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jxmpp.jid.Jid;

public abstract class DiscoInfoLookupShortcutMechanism implements Comparable<DiscoInfoLookupShortcutMechanism> {
    private final String name;
    private final int priority;

    protected DiscoInfoLookupShortcutMechanism(String str, int i10) {
        this.name = str;
        this.priority = i10;
    }

    public abstract DiscoverInfo getDiscoverInfoByUser(ServiceDiscoveryManager serviceDiscoveryManager, Jid jid);

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int compareTo(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        return Integer.compare(getPriority(), discoInfoLookupShortcutMechanism.getPriority());
    }
}
