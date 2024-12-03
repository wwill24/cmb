package org.bouncycastle.asn1.x500.style;

public class X500NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char separator;
    private String value;

    public X500NameTokenizer(String str) {
        this(str, ',');
    }

    public X500NameTokenizer(String str, char c10) {
        this.buf = new StringBuffer();
        this.value = str;
        this.index = -1;
        this.separator = c10;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    public String nextToken() {
        if (this.index == this.value.length()) {
            return null;
        }
        int i10 = this.index + 1;
        this.buf.setLength(0);
        boolean z10 = false;
        boolean z11 = false;
        while (i10 != this.value.length()) {
            char charAt = this.value.charAt(i10);
            if (charAt == '\"') {
                if (!z10) {
                    z11 = !z11;
                }
            } else if (!z10 && !z11) {
                if (charAt == '\\') {
                    this.buf.append(charAt);
                    z10 = true;
                } else if (charAt == this.separator) {
                    break;
                } else {
                    this.buf.append(charAt);
                }
                i10++;
            }
            this.buf.append(charAt);
            z10 = false;
            i10++;
        }
        this.index = i10;
        return this.buf.toString();
    }
}
