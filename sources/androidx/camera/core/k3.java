package androidx.camera.core;

import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.core.util.h;

public final class k3 {

    /* renamed from: a  reason: collision with root package name */
    private int f2786a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private Rational f2787b;

    /* renamed from: c  reason: collision with root package name */
    private int f2788c;

    /* renamed from: d  reason: collision with root package name */
    private int f2789d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f2790a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final Rational f2791b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2792c;

        /* renamed from: d  reason: collision with root package name */
        private int f2793d = 0;

        public a(@NonNull Rational rational, int i10) {
            this.f2791b = rational;
            this.f2792c = i10;
        }

        @NonNull
        public k3 a() {
            h.h(this.f2791b, "The crop aspect ratio must be set.");
            return new k3(this.f2790a, this.f2791b, this.f2792c, this.f2793d);
        }

        @NonNull
        public a b(int i10) {
            this.f2793d = i10;
            return this;
        }

        @NonNull
        public a c(int i10) {
            this.f2790a = i10;
            return this;
        }
    }

    k3(int i10, @NonNull Rational rational, int i11, int i12) {
        this.f2786a = i10;
        this.f2787b = rational;
        this.f2788c = i11;
        this.f2789d = i12;
    }

    @NonNull
    public Rational a() {
        return this.f2787b;
    }

    public int b() {
        return this.f2789d;
    }

    public int c() {
        return this.f2788c;
    }

    public int d() {
        return this.f2786a;
    }
}
