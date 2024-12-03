package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class j {

    /* renamed from: e  reason: collision with root package name */
    static final Charset f2665e = StandardCharsets.US_ASCII;

    /* renamed from: f  reason: collision with root package name */
    static final String[] f2666f = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f2667g = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: h  reason: collision with root package name */
    static final byte[] f2668h = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: a  reason: collision with root package name */
    public final int f2669a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2670b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2671c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2672d;

    j(int i10, int i11, byte[] bArr) {
        this(i10, i11, -1, bArr);
    }

    @NonNull
    public static j a(@NonNull String str) {
        if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
            byte[] bytes = str.getBytes(f2665e);
            return new j(1, bytes.length, bytes);
        }
        return new j(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
    }

    @NonNull
    public static j b(@NonNull double[] dArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[12] * dArr.length)]);
        wrap.order(byteOrder);
        for (double putDouble : dArr) {
            wrap.putDouble(putDouble);
        }
        return new j(12, dArr.length, wrap.array());
    }

    @NonNull
    public static j c(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[9] * iArr.length)]);
        wrap.order(byteOrder);
        for (int putInt : iArr) {
            wrap.putInt(putInt);
        }
        return new j(9, iArr.length, wrap.array());
    }

    @NonNull
    public static j d(@NonNull m[] mVarArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[10] * mVarArr.length)]);
        wrap.order(byteOrder);
        for (m mVar : mVarArr) {
            wrap.putInt((int) mVar.b());
            wrap.putInt((int) mVar.a());
        }
        return new j(10, mVarArr.length, wrap.array());
    }

    @NonNull
    public static j e(@NonNull String str) {
        byte[] bytes = (str + 0).getBytes(f2665e);
        return new j(2, bytes.length, bytes);
    }

    @NonNull
    public static j f(long j10, @NonNull ByteOrder byteOrder) {
        return g(new long[]{j10}, byteOrder);
    }

    @NonNull
    public static j g(@NonNull long[] jArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[4] * jArr.length)]);
        wrap.order(byteOrder);
        for (long j10 : jArr) {
            wrap.putInt((int) j10);
        }
        return new j(4, jArr.length, wrap.array());
    }

    @NonNull
    public static j h(@NonNull m[] mVarArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[5] * mVarArr.length)]);
        wrap.order(byteOrder);
        for (m mVar : mVarArr) {
            wrap.putInt((int) mVar.b());
            wrap.putInt((int) mVar.a());
        }
        return new j(5, mVarArr.length, wrap.array());
    }

    @NonNull
    public static j i(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(f2667g[3] * iArr.length)]);
        wrap.order(byteOrder);
        for (int i10 : iArr) {
            wrap.putShort((short) i10);
        }
        return new j(3, iArr.length, wrap.array());
    }

    public int j() {
        return f2667g[this.f2669a] * this.f2670b;
    }

    public String toString() {
        return "(" + f2666f[this.f2669a] + ", data length:" + this.f2672d.length + ")";
    }

    j(int i10, int i11, long j10, byte[] bArr) {
        this.f2669a = i10;
        this.f2670b = i11;
        this.f2671c = j10;
        this.f2672d = bArr;
    }
}
