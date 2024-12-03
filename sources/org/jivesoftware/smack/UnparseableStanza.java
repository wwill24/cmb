package org.jivesoftware.smack;

public class UnparseableStanza {
    private final CharSequence content;

    /* renamed from: e  reason: collision with root package name */
    private final Exception f24096e;

    UnparseableStanza(CharSequence charSequence, Exception exc) {
        this.content = charSequence;
        this.f24096e = exc;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public Exception getParsingException() {
        return this.f24096e;
    }
}
