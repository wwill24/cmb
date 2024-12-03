package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.commons.cli.HelpFormatter;
import org.minidns.record.NSEC3;

public class l extends h {

    /* renamed from: c  reason: collision with root package name */
    public final NSEC3.HashAlgorithm f41676c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f41677d;

    /* renamed from: e  reason: collision with root package name */
    public final byte f41678e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41679f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f41680g;

    private l(NSEC3.HashAlgorithm hashAlgorithm, byte b10, byte b11, int i10, byte[] bArr) {
        this.f41677d = b10;
        this.f41676c = hashAlgorithm == null ? NSEC3.HashAlgorithm.a(b10) : hashAlgorithm;
        this.f41678e = b11;
        this.f41679f = i10;
        this.f41680g = bArr;
    }

    public static l i(DataInputStream dataInputStream) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[readUnsignedByte];
        if (dataInputStream.read(bArr) == readUnsignedByte || readUnsignedByte == 0) {
            return new l(readByte, readByte2, readUnsignedShort, bArr);
        }
        throw new IOException();
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f41677d);
        dataOutputStream.writeByte(this.f41678e);
        dataOutputStream.writeShort(this.f41679f);
        dataOutputStream.writeByte(this.f41680g.length);
        dataOutputStream.write(this.f41680g);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f41676c);
        sb2.append(' ');
        sb2.append(this.f41678e);
        sb2.append(' ');
        sb2.append(this.f41679f);
        sb2.append(' ');
        if (this.f41680g.length == 0) {
            str = HelpFormatter.DEFAULT_OPT_PREFIX;
        } else {
            str = new BigInteger(1, this.f41680g).toString(16).toUpperCase();
        }
        sb2.append(str);
        return sb2.toString();
    }

    l(byte b10, byte b11, int i10, byte[] bArr) {
        this((NSEC3.HashAlgorithm) null, b10, b11, i10, bArr);
    }
}
