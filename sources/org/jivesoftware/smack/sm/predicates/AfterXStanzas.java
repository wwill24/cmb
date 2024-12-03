package org.jivesoftware.smack.sm.predicates;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

public class AfterXStanzas implements StanzaFilter {
    final int count;
    int currentCount = 0;

    public AfterXStanzas(int i10) {
        this.count = i10;
    }

    public synchronized boolean accept(Stanza stanza) {
        int i10 = this.currentCount + 1;
        this.currentCount = i10;
        if (i10 != this.count) {
            return false;
        }
        resetCounter();
        return true;
    }

    public synchronized void resetCounter() {
        this.currentCount = 0;
    }
}
