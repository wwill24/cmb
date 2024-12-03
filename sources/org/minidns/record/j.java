package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;

public class j extends h {

    /* renamed from: c  reason: collision with root package name */
    public final int f41673c;

    /* renamed from: d  reason: collision with root package name */
    public final DnsName f41674d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public final DnsName f41675e;

    public j(int i10, DnsName dnsName) {
        this.f41673c = i10;
        this.f41674d = dnsName;
        this.f41675e = dnsName;
    }

    public static j i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new j(dataInputStream.readUnsignedShort(), DnsName.v(dataInputStream, bArr));
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f41673c);
        this.f41674d.G(dataOutputStream);
    }

    public String toString() {
        return this.f41673c + " " + this.f41674d + '.';
    }
}
