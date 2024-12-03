package org.minidns.dnsmessage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final DnsName f33653a;

    /* renamed from: b  reason: collision with root package name */
    public final Record.TYPE f33654b;

    /* renamed from: c  reason: collision with root package name */
    public final Record.CLASS f33655c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33656d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f33657e;

    public a(DnsName dnsName, Record.TYPE type, Record.CLASS classR, boolean z10) {
        this.f33653a = dnsName;
        this.f33654b = type;
        this.f33655c = classR;
        this.f33656d = z10;
    }

    public DnsMessage.b a() {
        DnsMessage.b d10 = DnsMessage.d();
        d10.A(this);
        return d10;
    }

    public byte[] b() {
        int i10;
        if (this.f33657e == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                this.f33653a.G(dataOutputStream);
                dataOutputStream.writeShort(this.f33654b.d());
                int b10 = this.f33655c.b();
                if (this.f33656d) {
                    i10 = 32768;
                } else {
                    i10 = 0;
                }
                dataOutputStream.writeShort(b10 | i10);
                dataOutputStream.flush();
                this.f33657e = byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
        return this.f33657e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(b(), ((a) obj).b());
    }

    public int hashCode() {
        return Arrays.hashCode(b());
    }

    public String toString() {
        return this.f33653a.q() + ".\t" + this.f33655c + 9 + this.f33654b;
    }

    public a(DnsName dnsName, Record.TYPE type, Record.CLASS classR) {
        this(dnsName, type, classR, false);
    }

    public a(DnsName dnsName, Record.TYPE type) {
        this(dnsName, type, Record.CLASS.IN);
    }

    public a(CharSequence charSequence, Record.TYPE type, Record.CLASS classR) {
        this(DnsName.b(charSequence), type, classR);
    }

    public a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        this.f33653a = DnsName.v(dataInputStream, bArr);
        this.f33654b = Record.TYPE.b(dataInputStream.readUnsignedShort());
        this.f33655c = Record.CLASS.a(dataInputStream.readUnsignedShort());
        this.f33656d = false;
    }
}
