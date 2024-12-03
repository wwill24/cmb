package org.jivesoftware.smack.compression;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XmppInputOutputFilter;

public abstract class XmppCompressionFactory implements Comparable<XmppCompressionFactory> {
    private final String method;
    private final int priority;

    protected XmppCompressionFactory(String str, int i10) {
        this.method = str;
        this.priority = i10;
    }

    public abstract XmppInputOutputFilter fabricate(ConnectionConfiguration connectionConfiguration);

    public final String getCompressionMethod() {
        return this.method;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int compareTo(XmppCompressionFactory xmppCompressionFactory) {
        return Integer.compare(getPriority(), xmppCompressionFactory.getPriority());
    }
}
