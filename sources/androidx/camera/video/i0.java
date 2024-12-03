package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.core.util.h;
import b0.e;

public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final e f3147a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f3148b;

    public static final class a extends i0 {

        /* renamed from: c  reason: collision with root package name */
        private final o f3149c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3150d;

        /* renamed from: e  reason: collision with root package name */
        private final Throwable f3151e;

        a(@NonNull e eVar, @NonNull e0 e0Var, @NonNull o oVar, int i10, Throwable th2) {
            super(eVar, e0Var);
            this.f3149c = oVar;
            this.f3150d = i10;
            this.f3151e = th2;
        }

        @NonNull
        static String g(int i10) {
            switch (i10) {
                case 0:
                    return "ERROR_NONE";
                case 1:
                    return "ERROR_UNKNOWN";
                case 2:
                    return "ERROR_FILE_SIZE_LIMIT_REACHED";
                case 3:
                    return "ERROR_INSUFFICIENT_STORAGE";
                case 4:
                    return "ERROR_SOURCE_INACTIVE";
                case 5:
                    return "ERROR_INVALID_OUTPUT_OPTIONS";
                case 6:
                    return "ERROR_ENCODING_FAILED";
                case 7:
                    return "ERROR_RECORDER_ERROR";
                case 8:
                    return "ERROR_NO_VALID_DATA";
                default:
                    return "Unknown(" + i10 + ")";
            }
        }

        public Throwable h() {
            return this.f3151e;
        }

        public int i() {
            return this.f3150d;
        }

        public boolean j() {
            return this.f3150d != 0;
        }
    }

    public static final class b extends i0 {
        b(@NonNull e eVar, @NonNull e0 e0Var) {
            super(eVar, e0Var);
        }
    }

    public static final class c extends i0 {
        c(@NonNull e eVar, @NonNull e0 e0Var) {
            super(eVar, e0Var);
        }
    }

    public static final class d extends i0 {
        d(@NonNull e eVar, @NonNull e0 e0Var) {
            super(eVar, e0Var);
        }
    }

    i0(@NonNull e eVar, @NonNull e0 e0Var) {
        this.f3147a = (e) h.g(eVar);
        this.f3148b = (e0) h.g(e0Var);
    }

    @NonNull
    static a a(@NonNull e eVar, @NonNull e0 e0Var, @NonNull o oVar) {
        return new a(eVar, e0Var, oVar, 0, (Throwable) null);
    }

    @NonNull
    static a b(@NonNull e eVar, @NonNull e0 e0Var, @NonNull o oVar, int i10, Throwable th2) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "An error type is required.");
        return new a(eVar, e0Var, oVar, i10, th2);
    }

    @NonNull
    static b d(@NonNull e eVar, @NonNull e0 e0Var) {
        return new b(eVar, e0Var);
    }

    @NonNull
    static c e(@NonNull e eVar, @NonNull e0 e0Var) {
        return new c(eVar, e0Var);
    }

    @NonNull
    static d f(@NonNull e eVar, @NonNull e0 e0Var) {
        return new d(eVar, e0Var);
    }

    @NonNull
    public e c() {
        return this.f3147a;
    }
}
