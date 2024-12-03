package org.minidns.dnsname;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsname.InvalidDnsNameException;
import xm.c;

public final class DnsName implements CharSequence, Serializable, Comparable<DnsName> {

    /* renamed from: g  reason: collision with root package name */
    public static final DnsName f33658g = new DnsName(".");

    /* renamed from: h  reason: collision with root package name */
    public static final DnsName f33659h = new DnsName("in-addr.arpa");

    /* renamed from: j  reason: collision with root package name */
    public static final DnsName f33660j = new DnsName("ip6.arpa");

    /* renamed from: k  reason: collision with root package name */
    public static boolean f33661k = true;
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private transient byte[] f33662a;
    public final String ace;

    /* renamed from: b  reason: collision with root package name */
    private transient String f33663b;

    /* renamed from: c  reason: collision with root package name */
    private transient String f33664c;

    /* renamed from: d  reason: collision with root package name */
    private transient DnsLabel[] f33665d;

    /* renamed from: e  reason: collision with root package name */
    private transient DnsLabel[] f33666e;

    /* renamed from: f  reason: collision with root package name */
    private transient int f33667f;
    private final String rawAce;
    private int size;

    static {
        Class<DnsName> cls = DnsName.class;
    }

    private DnsName(String str) {
        this(str, true);
    }

    private static byte[] C(DnsLabel[] dnsLabelArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            dnsLabelArr[length].h(byteArrayOutputStream);
        }
        byteArrayOutputStream.write(0);
        return byteArrayOutputStream.toByteArray();
    }

    private void D() {
        x();
        if (this.f33662a.length > 255) {
            throw new InvalidDnsNameException.DNSNameTooLongException(this.ace, this.f33662a);
        }
    }

    public static DnsName b(CharSequence charSequence) {
        return c(charSequence.toString());
    }

    public static DnsName c(String str) {
        return new DnsName(str, false);
    }

    public static DnsName d(DnsLabel dnsLabel, DnsLabel dnsLabel2, DnsName dnsName) {
        dnsName.x();
        DnsLabel[] dnsLabelArr = dnsName.f33666e;
        DnsLabel[] dnsLabelArr2 = new DnsLabel[(dnsLabelArr.length + 2)];
        System.arraycopy(dnsLabelArr, 0, dnsLabelArr2, 0, dnsLabelArr.length);
        DnsLabel[] dnsLabelArr3 = dnsName.f33666e;
        dnsLabelArr2[dnsLabelArr3.length] = dnsLabel2;
        dnsLabelArr2[dnsLabelArr3.length + 1] = dnsLabel;
        return new DnsName(dnsLabelArr2, true);
    }

    public static DnsName e(DnsLabel dnsLabel, DnsName dnsName) {
        dnsName.z();
        DnsLabel[] dnsLabelArr = dnsName.f33666e;
        DnsLabel[] dnsLabelArr2 = new DnsLabel[(dnsLabelArr.length + 1)];
        System.arraycopy(dnsLabelArr, 0, dnsLabelArr2, 0, dnsLabelArr.length);
        dnsLabelArr2[dnsName.f33666e.length] = dnsLabel;
        return new DnsName(dnsLabelArr2, true);
    }

    public static DnsName h(DnsName dnsName, DnsName dnsName2) {
        dnsName.z();
        dnsName2.z();
        int length = dnsName.f33666e.length;
        DnsLabel[] dnsLabelArr = dnsName2.f33666e;
        DnsLabel[] dnsLabelArr2 = new DnsLabel[(length + dnsLabelArr.length)];
        System.arraycopy(dnsLabelArr, 0, dnsLabelArr2, 0, dnsLabelArr.length);
        DnsLabel[] dnsLabelArr3 = dnsName.f33666e;
        System.arraycopy(dnsLabelArr3, 0, dnsLabelArr2, dnsName2.f33666e.length, dnsLabelArr3.length);
        return new DnsName(dnsLabelArr2, true);
    }

    private static DnsLabel[] o(String str) {
        String[] split = str.split("[.。．｡]", 128);
        for (int i10 = 0; i10 < split.length / 2; i10++) {
            String str2 = split[i10];
            int length = (split.length - i10) - 1;
            split[i10] = split[length];
            split[length] = str2;
        }
        try {
            return DnsLabel.d(split);
        } catch (DnsLabel.LabelToLongException e10) {
            throw new InvalidDnsNameException.LabelTooLongException(str, e10.label);
        }
    }

    private static String t(DnsLabel[] dnsLabelArr, int i10) {
        StringBuilder sb2 = new StringBuilder(i10);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            sb2.append(dnsLabelArr[length]);
            sb2.append('.');
        }
        sb2.setLength(sb2.length() - 1);
        return sb2.toString();
    }

    public static DnsName v(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 192) == 192) {
            int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte2));
            return w(bArr, readUnsignedByte2, hashSet);
        } else if (readUnsignedByte == 0) {
            return f33658g;
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            return h(new DnsName(new String(bArr2, StandardCharsets.US_ASCII)), v(dataInputStream, bArr));
        }
    }

    private static DnsName w(byte[] bArr, int i10, HashSet<Integer> hashSet) throws IllegalStateException {
        byte b10 = bArr[i10] & 255;
        if ((b10 & 192) == 192) {
            int i11 = ((b10 & 63) << 8) + (bArr[i10 + 1] & 255);
            if (!hashSet.contains(Integer.valueOf(i11))) {
                hashSet.add(Integer.valueOf(i11));
                return w(bArr, i11, hashSet);
            }
            throw new IllegalStateException("Cyclic offsets detected.");
        } else if (b10 == 0) {
            return f33658g;
        } else {
            int i12 = i10 + 1;
            return h(new DnsName(new String(bArr, i12, b10, StandardCharsets.US_ASCII)), w(bArr, i12 + b10, hashSet));
        }
    }

    private void x() {
        if (this.f33662a == null) {
            z();
            this.f33662a = C(this.f33665d);
        }
    }

    private void y() {
        if (this.f33664c == null) {
            String[] split = this.ace.split("[.。．｡]", 2);
            this.f33664c = split[0];
            if (split.length > 1) {
                this.f33663b = split[1];
            } else {
                this.f33663b = "";
            }
        }
    }

    private void z() {
        if (this.f33665d != null && this.f33666e != null) {
            return;
        }
        if (s()) {
            DnsLabel[] dnsLabelArr = new DnsLabel[0];
            this.f33665d = dnsLabelArr;
            this.f33666e = dnsLabelArr;
            return;
        }
        this.f33665d = o(this.ace);
        this.f33666e = o(this.rawAce);
    }

    public int A() {
        if (this.size < 0) {
            if (s()) {
                this.size = 1;
            } else {
                this.size = this.ace.length() + 2;
            }
        }
        return this.size;
    }

    public DnsName B(int i10) {
        z();
        DnsLabel[] dnsLabelArr = this.f33665d;
        if (i10 > dnsLabelArr.length) {
            throw new IllegalArgumentException();
        } else if (i10 == dnsLabelArr.length) {
            return this;
        } else {
            if (i10 == 0) {
                return f33658g;
            }
            return new DnsName((DnsLabel[]) Arrays.copyOfRange(this.f33666e, 0, i10), false);
        }
    }

    public void G(OutputStream outputStream) throws IOException {
        x();
        outputStream.write(this.f33662a);
    }

    /* renamed from: a */
    public int compareTo(DnsName dnsName) {
        return this.ace.compareTo(dnsName.ace);
    }

    public char charAt(int i10) {
        return this.ace.charAt(i10);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DnsName)) {
            return false;
        }
        DnsName dnsName = (DnsName) obj;
        x();
        dnsName.x();
        return Arrays.equals(this.f33662a, dnsName.f33662a);
    }

    public int hashCode() {
        if (this.f33667f == 0 && !s()) {
            x();
            this.f33667f = Arrays.hashCode(this.f33662a);
        }
        return this.f33667f;
    }

    public byte[] i() {
        x();
        return (byte[]) this.f33662a.clone();
    }

    public String j() {
        y();
        return this.f33664c;
    }

    public DnsLabel k(int i10) {
        z();
        return this.f33665d[i10];
    }

    public int l() {
        z();
        return this.f33665d.length;
    }

    public int length() {
        return this.ace.length();
    }

    public DnsName p() {
        if (s()) {
            return f33658g;
        }
        return B(l() - 1);
    }

    public String q() {
        return this.rawAce;
    }

    public boolean r(DnsName dnsName) {
        z();
        dnsName.z();
        if (this.f33665d.length < dnsName.f33665d.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            DnsLabel[] dnsLabelArr = dnsName.f33665d;
            if (i10 >= dnsLabelArr.length) {
                return true;
            }
            if (!this.f33665d[i10].equals(dnsLabelArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    public boolean s() {
        return this.ace.isEmpty() || this.ace.equals(".");
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.ace.subSequence(i10, i11);
    }

    public String toString() {
        return this.ace;
    }

    private DnsName(String str, boolean z10) {
        this.size = -1;
        if (str.isEmpty()) {
            this.rawAce = f33658g.rawAce;
        } else {
            int length = str.length();
            int i10 = length - 1;
            if (length >= 2 && str.charAt(i10) == '.') {
                str = str.subSequence(0, i10).toString();
            }
            if (z10) {
                this.rawAce = str;
            } else {
                this.rawAce = c.a(str);
            }
        }
        this.ace = this.rawAce.toLowerCase(Locale.US);
        if (f33661k) {
            D();
        }
    }

    private DnsName(DnsLabel[] dnsLabelArr, boolean z10) {
        this.size = -1;
        this.f33666e = dnsLabelArr;
        this.f33665d = new DnsLabel[dnsLabelArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < dnsLabelArr.length; i11++) {
            i10 += dnsLabelArr[i11].length() + 1;
            this.f33665d[i11] = dnsLabelArr[i11].a();
        }
        this.rawAce = t(dnsLabelArr, i10);
        this.ace = t(this.f33665d, i10);
        if (z10 && f33661k) {
            D();
        }
    }
}
