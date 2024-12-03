package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.video.c;
import com.google.android.gms.common.api.a;

public abstract class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final Range<Integer> f3075a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Range<Integer> f3076b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f3077c = a().c(0).a();

    /* renamed from: androidx.camera.video.a$a  reason: collision with other inner class name */
    public static abstract class C0021a {
        C0021a() {
        }

        @NonNull
        public abstract a a();

        @NonNull
        public abstract C0021a b(@NonNull Range<Integer> range);

        @NonNull
        public abstract C0021a c(int i10);

        @NonNull
        public abstract C0021a d(@NonNull Range<Integer> range);

        @NonNull
        public abstract C0021a e(int i10);
    }

    static {
        Integer valueOf = Integer.valueOf(a.e.API_PRIORITY_OTHER);
        f3075a = new Range<>(0, valueOf);
        f3076b = new Range<>(0, valueOf);
    }

    a() {
    }

    @NonNull
    public static C0021a a() {
        return new c.b().f(-1).e(-1).c(-1).b(f3075a).d(f3076b);
    }

    @NonNull
    public abstract Range<Integer> b();

    public abstract int c();

    @NonNull
    public abstract Range<Integer> d();

    public abstract int e();

    public abstract int f();
}
