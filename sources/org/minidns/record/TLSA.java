package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TLSA extends h {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Map<Byte, CertUsage> f41633k = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Map<Byte, Selector> f41634l = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Map<Byte, MatchingType> f41635m = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final byte f41636c;

    /* renamed from: d  reason: collision with root package name */
    public final CertUsage f41637d;

    /* renamed from: e  reason: collision with root package name */
    public final byte f41638e;

    /* renamed from: f  reason: collision with root package name */
    public final Selector f41639f;

    /* renamed from: g  reason: collision with root package name */
    public final byte f41640g;

    /* renamed from: h  reason: collision with root package name */
    public final MatchingType f41641h;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f41642j;

    public enum CertUsage {
        caConstraint((byte) 0),
        serviceCertificateConstraint((byte) 1),
        trustAnchorAssertion((byte) 2),
        domainIssuedCertificate((byte) 3);
        
        public final byte byteValue;

        private CertUsage(byte b10) {
            this.byteValue = b10;
            TLSA.f41633k.put(Byte.valueOf(b10), this);
        }
    }

    public enum MatchingType {
        noHash((byte) 0),
        f41649b((byte) 1),
        sha512((byte) 2);
        
        public final byte byteValue;

        private MatchingType(byte b10) {
            this.byteValue = b10;
            TLSA.f41635m.put(Byte.valueOf(b10), this);
        }
    }

    public enum Selector {
        fullCertificate((byte) 0),
        subjectPublicKeyInfo((byte) 1);
        
        public final byte byteValue;

        private Selector(byte b10) {
            this.byteValue = b10;
            TLSA.f41634l.put(Byte.valueOf(b10), this);
        }
    }

    static {
        CertUsage.values();
        Selector.values();
        MatchingType.values();
    }

    TLSA(byte b10, byte b11, byte b12, byte[] bArr) {
        this.f41636c = b10;
        this.f41637d = f41633k.get(Byte.valueOf(b10));
        this.f41638e = b11;
        this.f41639f = f41634l.get(Byte.valueOf(b11));
        this.f41640g = b12;
        this.f41641h = f41635m.get(Byte.valueOf(b12));
        this.f41642j = bArr;
    }

    public static TLSA o(DataInputStream dataInputStream, int i10) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        byte readByte3 = dataInputStream.readByte();
        int i11 = i10 - 3;
        byte[] bArr = new byte[i11];
        if (dataInputStream.read(bArr) == i11) {
            return new TLSA(readByte, readByte2, readByte3, bArr);
        }
        throw new IOException();
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f41636c);
        dataOutputStream.writeByte(this.f41638e);
        dataOutputStream.writeByte(this.f41640g);
        dataOutputStream.write(this.f41642j);
    }

    public boolean l(byte[] bArr) {
        return Arrays.equals(this.f41642j, bArr);
    }

    public String toString() {
        return this.f41636c + ' ' + this.f41638e + ' ' + this.f41640g + ' ' + new BigInteger(1, this.f41642j).toString(16);
    }
}
