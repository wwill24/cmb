package org.minidns.record;

import j$.util.DesugarTimeZone;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smack.datatypes.UInt32;
import org.minidns.constants.DnssecConstants;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;
import zm.b;

public class q extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Record.TYPE f41688c;

    /* renamed from: d  reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f41689d;

    /* renamed from: e  reason: collision with root package name */
    public final byte f41690e;

    /* renamed from: f  reason: collision with root package name */
    public final byte f41691f;

    /* renamed from: g  reason: collision with root package name */
    public final long f41692g;

    /* renamed from: h  reason: collision with root package name */
    public final Date f41693h;

    /* renamed from: j  reason: collision with root package name */
    public final Date f41694j;

    /* renamed from: k  reason: collision with root package name */
    public final int f41695k;

    /* renamed from: l  reason: collision with root package name */
    public final DnsName f41696l;

    /* renamed from: m  reason: collision with root package name */
    private final byte[] f41697m;

    /* renamed from: n  reason: collision with root package name */
    private transient String f41698n;

    private q(Record.TYPE type, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b10, byte b11, long j10, Date date, Date date2, int i10, DnsName dnsName, byte[] bArr) {
        this.f41688c = type;
        this.f41690e = b10;
        this.f41689d = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b10) : signatureAlgorithm;
        this.f41691f = b11;
        this.f41692g = j10;
        this.f41693h = date;
        this.f41694j = date2;
        this.f41695k = i10;
        this.f41696l = dnsName;
        this.f41697m = bArr;
    }

    public static q l(DataInputStream dataInputStream, byte[] bArr, int i10) throws IOException {
        Record.TYPE b10 = Record.TYPE.b(dataInputStream.readUnsignedShort());
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        long readInt = ((long) dataInputStream.readInt()) & UInt32.MAX_VALUE_LONG;
        Date date = new Date((((long) dataInputStream.readInt()) & UInt32.MAX_VALUE_LONG) * 1000);
        Date date2 = new Date((UInt32.MAX_VALUE_LONG & ((long) dataInputStream.readInt())) * 1000);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        DnsName v10 = DnsName.v(dataInputStream, bArr);
        int A = (i10 - v10.A()) - 18;
        byte[] bArr2 = new byte[A];
        if (dataInputStream.read(bArr2) == A) {
            return new q(b10, (DnssecConstants.SignatureAlgorithm) null, readByte, readByte2, readInt, date, date2, readUnsignedShort, v10, bArr2);
        }
        throw new IOException();
    }

    public Record.TYPE a() {
        return Record.TYPE.RRSIG;
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        o(dataOutputStream);
        dataOutputStream.write(this.f41697m);
    }

    public byte[] i() {
        return (byte[]) this.f41697m.clone();
    }

    public DataInputStream j() {
        return new DataInputStream(new ByteArrayInputStream(this.f41697m));
    }

    public String k() {
        if (this.f41698n == null) {
            this.f41698n = b.a(this.f41697m);
        }
        return this.f41698n;
    }

    public void o(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f41688c.d());
        dataOutputStream.writeByte(this.f41690e);
        dataOutputStream.writeByte(this.f41691f);
        dataOutputStream.writeInt((int) this.f41692g);
        dataOutputStream.writeInt((int) (this.f41693h.getTime() / 1000));
        dataOutputStream.writeInt((int) (this.f41694j.getTime() / 1000));
        dataOutputStream.writeShort(this.f41695k);
        this.f41696l.G(dataOutputStream);
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return this.f41688c + ' ' + this.f41689d + ' ' + this.f41691f + ' ' + this.f41692g + ' ' + simpleDateFormat.format(this.f41693h) + ' ' + simpleDateFormat.format(this.f41694j) + ' ' + this.f41695k + ' ' + this.f41696l + ". " + k();
    }
}
