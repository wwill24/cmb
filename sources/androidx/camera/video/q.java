package androidx.camera.video;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f3403a;

    /* renamed from: b  reason: collision with root package name */
    public static final q f3404b;

    /* renamed from: c  reason: collision with root package name */
    public static final q f3405c;

    /* renamed from: d  reason: collision with root package name */
    public static final q f3406d;

    /* renamed from: e  reason: collision with root package name */
    public static final q f3407e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f3408f;

    /* renamed from: g  reason: collision with root package name */
    static final q f3409g = b.e(-1, "NONE");

    /* renamed from: h  reason: collision with root package name */
    private static final Set<q> f3410h;

    /* renamed from: i  reason: collision with root package name */
    private static final List<q> f3411i;

    static abstract class b extends q {
        b() {
            super();
        }

        @NonNull
        static b e(int i10, @NonNull String str) {
            return new h(i10, str);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract String c();

        /* access modifiers changed from: package-private */
        public abstract int d();
    }

    static {
        b e10 = b.e(4, "SD");
        f3403a = e10;
        b e11 = b.e(5, "HD");
        f3404b = e11;
        b e12 = b.e(6, "FHD");
        f3405c = e12;
        b e13 = b.e(8, "UHD");
        f3406d = e13;
        b e14 = b.e(0, "LOWEST");
        f3407e = e14;
        b e15 = b.e(1, "HIGHEST");
        f3408f = e15;
        f3410h = new HashSet(Arrays.asList(new q[]{e14, e15, e10, e11, e12, e13}));
        f3411i = Arrays.asList(new q[]{e13, e12, e11, e10});
    }

    static boolean a(@NonNull q qVar) {
        return f3410h.contains(qVar);
    }

    @NonNull
    static List<q> b() {
        return new ArrayList(f3411i);
    }

    private q() {
    }
}
