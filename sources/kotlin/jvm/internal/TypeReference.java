package kotlin.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KTypeProjection;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.beanutils.PropertyUtils;
import wk.c;
import wk.e;
import wk.m;

public final class TypeReference implements m {

    /* renamed from: e  reason: collision with root package name */
    public static final a f32119e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final e f32120a;

    /* renamed from: b  reason: collision with root package name */
    private final List<KTypeProjection> f32121b;

    /* renamed from: c  reason: collision with root package name */
    private final m f32122c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32123d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32124a;

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
                f32124a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.b.<clinit>():void");
        }
    }

    public TypeReference(e eVar, List<KTypeProjection> list, m mVar, int i10) {
        j.g(eVar, "classifier");
        j.g(list, "arguments");
        this.f32120a = eVar;
        this.f32121b = list;
        this.f32122c = mVar;
        this.f32123d = i10;
    }

    /* access modifiers changed from: private */
    public final String e(KTypeProjection kTypeProjection) {
        TypeReference typeReference;
        String str;
        if (kTypeProjection.b() == null) {
            return "*";
        }
        m a10 = kTypeProjection.a();
        if (a10 instanceof TypeReference) {
            typeReference = (TypeReference) a10;
        } else {
            typeReference = null;
        }
        if (typeReference == null || (str = typeReference.f(true)) == null) {
            str = String.valueOf(kTypeProjection.a());
        }
        int i10 = b.f32124a[kTypeProjection.b().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 == 2) {
            return "in " + str;
        } else if (i10 == 3) {
            return "out " + str;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final String f(boolean z10) {
        c cVar;
        String str;
        String str2;
        e a10 = a();
        Class cls = null;
        if (a10 instanceof c) {
            cVar = (c) a10;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cls = ok.a.a(cVar);
        }
        if (cls == null) {
            str = a().toString();
        } else if ((this.f32123d & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            str = h(cls);
        } else if (!z10 || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            e a11 = a();
            j.e(a11, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            str = ok.a.b((c) a11).getName();
        }
        String str3 = "";
        if (g().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt___CollectionsKt.W(g(), ", ", "<", ">", 0, (CharSequence) null, new TypeReference$asString$args$1(this), 24, (Object) null);
        }
        if (i()) {
            str3 = TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        String str4 = str + str2 + str3;
        m mVar = this.f32122c;
        if (!(mVar instanceof TypeReference)) {
            return str4;
        }
        String f10 = ((TypeReference) mVar).f(true);
        if (j.b(f10, str4)) {
            return str4;
        }
        if (j.b(f10, str4 + '?')) {
            return str4 + '!';
        }
        return PropertyUtils.MAPPED_DELIM + str4 + ".." + f10 + PropertyUtils.MAPPED_DELIM2;
    }

    private final String h(Class<?> cls) {
        if (j.b(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (j.b(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (j.b(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (j.b(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (j.b(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (j.b(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (j.b(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        if (j.b(cls, double[].class)) {
            return "kotlin.DoubleArray";
        }
        return "kotlin.Array";
    }

    public e a() {
        return this.f32120a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (!j.b(a(), typeReference.a()) || !j.b(g(), typeReference.g()) || !j.b(this.f32122c, typeReference.f32122c) || this.f32123d != typeReference.f32123d) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List<KTypeProjection> g() {
        return this.f32121b;
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + g().hashCode()) * 31) + Integer.hashCode(this.f32123d);
    }

    public boolean i() {
        return (this.f32123d & 1) != 0;
    }

    public String toString() {
        return f(false) + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TypeReference(e eVar, List<KTypeProjection> list, boolean z10) {
        this(eVar, list, (m) null, z10 ? 1 : 0);
        j.g(eVar, "classifier");
        j.g(list, "arguments");
    }
}
