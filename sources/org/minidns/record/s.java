package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;

public class s extends h implements Comparable<s> {

    /* renamed from: c  reason: collision with root package name */
    public final int f41706c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41707d;

    /* renamed from: e  reason: collision with root package name */
    public final int f41708e;

    /* renamed from: f  reason: collision with root package name */
    public final DnsName f41709f;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public final DnsName f41710g;

    public s(int i10, int i11, int i12, DnsName dnsName) {
        this.f41706c = i10;
        this.f41707d = i11;
        this.f41708e = i12;
        this.f41709f = dnsName;
        this.f41710g = dnsName;
    }

    public static s j(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new s(dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), DnsName.v(dataInputStream, bArr));
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f41706c);
        dataOutputStream.writeShort(this.f41707d);
        dataOutputStream.writeShort(this.f41708e);
        this.f41709f.G(dataOutputStream);
    }

    /* renamed from: i */
    public int compareTo(s sVar) {
        int i10 = sVar.f41706c - this.f41706c;
        if (i10 == 0) {
            return this.f41707d - sVar.f41707d;
        }
        return i10;
    }

    public String toString() {
        return this.f41706c + " " + this.f41707d + " " + this.f41708e + " " + this.f41709f + ".";
    }
}
