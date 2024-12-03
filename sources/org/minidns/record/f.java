package org.minidns.record;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.minidns.constants.DnssecConstants;
import zm.b;

public class f extends h {

    /* renamed from: c  reason: collision with root package name */
    public final short f41655c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f41656d;

    /* renamed from: e  reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f41657e;

    /* renamed from: f  reason: collision with root package name */
    public final byte f41658f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f41659g;

    /* renamed from: h  reason: collision with root package name */
    private transient Integer f41660h;

    private f(short s10, byte b10, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b11, byte[] bArr) {
        this.f41655c = s10;
        this.f41656d = b10;
        this.f41658f = b11;
        this.f41657e = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b11) : signatureAlgorithm;
        this.f41659g = bArr;
    }

    public static f p(DataInputStream dataInputStream, int i10) throws IOException {
        short readShort = dataInputStream.readShort();
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        byte[] bArr = new byte[(i10 - 4)];
        dataInputStream.readFully(bArr);
        return new f(readShort, readByte, readByte2, bArr);
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f41655c);
        dataOutputStream.writeByte(this.f41656d);
        dataOutputStream.writeByte(this.f41657e.number);
        dataOutputStream.write(this.f41659g);
    }

    public byte[] i() {
        return (byte[]) this.f41659g.clone();
    }

    public DataInputStream j() {
        return new DataInputStream(new ByteArrayInputStream(this.f41659g));
    }

    public int k() {
        return this.f41659g.length;
    }

    public int l() {
        long j10;
        if (this.f41660h == null) {
            byte[] e10 = e();
            long j11 = 0;
            for (int i10 = 0; i10 < e10.length; i10++) {
                if ((i10 & 1) > 0) {
                    j10 = ((long) e10[i10]) & 255;
                } else {
                    j10 = (((long) e10[i10]) & 255) << 8;
                }
                j11 += j10;
            }
            this.f41660h = Integer.valueOf((int) ((j11 + ((j11 >> 16) & 65535)) & 65535));
        }
        return this.f41660h.intValue();
    }

    public boolean o(byte[] bArr) {
        return Arrays.equals(this.f41659g, bArr);
    }

    public String toString() {
        return this.f41655c + ' ' + this.f41656d + ' ' + this.f41657e + ' ' + b.a(this.f41659g);
    }

    public f(short s10, byte b10, byte b11, byte[] bArr) {
        this(s10, b10, DnssecConstants.SignatureAlgorithm.a(b11), bArr);
    }

    public f(short s10, byte b10, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this(s10, b10, signatureAlgorithm, signatureAlgorithm.number, bArr);
    }
}
