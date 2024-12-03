package org.jivesoftware.smack.util;

import java.io.IOException;

public class ExtendedAppendable implements Appendable {
    private final Appendable appendable;

    public ExtendedAppendable(Appendable appendable2) {
        this.appendable = appendable2;
    }

    public ExtendedAppendable append(CharSequence charSequence) throws IOException {
        this.appendable.append(charSequence);
        return this;
    }

    public ExtendedAppendable append(CharSequence charSequence, int i10, int i11) throws IOException {
        this.appendable.append(charSequence, i10, i11);
        return this;
    }

    public ExtendedAppendable append(char c10) throws IOException {
        this.appendable.append(c10);
        return this;
    }

    public ExtendedAppendable append(boolean z10) throws IOException {
        this.appendable.append(String.valueOf(z10));
        return this;
    }

    public ExtendedAppendable append(int i10) throws IOException {
        this.appendable.append(String.valueOf(i10));
        return this;
    }
}
