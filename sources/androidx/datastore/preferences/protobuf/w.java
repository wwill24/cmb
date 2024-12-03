package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;
import org.bouncycastle.i18n.LocalizedMessage;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f5382a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f5383b = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f5384c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f5385d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f5386e;

    public interface a extends i<Boolean> {
    }

    public interface b extends i<Double> {
    }

    public interface c {
        int getNumber();
    }

    public interface d<T extends c> {
        T findValueByNumber(int i10);
    }

    public interface e {
        boolean isInRange(int i10);
    }

    public interface f extends i<Float> {
    }

    public interface g extends i<Integer> {
    }

    public interface h extends i<Long> {
    }

    public interface i<E> extends List<E>, RandomAccess {
        i<E> a(int i10);

        void c();

        boolean h();
    }

    static {
        byte[] bArr = new byte[0];
        f5384c = bArr;
        f5385d = ByteBuffer.wrap(bArr);
        f5386e = h.h(bArr);
    }

    static <T> T a(T t10) {
        t10.getClass();
        return t10;
    }

    static <T> T b(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i10, int i11) {
        int i12 = i(i11, bArr, i10, i11);
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public static int f(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.m(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((k0) obj).toBuilder().n((k0) obj2).buildPartial();
    }

    static int i(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f5382a);
    }
}
