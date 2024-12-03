package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import org.minidns.record.Record;
import zm.a;

public class NSEC3 extends h {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Map<Byte, HashAlgorithm> f41558l = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashAlgorithm f41559c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f41560d;

    /* renamed from: e  reason: collision with root package name */
    public final byte f41561e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41562f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f41563g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f41564h;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f41565j;

    /* renamed from: k  reason: collision with root package name */
    public final List<Record.TYPE> f41566k;

    public enum HashAlgorithm {
        RESERVED(0, "Reserved"),
        SHA1(1, "SHA-1");
        
        public final String description;
        public final byte value;

        private HashAlgorithm(int i10, String str) {
            if (i10 < 0 || i10 > 255) {
                throw new IllegalArgumentException();
            }
            byte b10 = (byte) i10;
            this.value = b10;
            this.description = str;
            NSEC3.f41558l.put(Byte.valueOf(b10), this);
        }

        public static HashAlgorithm a(byte b10) {
            return (HashAlgorithm) NSEC3.f41558l.get(Byte.valueOf(b10));
        }
    }

    private NSEC3(HashAlgorithm hashAlgorithm, byte b10, byte b11, int i10, byte[] bArr, byte[] bArr2, List<Record.TYPE> list) {
        this.f41560d = b10;
        this.f41559c = hashAlgorithm == null ? HashAlgorithm.a(b10) : hashAlgorithm;
        this.f41561e = b11;
        this.f41562f = i10;
        this.f41563g = bArr;
        this.f41564h = bArr2;
        this.f41566k = list;
        this.f41565j = m.i(list);
    }

    public static NSEC3 l(DataInputStream dataInputStream, int i10) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[readUnsignedByte];
        if (dataInputStream.read(bArr) == readUnsignedByte) {
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            byte[] bArr2 = new byte[readUnsignedByte2];
            if (dataInputStream.read(bArr2) == readUnsignedByte2) {
                int i11 = i10 - ((readUnsignedByte + 6) + readUnsignedByte2);
                byte[] bArr3 = new byte[i11];
                if (dataInputStream.read(bArr3) == i11) {
                    return new NSEC3(readByte, readByte2, readUnsignedShort, bArr, bArr2, m.k(bArr3));
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    public Record.TYPE a() {
        return Record.TYPE.NSEC3;
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f41560d);
        dataOutputStream.writeByte(this.f41561e);
        dataOutputStream.writeShort(this.f41562f);
        dataOutputStream.writeByte(this.f41563g.length);
        dataOutputStream.write(this.f41563g);
        dataOutputStream.writeByte(this.f41564h.length);
        dataOutputStream.write(this.f41564h);
        dataOutputStream.write(this.f41565j);
    }

    public byte[] j() {
        return (byte[]) this.f41564h.clone();
    }

    public byte[] k() {
        return (byte[]) this.f41563g.clone();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f41559c);
        sb2.append(' ');
        sb2.append(this.f41561e);
        sb2.append(' ');
        sb2.append(this.f41562f);
        sb2.append(' ');
        if (this.f41563g.length == 0) {
            str = HelpFormatter.DEFAULT_OPT_PREFIX;
        } else {
            str = new BigInteger(1, this.f41563g).toString(16).toUpperCase();
        }
        sb2.append(str);
        sb2.append(' ');
        sb2.append(a.a(this.f41564h));
        for (Record.TYPE append : this.f41566k) {
            sb2.append(' ');
            sb2.append(append);
        }
        return sb2.toString();
    }

    public NSEC3(byte b10, byte b11, int i10, byte[] bArr, byte[] bArr2, List<Record.TYPE> list) {
        this((HashAlgorithm) null, b10, b11, i10, bArr, bArr2, list);
    }
}
