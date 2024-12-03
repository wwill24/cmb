package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import org.minidns.constants.DnssecConstants;

public abstract class i extends h {

    /* renamed from: c  reason: collision with root package name */
    public final int f41663c;

    /* renamed from: d  reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f41664d;

    /* renamed from: e  reason: collision with root package name */
    public final byte f41665e;

    /* renamed from: f  reason: collision with root package name */
    public final DnssecConstants.DigestAlgorithm f41666f;

    /* renamed from: g  reason: collision with root package name */
    public final byte f41667g;

    /* renamed from: h  reason: collision with root package name */
    protected final byte[] f41668h;

    protected static final class b {

        /* renamed from: a  reason: collision with root package name */
        protected final int f41669a;

        /* renamed from: b  reason: collision with root package name */
        protected final byte f41670b;

        /* renamed from: c  reason: collision with root package name */
        protected final byte f41671c;

        /* renamed from: d  reason: collision with root package name */
        protected final byte[] f41672d;

        private b(int i10, byte b10, byte b11, byte[] bArr) {
            this.f41669a = i10;
            this.f41670b = b10;
            this.f41671c = b11;
            this.f41672d = bArr;
        }
    }

    protected i(int i10, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b10, DnssecConstants.DigestAlgorithm digestAlgorithm, byte b11, byte[] bArr) {
        this.f41663c = i10;
        this.f41665e = b10;
        this.f41664d = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b10) : signatureAlgorithm;
        this.f41667g = b11;
        this.f41666f = digestAlgorithm == null ? DnssecConstants.DigestAlgorithm.a(b11) : digestAlgorithm;
        this.f41668h = bArr;
    }

    protected static b j(DataInputStream dataInputStream, int i10) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int i11 = i10 - 4;
        byte[] bArr = new byte[i11];
        if (dataInputStream.read(bArr) == i11) {
            return new b(readUnsignedShort, readByte, readByte2, bArr);
        }
        throw new IOException();
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f41663c);
        dataOutputStream.writeByte(this.f41665e);
        dataOutputStream.writeByte(this.f41667g);
        dataOutputStream.write(this.f41668h);
    }

    public boolean i(byte[] bArr) {
        return Arrays.equals(this.f41668h, bArr);
    }

    public String toString() {
        return this.f41663c + ' ' + this.f41664d + ' ' + this.f41666f + ' ' + new BigInteger(1, this.f41668h).toString(16).toUpperCase();
    }

    protected i(int i10, byte b10, byte b11, byte[] bArr) {
        this(i10, (DnssecConstants.SignatureAlgorithm) null, b10, (DnssecConstants.DigestAlgorithm) null, b11, bArr);
    }
}
