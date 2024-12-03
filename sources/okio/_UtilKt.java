package okio;

import com.coffeemeetsbagel.models.NetworkProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.Buffer;
import okio.internal.e;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\t\u001a\u00020\b*\u00020\bH\u0000\u001a\f\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a0\u0010\f\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0011*\u00020\bH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0000\u001a\u0014\u0010\u0018\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\bH\u0000\" \u0010\u001f\u001a\u00020\u00198\u0000X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\"\u001a\u0010#\u001a\u00020\b8\u0000XD¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"", "size", "offset", "byteCount", "", "b", "", "h", "", "f", "g", "", "a", "aOffset", "bOffset", "", "", "", "i", "j", "Lokio/ByteString;", "position", "d", "sizeParam", "e", "Lokio/Buffer$UnsafeCursor;", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "DEFAULT__new_UnsafeCursor", "I", "c", "()I", "DEFAULT__ByteString_size", "okio"}, k = 2, mv = {1, 6, 0})
public final class _UtilKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Buffer.UnsafeCursor f33442a = new Buffer.UnsafeCursor();

    /* renamed from: b  reason: collision with root package name */
    private static final int f33443b = -1234567890;

    public static final boolean a(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        j.g(bArr, "a");
        j.g(bArr2, NetworkProfile.BISEXUAL);
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c() {
        return f33443b;
    }

    public static final int d(ByteString byteString, int i10) {
        j.g(byteString, "<this>");
        return i10 == f33443b ? byteString.H() : i10;
    }

    public static final int e(byte[] bArr, int i10) {
        j.g(bArr, "<this>");
        return i10 == f33443b ? bArr.length : i10;
    }

    public static final int f(int i10) {
        return ((i10 & 255) << 24) | ((-16777216 & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final long g(long j10) {
        return ((j10 & 255) << 56) | ((-72057594037927936L & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static final short h(short s10) {
        short s11 = s10 & 65535;
        return (short) (((s11 & 255) << 8) | ((65280 & s11) >>> 8));
    }

    public static final String i(byte b10) {
        return r.p(new char[]{e.f()[(b10 >> 4) & 15], e.f()[b10 & 15]});
    }

    public static final String j(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {e.f()[(i10 >> 28) & 15], e.f()[(i10 >> 24) & 15], e.f()[(i10 >> 20) & 15], e.f()[(i10 >> 16) & 15], e.f()[(i10 >> 12) & 15], e.f()[(i10 >> 8) & 15], e.f()[(i10 >> 4) & 15], e.f()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return r.q(cArr, i11, 8);
    }
}
