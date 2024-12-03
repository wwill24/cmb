package b2;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

public interface h {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f7743a = new b.c();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0088b f7744b = new b.C0088b();

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f7745a;

            public a(@NonNull Throwable th2) {
                this.f7745a = th2;
            }

            @NonNull
            public Throwable a() {
                return this.f7745a;
            }

            @NonNull
            public String toString() {
                return "FAILURE (" + this.f7745a.getMessage() + ")";
            }
        }

        /* renamed from: b2.h$b$b  reason: collision with other inner class name */
        public static final class C0088b extends b {
            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }

            private C0088b() {
            }
        }

        public static final class c extends b {
            @NonNull
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        b() {
        }
    }
}
