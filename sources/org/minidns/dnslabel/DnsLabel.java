package org.minidns.dnslabel;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public abstract class DnsLabel implements CharSequence, Comparable<DnsLabel> {

    /* renamed from: d  reason: collision with root package name */
    public static final DnsLabel f33576d = c("*");

    /* renamed from: e  reason: collision with root package name */
    public static boolean f33577e = true;

    /* renamed from: a  reason: collision with root package name */
    public final String f33578a;

    /* renamed from: b  reason: collision with root package name */
    private transient DnsLabel f33579b;

    /* renamed from: c  reason: collision with root package name */
    private transient byte[] f33580c;

    public static class LabelToLongException extends IllegalArgumentException {
        private static final long serialVersionUID = 1;
        public final String label;

        LabelToLongException(String str) {
            this.label = str;
        }
    }

    protected DnsLabel(String str) {
        this.f33578a = str;
        if (f33577e) {
            e();
            if (this.f33580c.length > 63) {
                throw new LabelToLongException(str);
            }
        }
    }

    public static DnsLabel c(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Label is null or empty");
        } else if (c.j(str)) {
            return c.i(str);
        } else {
            return e.i(str);
        }
    }

    public static DnsLabel[] d(String[] strArr) {
        DnsLabel[] dnsLabelArr = new DnsLabel[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            dnsLabelArr[i10] = c(strArr[i10]);
        }
        return dnsLabelArr;
    }

    private void e() {
        if (this.f33580c == null) {
            this.f33580c = this.f33578a.getBytes(StandardCharsets.US_ASCII);
        }
    }

    public final DnsLabel a() {
        if (this.f33579b == null) {
            this.f33579b = c(this.f33578a.toLowerCase(Locale.US));
        }
        return this.f33579b;
    }

    /* renamed from: b */
    public final int compareTo(DnsLabel dnsLabel) {
        return a().f33578a.compareTo(dnsLabel.a().f33578a);
    }

    public final char charAt(int i10) {
        return this.f33578a.charAt(i10);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DnsLabel)) {
            return false;
        }
        return this.f33578a.equals(((DnsLabel) obj).f33578a);
    }

    public final void h(ByteArrayOutputStream byteArrayOutputStream) {
        e();
        byteArrayOutputStream.write(this.f33580c.length);
        byte[] bArr = this.f33580c;
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public final int hashCode() {
        return this.f33578a.hashCode();
    }

    public final int length() {
        return this.f33578a.length();
    }

    public final CharSequence subSequence(int i10, int i11) {
        return this.f33578a.subSequence(i10, i11);
    }

    public final String toString() {
        return this.f33578a;
    }
}
