package org.jivesoftware.smack.internal;

import java.io.IOException;
import org.jivesoftware.smack.util.ExtendedAppendable;

public abstract class AbstractStats {
    private transient String toStringCache;

    public final void appendStatsTo(Appendable appendable) throws IOException {
        appendStatsTo(new ExtendedAppendable(appendable));
    }

    public abstract void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException;

    public final String toString() {
        String str = this.toStringCache;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            appendStatsTo((Appendable) sb2);
            String sb3 = sb2.toString();
            this.toStringCache = sb3;
            return sb3;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
