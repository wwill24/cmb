package okio;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.internal.h;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160-\u0012\u0006\u00108\u001a\u000203¢\u0006\u0004\b9\u0010:J\b\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0001H\u0016J\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0005H\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J(\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\fH\u0016J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\fH\u0016J\u000f\u0010'\u001a\u00020\u0016H\u0010¢\u0006\u0004\b'\u0010(J\u0013\u0010*\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0002J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0005H\u0016R \u00102\u001a\b\u0012\u0004\u0012\u00020\u00160-8\u0000X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002038\u0000X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "V", "Ljava/lang/Object;", "writeReplace", "", "a", "p", "M", "algorithm", "d", "(Ljava/lang/String;)Lokio/ByteString;", "", "beginIndex", "endIndex", "J", "pos", "", "v", "(I)B", "l", "()I", "", "N", "Lokio/Buffer;", "buffer", "offset", "byteCount", "", "R", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "z", "A", "fromIndex", "r", "x", "t", "()[B", "", "equals", "hashCode", "toString", "", "e", "[[B", "U", "()[[B", "segments", "", "f", "[I", "T", "()[I", "directory", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class SegmentedByteString extends ByteString {

    /* renamed from: e  reason: collision with root package name */
    private final transient byte[][] f33420e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int[] f33421f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f33309d.j());
        j.g(bArr, "segments");
        j.g(iArr, "directory");
        this.f33420e = bArr;
        this.f33421f = iArr;
    }

    private final ByteString V() {
        return new ByteString(N());
    }

    private final Object writeReplace() {
        return V();
    }

    public boolean A(int i10, byte[] bArr, int i11, int i12) {
        int i13;
        j.g(bArr, "other");
        if (i10 < 0 || i10 > H() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int b10 = h.b(this, i10);
        while (i10 < i14) {
            if (b10 == 0) {
                i13 = 0;
            } else {
                i13 = T()[b10 - 1];
            }
            int i15 = T()[U().length + b10];
            int min = Math.min(i14, (T()[b10] - i13) + i13) - i10;
            if (!_UtilKt.a(U()[b10], i15 + (i10 - i13), bArr, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }

    public ByteString J(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        int d10 = _UtilKt.d(this, i11);
        int i12 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (d10 <= H()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i13 = d10 - i10;
                if (i13 >= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException(("endIndex=" + d10 + " < beginIndex=" + i10).toString());
                } else if (i10 == 0 && d10 == H()) {
                    return this;
                } else {
                    if (i10 == d10) {
                        return ByteString.f33309d;
                    }
                    int b10 = h.b(this, i10);
                    int b11 = h.b(this, d10 - 1);
                    byte[][] bArr = (byte[][]) k.k(U(), b10, b11 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (b10 <= b11) {
                        int i14 = 0;
                        int i15 = b10;
                        while (true) {
                            iArr[i14] = Math.min(T()[i15] - i10, i13);
                            int i16 = i14 + 1;
                            iArr[i14 + bArr.length] = T()[U().length + i15];
                            if (i15 == b11) {
                                break;
                            }
                            i15++;
                            i14 = i16;
                        }
                    }
                    if (b10 != 0) {
                        i12 = T()[b10 - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i10 - i12);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + d10 + " > length(" + H() + PropertyUtils.MAPPED_DELIM2).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
    }

    public ByteString M() {
        return V().M();
    }

    public byte[] N() {
        byte[] bArr = new byte[H()];
        int length = U().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = T()[length + i10];
            int i14 = T()[i10];
            int i15 = i14 - i11;
            byte[] unused = k.f(U()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public void R(Buffer buffer, int i10, int i11) {
        int i12;
        j.g(buffer, "buffer");
        int i13 = i10 + i11;
        int b10 = h.b(this, i10);
        while (i10 < i13) {
            if (b10 == 0) {
                i12 = 0;
            } else {
                i12 = T()[b10 - 1];
            }
            int i14 = T()[U().length + b10];
            int min = Math.min(i13, (T()[b10] - i12) + i12) - i10;
            int i15 = i14 + (i10 - i12);
            Segment segment = new Segment(U()[b10], i15, i15 + min, true, false);
            Segment segment2 = buffer.f33298a;
            if (segment2 == null) {
                segment.f33414g = segment;
                segment.f33413f = segment;
                buffer.f33298a = segment;
            } else {
                j.d(segment2);
                Segment segment3 = segment2.f33414g;
                j.d(segment3);
                segment3.c(segment);
            }
            i10 += min;
            b10++;
        }
        buffer.I(buffer.size() + ((long) i11));
    }

    public final int[] T() {
        return this.f33421f;
    }

    public final byte[][] U() {
        return this.f33420e;
    }

    public String a() {
        return V().a();
    }

    public ByteString d(String str) {
        j.g(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = U().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = T()[length + i10];
            int i13 = T()[i10];
            instance.update(U()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digest = instance.digest();
        j.f(digest, "digestBytes");
        return new ByteString(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.H() == H() && z(0, byteString, 0, H())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int k10 = k();
        if (k10 != 0) {
            return k10;
        }
        int length = U().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = T()[length + i10];
            int i14 = T()[i10];
            byte[] bArr = U()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        B(i11);
        return i11;
    }

    public int l() {
        return T()[U().length - 1];
    }

    public String p() {
        return V().p();
    }

    public int r(byte[] bArr, int i10) {
        j.g(bArr, "other");
        return V().r(bArr, i10);
    }

    public byte[] t() {
        return N();
    }

    public String toString() {
        return V().toString();
    }

    public byte v(int i10) {
        int i11;
        _UtilKt.b((long) T()[U().length - 1], (long) i10, 1);
        int b10 = h.b(this, i10);
        if (b10 == 0) {
            i11 = 0;
        } else {
            i11 = T()[b10 - 1];
        }
        return U()[b10][(i10 - i11) + T()[U().length + b10]];
    }

    public int x(byte[] bArr, int i10) {
        j.g(bArr, "other");
        return V().x(bArr, i10);
    }

    public boolean z(int i10, ByteString byteString, int i11, int i12) {
        int i13;
        j.g(byteString, "other");
        if (i10 < 0 || i10 > H() - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int b10 = h.b(this, i10);
        while (i10 < i14) {
            if (b10 == 0) {
                i13 = 0;
            } else {
                i13 = T()[b10 - 1];
            }
            int i15 = T()[U().length + b10];
            int min = Math.min(i14, (T()[b10] - i13) + i13) - i10;
            if (!byteString.A(i11, U()[b10], i15 + (i10 - i13), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }
}
