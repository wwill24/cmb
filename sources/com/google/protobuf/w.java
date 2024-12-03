package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import org.bouncycastle.i18n.LocalizedMessage;
import org.jivesoftware.smack.util.StringUtils;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f21952a = Charset.forName(StringUtils.USASCII);

    /* renamed from: b  reason: collision with root package name */
    static final Charset f21953b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    static final Charset f21954c = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f21955d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteBuffer f21956e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f21957f;

    public interface a extends j<Boolean> {
        a a(int i10);
    }

    public interface b extends j<Double> {
        b a(int i10);
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

    public interface f extends j<Float> {
        f a(int i10);
    }

    public interface g extends j<Integer> {
        int G(int i10, int i11);

        void U0(int i10);

        g a(int i10);

        int getInt(int i10);
    }

    public static class h<F, T> extends AbstractList<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<F> f21958a;

        /* renamed from: b  reason: collision with root package name */
        private final a<F, T> f21959b;

        public interface a<F, T> {
            T convert(F f10);
        }

        public h(List<F> list, a<F, T> aVar) {
            this.f21958a = list;
            this.f21959b = aVar;
        }

        public T get(int i10) {
            return this.f21959b.convert(this.f21958a.get(i10));
        }

        public int size() {
            return this.f21958a.size();
        }
    }

    public interface i extends j<Long> {
        i a(int i10);
    }

    public interface j<E> extends List<E>, RandomAccess {
        j<E> a(int i10);

        void c();

        boolean h();
    }

    static {
        byte[] bArr = new byte[0];
        f21955d = bArr;
        f21956e = ByteBuffer.wrap(bArr);
        f21957f = h.k(bArr);
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
        return Utf8.s(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((l0) obj).toBuilder().mergeFrom((l0) obj2).buildPartial();
    }

    static int i(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f21953b);
    }
}
