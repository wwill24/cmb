package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.video.l;
import com.google.android.gms.common.api.a;
import java.util.Arrays;

public abstract class j0 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final Range<Integer> f3383a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Range<Integer> f3384b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final r f3385c;

    public static abstract class a {
        a() {
        }

        @NonNull
        public abstract j0 a();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a b(int i10);

        @NonNull
        public abstract a c(@NonNull Range<Integer> range);

        @NonNull
        public abstract a d(@NonNull Range<Integer> range);

        @NonNull
        public abstract a e(@NonNull r rVar);
    }

    static {
        Integer valueOf = Integer.valueOf(a.e.API_PRIORITY_OTHER);
        f3383a = new Range<>(0, valueOf);
        f3384b = new Range<>(0, valueOf);
        q qVar = q.f3405c;
        f3385c = r.f(Arrays.asList(new q[]{qVar, q.f3404b, q.f3403a}), m.a(qVar));
    }

    j0() {
    }

    @NonNull
    public static a a() {
        return new l.b().e(f3385c).d(f3383a).c(f3384b).b(-1);
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    @NonNull
    public abstract Range<Integer> c();

    @NonNull
    public abstract Range<Integer> d();

    @NonNull
    public abstract r e();

    @NonNull
    public abstract a f();
}
