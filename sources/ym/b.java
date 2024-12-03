package ym;

import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.h;

public abstract class b extends h {

    /* renamed from: c  reason: collision with root package name */
    public final DnsName f42186c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public final DnsName f42187d;

    protected b(DnsName dnsName) {
        this.f42186c = dnsName;
        this.f42187d = dnsName;
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        this.f42186c.G(dataOutputStream);
    }

    public String toString() {
        return this.f42186c + ".";
    }
}
