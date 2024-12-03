package org.minidns.edns;

import java.nio.charset.StandardCharsets;
import org.minidns.edns.Edns;
import zm.d;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final b f33735f = new b();

    private b() {
        this(new byte[0]);
    }

    /* access modifiers changed from: protected */
    public CharSequence b() {
        return d.a(this.f33731c);
    }

    public Edns.OptionCode c() {
        return Edns.OptionCode.NSID;
    }

    /* access modifiers changed from: protected */
    public CharSequence e() {
        return (Edns.OptionCode.NSID + ": ") + new String(this.f33731c, StandardCharsets.US_ASCII);
    }

    public b(byte[] bArr) {
        super(bArr);
    }
}
