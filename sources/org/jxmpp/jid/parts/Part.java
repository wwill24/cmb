package org.jxmpp.jid.parts;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class Part implements CharSequence, Serializable {
    private static final long serialVersionUID = 1;
    private final String part;

    protected Part(String str) {
        this.part = str;
    }

    protected static void a(String str) throws XmppStringprepException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 1023) {
            throw new XmppStringprepException(str, "Given string is longer then 1023 bytes");
        } else if (bytes.length == 0) {
            throw new XmppStringprepException(str, "Argument can't be the empty string");
        }
    }

    public final char charAt(int i10) {
        return this.part.charAt(i10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.part.equals(obj.toString());
    }

    public final int hashCode() {
        return this.part.hashCode();
    }

    public final int length() {
        return this.part.length();
    }

    public final CharSequence subSequence(int i10, int i11) {
        return this.part.subSequence(i10, i11);
    }

    public final String toString() {
        return this.part;
    }
}
