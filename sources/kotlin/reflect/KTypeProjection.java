package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import wk.m;

public final class KTypeProjection {

    /* renamed from: c  reason: collision with root package name */
    public static final a f32152c = new a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final KTypeProjection f32153d = new KTypeProjection((KVariance) null, (m) null);

    /* renamed from: a  reason: collision with root package name */
    private final KVariance f32154a;

    /* renamed from: b  reason: collision with root package name */
    private final m f32155b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KTypeProjection a(m mVar) {
            j.g(mVar, "type");
            return new KTypeProjection(KVariance.INVARIANT, mVar);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32156a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f32156a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KTypeProjection.b.<clinit>():void");
        }
    }

    public KTypeProjection(KVariance kVariance, m mVar) {
        boolean z10;
        boolean z11;
        String str;
        this.f32154a = kVariance;
        this.f32155b = mVar;
        boolean z12 = true;
        if (kVariance == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (mVar == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(z10 != z11 ? false : z12)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public final m a() {
        return this.f32155b;
    }

    public final KVariance b() {
        return this.f32154a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return this.f32154a == kTypeProjection.f32154a && j.b(this.f32155b, kTypeProjection.f32155b);
    }

    public int hashCode() {
        KVariance kVariance = this.f32154a;
        int i10 = 0;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        m mVar = this.f32155b;
        if (mVar != null) {
            i10 = mVar.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        int i10;
        KVariance kVariance = this.f32154a;
        if (kVariance == null) {
            i10 = -1;
        } else {
            i10 = b.f32156a[kVariance.ordinal()];
        }
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.f32155b);
        }
        if (i10 == 2) {
            return "in " + this.f32155b;
        } else if (i10 == 3) {
            return "out " + this.f32155b;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
