package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.jivesoftware.smack.datatypes.UInt32;
import org.minidns.dnsname.DnsName;

public class r extends h {

    /* renamed from: c  reason: collision with root package name */
    public final DnsName f41699c;

    /* renamed from: d  reason: collision with root package name */
    public final DnsName f41700d;

    /* renamed from: e  reason: collision with root package name */
    public final long f41701e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41702f;

    /* renamed from: g  reason: collision with root package name */
    public final int f41703g;

    /* renamed from: h  reason: collision with root package name */
    public final int f41704h;

    /* renamed from: j  reason: collision with root package name */
    public final long f41705j;

    public r(DnsName dnsName, DnsName dnsName2, long j10, int i10, int i11, int i12, long j11) {
        this.f41699c = dnsName;
        this.f41700d = dnsName2;
        this.f41701e = j10;
        this.f41702f = i10;
        this.f41703g = i11;
        this.f41704h = i12;
        this.f41705j = j11;
    }

    public static r i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new r(DnsName.v(dataInputStream, bArr), DnsName.v(dataInputStream, bArr), ((long) dataInputStream.readInt()) & UInt32.MAX_VALUE_LONG, dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt(), ((long) dataInputStream.readInt()) & UInt32.MAX_VALUE_LONG);
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        this.f41699c.G(dataOutputStream);
        this.f41700d.G(dataOutputStream);
        dataOutputStream.writeInt((int) this.f41701e);
        dataOutputStream.writeInt(this.f41702f);
        dataOutputStream.writeInt(this.f41703g);
        dataOutputStream.writeInt(this.f41704h);
        dataOutputStream.writeInt((int) this.f41705j);
    }

    public String toString() {
        return this.f41699c + ". " + this.f41700d + ". " + this.f41701e + ' ' + this.f41702f + ' ' + this.f41703g + ' ' + this.f41704h + ' ' + this.f41705j;
    }
}
