package org.minidns.edns;

import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.edns.Edns;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f33729a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33730b;

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f33731c;

    /* renamed from: d  reason: collision with root package name */
    private String f33732d;

    /* renamed from: e  reason: collision with root package name */
    private String f33733e;

    /* renamed from: org.minidns.edns.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0392a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33734a;

        static {
            int[] iArr = new int[Edns.OptionCode.values().length];
            f33734a = iArr;
            try {
                iArr[Edns.OptionCode.NSID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected a(int i10, byte[] bArr) {
        this.f33729a = i10;
        this.f33730b = bArr.length;
        this.f33731c = bArr;
    }

    public static a d(int i10, byte[] bArr) {
        if (C0392a.f33734a[Edns.OptionCode.a(i10).ordinal()] != 1) {
            return new c(i10, bArr);
        }
        return new b(bArr);
    }

    public final String a() {
        if (this.f33733e == null) {
            this.f33733e = b().toString();
        }
        return this.f33733e;
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence b();

    public abstract Edns.OptionCode c();

    /* access modifiers changed from: protected */
    public abstract CharSequence e();

    public final void f(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f33729a);
        dataOutputStream.writeShort(this.f33730b);
        dataOutputStream.write(this.f33731c);
    }

    public final String toString() {
        if (this.f33732d == null) {
            this.f33732d = e().toString();
        }
        return this.f33732d;
    }

    protected a(byte[] bArr) {
        this.f33729a = c().asInt;
        this.f33730b = bArr.length;
        this.f33731c = bArr;
    }
}
