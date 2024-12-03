package kotlin.random;

import java.io.Serializable;
import kk.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class Random {

    /* renamed from: a  reason: collision with root package name */
    public static final Default f32142a = new Default((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Random f32143b = b.f32004a.b();

    public static final class Default extends Random implements Serializable {

        private static final class Serialized implements Serializable {

            /* renamed from: a  reason: collision with root package name */
            public static final Serialized f32144a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f32142a;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.f32144a;
        }

        public int b(int i10) {
            return Random.f32143b.b(i10);
        }

        public int c() {
            return Random.f32143b.c();
        }

        public int d(int i10) {
            return Random.f32143b.d(i10);
        }

        public int e(int i10, int i11) {
            return Random.f32143b.e(i10, i11);
        }
    }

    public abstract int b(int i10);

    public int c() {
        return b(32);
    }

    public int d(int i10) {
        return e(0, i10);
    }

    public int e(int i10, int i11) {
        int i12;
        int c10;
        int i13;
        int c11;
        boolean z10;
        c.b(i10, i11);
        int i14 = i11 - i10;
        if (i14 > 0 || i14 == Integer.MIN_VALUE) {
            if (((-i14) & i14) == i14) {
                i12 = b(c.c(i14));
            } else {
                do {
                    c10 = c() >>> 1;
                    i13 = c10 % i14;
                } while ((c10 - i13) + (i14 - 1) < 0);
                i12 = i13;
            }
            return i10 + i12;
        }
        do {
            c11 = c();
            z10 = false;
            if (i10 <= c11 && c11 < i11) {
                z10 = true;
                continue;
            }
        } while (!z10);
        return c11;
    }
}
